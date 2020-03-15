import java.utils.Scanner;

public class StudentSeats{
	
	static int getInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter an integer...");
            scanner.next();
        }
        return scanner.nextInt();
	   }
	static int getRows(Scanner scanner){
		System.out.println("How many rows does your class have?")
		int rows = getInt(scanner)
		while (rows < 0 || rows > 10) {
            System.out.println("Please enter a number from 1 to 10...");
            rows = getInt(scanner);
        }
	}
	static int getStudents(Scanner scanner){
		System.out.println("How many students are in your class?")
		int rows = getInt(scanner)
		while (rows < 0 || rows > 100) {
            System.out.println("Please enter a number from 1 to 100...");
            rows = getInt(scanner);
        }
	}
	
	public static void main(String[] args){
		
	}
}