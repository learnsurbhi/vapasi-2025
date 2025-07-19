package com.tw.repo;

import com.tw.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {

    List<Product> findByCategory(String category);
    Optional<Product> findById(int id);


    List<Product> findByName(String name);
}
