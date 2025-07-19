package com.tw.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="roles")
public class Role {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     @Column(nullable = false,unique = true,length = 20)
     private String roleName;

     @ManyToMany(mappedBy="roles")
    private List<User> users;
}
