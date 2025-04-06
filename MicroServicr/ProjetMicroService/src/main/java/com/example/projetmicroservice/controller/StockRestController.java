package com.example.projetmicroservice.controller;

import com.example.projetmicroservice.entities.Stock;
import com.example.projetmicroservice.repository.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RequestMapping("/api/stocks")
public class StockRestController {

    @Autowired
    private StockService stockService;

    // 🔹 Ajouter un stock
    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.addStock(stock), HttpStatus.CREATED);
    }

    // 🔹 Mettre à jour un stock
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable int id, @RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.updateStock(id, stock), HttpStatus.OK);
    }

    // 🔹 Supprimer un stock
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable int id) {
        return new ResponseEntity<>(stockService.deleteStock(id), HttpStatus.OK);
    }

    // 🔹 Récupérer tous les stocks
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.OK);
    }

    // 🔹 Récupérer un stock par ID
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable int id) {
        Optional<Stock> stock = stockService.getStockById(id);
        return stock.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // 🔹 Compter les stocks
    @GetMapping("/count")
    public ResponseEntity<Long> countStocks() {
        return new ResponseEntity<>(stockService.countStocks(), HttpStatus.OK);
    }

    // 🔹 Rechercher des stocks
    @GetMapping("/search")
    public ResponseEntity<List<Stock>> searchStocks(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String type) {
        List<Stock> stocks = stockService.searchStocks(name, type);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
}
