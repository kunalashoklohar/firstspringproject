package com.spring.firstspringproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.firstspringproject.model.Stock;


public interface StockRepository extends JpaRepository<Stock, Long> {

}
