package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.VehicleType;

public class Vehicle extends BaseModel{

    private String vehicleNumber;
    private String nameOfOwner;
    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType){
        this.vehicleType = vehicleType;

    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }



}
