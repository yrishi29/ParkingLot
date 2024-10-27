package org.example.parkinglot.models;

import org.example.parkinglot.models.enums.PaymentMode;
import org.example.parkinglot.models.enums.PaymentStatus;

public class Payment extends BaseModel {
    private int amount;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private Bill bill;
    private String refId;
}
