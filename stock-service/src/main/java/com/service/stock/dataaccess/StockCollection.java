package com.service.stock.dataaccess;

import com.service.stock.domain.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockCollection extends MongoRepository<Stock,String> {
}
