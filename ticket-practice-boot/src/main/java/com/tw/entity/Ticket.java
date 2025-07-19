package com.tw.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
@Table(name="ticket")
public class Ticket {

    @Id
private int pnr;
    @Column(length=20)
private String source;
    @Column(length=20)
private String destination;
    @Column(length=20)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
private Date date;
}
