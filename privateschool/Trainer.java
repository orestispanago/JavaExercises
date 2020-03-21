package privateschool;


public class Trainer {
private String firstName;
private String lastName;
private String subject;

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
        MainClass.trainers.add(this);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
@Override
    public String toString() {
        return String.format("Trainer: %-10s %s %s\n",firstName, lastName,subject);
    }
}
