package test;

import java.util.ArrayList;

public class Driver {
	public static void main(String args[]) {
		Theatre t1 = new SmallTheatre(1);
		Theatre t2 = new LargeTheatre(2);
		ArrayList<Theatre> tlist = new ArrayList<Theatre>();
		tlist.add(t1);
		tlist.add(t2);
		tlist.add(new ThreeDTheatre(3));
		for (Theatre t : tlist) {
			System.out.println("Theatre number: " + t.getTheatreNumber());
			System.out.println("Seat number: " + t.getNumSeats());
			t.startMovie();
		}
	}
}
