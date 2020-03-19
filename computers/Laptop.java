package computers;

public class Laptop extends Computer {

    private boolean hasWifi;

    public Laptop(double price) {
        super(price);
    }

    public Laptop(String brand, double price, boolean hasWifi) {
        super(brand, price, hasWifi);
        setPrice(price);
    }

    @Override
    void setPrice(double price) {
        if (hasWifi==true) {
            
            this.price = price + 20;
            System.out.println(price);
        }
    }

}
