package org.example.parkinglot.models;
import org.example.parkinglot.models.enums.ParkingFloorStatus;
import org.example.parkinglot.models.enums.VehicleType;

import java.util.ArrayList;
import java.util.List;


public class ParkingFloor extends BaseModel {

    private int floorNumber;
    private List<ParkingSlot> parkingSlotList;
    private List<VehicleType> allowedVehicleTypes;

    public ParkingFloor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.parkingSlotList = new ArrayList<>();
    }



    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSlot> getParkingSlotList() {
        return parkingSlotList;
    }

    public void setParkingSlotList(List<ParkingSlot> parkingSlotList) {
        this.parkingSlotList = parkingSlotList;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    private ParkingFloorStatus parkingFloorStatus;

}
