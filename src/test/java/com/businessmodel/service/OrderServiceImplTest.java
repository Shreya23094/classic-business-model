package com.businessmodel.service;

import com.businessmodel.dto.OrderDto;
import com.businessmodel.dto.OrderWithDetailsDto;
import com.businessmodel.entity.Customer;
import com.businessmodel.entity.Order;
import com.businessmodel.exception.BadRequestException;
import com.businessmodel.exception.ResourceNotFoundException;
import com.businessmodel.repository.OrderRepo;
import com.businessmodel.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class OrderServiceImplTest {

    @Mock
    private OrderRepo orderRepo;
    @InjectMocks
    private OrderServiceImpl orderService;


}
