package playwithemployees;

public class Receptionist extends Employee implements Driving {

    public Receptionist(String name, int salary) {
        super(name, salary);
    }

    public void greet() {
        System.out.println(getName() + " Receptionist is greeting");
    }

    @Override
    public void driving() {
        System.out.println(getName() + " is driving");
    }

    @Override
    public void work() {
        greet();
    }
}
