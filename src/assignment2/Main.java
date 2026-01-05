package assignment2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Servicable service = new Bus("City Bus", 2020, 150000.0, 30);
        service.performService();
        service.getServiceIntervalKm();


        Servicable carService = new Car("Cool car", 2022, 30000.0, 4);
        carService.performService();
        carService.getServiceIntervalKm();

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Toyota Corolla", 2022, 25000.0, 4));
        vehicles.add(new Car("Honda Civic", 2021, 23000.0, 4));
        vehicles.add(new Bus("School Bus", 2019, 80000.0, 40));
        vehicles.add(new Bus("Tour Bus", 2023, 120000.0, 50));

        Fleetapp app = new Fleetapp(vehicles);
        app.run();
    }
}