package org.example.parkinglot.controller;

import org.example.parkinglot.dtos.IssueTicketRequestDTO;
import org.example.parkinglot.dtos.IssueTicketResponseDTO;
import org.example.parkinglot.dtos.enums.ResponseStatus;
import org.example.parkinglot.models.Ticket;
import org.example.parkinglot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    //DI
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO) {

        IssueTicketResponseDTO responseDTO =  new IssueTicketResponseDTO();
        try {

            Ticket ticket = ticketService.issueTicket(requestDTO.getVehicleNumber(),
                    requestDTO.getOwnerName(),
                    requestDTO.getVehicleType(),
                    requestDTO.getGateId()


            );


            responseDTO.setTicketNumber(ticket.getTicketNumber());
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            responseDTO.setEntryTime(ticket.getEntryTime());
            responseDTO.setParkingSlot(ticket.getParkingSlot());
            responseDTO.setResponseMessage("Ticket generated successfully");


        }catch ( Exception e ) {

            responseDTO.setTicketNumber(null);
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setResponseMessage("Ticket not generated");
        }

        return responseDTO;

    }

}
