public class DoEveryDay{
	
	public static void main(String[] args){
		
		int day = Integer.parseInt(args[0]);
		if (day>=1 && day <=7){
		switch (day) {
		  case 6:case 7:
			System.out.println("Weekend...relaxing!");
			break;
		  default:
			System.out.println("Go to work");
		}			
		}
		else{
			System.out.println("Invalid day!");
		}

}
}