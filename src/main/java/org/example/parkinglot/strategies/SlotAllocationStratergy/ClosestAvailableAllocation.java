package org.example.parkinglot.strategies.SlotAllocationStratergy;

import org.example.parkinglot.models.*;
import org.example.parkinglot.models.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ClosestAvailableAllocation implements  SlotAllocationStrategy {


    @Override
    public ParkingSlot getParkingSlot(ParkingLot parkingLot, VehicleType vehicleType, Gate gate) {

        List<ParkingSlot> emptySlots = new ArrayList<>();

        for(ParkingFloor floor : parkingLot.getParkingFloors()) {
            for(ParkingSlot slot: floor.getParkingSlotList()){

                if (slot.getVehicle() == null && slot.getVehicleType() == vehicleType) {
                    slot.setVehicle( new Vehicle (vehicleType)); // Assign vehicle
                    return slot;
                }
            }
        }


        return null;
    }



}
