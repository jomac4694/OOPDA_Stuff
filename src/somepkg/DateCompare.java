package somepkg;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateCompare {

	public static void main(String[] args) {
		//First line creates a GregorianCalender object of type Calender (possible because of polymorphism).
		//The line after uses set method to set specific date. The subsequent lines then instantiate 3 Dates using getTime() function (which returns a Date).
		//The subsequent lines initialize 3 different dates.
		Calendar birthday = new GregorianCalendar();
		birthday.set(1990, 0, 9);
		Date amberBirthday = birthday.getTime();
		birthday.set(1991, 7, 12);
		Date kenBirthday = birthday.getTime();
		birthday.set(1993, 6, 27);
		Date adamBirthday = birthday.getTime();
		
		// Comparing dates, uses %d which signifies an int will replace that space. The int is indicated by the following argument.
		System.out.printf("\nAmber's birthday compared to Ken's: %d", amberBirthday.compareTo(kenBirthday));
		System.out.printf("\nKen's birthday compared to Amber's: %d", kenBirthday.compareTo(amberBirthday));
		System.out.printf("\nAdam's birthday compared to itself: %d", adamBirthday.compareTo(adamBirthday));

	}

}