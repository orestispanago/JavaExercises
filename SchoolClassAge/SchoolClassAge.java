public class SchoolClassAge{
	
	public static void main(String[] args){
		
		int age = Integer.parseInt(args[0]);

		if (age>0 && age<5){
			System.out.println("You are not a student yet");
		}
		else if (age>=5 && age <12){
			System.out.println("Dimotiko");
		}
		else if (age>=12 && age <15){
			System.out.println("Gymnasio");
		}
		else if (age>=15 && age <18){
			System.out.println("Lykeio");
		}
		else if(age>=18 && age <120){
			System.out.println("You don't go to school anymore!");
		}
		else{
			System.out.println("Invalid age!");
		}
		// A switch statement could have been used but this would require 13 cases
		// if statements require less code here

	}
}