package computers;

public class Tablet extends Computer {

    private boolean hasBluetooth;

    public Tablet(double price) {
        super(price);
    }

    public Tablet(String brand, double price, boolean hasBluetooth) {
        super(brand, price, hasBluetooth);
        setPrice(price);
    }

    @Override
    void setPrice(double price) {
        if (hasBluetooth==true) {
            
            this.price = price + 20;
            System.out.println(price);
        }
    }

}
