package com.scaler.parkinglot.controllers;

import com.scaler.parkinglot.dto.GenerateTicketRequestDto;
import com.scaler.parkinglot.dto.GenerateTicketResponseDto;
import com.scaler.parkinglot.exceptions.NoParkingSpotAvailableException;
import com.scaler.parkinglot.models.ResponseStatus;
import com.scaler.parkinglot.models.Ticket;
import com.scaler.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) throws NoParkingSpotAvailableException {
        //Vehicle Number -> Get the vehicle object.
        //Gate id -> Get teh gate object.

        try {
            Ticket ticket = ticketService.generateTicket(generateTicketRequestDto.getVehicleNumber(),
                    generateTicketRequestDto.getVehicleType(),
                    generateTicketRequestDto.getGateId());

            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setTicket(ticket);
            generateTicketResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return generateTicketResponseDto;
        } catch (NoParkingSpotAvailableException noParkingSpotAvailableException) {
            GenerateTicketResponseDto generateTicketResponseDto = new GenerateTicketResponseDto();
            generateTicketResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return generateTicketResponseDto;
        }
    }
}




