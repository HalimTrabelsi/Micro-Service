package com.example.projetmicroservice.repository;

import com.example.projetmicroservice.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock, Integer> {
    List<Stock> findByStockNameContainingIgnoreCaseAndStockTypeContainingIgnoreCase(String name, String type);
}
