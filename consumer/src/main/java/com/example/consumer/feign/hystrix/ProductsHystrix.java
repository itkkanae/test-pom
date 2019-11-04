package com.example.consumer.feign.hystrix;

import com.example.consumer.feign.ProductsFeign;
import org.springframework.stereotype.Component;


@Component
public class ProductsHystrix implements ProductsFeign {


    @Override
    public String pdTest(String string) {
        return "aaaaa";
    }
}
