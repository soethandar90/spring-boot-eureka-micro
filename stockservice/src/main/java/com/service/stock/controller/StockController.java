package com.service.stock.controller;

import com.service.stock.contract.StockDto;
import com.service.stock.domain.Stock;
import com.service.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<StockDto> addStock(@RequestBody Stock product) {
        return new ResponseEntity<StockDto>(stockService.addStock(product), HttpStatus.CREATED);
    }

    @PutMapping("/{productNumber}")
    public ResponseEntity<StockDto> updateStock(@PathVariable String productNumber, @RequestBody Stock product) {
        return new ResponseEntity<>(stockService.updateStock(productNumber, product), HttpStatus.OK);
    }

    @GetMapping("/{productNumber}")
    public ResponseEntity<Optional<StockDto>> getStock(@PathVariable String productNumber) {
        return new ResponseEntity<>(stockService.getStock(productNumber), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StockDto>> getStockList() {
        return new ResponseEntity<>(stockService.getStockList(), HttpStatus.OK);
    }

    @DeleteMapping("/{productNumber}")
    public ResponseEntity deleteStock(@PathVariable String productNumber) {
        stockService.deleteStock(productNumber);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
