
package com.businessmodel.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.businessmodel.dto.AmountDto;
import com.businessmodel.entity.Payment;
import com.businessmodel.entity.PaymentId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, PaymentId> {
	@Query("select sum(p.amount) from Payment p where p.customer.customerNumber=:customerId")
	BigDecimal sumPaymentByCustomer(@Param("customerId") Integer customerId);

	@Query("SELECT new com.businessmodel.dto.AmountDto(" + "YEAR(p.paymentDate), SUM(p.amount)) " + "FROM Payment p "
			+ "GROUP BY YEAR(p.paymentDate) " + "ORDER BY YEAR(p.paymentDate)")
	List<AmountDto> getYearlyRevenue();

}
