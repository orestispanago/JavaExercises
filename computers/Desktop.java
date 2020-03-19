package computers;

public class Desktop extends Computer {

    private boolean hasExtraLighting;

    public Desktop(double price) {
        super(price);
    }

    public Desktop(String brand, double price, boolean hasExtraLighting) {
        super(brand, price, hasExtraLighting);
        setPrice(price);
    }

    @Override
    void setPrice(double price) {
        if (hasExtraLighting==true) {
            
            this.price = price + 20;
            System.out.println(price);
        }
    }

}
