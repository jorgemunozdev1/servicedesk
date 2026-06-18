package org.example.repository;

import org.example.model.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryTicketRepository implements TicketRepository {
    private final List<Ticket> tickets = new ArrayList<>();
    private long currentId = 1;

    @Override
    public List<Ticket> findAll() {
        return tickets;
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return tickets.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public Ticket save(Ticket ticket) {
        if (ticket.getId() == null) {
            ticket.setId(currentId++);
            tickets.add(ticket);
        } else {
            tickets.removeIf(t -> t.getId().equals(ticket.getId()));
            tickets.add(ticket);
        }
        return ticket;
    }
}
