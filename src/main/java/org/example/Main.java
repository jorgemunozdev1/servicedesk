package org.example;

import org.example.repository.InMemoryTicketRepository;
import org.example.service.TicketService;
import org.example.ui.ConsoleUI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var repository = new InMemoryTicketRepository();
        var service = new TicketService(repository);
        var ui = new ConsoleUI(service);

        ui.start();
    }
}