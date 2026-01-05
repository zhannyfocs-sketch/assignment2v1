package assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fleetapp {
    private List<Vehicle> vehicles;
    private Scanner appScanner;
    private boolean running;
    private int menuCallCount;

    private void init() {
        appScanner = new Scanner(System.in);
        running = true;
        menuCallCount = 0;
    }

    public Fleetapp() {
        vehicles = new ArrayList<Vehicle>();
        init();
    }

    public Fleetapp(List<Vehicle> vehicles) {
        this.vehicles = new ArrayList<Vehicle>(vehicles);
        init();
    }

    public void run() {
        while (running) {
            showMenu();
            int nextCommand = requestCommand();
            switch (nextCommand) {
                case 1:
                    printAllVehicles();
                    break;
                case 2:
                    addNewCar();
                    break;
                case 3:
                    addNewBus();
                    break;
                case 4:
                    showTotalYearlyInsuranceFees();
                    break;
                case 5:
                    showVehiclesOlderThanNYears();
                    break;
                case 6:
                    performServiceForAllVehicles();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Incorrect!");
                    break;
            }
        }
    }

    private void showMenu() {
        if (menuCallCount == 0) {
            System.out.println("Welcome to Fleet Management System!");
        }
        System.out.println("Fleet Management System");
        System.out.println("1. Print all vehicles");
        System.out.println("2. Add new car");
        System.out.println("3. Add new bus");
        System.out.println("4. Show total yearly insurance fees");
        System.out.println("5. Show vehicles older than N years");
        System.out.println("6. Perform service for all vehicles");
        System.out.println("7. Quit");
        System.out.print("Enter your choice: ");
        menuCallCount++;
    }

    private void addNewBus() {
        System.out.println("Add New Bus");

        System.out.print("Enter model: ");
        String model = appScanner.nextLine();

        System.out.print("Enter year: ");
        int year = Integer.parseInt(appScanner.nextLine());

        System.out.print("Enter base price: ");
        double basePrice = Double.parseDouble(appScanner.nextLine());

        System.out.print("Enter passenger capacity: ");
        int capacity = Integer.parseInt(appScanner.nextLine());

        Bus newBus = new Bus(model, year, basePrice, capacity);
        vehicles.add(newBus);
        System.out.println("Bus added successfully!");
    }

    private void addNewCar() {
        System.out.println(" Add New Car");

        System.out.print("Enter model: ");
        String model = appScanner.nextLine();

        System.out.print("Enter year: ");
        int year = Integer.parseInt(appScanner.nextLine());

        System.out.print("Enter base price: ");
        double basePrice = Double.parseDouble(appScanner.nextLine());

        System.out.print("Enter number of doors: ");
        int doors = Integer.parseInt(appScanner.nextLine());

        Car newCar = new Car(model, year, basePrice, doors);
        vehicles.add(newCar);
        System.out.println("Car added successfully!");
    }

    private void printAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        System.out.println("All Vehicles");
        for (Vehicle v : vehicles) {
            System.out.println(v);
        }
    }

    private void showTotalYearlyInsuranceFees() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        double total = 0;
        for (Vehicle v : vehicles) total += v.calculateInsuranceFee();

        System.out.printf(String.valueOf(total));
    }

    private void showVehiclesOlderThanNYears() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        System.out.print("Enter current year: ");
        int currentYear = Integer.parseInt(appScanner.nextLine());

        System.out.print("Enter years: ");
        int n = Integer.parseInt(appScanner.nextLine());

        System.out.println(" Vehicles older than " + n + " years");
        boolean found = false;
        for (Vehicle v : vehicles) {
            if (v.getAge(currentYear) > n) {
                System.out.println(v);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found.");
        }
    }

    private void performServiceForAllVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles in the fleet.");
            return;
        }

        System.out.println("Performing service:");
        for (Vehicle v : vehicles) {
            if (v != null) {
                ((Servicable) v).performService();
            }
        }
    }

    private int requestCommand() {
        try {
            return Integer.parseInt(appScanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}