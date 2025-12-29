package assignment2;

public abstract class Vehicle implements Servicable {
    private int id;
    private static int idGen = 1;
    private String model;
    private int year;
    private double basePrice;

    public Vehicle() {
        this.id = idGen++;
    }

    public Vehicle(String model, int year, double basePrice) {
        this();
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public int getId() {
        return this.id;
    }

    public int getYear() {
        return this.year;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public int getAge(int currentYear) {
        return currentYear - this.year;
    }

    public void setModel(String model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        this.model = model;
    }

    public void setYear(int year) {
        if (year < 1900 || year > 2025) {
            throw new IllegalArgumentException();
        }
        this.year = year;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice < 0) {
            throw new IllegalArgumentException();
        }
        this.basePrice = basePrice;
    }

    public String getModel() {
        return model;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return id + " " + model + " " + year + " " + basePrice;
    }
}
