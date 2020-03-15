public class MonthDays{
	
	public static void main(String[] args){
		
		int month = Integer.parseInt(args[0]);
		if (month>0 && month <=12){
		switch (month) {
		  case 1:case 3:case 5:case 7:case 8: case 10:case 12:
			System.out.println("31");
			break;
		  case 2:
			System.out.println("28/29");
			break;
		  default:
			System.out.println("30");
		}
		}
		else{
			System.out.println("Invalid month!");
		}

}
}