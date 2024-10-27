package org.example.parkinglot.dtos;

import org.example.parkinglot.dtos.enums.ResponseStatus;
import org.example.parkinglot.models.ParkingSlot;

import java.util.Date;

public class IssueTicketResponseDTO {


    private String ticketNumber;
    private String responseMessage;
    private ResponseStatus responseStatus;
    private Date entryTime;
    private ParkingSlot parkingSlot;

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }


}
