package org.example.repository;

import org.example.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {
    List<Ticket> findAll();
    Optional<Ticket> findById(Long id);
    Ticket save(Ticket ticket);
}
