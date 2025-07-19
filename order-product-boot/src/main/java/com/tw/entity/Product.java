package com.tw.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
//creating  a table with same name as entity
public class Product {
    @Id
    private int code;
    @Column(length = 100)
    private String name;
    private double price;
    private int stock;

    @JsonManagedReference("prod")
    @OneToMany(mappedBy = "prod")
    private List<Order> orders;
}
