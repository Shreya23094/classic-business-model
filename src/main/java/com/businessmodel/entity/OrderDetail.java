package com.businessmodel.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orderdetails")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailId id;

    @Column(name = "quantityOrdered", nullable = false)
    private Integer quantityOrdered;

    @Column(name = "priceEach", nullable = false)
    private BigDecimal priceEach;

    @Column(name = "orderLineNumber", nullable = false)
    private Short orderLineNumber;

    @ManyToOne
    @MapsId("orderNumber")
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber")
    private Order order;

    @ManyToOne
    @MapsId("productCode")
    @JoinColumn(name = "productCode", referencedColumnName = "productCode")
    private Product product;

    public OrderDetail() {
    }

    public OrderDetail(OrderDetailId id, Integer quantityOrdered, BigDecimal  priceEach, Short orderLineNumber, Order order, Product product) {
        this.id = id;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
        this.order = order;
        this.product = product;
    }

    public OrderDetailId getId() {
        return id;
    }

    public void setId(OrderDetailId id) {
        this.id = id;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal  getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal  priceEach) {
        this.priceEach = priceEach;
    }

    public Short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}