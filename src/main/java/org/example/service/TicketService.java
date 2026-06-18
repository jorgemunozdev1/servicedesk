package org.example.service;

import org.example.model.Ticket;
import org.example.repository.TicketRepository;

import java.util.List;

public class TicketService {
    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket createTicket(String title, String description) {
        Ticket ticket = new Ticket(null, title, description);
        return repository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return repository.findAll();
    }
}
