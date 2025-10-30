package com.plurasight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private List<com.plurasight.Vehicle> inventory = new ArrayList<>();

    public Dealership() {
        //
        inventory.add(new com.plurasight.Vehicle(1001, 2022, "♾\uFE0F Toyota", "Camry ♾\uFE0F", "Sedan", "Black", 15000, 22000));
        inventory.add(new com.plurasight.Vehicle(1002, 2020, "♾\uFE0F BMW", "M5 ♾\uFE0F", "Sedan", "Black", 30000, 18000));
        inventory.add(new com.plurasight.Vehicle(1003, 2019, "♾\uFE0F Ford", "Raptor ♾\uFE0F", "Truck", "Blue", 45000, 29000));
    }

    public List<com.plurasight.Vehicle> getAllVehicles() {
        return inventory;
    }

    public com.plurasight.Vehicle findByVin(int vin) {
        for (com.plurasight.Vehicle v : inventory) {
            if (v.getVin() == vin && !v.isSold()) {
                return v;
            }
        }
        return null;
    }

    public void addVehicle(com.plurasight.Vehicle v) {
        inventory.add(v);
    }

    public boolean removeVehicle(int vin) {
        return inventory.removeIf(v -> v.getVin() == vin);
    }

    public List<com.plurasight.Vehicle> getByPrice(double min, double max) {
        List<com.plurasight.Vehicle> result = new ArrayList<>();
        for (com.plurasight.Vehicle v : inventory) {
            if (!v.isSold() && v.getPrice() >= min && v.getPrice() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<com.plurasight.Vehicle> getByMakeModel(String make, String model) {
        List<com.plurasight.Vehicle> result = new ArrayList<>();
        for (com.plurasight.Vehicle v : inventory) {
            if (!v.isSold()
                    && v.getMake().equalsIgnoreCase(make)
                    && v.getModel().equalsIgnoreCase(model)) {
                result.add(v);
            }
        }
        return result;
    }

    public List<com.plurasight.Vehicle> getByYear(int min, int max) {
        List<com.plurasight.Vehicle> result = new ArrayList<>();
        for (com.plurasight.Vehicle v : inventory) {
            if (!v.isSold() && v.getYear() >= min && v.getYear() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<com.plurasight.Vehicle> getByColor(String color) {
        List<com.plurasight.Vehicle> result = new ArrayList<>();
        for (com.plurasight.Vehicle v : inventory) {
            if (!v.isSold() && v.getColor().equalsIgnoreCase(color)) {
                result.add(v);
            }
        }
        return result;
    }

    public List<com.plurasight.Vehicle> getByMileage(int min, int max) {
        List<com.plurasight.Vehicle> result = new ArrayList<>();
        for (com.plurasight.Vehicle v : inventory) {
            if (!v.isSold() && v.getMileage() >= min && v.getMileage() <= max) {
                result.add(v);
            }
        }
        return result;
    }

    public List<com.plurasight.Vehicle> getByType(String type) {
        List<com.plurasight.Vehicle> result = new ArrayList<>();
        for (com.plurasight.Vehicle v : inventory) {
            if (!v.isSold() && v.getType().equalsIgnoreCase(type)) {
                result.add(v);
            }
        }
        return result;
    }
}