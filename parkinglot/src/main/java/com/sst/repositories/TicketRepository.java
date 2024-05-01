package com.scaler.parkinglot.repositories;

import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.services.TicketService;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    //map -> ticketId : ticketObj
    private Map<Long, Ticket> tickets = new HashMap<>();
    private Long ticketIdSequence = 0L;

    public Ticket saveTicket(Ticket ticket) {
        /// do something.
        ticketIdSequence += 1;
        ticket.setId(ticketIdSequence);
        tickets.put(ticketIdSequence, ticket);
        return ticket;
    }
}
