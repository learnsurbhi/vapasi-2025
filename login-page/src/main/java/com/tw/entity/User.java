package com.tw.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length =20, nullable = false)
    private String name;
    @Column(length =20, nullable = false)
    private String email;
    @Column(length =20, nullable = false)
    private String password;
}
