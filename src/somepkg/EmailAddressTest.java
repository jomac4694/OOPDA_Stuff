package somepkg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class EmailAddressTest {
	public static void main(String[] args) {
		System.out.println("Enter H for HashSet, L for LinkedHastSet or T ofr TreeSet: ");
		Scanner sc = new Scanner(System.in);
		char option = sc.next().toUpperCase().charAt(0);
		sc.close();
		//Defines and initializes each Set<String> as null (nothing).
		Set<String> emailAddresses=null, gmailAddresses=null, 
				hotmailAddresses=null, possibleDupeAddresses=null;
		
		//If the user enters 'H', then the following code will initialize the 4 sets as HashSets, which is possible because HashSet IS a Set.
		if (option == 'H') {
			emailAddresses = new HashSet<>();
			gmailAddresses = new HashSet<>();
			hotmailAddresses = new HashSet<>();
			possibleDupeAddresses = new HashSet<>();
		}
		//If the user enters 'L', then the following code will initialize the 4 sets as HashSets, which is possible because HashSet IS a Set.
		else if (option == 'L') {
			emailAddresses = new HashSet<>();
			gmailAddresses = new HashSet<>();
			hotmailAddresses = new HashSet<>();
			possibleDupeAddresses = new HashSet<>();
		}
		//If the user enters 'T', then the following code will initialize the 4 sets as HashSets, which is possible because HashSet IS a Set.
		else if (option == 'T') {
			emailAddresses = new HashSet<>();
			gmailAddresses = new HashSet<>();
			hotmailAddresses = new HashSet<>();
			possibleDupeAddresses = new HashSet<>();
		}
		//adds strings to list	
		emailAddresses.add("amber@yahoo.com");
		emailAddresses.add("bill@gmail.com");
		emailAddresses.add("cherise@yahoo.com");
		emailAddresses.add("derek@gmail.com");
		emailAddresses.add("elias@acme.edu");
		emailAddresses.add("fadhi@yahoo.com");
		emailAddresses.add("gwen@gmail.com");
		emailAddresses.add("harry@students.acme.edu");
		
		hotmailAddresses.add("ivy@hotmail.com");
		hotmailAddresses.add("jacob@hotmail.com");
		
		possibleDupeAddresses.add("cherise@yahoo.com");
		possibleDupeAddresses.add("kelly@acme.edu");
		/*Uses a basic for each loop to iterate through emailAdressed list. If the string
		 * in the current iteration contains the substring "gmail", then it adds it to the gmailAdress lis */
		for (String addr : emailAddresses) {
			if (addr.contains("gmail"))
				gmailAddresses.add(addr);
		}
		//Just displays all the lists using displayItems() function
		System.out.println("\nemailAddresses:\n");
		displayItems(emailAddresses);
		 
		System.out.println("\nhotmailAddresses:\n");
		displayItems(hotmailAddresses);
		
		System.out.println("\ngmailAddresses:\n");
		displayItems(gmailAddresses);
		
		System.out.println("\npossibleDupeAddresses:\n");
		displayItems(possibleDupeAddresses);
			
			emailAddresses.removeAll(gmailAddresses);
			emailAddresses.addAll(hotmailAddresses);
			emailAddresses.addAll(possibleDupeAddresses);
		
		System.out.println("\nemailAddresses - gmail + hotmail + possible dupes\n");
		displayItems(emailAddresses);
	}
	/* Private function (for internal class use only) thats accepts any type of Collection<String>(list, queue, stack, etc) as an argument.
	 * Then uses a basic for-each loop to iterate through the collection, using a String object to hold each item in the collection.
	 */
	private static void displayItems(Collection<String> myCollection) {
		for ( String s : myCollection) {
			System.out.println("  " + s.toString());
		}
	}
}
