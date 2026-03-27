package com.businessmodel.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailPK implements Serializable {

    private Integer orderNumber;
    private String productCode;

    public OrderDetailPK() {
    }

    public OrderDetailPK(Integer orderNumber, String productCode) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailPK)) return false;
        OrderDetailPK that = (OrderDetailPK) o;
        return Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, productCode);
    }
}
