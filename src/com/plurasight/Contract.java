package com.plurasight;

public abstract class Contract {
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicle;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    // total price
    public abstract double getTotalPrice();

    // monthly payment
    public abstract double getMonthlyPayment();
}
