package privateschool;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static List<Course> courses = new ArrayList();
    public static List<Student> students = new ArrayList();
    public static List<Trainer> trainers = new ArrayList();
    public static List<Assignment> assignments = new ArrayList();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static int getIntFromTo(Scanner scanner, int from, int to) {
        int num;
        do {
            System.out.printf("Please select from %d to %d\n", from, to);
            while (!scanner.hasNextInt()) {
                System.out.printf("Please select from %d to %d\n", from, to);
                scanner.next();
            }
            num = scanner.nextInt();
        } while (num < from || num > to);
        return num;
    }

    public static void loadDataset(DateTimeFormatter formatter) {
        LocalDate dat = LocalDate.parse("12/05/2016", formatter);
        Student s1 = new Student("Bruce", "Dickinson", dat);
        Student s2 = new Student("Ronnie", "Dio", dat);
        Student s3 = new Student("Eric", "Clapton", dat);
        Student s4 = new Student("Alice", "Cooper", dat);
        Student s5 = new Student("Axl", "Rose", dat);
        Student s6 = new Student("Ozzy", "Osbourne", dat);
        Student s7 = new Student("Robert", "Plant", dat);
        Student s8 = new Student("Rob", "Halford", dat);
        Student s9 = new Student("Lemmy", "Killmister", dat);
        Student s10 = new Student("Bob", "Dylan", dat);

        Trainer t1 = new Trainer("Jimmy", "Hendrix", "Java");
        Trainer t2 = new Trainer("Jim", "Morrison", "Python");
        Trainer t3 = new Trainer("Janis", "Joplin", "SQL");

        Course c1 = new Course("Web development", "Front End", "Full time", dat, dat);
        Course c2 = new Course("Web development", "Back End", "Full time", dat, dat);

        Assignment a1 = new Assignment("Assignment 1", "An easy one", dat);
        Assignment a2 = new Assignment("Assignment 2", "A hard one", dat);
    }

    static void fakeData(Scanner scanner, DateTimeFormatter formatter) {
        System.out.print("Would you like to use fake data? (y/n):");
        boolean useFake = isInputYes(scanner);
        if (useFake == true) {
            loadDataset(formatter);
        }
    }

    public static void printList(List listName) {
        for (int i = 0; i < listName.size(); i++) {
            System.out.print(i + 1 + "." + listName.get(i).toString());
        }
    }

    static boolean isInputYes(Scanner scanner) {
        char input = scanner.next(".").charAt(0);
        while (input != 'y' && input != 'n') {
            System.out.print("Please type 'y' for yes or 'n' for no:");
            input = scanner.next(".").charAt(0);
        }
        return input == 'y';
    }

    static boolean isJava(Scanner scanner) {
        System.out.print("Please type 'j' for Java or 'c' for C#:");
        char input = scanner.next(".").charAt(0);
        while (input != 'j' && input != 'c') {
            System.out.print("Please type 'j' for java or 'c' for C#:");
            input = scanner.next(".").charAt(0);
        }
        return input == 'j';
    }

    static boolean isFullTime(Scanner scanner) {
        System.out.print("Please type 'f' for full-time or 'p' for part-time:");
        char input = scanner.next(".").charAt(0);
        while (input != 'f' && input != 'p') {
            System.out.print("Please type 'f' for full-time or 'p' for part-time:");
            input = scanner.next(".").charAt(0);
        }
        return input == 'f';
    }

    static String getCourseStream(Scanner scanner) {
        if (!isJava(scanner)) {
            return "C#";
        }
        return "Java";
    }

    static String getCourseType(Scanner scanner) {
        if (!isFullTime(scanner)) {
            return "part-time";
        }
        return "full-time";
    }

    static boolean isDateValid(String dateString, DateTimeFormatter formatter) {
        try {
            LocalDate.parse(dateString, formatter);
        } catch (java.time.format.DateTimeParseException e) {
            return false;
        }
        return true;
    }

    static LocalDate getDate(Scanner scanner, String message, DateTimeFormatter formatter) {
        String dateString = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.printf("Enter %s date (dd/mm/yyyy):", message);
            dateString = scanner.next();
            isValid = isDateValid(dateString, formatter);
        }
        return LocalDate.parse(dateString, formatter);

    }

    static void regCourse(Scanner scanner, DateTimeFormatter formatter) {
        do {
            System.out.print("Enter a course title:");
            String title = scanner.next();
            System.out.println("Select course's stream,");
            String stream = getCourseStream(scanner);
            String type = getCourseType(scanner);
            LocalDate start_date = getDate(scanner, "course start", formatter);
            LocalDate end_date = getDate(scanner, "course end", formatter);
            Course c1 = new Course(title, stream, type, start_date, end_date);
            System.out.print("Do you want to register another course? (y/n):");
        } while (isInputYes(scanner));
    }

    static void regStudent(Scanner scanner, DateTimeFormatter formatter) {
        do {
            System.out.print("Enter the student's first name:");
            String firstName = scanner.next();
            System.out.print("Enter the student's last name:");
            String lastName = scanner.next();
            LocalDate dateOfBirth = getDate(scanner, "birth date", formatter);
            Student s1 = new Student(firstName, lastName, dateOfBirth);
            System.out.print("Do you want to register another student? (y/n):");
        } while (isInputYes(scanner));
    }

    static void regTrainer(Scanner scanner, DateTimeFormatter formatter) {
        do {
            System.out.print("Enter the trainer's first name:");
            String firstName = scanner.next();
            System.out.print("Enter the student's last name:");
            String lastName = scanner.next();
            System.out.print("Enter the student's subject:");
            String subject = scanner.next();
            Trainer t1 = new Trainer(firstName, lastName, subject);
            System.out.print("Do you want to register another trainer? (y/n):");
        } while (isInputYes(scanner));
    }

    static void regAssignment(Scanner scanner, DateTimeFormatter formatter) {
        do {
            System.out.print("Enter assignment title:");
            String title = scanner.next();
            System.out.print("Enter assignment description:");
            String description = scanner.next();
            LocalDate subDateTime = getDate(scanner, "submission date", formatter);
            Assignment a1 = new Assignment(title, description, subDateTime);
            System.out.print("Do you want to register another assignment? (y/n):");
        } while (isInputYes(scanner));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
//        int numb = getIntFromTo(scanner, 1, 4);
//        fakeData(scanner, formatter);
//        regCourse(scanner, formatter);
//        printList(courses);
//        regTrainer(scanner, formatter);
//        printList(trainers);
//        regAssignment(scanner, formatter);
//        printList(assignments);
        regStudent(scanner, formatter);
        printList(students);
    }
}
