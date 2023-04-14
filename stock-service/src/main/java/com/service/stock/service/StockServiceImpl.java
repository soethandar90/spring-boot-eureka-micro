package com.service.stock.service;

import com.service.stock.contract.StockDto;
import com.service.stock.dataaccess.StockCollection;
import com.service.stock.domain.Stock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockCollection stockCollection;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StockDto addStock(Stock product) {
        return modelMapper.map(stockCollection.save(product), StockDto.class);
    }

    @Override
    public StockDto updateStock(String productNumber, Stock stock) {
        Stock existingStock = modelMapper.map(getStock(productNumber).get(), Stock.class);
        existingStock.setNumberInStock(stock.getNumberInStock());
        existingStock.setLocationCode(stock.getLocationCode());
        return modelMapper.map(stockCollection.save(existingStock), StockDto.class);
    }

    @Override
    public Optional<StockDto> getStock(String productNumber) {
        return Optional.ofNullable(modelMapper.map(stockCollection.findById(productNumber), StockDto.class));
    }

    @Override
    public List<StockDto> getStockList() {
        List<StockDto> StockDtoList = new ArrayList<>();
        List<Stock> stockList= stockCollection.findAll();
        if(stockList.size()>0){
            ListIterator<Stock> itr = stockList.listIterator();
            while(itr.hasNext()){
                StockDtoList.add(modelMapper.map(itr.next(), StockDto.class));
            }
        }
        return StockDtoList;
    }

    @Override
    public void deleteStock(String productNumber) {
        stockCollection.deleteById(productNumber);
    }
}
