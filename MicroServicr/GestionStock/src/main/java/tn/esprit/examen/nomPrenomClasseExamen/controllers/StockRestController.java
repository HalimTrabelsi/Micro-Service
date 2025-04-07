package tn.esprit.examen.nomPrenomClasseExamen.controllers;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Stock;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.StockRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.services.StockService;



import java.util.List;
import java.util.Optional;


@RestController
@Service
@RequestMapping("/api/stocks")
public class StockRestController {

    @Autowired
    private StockService stockService;

    // 🔹 Ajouter un stock
    @PostMapping("/addStock")
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.addStock(stock), HttpStatus.CREATED);
    }

    // 🔹 Mettre à jour un stock
    @PutMapping("/updateStock/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable int id, @RequestBody Stock stock) {
        return new ResponseEntity<>(stockService.updateStock(id, stock), HttpStatus.OK);
    }

    // 🔹 Supprimer un stock
    @DeleteMapping("/deleteStock/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable int id) {
        return new ResponseEntity<>(stockService.deleteStock(id), HttpStatus.OK);
    }

    // 🔹 Récupérer tous les stocks
    @GetMapping("/getAllStocks")
    public ResponseEntity<List<Stock>> getAllStocks() {
        return new ResponseEntity<>(stockService.getAllStocks(), HttpStatus.OK);
    }

    // 🔹 Récupérer un stock par ID
    @GetMapping("/getStockById/{id}")
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

    // 🔹 Rechercher des stocks par nom
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Stock>> searchStocks(@PathVariable String name) {
        List<Stock> stocks = stockService.searchStocks(name);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    // 🔹 Trier les stocks par prix (ordre décroissant par défaut)
    @GetMapping("/sortByPrice")
    public ResponseEntity<List<Stock>> sortStocksByPrice() {
        List<Stock> stocks = stockService.sortStocksByPriceDesc();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
    // 🔹 Trier les stocks par prix avec un PathVariable
    @GetMapping("/sortByPriceByOrder/{order}")
    public ResponseEntity<List<Stock>> sortStocksByPrice(@PathVariable String order) {
        List<Stock> stocks = stockService.sortStocksByPrice(order);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }




}
