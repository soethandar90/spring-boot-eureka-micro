package com.service.stock.contract;

import lombok.Data;
@Data
public class StockDto {
    private String productNumber;
    private int numberInStock;
    private String locationCode;
}
