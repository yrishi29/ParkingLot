package org.example.parkinglot.strategies.SlotAllocationStratergy;

import org.example.parkinglot.models.Gate;
import org.example.parkinglot.models.ParkingLot;
import org.example.parkinglot.models.ParkingSlot;
import org.example.parkinglot.models.enums.VehicleType;

public class FarthestAvailableAllocation implements  SlotAllocationStrategy {


    @Override
    public ParkingSlot getParkingSlot(ParkingLot parkingLot, VehicleType vehicleType, Gate gate) {
        return null;
    }
}
