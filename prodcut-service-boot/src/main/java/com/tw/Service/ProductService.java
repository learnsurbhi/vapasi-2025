package com.tw.Service;

import com.tw.Model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);
    Product findById(int id);
    List<Product> findByName(String name);
    List<Product> findByCategory(String category);
}
