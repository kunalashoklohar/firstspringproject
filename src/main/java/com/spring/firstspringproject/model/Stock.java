package com.spring.firstspringproject.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name="stock")
public class Stock {
	  // This constructor was needed for post @Requestbody for binding
	    public Stock(long id, String stockName, float currentPrice) {
		super();
		this.id = id;
		this.stockName = stockName;
		this.currentPrice = currentPrice;
	}
	    
         //      default constructor needed for stockRepository.findAll()
	    public Stock() {
			
		}
	    
	    
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
	    
	    @Column(name = "stock_name", nullable = false)
		private String stockName;
	    
	    @Column(name = "current_price", nullable = false)
		private float currentPrice;


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getStockName() {
			return stockName;
		}

		public void setStockName(String stockName) {
			this.stockName = stockName;
		}

		public float getCurrentPrice() {
			return currentPrice;
		}

		public void setCurrentPrice(float currentPrice) {
			this.currentPrice = currentPrice;
		}
		

}
