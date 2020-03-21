package privateschool;

import java.time.LocalDate;


public class Student {
private String firstName;
private String lastName;
private LocalDate dateOfBirth;
private double tuitionFees;

    public Student(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        MainClass.students.add(this);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public String getDateOfBirthString() {
        return dateOfBirth.format(MainClass.formatter);
    }
    public double getTuitionFees() {
        return tuitionFees;
    }

@Override
    public String toString() {
        return String.format("Student: %-10s %s %s\n",firstName, lastName,getDateOfBirthString());
    }
}
