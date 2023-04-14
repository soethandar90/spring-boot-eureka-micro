package com.service.stock.service;

import com.service.stock.contract.StockDto;
import com.service.stock.domain.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    StockDto addStock(Stock product);
    StockDto updateStock(String productNumber, Stock product);
    Optional<StockDto> getStock(String productNumber);
    List<StockDto> getStockList();
    void deleteStock(String productNumber);
}
