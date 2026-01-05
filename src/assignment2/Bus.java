package assignment2;

public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() * 0.67;
    }

    @Override
    public void performService() {
        System.out.println("The bus is cool");
    }

    @Override
    public int getServiceIntervalKm() {
        return 2000;
    }

    @Override
    public String toString() {
        return super.toString() + " " + passengerCapacity;
    }
}