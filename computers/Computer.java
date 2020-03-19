package computers;

public abstract class Computer {

    public String brand;
    protected double price;
    public boolean extraCHaracteristics;
    public int computersCreated;

    public Computer(double price) {
        this.price = price;
        computersCreated++;
    }

    public Computer(String brand, double price, boolean extraCHaracteristics) {
        this(price);
        this.brand = brand;
        this.extraCHaracteristics = extraCHaracteristics;
        computersCreated++;

    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    private void setBrand(String brand) {
        this.brand = brand;
    }

    abstract void setPrice(double price);

//    public static int getComputersCreated() {
//        return computersCreated;
//    }
}
