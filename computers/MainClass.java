package computers;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        String asus = "Asus";
        String acer = "Acer";
        String sony = "Sony";
        String lenovo = "Lenovo";

        Computer lap1 = new Laptop(lenovo, 1200, true);
        Computer desk1 = new Desktop(acer, 800, true);
        Computer tab1 = new Tablet(sony, 1100, true);
        Computer lap2 = new Laptop(lenovo, 1000, true);
        Computer desk2 = new Desktop(acer, 900, true);
        Computer tab2 = new Tablet(sony, 1300, true);

        Computer lap3 = new Laptop(450);
        Computer desk3 = new Desktop(acer, 800, true);
        Computer tab3 = new Tablet(sony, 1100, true);

        List<Computer> computers = new ArrayList();
        computers.add(lap1);
        computers.add(lap2);
        computers.add(lap3);
        computers.add(desk1);
        computers.add(desk2);
        computers.add(desk3);
        computers.add(tab1);
        computers.add(tab2);
        computers.add(tab3);
        for (Computer computer : computers) {
            System.out.println(computer.brand + ": " + computer.price + ", ");
        }
        System.out.println(lap1.getPrice());

        double sumSony = 0;
        double sumAcer = 0;
        double sumAsus = 0;
        double sumLenovo = 0;
        double sumUnknown = 0;

        for (Computer computer : computers) {
            if (computer.getBrand() == sony) {
                sumSony += computer.getPrice();
            } else if (computer.getBrand() == acer) {
                sumAcer += computer.getPrice();
            } else if (computer.getBrand() == asus) {
                sumAsus += computer.getPrice();
            } else if (computer.getBrand() == lenovo) {
                sumLenovo += computer.getPrice();
            } else {
                sumUnknown += computer.getPrice();
            }
        }
        double sumTotal = sumSony + sumAcer + sumAsus + sumLenovo + sumUnknown;
        System.out.printf("%s computers cost %.2f.\n", sony, sumSony);
        System.out.printf("%s computers cost %.2f.\n", acer, sumAcer);
        System.out.printf("%s computers cost %.2f.\n", asus, sumAsus);
        System.out.printf("%s computers cost %.2f.\n", lenovo, sumLenovo);

        double sumDesktop = 0;
        double sumLaptop = 0;
        double sumTablet = 0;
        for (Computer computer : computers) {
            if (computer instanceof Desktop) {
                sumDesktop += computer.getPrice();
            } else if (computer instanceof Laptop) {
                sumLaptop += computer.getPrice();
            } else{
                sumTablet += computer.getPrice();
            }
        }
         System.out.printf("Desktops cost %.2f.\n", sumDesktop);
         System.out.printf("Laptops cost %.2f.\n", sumLaptop);
         System.out.printf("Tablets cost %.2f.\n", sumTablet);

    }

}
