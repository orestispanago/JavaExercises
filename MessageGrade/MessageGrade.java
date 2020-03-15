public class MessageGrade{
	
	public static void main(String[] args){
		
		String grade = args[0];
			switch(grade){
				case "A":
				System.out.println("Perfect!");
				break;
				case "B":
				System.out.println("Good!");
				break;
				case "C":
				System.out.println("Pass!");
				break;
				case "D":
				System.out.println("Pass!");
				break;
				case "F":
				System.out.println("Fail!");
				break;
				default:
				System.out.println("Invalid grade!");
				break;

			}
			}

}