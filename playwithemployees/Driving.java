package playwithemployees;


public interface Driving {
    
    int speed = 0;
    
    void driving();
    public default void slowDown(){
        System.out.println("Slowing down");
    }
    public default void speedUp(){
        System.out.println("Speeding up");
    }
    public static int getSpeed(){
        return speed;
    }
}
