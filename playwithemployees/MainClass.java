package playwithemployees;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        Employee t1 = new Teacher("Bob", 1000);
        Employee t2 = new Teacher("Mary", 1000);
        Employee r1 = new Receptionist("Lara", 1200);
        Employee d1 = new Director("Andy", 2400);
        Employee d2 = new Director("Jane", 2400);

        List<Employee> employees = new ArrayList();
        employees.add(t1);
        employees.add(t2);
        employees.add(r1);
        employees.add(d1);
        employees.add(d2);

        for (Employee emp : employees) {
            emp.work();
        }

        List<Employee> advisers = new ArrayList();
        List<Employee> drivers = new ArrayList();
        for (Employee emp : employees) {
            if (emp instanceof Advisable && emp instanceof Driving) {
                advisers.add(emp);
                drivers.add(emp);
            } else if (emp instanceof Driving) {
                drivers.add(emp);
            }else{
                advisers.add(emp);
            }
        }
        System.out.println("-----Printing advisers-----");
        for (Employee emp : advisers) {
            System.out.println(emp.getName());
        }
        System.out.println("-----Printing drivers-----");
        for (Employee emp : drivers) {
            System.out.println(emp.getName());
        }

        Director d3 = new Director("Panagiotis", 3000);
        d3.slowDown();
        
        Advisable advisable = new Director("Kalliopi", 3100);
    }

}
