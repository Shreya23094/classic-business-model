package com.businessmodel.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.businessmodel.dto.AmountDto;
import com.businessmodel.service.PaymentService;

@RestController
@RequestMapping("api/payments")
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@GetMapping("/revenue")
	public ResponseEntity<List<AmountDto>> getYearlyRevenue() {
		return new ResponseEntity<>(paymentService.getYearlyRevenue(), HttpStatus.OK);
	}
}