package playwithemployees;

public class Teacher extends Employee implements Advisable {

    public Teacher(String name, int salary) {
        super(name, salary);
    }

    public void teach() {
        System.out.println(getName() + " Teacher is teaching");
    }

    @Override
    public void giveAdvice() {
        System.out.println(getName() + " Teacher is giving advice");
    }

    @Override
    public void work() {
        teach();
    }
    
}
