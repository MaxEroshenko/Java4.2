package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsRepository repository = new TicketsRepository();
    private TicketsManager manager = new TicketsManager(repository);
    private Ticket first = new Ticket(1, 26500, "DME", "FRU", 125);
    private Ticket second = new Ticket(2, 29700, "OGZ", "VKO", 115);
    private Ticket third = new Ticket(3, 16300, "DME", "FRU", 125);

    @BeforeEach
    public void setUp() {
        manager = new TicketsManager(repository);
    }
    @Test
    public void shouldReturnEmptyIfNoTickets() {
        manager.ticketAdd(first);
        manager.ticketAdd(second);
        manager.ticketAdd(third);
        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("GOJ", "KUF");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnTicketIfContains() {
        manager.ticketAdd(first);
        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = manager.findAll("DME", "FRU");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsIfContains() {
        manager.ticketAdd(first);
        manager.ticketAdd(second);
        manager.ticketAdd(third);
        Ticket[] expected = new Ticket[]{third, first};
        Ticket[] actual = manager.findAll("DME", "FRU");
        assertArrayEquals(expected, actual);
    }

}
