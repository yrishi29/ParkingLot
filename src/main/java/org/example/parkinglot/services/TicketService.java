package org.example.parkinglot.services;

import org.example.parkinglot.exceptions.GateNotFoundException;
import org.example.parkinglot.exceptions.ParkingLotNotFound;
import org.example.parkinglot.factories.SlotAllocationFactory;
import org.example.parkinglot.models.*;
import org.example.parkinglot.models.enums.SlotAllocationStrategyType;
import org.example.parkinglot.models.enums.VehicleType;
import org.example.parkinglot.repositories.GateRepository;
import org.example.parkinglot.repositories.ParkingLotRepository;
import org.example.parkinglot.repositories.TicketRepository;
import org.example.parkinglot.repositories.VehicleRepository;
import org.example.parkinglot.strategies.SlotAllocationStratergy.SlotAllocationStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    TicketRepository ticketRepository;
    GateRepository gateRepository;
    VehicleRepository vehicleRepository;
    ParkingLotRepository parkingLotRepository;


    public TicketService(TicketRepository ticketRepository
    , GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository) {
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public Ticket issueTicket(String vehicleNumber,
                              String ownerName,
                              VehicleType vehicleType,
                              long gateId) throws Exception {

        Ticket ticket = new Ticket();

        ticket.setEntryTime(new Date());
        Optional<Gate> optionalGate =  gateRepository.get(gateId);

        if(optionalGate.isEmpty()) {
            throw new GateNotFoundException("Gate not found ");

        }

        Gate gate = optionalGate.get();
        ticket.setGeneratedAt(gate);
        ticket.setGeneratedBy(gate.getCurrentOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.getByNumber(vehicleNumber);
        Vehicle savedVehicle;
        if(optionalVehicle.isEmpty()) {
            // save the vehicle!
            Vehicle vehicle = new Vehicle(vehicleType);
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setNameOfOwner(ownerName);

            savedVehicle = vehicleRepository.save(vehicle);
        } else {
            savedVehicle = optionalVehicle.get();
        }
        ticket.setVehicle(savedVehicle);

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.getByGate(gate);

        if(parkingLotOptional.isEmpty()){
            throw new ParkingLotNotFound("Parking Lot not found exception");

        }

        ParkingLot parkingLot = parkingLotOptional.get();

        SlotAllocationStrategyType slotAllocationStrategyType = parkingLot.getSlotAllocationStrategyType();


        SlotAllocationStrategy slotAllocationStrategy = SlotAllocationFactory.getSlotAllocationStrategy(slotAllocationStrategyType);

        // 4. from this implementation, get the actual slot.
        ParkingSlot parkingSlot = slotAllocationStrategy.getParkingSlot(parkingLot, vehicleType, gate);
        if(parkingSlot == null) {
            throw new Exception("Parking lot is full, cannot generate ticket");
        }
        ticket.setParkingSlot(parkingSlot);

        Ticket updatedTicket = ticketRepository.save(ticket);   // to get the actual id of the ticket
        updatedTicket.setTicketNumber("TicketID---" + ticket.getId());
        return updatedTicket;



    }
}
