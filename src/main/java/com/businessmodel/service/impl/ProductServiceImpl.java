package com.businessmodel.service.impl;

import com.businessmodel.dto.ProductDto;
import com.businessmodel.entity.Product;
import com.businessmodel.entity.ProductLine;
import com.businessmodel.exception.BadRequestException;
import com.businessmodel.mapper.ProductMapper;
import com.businessmodel.repository.ProductRepo;
import com.businessmodel.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;
    @Override
    public Page<ProductDto> findProductsByProductLine(final ProductLine productLine, final int page, final int size) {
        if (page < 0 || size <= 0) {
            throw new BadRequestException("Invalid pagination parameters");
        }
        if(productLine==null){
            throw new BadRequestException("ProductLine is required");
        }
        final Pageable pageable = PageRequest.of(page, size);
        final Page<Product> productPage=productRepo.findProductByProductLine(productLine,pageable);
        return productPage.map(ProductMapper::toProductDto);
    }
}