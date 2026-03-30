package com.businessmodel.mapper;

import com.businessmodel.dto.SupportDto;
import com.businessmodel.entity.Customer;

public class SupportMapper {

    public static Customer toCustomerEntity(SupportDto dto) {
        if (dto == null) return null;

        Customer customer = new Customer();

        customer.setCustomerNumber(dto.getCustomerNumber());
        customer.setCustomerName(dto.getCustomerName());
        customer.setPhone(dto.getPhone());
        customer.setCountry(dto.getCountry());


        return customer;
    }
}