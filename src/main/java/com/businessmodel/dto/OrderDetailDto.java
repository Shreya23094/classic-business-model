package com.businessmodel.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDto {

    private String productCode;
    private String productName;
    private Integer quantityOrdered;
    private BigDecimal priceEach;
}