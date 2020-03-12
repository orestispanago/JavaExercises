package playwithmath;

public class PlayWithMath {

    public static void main(String[] args) {
        double number = 3.45;
        double ceil = Math.ceil(number);
        double floor = Math.floor(number);
        long round = Math.round(number);
        double abs = Math.abs(number);
        
        System.out.println("Ceil: "+ceil);
        System.out.println("floor: "+floor);
        System.out.println("round: "+round);
        System.out.println("abs: "+abs);
    }
    
}
