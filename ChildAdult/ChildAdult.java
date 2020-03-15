import java.util.Scanner;

public class ChildAdult{
	static int getInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter an integer...");
            scanner.next();
        }
        return scanner.nextInt();
	   }
    static int getAge(Scanner scanner) {
        System.out.println("How old are you?");
        int age = getInt(scanner);
        while (age < 3 || age > 120) {
            System.out.println("You can't be serious! Please enter your real age. (3-120)");
            age = getInt(scanner);
        }
        return age;
    }
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int age = getAge(scanner);
		String msg = age >= 18 ? "You are an adult!" : "You are a child!";
		System.out.println(msg);
		}

}
