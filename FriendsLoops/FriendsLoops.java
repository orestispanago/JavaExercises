public class FriendsLoops{
	
	public static void main(String[] args){
		String friends[] = new String[]{"Phoebe", "Joey", "Monica", "Chandler"};
		
		System.out.println("*****Traditional for loop*****");
		for (int i=0; i<friends.length; i++){
			System.out.println(friends[i]);
		}
		
		System.out.println("*****Enhanced for loop*****");
		for (String item: friends) {
			System.out.println(item);
		}
		
		System.out.println("*****While loop*****");
		int j=0;
		while(j<friends.length){
			System.out.println(friends[j]);
			j++;
		}
		
		System.out.println("*****Do while loop*****");
		int k = 0;
        do {
            System.out.println(friends[k]);
            k++;
        } while (k < friends.length);
}
}