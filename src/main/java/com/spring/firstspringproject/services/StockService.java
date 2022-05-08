package com.spring.firstspringproject.services;

import java.util.List;

import com.spring.firstspringproject.model.Stock;

public interface StockService {
	
	Stock createStock(Stock stock);
	List <Stock> getAllStocks();
	Stock getStockById(long id);
	Stock updateStockById(Stock stock, long id);
	

}
