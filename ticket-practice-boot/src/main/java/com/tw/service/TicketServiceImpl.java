package com.tw.service;

import com.tw.entity.Ticket;
import com.tw.repo.TicketRepo;
import com.tw.util.InvalidTicketException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public Ticket save(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

    @Override
    public Ticket findByPnr(int pnr) {
        return ticketRepo.findByPnr(pnr).orElseThrow(() -> new InvalidTicketException("Ticket with PNR " + pnr + " not found"));
    }

    @Override
    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> findByDate(Date date) {
        return ticketRepo.findAllByDate(date);
    }
}
