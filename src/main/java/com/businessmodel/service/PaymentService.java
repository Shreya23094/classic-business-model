package com.businessmodel.service;

import java.util.List;
import com.businessmodel.dto.AmountDto;

public interface PaymentService {

	 AmountDto getTotalPaymentAmount(Integer customerId);

	 List<AmountDto> getYearlyRevenue();
}