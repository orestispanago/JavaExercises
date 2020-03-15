import java.util.Scanner;

public class WeightPlanet{
	
	    static double getDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.println("Please enter a number. Use comma ',' as decimal separator.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
	    static double getWeight(Scanner scanner) {
        System.out.println("How many Kgs do you weigh?");
        double weight = getDouble(scanner);
        while (weight < 20 || weight > 200) {
            System.out.println("Oh, come on! Please enter a reasonable weight (20-200Kg)!");
            weight = getDouble(scanner);
        }
        return weight;
    }
	   
	   static int getInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter an integer.");
            scanner.next();
        }
        return scanner.nextInt();
	   }
		
		static int getPlanet(Scanner scanner){
			String planets[] = new String[]{"Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
			System.out.println("Choose your favourite planet from the table below:");
			for(int i=0; i<planets.length; i++){
				System.out.println(i+1+" "+planets[i]);
			}
			int planetID = getInt(scanner);
			return planetID;
		}
		static double calcWeight(double weight,int planetID){
			double relativeGravity = 1;
			switch(planetID){
				case 1:
				relativeGravity = 0.78;
				break;
				case 2:
				relativeGravity = 0.39;
				break;
				case 3:
				relativeGravity = 2.65;
				break;
				case 4:
				relativeGravity = 1.17;
				break;
				case 5:
				relativeGravity = 1.05;
				break;
				case 6:
				relativeGravity = 1.23;
				break;
			}
			double planetWeight = weight*relativeGravity;
			return planetWeight;	
		}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		double weight = getWeight(scanner);
		int planetID = getPlanet(scanner);
		double planetWeight = calcWeight(weight,planetID);
		System.out.println("Your weight on your favourite planet is "+planetWeight+" Kgs");

}
}
