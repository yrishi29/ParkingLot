package org.example.parkinglot.repositories;

import org.example.parkinglot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Long, Ticket> ticketMap;
    private long counter = 0;

    public TicketRepository() {
        this.ticketMap = new HashMap<>();
        counter = 0;
    }

    public Ticket save(Ticket ticket) {
        counter++;
        ticket.setId(counter);
        ticketMap.put(counter, ticket);
        return ticket;
    }
}



