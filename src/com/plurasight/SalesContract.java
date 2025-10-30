package com.plurasight;

import com.plurasight.Contract;
import com.plurasight.Vehicle;

public class SalesContract extends Contract {
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail,
                         Vehicle vehicle, boolean finance) {
        super(date, customerName, customerEmail, vehicle);
        this.finance = finance;
    }

    private double getSalesTax() {
        return vehicle.getPrice() * 0.05;
    }

    private double getRecordingFee() {
        return 100;
    }

    private double getProcessingFee() {
        return vehicle.getPrice() < 10000 ? 295 : 495;
    }

    @Override
    public double getTotalPrice() {
        return vehicle.getPrice() + getSalesTax() + getRecordingFee() + getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) return 0;

        double price = vehicle.getPrice();
        if (price >= 10000) {
            return (price * (0.0425 / 12)) / (1 - Math.pow(1 + 0.0425 / 12, -48));
        } else {
            return (price * (0.0525 / 12)) / (1 - Math.pow(1 + 0.0525 / 12, -24));
        }
    }

    @Override
    public String toString() {
        return "SALE | " + customerName + " | " + vehicle.getMake() + " " + vehicle.getModel()
                + " | Total: $" + String.format("%.2f", getTotalPrice())
                + " | Monthly: $" + String.format("%.2f", getMonthlyPayment());
    }
}