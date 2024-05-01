package com.sst;

public class Main {
    public static void main(String[] args) throws NoParkingSpotAvailableException {
        System.out.println("Hello world!");

        //Create the objects of all the services, repositories and controllers.
        //Dependencies.

        //Registry Design pattern -> To store all the objects at one place
        //So that we can use these objects whenever required.
        ObjectRegistry objectRegistry = new ObjectRegistry();
        VehicleService vehicleService = new VehicleService();
        GateService gateService = new GateService();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotRepository);
        TicketService ticketService = new TicketService(vehicleService,
                gateService, spotAssignmentStrategy, ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        objectRegistry.register("vehicleService", vehicleService);
        objectRegistry.register("gateService", gateService);
        objectRegistry.register("ticketRepository", ticketRepository);
        objectRegistry.register("parkingLotRepo", parkingLotRepository);
        objectRegistry.register("spotAssignmentStrategy", spotAssignmentStrategy);
        objectRegistry.register("ticketService", ticketService);
        objectRegistry.register("ticketController", ticketController);

        GenerateTicketRequestDto requestDto = new GenerateTicketRequestDto();
        requestDto.setVehicleType(VehicleType.SMALL);
        requestDto.setVehicleNumber("HR16X11234");
        requestDto.setGateId(123L);

        GenerateTicketResponseDto responseDto = ticketController.generateTicket(requestDto);

        Ticket ticket = responseDto.getTicket();
        //We have got the Ticket, do whatever you want !!
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.