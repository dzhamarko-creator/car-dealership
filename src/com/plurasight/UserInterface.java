package com.plurasight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner in = new Scanner(System.in);
    private final com.plurasight.Dealership dealership = new com.plurasight.Dealership();

    public void start() {
        System.out.println(" ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡀⣄⣄⢳⠶⣶⣶⠶⠶⠖⠶⠶⢶⡶⣶⣶⣶⣶⠤⢄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢔⠋⠑⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⢯⣾⣿⣿⣿⣿⣿⣿⣾⣕⡦⡀⠀⠀⠀⠀⠀⠀⠐⠀⠁⠠⠀⢂\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣄⡔⠉⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⡏⡘⣫⣿⣿⣿⣿⣿⡼⣿⡿⢿⢘⣷⣄⣀⡀⠐⠀⠰⠀⠀⠐⠀⠂\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣠⣤⣦⣪⣷⣶⣶⣶⣶⣶⣶⣲⣶⣶⣶⣶⣶⣶⣶⣶⣾⡟⣀⣨⣿⣭⣿⣿⣿⣷⣾⣿⣿⣿⣿⣿⣿⣿⣷⠀⢀⠠⠀⠀⠀⠂⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⠈⠠⠀⠀⠠⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣶⣿⣿⣿⣿⢟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠈⠹⣿⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⢀⠀⡀⢀⢀⡀⠄⣠⣀⣾⠀⠀⠀⣜⠀⠀⠀⠀⣹⣿⠯⠍⠛⠠⠀⠒⣲⢽⣿⣿⣻⠟⠉⠀⠀⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⡜⠉⢂⡟⠠⡀⠤⢀⠄⡀⢀\n" +
                "⢌⡸⣨⠕⣎⠇⡌⡀⣿⣿⣿⣖⣦⣤⣿⣤⣤⣤⣴⣿⣿⣷⣶⣶⣶⣶⣶⣾⣿⣿⣿⠏⠀⠞⠁⠉⢄⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢠⢁⠄⠈⡗⢢⠑⢤⠁⡂⠌⠠\n" +
                "⠬⣙⢖⠻⡔⡻⡨⠅⠉⢛⠿⠿⠿⠿⠿⣿⢿⣿⣯⣿⣿⢿⡿⣿⣿⣿⣿⣿⣿⣿⡿⠀⡗⢀⠀⠠⠀⡅⢺⣿⣿⡿⣿⣻⣿⣿⣿⡾⠿⠛⡿⠟⠋⠈⠄⢄⢲⠌⢄⠣⠤⢡⡁⠎⡁\n" +
                "⣋⠵⣃⣝⡳⡱⢢⡠⠟⢼⣇⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣦⠀⠄⠀⢀⡙⣿⣿⣿⡇⠀⡃⠀⠔⢄⢉⣧⣎⡿⠚⠛⠛⠉⠉⠀⠀⠀⠀⠀⠦⣀⣀⠤⡥⣤⠳⡐⢌⡐⠌⡀⠄⡀⢀\n" +
                "⢬⠳⡃⠋⠐⠏⠁⠀⠂⠀⠈⠉⠙⠓⣷⣒⣒⡒⡒⣘⣉⣫⣿⠋⠻⠿⠿⠾⢟⢹⡃⠀⢱⢀⠈⢀⠜⠁⢲⠀⠀⠀⠀⣀⢀⠠⡀⢤⠰⡐⡌⢎⠁⢃⡑⣀⣣⢔⢠⡅⣒⢜⠢⡅⢂\n" +
                "⠀⠀⠀⠁⡀⠄⠀⡀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠉⠉⠁⠁⠀⠀⠀⠀⠀⠀⠀⠀⠑⣆⣢⡀⡎⣉⣁⣤⠶⡓⠆⠧⢚⠑⠎⣌⢣⢉⢂⣃⠱⢌⡖⣍⢃⠖⡵⠒⡭⡱⠙⠦⣉⡱⢌⡄" +
                "                     ★★ Welcome to the Best TX Dealership ★★ ");
        while (true) {
            System.out.println("""
                    1) ❇️ View all 💲
                    2) ❇️ Search by price 💲
                    3) ❇️ Search by make/model 💲
                    4) ❇️ Search by year 💲
                    5) ❇️ Search by color 💲
                    6) ❇️ Search by mileage 💲
                    7) ❇️ Search by type 💲
                    8) ❇️ Add vehicle 💲
                    9) ❇️ Remove vehicle 💲
                    10) ❇️ Buy vehicle 💲
                    11) ❇️ Lease vehicle 💲
                    0) 🛑 Exit 🛑
                    """);
            System.out.print("Choice: ");
            String choice = in.nextLine();

            switch (choice) {
                case "1" -> show(dealership.getAllVehicles());
                case "2" -> searchByPrice();
                case "3" -> searchByMakeModel();
                case "4" -> searchByYear();
                case "5" -> searchByColor();
                case "6" -> searchByMileage();
                case "7" -> searchByType();
                case "8" -> addVehicle();
                case "9" -> removeVehicle();
                case "10" -> buyVehicle();
                case "11" -> leaseVehicle();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Not a menu option.");
            }
        }
    }

    private void show(List<com.plurasight.Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }
        for (com.plurasight.Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void searchByPrice() {
        try {
            System.out.print("Min price: ");
            double min = Double.parseDouble(in.nextLine());
            System.out.print("Max price: ");
            double max = Double.parseDouble(in.nextLine());
            show(dealership.getByPrice(min, max));
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.");
        }
    }

    private void searchByMakeModel() {
        System.out.print("Make: ");
        String make = in.nextLine();
        System.out.print("Model: ");
        String model = in.nextLine();
        show(dealership.getByMakeModel(make, model));
    }

    private void searchByYear() {
        try {
            System.out.print("Min year: ");
            int min = Integer.parseInt(in.nextLine());
            System.out.print("Max year: ");
            int max = Integer.parseInt(in.nextLine());
            show(dealership.getByYear(min, max));
        } catch (NumberFormatException e) {
            System.out.println("Invalid year.");
        }
    }

    private void searchByColor() {
        System.out.print("Color: ");
        String color = in.nextLine();
        show(dealership.getByColor(color));
    }

    private void searchByMileage() {
        try {
            System.out.print("Min miles: ");
            int min = Integer.parseInt(in.nextLine());
            System.out.print("Max miles: ");
            int max = Integer.parseInt(in.nextLine());
            show(dealership.getByMileage(min, max));
        } catch (NumberFormatException e) {
            System.out.println("Invalid mileage.");
        }
    }

    private void searchByType() {
        System.out.print("Type (SUV, Sedan, Truck...): ");
        String type = in.nextLine();
        show(dealership.getByType(type));
    }

    private void addVehicle() {
        try {
            System.out.print("VIN: ");
            int vin = Integer.parseInt(in.nextLine());
            System.out.print("Year: ");
            int year = Integer.parseInt(in.nextLine());
            System.out.print("Make: ");
            String make = in.nextLine();
            System.out.print("Model: ");
            String model = in.nextLine();
            System.out.print("Type: ");
            String type = in.nextLine();
            System.out.print("Color: ");
            String color = in.nextLine();
            System.out.print("Mileage: ");
            int miles = Integer.parseInt(in.nextLine());
            System.out.print("Price: ");
            double price = Double.parseDouble(in.nextLine());

            com.plurasight.Vehicle v = new com.plurasight.Vehicle(vin, year, make, model, type, color, miles, price);
            dealership.addVehicle(v);
            System.out.println("Vehicle added.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void removeVehicle() {
        try {
            System.out.print("VIN to remove: ");
            int vin = Integer.parseInt(in.nextLine());
            boolean removed = dealership.removeVehicle(vin);
            System.out.println(removed ? "Removed." : "Not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid VIN.");
        }
    }

    private void buyVehicle() {
        try {
            System.out.print("Date (YYYY-MM-DD): ");
            String date = in.nextLine();
            System.out.print("Your name: ");
            String name = in.nextLine();
            System.out.print("Your email: ");
            String email = in.nextLine();
            System.out.print("VIN to buy: ");
            int vin = Integer.parseInt(in.nextLine());
            System.out.print("Finance? (yes/no): ");
            boolean finance = in.nextLine().equalsIgnoreCase("yes");

            com.plurasight.Vehicle v = dealership.findByVin(vin);
            if (v == null) {
                System.out.println("Vehicle not available.");
                return;
            }

            com.plurasight.SalesContract contract = new com.plurasight.SalesContract(date, name, email, v, finance);
            v.setSold(true);
            System.out.println(contract);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    private void leaseVehicle() {
        try {
            System.out.print("Date (YYYY-MM-DD): ");
            String date = in.nextLine();
            System.out.print("Your name: ");
            String name = in.nextLine();
            System.out.print("Your email: ");
            String email = in.nextLine();
            System.out.print("VIN to lease: ");
            int vin = Integer.parseInt(in.nextLine());

            com.plurasight.Vehicle v = dealership.findByVin(vin);
            if (v == null) {
                System.out.println("Vehicle not available.");
                return;
            }

            // NOTE: “can't lease over 3 years old”
            if (2025 - v.getYear() > 3) {
                System.out.println("This vehicle is too old to lease.");
                return;
            }

            com.plurasight.LeaseContract contract = new com.plurasight.LeaseContract(date, name, email, v);
            v.setSold(true);
            System.out.println(contract);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }
}