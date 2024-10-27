package org.example.parkinglot.models;


import org.example.parkinglot.models.enums.GateStatus;
import org.example.parkinglot.models.enums.GateType;

public class Gate extends BaseModel{

    private int gateNumber;
    private Operator currentOperator;


//    Gate gate2 = new Gate(2, exitGateOperator, GateType.EXIT_GATE)

    public Gate(int gateNumber, Operator currentOperator, GateType gateType){
        this.gateNumber = gateNumber;
        this.currentOperator = currentOperator;
        this.gateType = gateType;

    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    private GateType gateType;
    private GateStatus gateStatus;


}
