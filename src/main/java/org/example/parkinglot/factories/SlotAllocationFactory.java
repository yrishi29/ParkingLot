package org.example.parkinglot.factories;


import org.example.parkinglot.models.enums.SlotAllocationStrategyType;
import org.example.parkinglot.strategies.SlotAllocationStratergy.ClosestAvailableAllocation;
import org.example.parkinglot.strategies.SlotAllocationStratergy.FarthestAvailableAllocation;
import org.example.parkinglot.strategies.SlotAllocationStratergy.RandomSlotAllocation;
import org.example.parkinglot.strategies.SlotAllocationStratergy.SlotAllocationStrategy;

public class SlotAllocationFactory {


    public static SlotAllocationStrategy getSlotAllocationStrategy(SlotAllocationStrategyType type) {
        if(type == SlotAllocationStrategyType.RANDOM){
            return new RandomSlotAllocation();
        }
        if(type == SlotAllocationStrategyType.NEAREST_TO_GATE){
            return new ClosestAvailableAllocation();
        }
        return new FarthestAvailableAllocation();
    }
}