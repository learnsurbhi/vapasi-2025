package com.tw.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="books")
public class Book {

    @Column(length=20)
    private String title;
    @Column(length=20)
    private String author;
    @Column(length=20)
    private String genre;
    @Id
    private int isbn;
    private double price;
}
