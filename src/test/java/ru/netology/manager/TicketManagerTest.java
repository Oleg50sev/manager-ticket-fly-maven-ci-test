package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;


import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(1, 1499, "DME", "SIP", 145);
    Ticket ticket2 = new Ticket(2, 1299, "SIP", "SVO", 160);
    Ticket ticket3 = new Ticket(3, 4100, "LED", "UFA", 170);
    Ticket ticket4 = new Ticket(4, 2950, "VKO", "KZN", 155);
    Ticket ticket5 = new Ticket(5, 1299, "DME", "SIP", 145);

    @BeforeEach
    void add() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    void shouldfindAllSeveralTicketsMinToMax() {

        Ticket[] expected = {ticket5, ticket1};
        Ticket[] actual = manager.findAll("DME", "SIP");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindAllOneTicket() {

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("VKO", "KZN");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindAllOnlyFrom() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindAllOnlyTo() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldfindAllNull() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("", "");
        assertArrayEquals(expected, actual);
    }
}