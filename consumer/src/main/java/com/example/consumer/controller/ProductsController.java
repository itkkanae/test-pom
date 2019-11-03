package com.example.consumer.controller;

import com.example.consumer.feign.ProductsFeign;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "产品Controller")
@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Resource
    private ProductsFeign productsFeign;


}
