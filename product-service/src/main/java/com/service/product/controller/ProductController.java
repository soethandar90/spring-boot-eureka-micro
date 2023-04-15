package com.service.product.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {
    @GetMapping("/{productNumber}")
    public String getProduct(@PathVariable String productNumber) {
        return "Inside product service " + productNumber;
    }
}
