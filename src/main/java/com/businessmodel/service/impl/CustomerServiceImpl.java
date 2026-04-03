package com.businessmodel.service.impl;

import com.businessmodel.dto.*;
import com.businessmodel.entity.Customer;
import com.businessmodel.entity.Employee;
import com.businessmodel.entity.Order;
import com.businessmodel.exception.BadRequestException;
import com.businessmodel.exception.BusinessException;
import com.businessmodel.exception.ResourceNotFoundException;
import com.businessmodel.mapper.CustomerMapper;
import com.businessmodel.mapper.OrderMapper;
import com.businessmodel.mapper.SupportMapper;
import com.businessmodel.repository.CustomerRepo;
import com.businessmodel.repository.OrderRepo;
import com.businessmodel.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public Page<CustomerDto> getCustomersByCountry(final String country, final int page, final int size) {
        if (country == null || country.isBlank()) {
            throw new BadRequestException("Country cannot be empty");
        }
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        final Pageable pageable = PageRequest.of(page, size);
        final Page<Customer> customerPage = customerRepo.findByCountry(country, pageable);
        return customerPage.map(CustomerMapper::toCustomerDto);
    }

    @Override
    public List<CustomerDto> getTopCustomers(final int page, final int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        final Pageable pageable = PageRequest.of(page, size);
        final Page<Customer> customerPage = customerRepo.findAllByOrderByCreditLimitDesc(pageable);
        final List<CustomerDto> list=new ArrayList<>();
        for(final Customer c:customerPage.getContent()) {
            list.add(CustomerMapper.toCustomerDto(c));
        }
        return list;
    }

    @Override
    public Page<OrderDto> getOrdersByCustomer(final Integer customerId, final int page, final int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        final Customer customer= customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " not found"));
        final Pageable pageable = PageRequest.of(page, size);
        final Page<Order> orderPage=orderRepo.findByCustomer(customer,pageable);
        return orderPage.map(OrderMapper::toOrderDto);
    }

    @Override
    public List<OrderDto> getOrdersByCustomerIdAndStatus(final Integer customerId, final String status) {
         customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " not found"));
        final List<Order> orders = orderRepo.findByCustomerCustomerNumberAndStatus(customerId, status);
        final List<OrderDto> orderDto = new ArrayList<>();
        orders.forEach(o -> orderDto.add(OrderMapper.toOrderDto(o)));
        return orderDto;
    }

    @Override
    public SupportDto getCustomerSupport(final Integer customerId) {
        final Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with id " + customerId + " not found"));
        final Employee emp = customer.getSalesRep();
        if(emp == null) {
            throw new BusinessException("No support assigned to this customer");
        }
        return SupportMapper.toSupportDto(emp);
    }

}