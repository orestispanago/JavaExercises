public class DriveDrinkVote{
	
	public static void main(String[] args){
		
		int age = Integer.parseInt(args[0]);
		if (age>0 && age <=120){
			if (age<16){
				System.out.println("You cannot drive!");
			}
			else if(age>=16 && age<=17){
				System.out.println("You can drive but not vote!");
			}
			else if(age>=18 && age<=21){
				System.out.println("You can vote but not drink!");
			}
			else{
				System.out.println("You can do anything!");
			}
		}
		else{
			System.out.println("Invalid age!");
		}

}
}