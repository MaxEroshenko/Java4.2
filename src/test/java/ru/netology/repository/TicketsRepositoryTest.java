package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.exception.notFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TicketsRepositoryTest {
    private TicketsRepository repository = new TicketsRepository();
    private Ticket first = new Ticket(1, 26500, "DME", "FRU", 125);
    private Ticket second = new Ticket(2, 29700, "OGZ", "VKO", 115);
    private Ticket third = new Ticket(3, 16300, "DME", "FRU", 125);

    @BeforeEach
    public void setUp() {
        repository = new TicketsRepository();
        repository.save(first);
        repository.save(second);
        repository.save(third);
    }

    @Test
    public void shouldFindAllTickets() {
        Ticket[] expected = new Ticket[]{first, second, third};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfExist() {
        int idToFind = 2;

        Ticket expected = second;
        Ticket actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindByIdIfNotExist() {
        int idToFind = 7;
        Ticket expected = null;
        Ticket actual = repository.findById(idToFind);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfExist() {
        int idToRemove = 3;

        repository.removeById(idToRemove);

        Ticket[] expected = {first, second};
        Ticket[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfNotExist() {
        assertThrows(notFoundException.class, () -> repository.removeById(5));
    }
}
