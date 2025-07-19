package com.tw.rest;

import com.tw.entity.Customer;
import com.tw.entity.Product;
import com.tw.repo.ProductRepository;
import com.tw.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/prod")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value="/add",consumes ="application/json",produces="application/json")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
       Product newProduct = productService.addProduct(product);
       return new ResponseEntity<>(newProduct, HttpStatus.OK);
   }

   @GetMapping(value="/listofproducts",produces="application/json")
   public ResponseEntity<List<Product>> findAllProducts(){
        List <Product> p= productService.findAll();
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);

   }

   @GetMapping(value="/outofstock",produces = "application/json")
   public ResponseEntity<List<Product>> outOfStockProducts(){
        List <Product> p= productService.outOfStock();
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);

   }

//   public ResponseEntity<Product> updateStock (@RequestParam int code){
//        boolean p= productService.updateStock(code);
//        if(p){ return new ResponseEntity<>(HttpStatus.OK); }
//   }
}

