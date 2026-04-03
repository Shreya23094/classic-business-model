package com.businessmodel.mapper;

import com.businessmodel.dto.SupportDto;
import com.businessmodel.entity.Employee;

public class SupportMapper {

    public static SupportDto toSupportDto(final Employee e) {

        return new SupportDto(e.getFirstName(), e.getLastName(), e.getEmail(), e.getJobTitle());
    }
}