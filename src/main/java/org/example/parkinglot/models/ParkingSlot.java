package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.ParkingSLotStatus;
import org.example.parkinglot.models.enums.VehicleType;

public class ParkingSlot extends BaseModel {
    private int slotNumber;
    private ParkingSLotStatus parkingSlotStatus;
    private VehicleType vehicleType;
    private Vehicle vehicle;

    public ParkingSlot(int slotNumber, VehicleType vehicleType) {
        this.slotNumber = slotNumber;
        this.vehicleType = vehicleType;

    }


    public ParkingSLotStatus getParkingSlotStatus() {
        return parkingSlotStatus;
    }

    public void setParkingSlotStatus(ParkingSLotStatus parkingSlotStatus) {
        this.parkingSlotStatus = parkingSlotStatus;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }




}