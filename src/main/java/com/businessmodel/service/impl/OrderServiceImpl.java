package com.businessmodel.service.impl;

import com.businessmodel.dto.*;
import com.businessmodel.entity.*;
import com.businessmodel.exception.BadRequestException;
import com.businessmodel.exception.ResourceNotFoundException;
import com.businessmodel.mapper.OrderMapper;
import com.businessmodel.repository.*;
import com.businessmodel.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;

    @Override
    public Page<OrderDto> getOrdersByStatus(final String status, final int  page, final int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        if(status==null || status.isBlank()){
            throw new BadRequestException("Status cannot be null or empty");
        }
        final Pageable pageable=PageRequest.of(page,size);
        final Page<Order> orderPage = orderRepo.findByStatus(status, pageable);
        return orderPage.map(OrderMapper::toOrderDto);
    }

    @Override
    public OrderWithDetailsDto getOrderWithDetails(final Integer orderId) {
        final Order order=orderRepo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException("Order not find with id: " + orderId));
        return OrderMapper.toOrderWithDetailsDto(order);
    }

}