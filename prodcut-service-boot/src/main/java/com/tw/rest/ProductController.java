package com.tw.rest;

import com.tw.Model.Product;
import com.tw.Service.ProductService;
import com.tw.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/prod")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(value="/add",consumes="application/json",produces = "application/json")
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product pro= productService.save(product);
        return new ResponseEntity<>(pro,HttpStatus.OK);
    }

    @GetMapping(value="/category/{category}",produces = "application/json")
    public ResponseEntity<List<Product>> findByCategory(@PathVariable String category) {
        List<Product> products= productService.findByCategory(category);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
