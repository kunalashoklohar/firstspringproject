package com.spring.firstspringproject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.spring.firstspringproject.model.Stock;
import com.spring.firstspringproject.services.StockService;


@RestController
@RequestMapping("/stockapi")
public class StockController {
	private StockService stockService;

	public StockController(StockService stockService) {
		
		super();
		this.stockService = stockService;
		System.out.println("_________________________heyyyy---------------------");
	}
	// create-stock RST API
	
	@PostMapping("/add/stock")
	@ResponseBody
	public ResponseEntity<Stock> createStock(@RequestBody Stock stock){
//		Stock st1 = new Stock(0, st, 0) ;
		System.out.println(stock);
		return new ResponseEntity<Stock>(stockService.createStock(stock) ,HttpStatus.CREATED);
		
	}
	
	//get-all stocks Rest API
	@GetMapping(value = "/get/stocks")
	public List <Stock> getAllStocks(){
		return stockService.getAllStocks();
	}
	
	// get a stock by id
	@GetMapping(value = "/get/stock/{id}")
	public ResponseEntity<Stock> getStockById(@PathVariable("id") long id){
		return new ResponseEntity<Stock>(stockService.getStockById(id), HttpStatus.OK); 
	}
	
	@PutMapping(value = "/update/stock/{id}")
	public ResponseEntity<Stock> updateStockById(@RequestBody Stock stock,@PathVariable("id") long id){
		return new ResponseEntity<Stock>(stockService.updateStockById(stock, id), HttpStatus.OK); 
	}

}
