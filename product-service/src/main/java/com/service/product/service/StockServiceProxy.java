package com.service.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service")
public interface StockServiceProxy {
    @GetMapping("/stocks/{productNumber}")
    String getStockFeign(@PathVariable("productNumber") String productNumber);
}
