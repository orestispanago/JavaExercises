package luckyday;

import java.time.LocalDate;
import java.util.Scanner;

public class LuckyDay {

    static void ageResponse(String name, int yearsOld) {
        if (yearsOld > 0 && yearsOld <= 5) {
            System.out.print("You are too young for this app! ");
            if (yearsOld == 3) {
                System.out.println("Come back in 3 years when you will be a student!");
            }
            System.exit(0);
        } else if (yearsOld >= 6 && yearsOld <= 18) {
            System.out.print("Oh you are a student! ");
            if (yearsOld == 10) {
                System.out.print("Keep up... 8 more years left and afterwards you will make money!");
            }
        } else if (yearsOld >= 19 && yearsOld <= 40) {
            System.out.print("Well, you must be employed! ");
            if (yearsOld == 25) {
                System.out.print("You finished school 7 years ago!");
            }
        }
        System.out.println("");
        pastFutureAge(name, yearsOld);
    }

    static void pastFutureAge(String name, int yearsOld) {
        int yearNow = LocalDate.now().getYear();
        int yearBorn = yearNow - yearsOld;
        if (1980 - yearBorn > 0) {
            System.out.println("You were " + (1980 - yearBorn) + " years old in 1980 " + name + "...");
        }
        System.out.println("You will be " + (2040 - yearBorn) + " in 2040 " + name + "...");
    }

    static void favouriteSeason(String name, Scanner input) {
        System.out.println("What is your favourite season " + name + " ?");
        System.out.println("1. Winter");
        System.out.println("2. Spring");
        System.out.println("3. Summer");
        System.out.println("4. Autumn");
        int favSeason = input.nextInt();
        switch (favSeason) {
            case 1:
                System.out.println("It must be cold outside " + name + "...");
                break;
            case 2:
                System.out.println("Ohh " + name + " , flowers are very beautiful these days!");
                break;
            case 3:
                System.out.println("Let's go for swimming " + name + " !");
                break;
            case 4:
                System.out.println("The trees are full of brown leaves " + name + " ...");
                break;
            default:
                break;
        }
    }

    static double calcBmi(double kg, double m) {
        double result = kg / (m * m);
        result = Math.round(result);
        return result;
    }

    static void bmi(String name, Scanner scanner) {
        double weight = getWeight(name, scanner);
        double height = getHeight(name, scanner);
        double bmi = calcBmi(weight, height);
        if (bmi > 0) {
            System.out.print(name + ", your BMI is: " + bmi + ", ");
            if (bmi > 0 && bmi < 18.5) {
                System.out.println("you are underweight...");
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                System.out.println("you have normal weight...");
            } else if (bmi >= 25 && bmi <= 29.9) {
                System.out.println("you are overweight!");
            } else if (bmi >= 30) {
                System.out.println("you are obese!");
            }
        } else {
            System.out.println("You must be kidding, " + name + " !");
        }
    }

    static int sumDaysDigits(int yearsOld) {
        int daysOld = yearsOld * 365;
        int sum = 0;
        while (daysOld > 0) {
            sum = sum + daysOld % 10;
            daysOld = daysOld / 10;
        }
        return sum;
    }

    static String findLuckyDay(String name, int age) {
        int dayDigits = sumDaysDigits(age);
        if (dayDigits > 6) {
            dayDigits = dayDigits % 7;
        }
        String weekDays[] = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Sarutday", "Sunday"};
        String luckyDay = weekDays[dayDigits];
        System.out.println("Your lucky day is: " + luckyDay);
        return luckyDay;
    }

    static void enterClub(String name, int age, boolean isMale, Scanner scanner) {
        String luckyDay = findLuckyDay(name, age);

        String permission = "You cannot enter, because ";

        if (age >= 20 && age
                <= 40) {
            if ("Wednesday".equals(luckyDay)) {
                String title = title(isMale, age, scanner);
                permission = "Welcome, " + title + " " + name;

            } else {
                permission = permission + "Wednesday is not your lucky day!";
            }
        } else {
            permission = permission + "you don't have the proper age!";
        }

        System.out.println(permission);

    }

    static String getName(Scanner scanner) {
        String name = scanner.next();
        System.out.println("Hello " + name + "!");
        return name;
    }

    static boolean isMale(Scanner scanner, String name) {
        System.out.print("Are you male or female? (m/f)");
        char gender = scanner.next(".").charAt(0);
        while (gender != 'm' && gender != 'f') {
            System.out.println(name + ", please type 'm' for male or 'f' for female");
            gender = scanner.next(".").charAt(0);
        }
        return gender == 'm';
    }

    static boolean isMarried(Scanner scanner) {
        System.out.print("Are you married? (y/n)");
        char married = scanner.next(".").charAt(0);
        while (married != 'y' && married != 'n') {
            System.out.println("Please type 'y' for yes or 'n' for no");
            married = scanner.next(".").charAt(0);
        }
        return married == 'y';
    }

    static double getDouble(String name, Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a number, " + name + ". Please use comma ',' as decimal separator.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    static double getWeight(String name, Scanner scanner) {
        System.out.println("How many Kgs do you weigh " + name + "?");
        double weight = getDouble(name, scanner);
        while (weight < 20 || weight > 200) {
            System.out.println("Oh, come on " + name + "! At least enter a reasonable weight (20-200Kg)!");
            weight = getDouble(name, scanner);
        }
        return weight;
    }

    static double getHeight(String name, Scanner scanner) {
        System.out.println("What is your height in meters " + name + "?");
        double height = getDouble(name, scanner);
        while (height < 1 || height > 2.3) {
            System.out.println("Oh, come on " + name + "! At least enter a reasonable height (1-2.3m)!");
            height = getDouble(name, scanner);
        }
        return height;
    }

    static int getInt(String name, Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter an integer " + name + ".");
            scanner.next();
        }
        return scanner.nextInt();
    }

    static int getAge(String name, Scanner scanner) {
        System.out.println("How old are you, " + name + "?");
        int age = getInt(name, scanner);
        while (age < 3 || age > 120) {
            System.out.println("You can't be serious, " + name + "! Please enter your real age. (3-120)");
            age = getInt(name, scanner);
        }
        return age;
    }

    static String title(boolean isMale, int age, Scanner scanner) {
        String title = "";
        if (!isMale) {
            boolean isMarried = isMarried(scanner);
            if (!isMarried) {
                return "Ms";
            } else {
                return "Mrs";
            }
        }
        if (age >= 25) {
            return "Mr";
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello, what is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = getName(scanner);
        boolean isMale = isMale(scanner, name);
        int age = getAge(name, scanner);
        ageResponse(name, age);
        favouriteSeason(name, scanner);
        bmi(name, scanner);
        enterClub(name, age, isMale, scanner);

    }

}
