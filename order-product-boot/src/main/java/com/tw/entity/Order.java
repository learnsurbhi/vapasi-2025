package com.tw.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;


    private LocalDate orderDate;
    @Column(length = 20) // to specify just the length of the value like for date it is in date format
    private String payMode;
    private double platformFee;

    @JsonBackReference("prod")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="code")
    private Product prod;

    @JsonBackReference("cust")
    @ManyToOne
    @JoinColumn(name="cust_id")
    private Customer customer;

}
