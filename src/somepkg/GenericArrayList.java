package somepkg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class GenericArrayList {
	
   public static void main(String[] args)
   {
      // Defines and instantiates an ArrayList object which can hold String objects, signified by <String>
      ArrayList<String> nameList = new ArrayList<>();  // From java 7 onward, diamond notation okay
      
      // Adds String objects to the ArrayList using the add() function
      nameList.add("James");
      nameList.add("Catherine");
      nameList.add("Bill");
      
      // Displays the size of the ArrayList using the size() function of the list.
      System.out.println("The generic ArrayList has " +
                         nameList.size() +
                         " objects stored in it.");

      /* Iterates through the list and prints each String object using a basic for-loop. Starts by initializing the
       * index (of the list) to 0 (beginning of the list). Loop runs while the index is less than the size of the list.
       * The index increases by 1 after each iteration.*/
      for (int index = 0; index < nameList.size(); index++)
         System.out.println(nameList.get(index));
      System.out.println();
      
      /* Iterates through the list and prints each String object using a basic for-each loop. The loop uses
       * an object of type Object to store the string which is possible because a String IS A Object.*/
      for (Object o : nameList) 
    	  	System.out.println(o);
      System.out.println();
      
      /*Iterates through the list using an Iterator object, it also prints the String object. Iterator objects are used specifically for stepping through Lists or Collections
       * uses a while loop that only runs while the list hasNext(), meaning it will go til is reaches the end of the list. the next() function
       * returns an item from the list while at the same time setting the iterator to the next item in the list  */
      Iterator<String> nameIterator = nameList.iterator();
      while (nameIterator.hasNext()) {
    	  	System.out.println(nameIterator.next());
      }
      System.out.println();
      
      /* Does essentially the same thing as the previous code but uses a ListIterator object instead. Also,
       * it starts at the end of the list by passing in an argument for the listIterator() function*/
      ListIterator<String> nameIterator2 = nameList.listIterator(nameList.size());
      while (nameIterator2.hasPrevious()) {
    	  	System.out.println(nameIterator2.previous());
      }
      System.out.println();
      //Initializes new iterator at index 1, goes to next item in iterator, replaces that item with "John", then goes back to previous index.
      nameIterator2 = nameList.listIterator(1); 
      nameIterator2.next();
      nameIterator2.set("John"); 
      nameIterator2.previous();
      //Iterates through the list using a another iterator
      while (nameIterator2.hasNext()) {
    	  	System.out.println(nameIterator2.next());
      }
      System.out.println();
      /* Iterates through the list and prints each String object using a basic for-each loop. The loop uses
       * an object of type Object to store the string which is possible because a String IS A Object.*/
      for (Object o : nameList) 
  	  	System.out.println(o);
      System.out.println();
   } 

}