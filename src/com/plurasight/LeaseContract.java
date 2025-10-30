package com.plurasight;

import com.plurasight.Contract;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
    }

    private double getEndValue() {
        return vehicle.getPrice() * 0.50;
    }

    private double getLeaseFee() {
        return vehicle.getPrice() * 0.07;
    }

    @Override
    public double getTotalPrice() {
        return getEndValue() + getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        double dep = (vehicle.getPrice() - getEndValue()) / 36;
        double moneyFactor = 0.04 / 2400;
        double financeFee = (vehicle.getPrice() + getEndValue()) * moneyFactor;
        double leaseFeePerMonth = getLeaseFee() / 36;
        return dep + financeFee + leaseFeePerMonth;
    }

    @Override
    public String toString() {
        return "LEASE | " + customerName + " | " + vehicle.getMake() + " " + vehicle.getModel()
                + " | Monthly: $" + String.format("%.2f", getMonthlyPayment());
    }
}