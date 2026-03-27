package com.businessmodel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private String productCode;
    private String productName;

    @ManyToOne
    @JoinColumn(name = "productLine")
    private ProductLine productLine;

    private String productScale;
    private String productVendor;
    private String productDescription;
    private Integer quantityInStock;
    private Double buyPrice;
    private Double MSRP;

    public Product() {
    }

    public Product(Double buyPrice, Double MSRP, String productCode, String productDescription, ProductLine productLine, String productName, String productScale, String productVendor, Integer quantityInStock) {
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.productLine = productLine;
        this.productName = productName;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.quantityInStock = quantityInStock;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }

    public String getProductScale() {
        return productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getMSRP() {
        return MSRP;
    }

    public void setMSRP(Double MSRP) {
        this.MSRP = MSRP;
    }
}