package com.businessmodel.controller;

import com.businessmodel.dto.OrderDto;
import com.businessmodel.dto.SupportDto;
import com.businessmodel.service.PaymentService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import com.businessmodel.dto.AmountDto;
import com.businessmodel.dto.CustomerDto;
import com.businessmodel.service.CustomerService;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final PaymentService paymentService;

    @GetMapping
    public Page<CustomerDto> getCustomersByCountry(@RequestParam final String country,
                                                   @RequestParam(defaultValue = "0") final int page,
                                                   @RequestParam(defaultValue = "10") final int size) {
        return customerService.getCustomersByCountry(country, page, size);
    }

    @GetMapping("/top")
    public List<CustomerDto> getTopCustomers(
            @RequestParam(defaultValue = "0") final int page,
            @RequestParam(defaultValue = "10") final int size) {

        return customerService.getTopCustomers(page, size);
    }

    @GetMapping("/{id}/orders")
    public Page<OrderDto> getOrdersByCustomer(@PathVariable final Integer id,
                                              @RequestParam(defaultValue = "0") final int page,
                                              @RequestParam(defaultValue = "10") final int size) {
        return customerService.getOrdersByCustomer(id,page, size);
    }


    @GetMapping("/{id}/orders_status")
    public ResponseEntity<List<OrderDto>> getOrdersByCustomerIdAndStatus(@PathVariable final Integer id, @RequestParam final String status) {
        return new ResponseEntity<>(customerService.getOrdersByCustomerIdAndStatus(id, status), HttpStatus.OK);
    }

    @GetMapping("/{id}/support")
    public ResponseEntity<SupportDto> getCustomerSupport(@PathVariable final Integer id) {
        return new ResponseEntity<>(customerService.getCustomerSupport(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/payment/amount")
    public ResponseEntity<AmountDto> getCustomerSpending(@PathVariable final Integer id) {
        return new ResponseEntity<>(paymentService.getTotalPaymentAmount(id), HttpStatus.OK);
    }
}