package com.example.provider.controller;

import com.example.provider.service.ProductsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @GetMapping("/test")
    String pdTest(@RequestParam("string") String string) {
        return "ok";
    }

}
