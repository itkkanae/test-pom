package com.example.consumer.feign.hystrix;

import com.example.common.dto.Product;
import com.example.consumer.feign.ProductsFeign;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsHystrix implements ProductsFeign {
    @Override
    public List<Product> selectByName(ProductExample example) {
        return new ArrayList<>();
    }

    @Override
    public int countByName(ProductExample example) {
        return 0;
    }

    @Override
    public boolean insertProduct(Product product) {
        return false;
    }
}
