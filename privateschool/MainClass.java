package privateschool;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static List<Course> courses = new ArrayList();
    public static List<Student> students = new ArrayList();
    public static List<Trainer> trainers = new ArrayList();
    public static List<Assignment> assignments = new ArrayList();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static List<String> options = new ArrayList(Arrays.asList(
            "Students\n",//
            "Trainers\n",//
            "Assignments\n",//
            "Courses\n",//
            "Students per course\n",//
            "Trainers per course\n",//
            "Assignments per course\n",//
            "Assignments per student\n",//
            "Students that belong to more than one courses\n"));//

    public static LocalDate randomBirthDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1950, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.of(2000, 1, 1).toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
        return randomBirthDate;
    }

    public static void loadDataset() {
        Student s1 = new Student("Bruce", "Dickinson", randomBirthDate());
        Student s2 = new Student("Ronnie", "Dio", randomBirthDate());
        Student s3 = new Student("Eric", "Clapton", randomBirthDate());
        Student s4 = new Student("Alice", "Cooper", randomBirthDate());
        Student s5 = new Student("Axl", "Rose", randomBirthDate());
        Student s6 = new Student("Ozzy", "Osbourne", randomBirthDate());
        Student s7 = new Student("Robert", "Plant", randomBirthDate());
        Student s8 = new Student("Rob", "Halford", randomBirthDate());
        Student s9 = new Student("Lemmy", "Killmister", randomBirthDate());
        Student s10 = new Student("Bob", "Dylan", randomBirthDate());

        Trainer t1 = new Trainer("Jimmy", "Hendrix", "Java");
        Trainer t2 = new Trainer("Jim", "Morrison", "Python");
        Trainer t3 = new Trainer("Janis", "Joplin", "SQL");

        Course c1 = new Course("Web development", "Front End", "Full time", randomBirthDate(), randomBirthDate());
        Course c2 = new Course("Web development", "Back End", "Full time", randomBirthDate(), randomBirthDate());
        Course c3 = new Course("Mob development", "Back End", "Full time", randomBirthDate(), randomBirthDate());

        Assignment a1 = new Assignment("Assignment 1", "An easy one", randomBirthDate());
        Assignment a2 = new Assignment("Assignment 2", "A hard one", randomBirthDate());

        t1.addCourse(c1);
        t1.addCourse(c2);
        t2.addCourse(c1);
        t2.addCourse(c2);
        t3.addCourse(c1);

        c1.addStudent(s1);
        c2.addStudent(s1);
        c3.addStudent(s1);
        s1.addCourse(c1);
        s1.addCourse(c2);
        s1.addCourse(c3);
        c1.addStudent(s2);
        s2.addCourse(c1);
        c1.addStudent(s3);
        s3.addCourse(c1);
        c2.addStudent(s3);
        s3.addCourse(c2);
        c1.addStudent(s4);
        s4.addCourse(c1);
        c2.addStudent(s5);
        s5.addCourse(c2);
        c2.addStudent(s6);
        s6.addCourse(c2);
        c2.addStudent(s7);
        s7.addCourse(c2);
        c2.addStudent(s8);
        s8.addCourse(c2);
        c2.addStudent(s9);
        s9.addCourse(c2);
        c2.addStudent(s10);
        s10.addCourse(c2);

        a1.addCourse(c1);
        c1.addAssignment(a1);
        a1.addCourse(c2);
        c2.addAssignment(a1);
        a2.addCourse(c1);
        c1.addAssignment(a2);
    }

    static int getIntFromTo(Scanner scanner, int from, int to) {
        int num;
        do {
            System.out.printf("Please select from %d to %d:", from, to);
            while (!scanner.hasNextInt()) {
                System.out.printf("Please select from %d to %d:", from, to);
                scanner.next();
            }
            num = scanner.nextInt();
        } while (num < from || num > to);
        return num;
    }

    static void dummyData(Scanner scanner, DateTimeFormatter formatter) {
        System.out.print("Would you like to use dummy data? (y/n):");
        boolean useDummyData = isInputYes(scanner);
        if (useDummyData == true) {
            loadDataset();
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
            addCoursesToStudent(s1, scanner);
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
            addCoursesToTrainer(t1, scanner);
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
            addCoursesToAssignment(a1, scanner);
            System.out.print("Do you want to register another assignment? (y/n):");
        } while (isInputYes(scanner));
    }

    static void addCoursesToAssignment(Assignment assignment, Scanner scanner) {
        do {
            System.out.println("Which course is the assignment for?");
            printList(courses);
            int courseID = getIntFromTo(scanner, 1, courses.size()) - 1;
            Course course = courses.get(courseID);
            course.addAssignment(assignment);
            assignment.addCourse(course);
            System.out.print("Do add the assignment to another course? (y/n):");
        } while (isInputYes(scanner) && assignment.getCoursesNumber() < courses.size());
        if (assignment.getCoursesNumber() == courses.size()) {
            System.out.println("Assignment has been added to all available courses!");
        }
    }

    static void addCoursesToTrainer(Trainer trainer, Scanner scanner) {
        do {
            System.out.println("Which course is the trainer going to teach?");
            printList(courses);
            int courseID = getIntFromTo(scanner, 1, courses.size()) - 1;
            Course course = courses.get(courseID);
            trainer.addCourse(course);
            course.addTrainer(trainer);
            System.out.print("Do you want to add another course to this trainer? (y/n):");
        } while (isInputYes(scanner) && trainer.getCoursesNumber() < courses.size());
        if (trainer.getCoursesNumber() == courses.size()) {
            System.out.println("All available courses are added to this trainer!");
        }
    }

    static void addCoursesToStudent(Student student, Scanner scanner) {
        do {
            System.out.println("Which course is the student going to attend?");
            printList(courses);
            int courseID = getIntFromTo(scanner, 1, courses.size()) - 1;
            Course course = courses.get(courseID);
            course.addStudent(student);
            student.addCourse(course);
            System.out.print("Do you enroll to another course? (y/n):");
        } while (isInputYes(scanner) && student.getCoursesNumber() < courses.size());
        if (student.getCoursesNumber() == courses.size()) {
            System.out.println("Student has enrolled to all available courses!");
        }
    }

    static void inspectData(Scanner scanner) {
        System.out.println("You can view one of the following lists:");
        printList(options);
        int choice = getIntFromTo(scanner, 1, options.size());
        switch (choice) {
            case 1:
                printList(students);
                break;
            case 2:
                printList(trainers);
                break;
            case 3:
                printList(assignments);
                break;
            case 4:
                printList(courses);
                break;
            case 5:
                printStudentsPerCourse();
                break;
            case 6:
                printTrainersPerCourse();
                break;
            default:
                System.out.println("Not implemented yet...");
                break;
        }

    }

    static void printTrainersPerCourse() {
        for (Course co : courses) {
            System.out.print(co);
            System.out.println("-------------------------------------------------------------------------");
            printList(co.getTrainers());
            System.out.println("=========================================================================");
        }
    }

    static void printStudentsPerCourse() {
        for (Course co : courses) {
            System.out.print(co);
            System.out.println("-------------------------------------------------------------------------");
            printList(co.getStudents());
            System.out.println("=========================================================================");
        }
    }

    static void printAssignmentsPerCourse() {
        for (Course co : courses) {
            System.out.print(co);
            System.out.println("-------------------------------------------------------------------------");
            printList(co.getAssignments());
            System.out.println("=========================================================================");
        }
    }

    static void printAssignmentsPerStudent() {
        for (Student st : students) {
            System.out.print(st);
            System.out.println("-------------------------------------------------------------------------");
            printList(st.getAssignments());
            System.out.println("=========================================================================");
        }
    }

    static void printStudentsMoreThanOneCourse() {
        System.out.println("-------------------------Assignments per student-------------------------");
        for (Student st : students) {
            if (st.getCoursesNumber() > 1) {
                System.out.print(st);
                System.out.println("-------------------------------------------------------------------------");
                for (Course co : st.getCourses()) {
                    System.out.print(co);
                }
                System.out.println("=========================================================================");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int numb = getIntFromTo(scanner, 1, 4);
        dummyData(scanner, formatter);
//        regCourse(scanner, formatter);
//        printList(courses);
//        regTrainer(scanner, formatter);
//        printList(trainers);
//        regAssignment(scanner, formatter);
//        printList(assignments);
//        regStudent(scanner, formatter);
//        printList(students);
//        inspectData(scanner);
//        printStudentsPerCourse();
        printAssignmentsPerStudent();
//        printAssignmentsPerCourse();
//        printStudentsMoreThanOneCourse();
    }
}
