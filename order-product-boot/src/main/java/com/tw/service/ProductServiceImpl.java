package com.tw.service;

import com.tw.entity.Product;
import com.tw.repo.ProductRepository;
import com.tw.util.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByCode(int code) {
        return productRepository.findById(code).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> outOfStock() {
        return productRepository.findOutOfStock();
    }



    @Override
    public boolean updateStock(int code) {
        Product p= productRepository.findById(code).orElseThrow(()-> new ProductNotFoundException("Product not found"));
        if(p.getStock()==0)
            throw new ProductNotFoundException("Product not found" + code);
         p.setStock(p.getStock()-1);
         return  true;

    }

}
