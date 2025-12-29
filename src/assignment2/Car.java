package assignment2;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        setNumberOfDoors(numberOfDoors);
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException();
        }
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        return getBasePrice() * 0.76;
    }

    @Override
    public void performService() {
        System.out.println("This is old car");
    }

    @Override
    public int getServiceIntervalKm() {
        return 100;
    }

    @Override
    public String toString() {
        return super.toString() + "  " + numberOfDoors;
    }
}