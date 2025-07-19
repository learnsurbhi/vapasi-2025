package com.tw.service;

import com.tw.entity.Ticket;

import java.util.Date;
import java.util.List;

public interface TicketService {

    Ticket save(Ticket ticket);
    Ticket findByPnr(int pnr);
    List<Ticket> findAll();
    List<Ticket> findByDate(Date date);


}
