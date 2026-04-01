package com.businessmodel.service.impl;

import com.businessmodel.dto.*;
import com.businessmodel.entity.*;
import com.businessmodel.mapper.OrderMapper;
import com.businessmodel.repository.*;
import com.businessmodel.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final CustomerRepo customerRepo;
    private final OrderDetailRepo orderDetailRepo;

    @Override
    public Page<OrderDto> getOrdersByCustomer(Integer customerId, int page, int size) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> orderPage = orderRepo.findByCustomer(customer, pageable);
        return orderPage.map(this::convertToDTO);
    }

    @Override
    public List<OrderDto> getOrdersByStatus(String status) {
        return orderRepo.findByStatus(status)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> getOrdersByCustomerId(Integer customerId) {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return orderRepo.findByCustomer(customer)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderWithDetailsDto getOrderWithDetails(Integer orderId) {

        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return OrderMapper.toOrderWithDetailsDto(order);
    }

    private OrderDto convertToDTO(Order order) {

        return OrderDto.builder()
                .orderNumber(order.getOrderNumber())
                .orderDate(order.getOrderDate())
                .requiredDate(order.getRequiredDate())
                .shippedDate(order.getShippedDate())
                .status(order.getStatus())
                .customerName(order.getCustomer().getCustomerName())
                .build();
    }
}