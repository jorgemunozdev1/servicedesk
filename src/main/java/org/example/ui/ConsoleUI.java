package org.example.ui;

import org.example.service.TicketService;

import java.util.Scanner;

public class ConsoleUI {
    private final TicketService service;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(TicketService service) {
        this.service = service;
    }

    public void start() {

        while (true) {
            System.out.println("\n1. Crear ticket");
            System.out.println("2. Listar tickets");
            System.out.println("3. Salir");

            String option = scanner.nextLine();

            switch (option) {
                case "1" -> createTicket();
                case "2" -> listTickets();
                case "3" -> System.exit(0);
            }
        }
    }

    private void createTicket() {
        System.out.println("Título:");
        String title = scanner.nextLine();

        System.out.println("Descripción:");
        String desc = scanner.nextLine();

        service.createTicket(title, desc);

        System.out.println("Ticket creado.");
    }

    private void listTickets() {
        service.getAllTickets().forEach(System.out::println);
    }
}
