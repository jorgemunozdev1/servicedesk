package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Ticket;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonTicketRepository {
    private final String FILE_PATH = "data/tickets.json";
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public List<Ticket> findAll() {
        try {
            File file = new File(FILE_PATH);

            if (!file.exists()) return new ArrayList<>();

            return mapper.readValue(file,
                    new TypeReference<List<Ticket>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return findAll().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public Ticket save(Ticket ticket) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
