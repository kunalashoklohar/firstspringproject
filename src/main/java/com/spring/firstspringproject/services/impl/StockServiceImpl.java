package com.spring.firstspringproject.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;



import com.spring.firstspringproject.services.StockService;
import com.spring.firstspringproject.exception.ResourceNotFoundException;
import com.spring.firstspringproject.model.Stock;
import com.spring.firstspringproject.repository.StockRepository;
@Service
public class StockServiceImpl implements StockService{
    
	private StockRepository stockRepository;
	
	public StockServiceImpl(StockRepository stockRepository) {
		super();
		this.stockRepository = stockRepository;
	}


	@Override
	public Stock createStock(Stock stock) {
	    System.out.println("Heyyyyyyyyyyyyyyyyyyyyyyyyy");
		return stockRepository.save(stock);
	}


	@Override
	public List<Stock> getAllStocks() {
		System.out.println(stockRepository.findAll());
     return stockRepository.findAll();
	}


	@Override
	public Stock getStockById(long id) {
	Optional <Stock> stock = stockRepository.findById(id);
//	Use Lambda Expression here
//	Java8  function Interface and lambda expression
//	return stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stock", "ID", id));
	if(stock.isPresent()) {
		return stock.get();
	}
	else {
		throw new ResourceNotFoundException("Stock", "ID", id);
	}
	}


	@Override
	public Stock updateStockById(Stock stock, long id) {
	    // check the okd stock
		Stock oldStock = stockRepository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Stock", "ID", id));
		// update the old stock
		oldStock.setStockName(stock.getStockName());
		oldStock.setCurrentPrice(stock.getCurrentPrice());
       // save to db
		stockRepository.save(oldStock);
		return oldStock;
	}

}
