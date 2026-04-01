package com.businessmodel.controller;

import com.businessmodel.dto.OrderDetailDto;
import com.businessmodel.dto.OrderWithDetailsDto;
import com.businessmodel.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor

public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderWithDetails(@PathVariable Integer id) {
        try {
            OrderWithDetailsDto orderDetailDto = orderService.getOrderWithDetails(id);
            return ResponseEntity.ok(orderDetailDto);

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }
    }
}