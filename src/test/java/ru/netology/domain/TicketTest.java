package ru.netology.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private Ticket first = new Ticket(1, 26500, "DME", "FRU", 125);
    private Ticket second = new Ticket(2, 29700, "OGZ", "VKO", 115);
    private Ticket third = new Ticket(3, 16300, "DME", "FRU", 125);

    @Test
    public void shouldSortTicketsByPrice() {
        Ticket[] expected = new Ticket[]{third, first, second};
        Ticket[] actual = new Ticket[]{first, second, third};

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);
    }
}
