package com.businessmodel.mapper;

import com.businessmodel.dto.OrderDetailDto;
import com.businessmodel.dto.OrderDto;
import com.businessmodel.dto.OrderWithDetailsDto;
import com.businessmodel.entity.Order;
import com.businessmodel.entity.OrderDetail;

import java.util.List;

public class OrderMapper {
    public static OrderDto toOrderDto(final Order o) {
        return new OrderDto(o.getOrderNumber(),o.getOrderDate(),o.getRequiredDate(),o.getShippedDate(),o.getStatus(),o.getCustomer().getCustomerName());
    }
    public static OrderDetailDto toOrderDetailDto(final OrderDetail d) {
        return new OrderDetailDto(d.getProduct().getProductCode(),
                d.getProduct().getProductName(),
                d.getQuantityOrdered(),d.getPriceEach());
    }
    public static OrderWithDetailsDto toOrderWithDetailsDto(final Order o) {

        final List<OrderDetailDto> items=o.getOrderDetails().stream().map(OrderMapper::toOrderDetailDto).toList();
        return new OrderWithDetailsDto(o.getOrderNumber(),o.getOrderDate(),o.getStatus(),o.getCustomer().getCustomerName(),items );
    }
}
