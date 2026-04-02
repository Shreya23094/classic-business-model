package com.businessmodel.service;

import java.util.List;

import com.businessmodel.dto.AmountDto;

public interface PaymentService {

	public AmountDto getTotalPaymentAmount(Integer customerId);

	public List<AmountDto> getYearlyRevenue();
}