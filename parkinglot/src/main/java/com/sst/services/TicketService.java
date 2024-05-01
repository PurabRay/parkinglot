package com.scaler.parkinglot.services;

import com.scaler.parkinglot.exceptions.NoParkingSpotAvailableException;
import com.scaler.parkinglot.models.*;
import com.scaler.parkinglot.repositories.TicketRepository;
import com.scaler.parkinglot.strategy.spotassignmentstrategy.SpotAssignmentStrategy;

import java.util.Date;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;

    public TicketService(VehicleService vehicleService, GateService gateService, SpotAssignmentStrategy spotAssignmentStrategy,
                         TicketRepository ticketRepository) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(String vehicleNumber, VehicleType vehicleType, Long gateId) throws NoParkingSpotAvailableException {
        // Using vehicle number we can fetch the vehicle object.
        // If Vehicle object is already there then fetch it otherwise create it.
        Vehicle vehicle = vehicleService.getVehicle(vehicleNumber);

        if (vehicle == null) {
            vehicle = vehicleService.registerVehicle(vehicleNumber, vehicleType);
        }

        Gate gate =  gateService.getGate(gateId);

        Ticket ticket = new Ticket();
        ticket.setVehicle(vehicle);
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setOperator(gate.getOperator());

        //Assign parking spot to the vehicle.
        ParkingSpot spot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        if (spot == null) {
            throw new NoParkingSpotAvailableException("No Parking spot is available");
        }

        ticket.setParkingSpot(spot);

        Ticket savedTicket = ticketRepository.saveTicket(ticket);

        return savedTicket;
    }
}
