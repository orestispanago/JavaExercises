public class SeasonMonth{
	
	public static void main(String[] args){
		
		int month = Integer.parseInt(args[0]);
		if (month>0 && month <=12){
		switch (month) {
		  case 12: case 1: case 2:
			System.out.println("Winter");
			break;
		  case 3: case 4: case 5:
			System.out.println("Spring");
			break;
		  case 6: case 7: case 8:
			System.out.println("Summer");
			break;
		  case 9: case 10: case 11:
			System.out.println("Autumn");
			break;
		}
		}
		else{
			System.out.println("Invalid month!");
		}

}
}