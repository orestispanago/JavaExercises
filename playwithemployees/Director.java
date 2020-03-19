package playwithemployees;

public class Director extends Employee implements Advisable, Driving {

    public Director(String name, int salary) {
        super(name, salary);
    }

    public void guide() {
        System.out.println(getName() + " Director is guiding");
    }

    @Override
    public void giveAdvice() {
        System.out.println(getName() + " Director gives advice");
    }

    @Override
    public void driving() {
        System.out.println(getName() + " Director is driving");
    }

    @Override
    public void work() {
        giveAdvice();
    }
}
