package com.tw.repo;

import com.tw.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TicketRepo extends JpaRepository<Ticket,Integer> {

List<Ticket> findAllByDate(Date date);
List<Ticket> findAll();
Optional<Ticket> findByPnr(int pnr);

}
