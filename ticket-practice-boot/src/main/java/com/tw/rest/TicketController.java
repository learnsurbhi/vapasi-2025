package com.tw.rest;

import com.tw.entity.Ticket;
import com.tw.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping(value="/add",consumes = "application/json",produces = "application/json")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        Ticket savedticket = ticketService.save(ticket);
        return new ResponseEntity<>(savedticket, HttpStatus.OK);
    }

    @GetMapping(value="/listoftickets",produces="application/json")
    public ResponseEntity<List<Ticket>> findAll() {
        return new ResponseEntity<>(ticketService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/date/{date}",produces="application/json")
    public ResponseEntity<List<Ticket>> findAllByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ssss") Date date) {
        List<Ticket> tickets = ticketService.findByDate(date);
        if (tickets == null || tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else  {
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        }
    }

}
