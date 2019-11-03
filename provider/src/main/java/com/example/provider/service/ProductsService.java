package com.example.provider.service;

import com.example.provider.mapper.ProductsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductsService {

    @Resource
    private ProductsMapper productsMapper;

}
