package com.businessmodel.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "productCode")
    private String productCode;

    @Column(name = "productName")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "productLine", referencedColumnName = "productLine")
    private ProductLine productLine;

    @Column(name = "productScale")
    private String productScale;

    @Column(name = "productVendor")
    private String productVendor;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "quantityInStock")
    private Short quantityInStock;

    @Column(name = "buyPrice")
    private BigDecimal buyPrice;

    @Column(name = "MSRP")
    private BigDecimal  msrp;

    public Product() {
    }

    public Product(BigDecimal  buyPrice, BigDecimal  msrp, String productCode, String productDescription, ProductLine productLine, String productName, String productScale, String productVendor, Short quantityInStock) {
        this.buyPrice = buyPrice;
        this.msrp = msrp;
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

    public Short getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal  getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal  buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal  getMSRP() {
        return msrp;
    }

    public void setMSRP(BigDecimal  msrp) {
        this.msrp = msrp;
    }
}