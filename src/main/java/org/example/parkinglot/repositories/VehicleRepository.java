package org.example.parkinglot.repositories;

import org.example.parkinglot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long, Vehicle> vehicleMap;
    private long counter;

    public VehicleRepository() {
        this.vehicleMap = new HashMap<>();
        this.counter = 0;
    }

    public Vehicle save(Vehicle vehicle){
        counter++;
        vehicle.setId(counter);
        vehicleMap.put(counter, vehicle);
        return vehicle;
    }

    public Optional<Vehicle> get(long id){
        if(vehicleMap.containsKey(id)){
            return Optional.of(vehicleMap.get(id));
        }
        return Optional.empty();
    }

    public Optional<Vehicle> getByNumber(String givenVehicleNumber){
        for(Vehicle vehicle : vehicleMap.values()){
            if(vehicle.getVehicleNumber().equals(givenVehicleNumber)){
                return Optional.of(vehicle);
            }
        }
        return Optional.empty();

    }
}
