package com.businessmodel.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.businessmodel.exception.BadRequestException;
import com.businessmodel.exception.BusinessException;
import com.businessmodel.exception.ResourceNotFoundException;
import com.businessmodel.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.businessmodel.dto.AmountDto;
import com.businessmodel.mapper.AmountMapper;
import com.businessmodel.repository.PaymentRepo;
import com.businessmodel.service.PaymentService;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepo paymentRepo;
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<AmountDto> getYearlyRevenue() {

		final List<AmountDto> result = paymentRepo.getYearlyRevenue();

		if (result == null) {
			throw new BusinessException("Unable to fetch yearly revenue data");
		}
        return result;

	}

	@Override
	public AmountDto getTotalPaymentAmount(final Integer customerId) {

		if (customerId == null || customerId <= 0) {
			throw new BadRequestException("Invalid customer ID: " + customerId);
		}

		customerRepo.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

		final BigDecimal total = paymentRepo.sumPaymentByCustomer(customerId);

		if (total == null) {
			throw new BusinessException("No payments found this customer having Id:" + customerId);
		}

		return AmountMapper.toCustomerSpendingDto(customerId, total);
	}
}