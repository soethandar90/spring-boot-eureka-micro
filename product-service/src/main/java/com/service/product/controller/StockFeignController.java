package com.service.product.controller;

import com.service.product.service.StockServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stock-service")
public class StockFeignController {
    @Autowired
    private StockServiceProxy stockServiceProxy;

    @GetMapping("/{productNumber}")
    public String getStock(@PathVariable String productNumber) {
        return stockServiceProxy.getStockFeign(productNumber);
    }

}
