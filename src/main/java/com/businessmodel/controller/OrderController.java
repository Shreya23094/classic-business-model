package com.businessmodel.controller;

import com.businessmodel.dto.OrderDto;
import com.businessmodel.dto.OrderWithDetailsDto;
import com.businessmodel.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public OrderWithDetailsDto getOrderWithDetails(@PathVariable final Integer id) {
        return orderService.getOrderWithDetails(id);
    }

    @GetMapping
    public Page<OrderDto> getOrdersByStatus(@RequestParam final String status,
                                            @RequestParam(defaultValue = "0") final int page,
                                            @RequestParam(defaultValue = "10") final int size
    ) {
        return orderService.getOrdersByStatus(status, page,size);
    }

}