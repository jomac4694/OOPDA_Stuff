package cinemabookingthing;

import java.util.ArrayList;
//Represents a row in the theatre, holds seats
public class Row extends ArrayList<Seat> implements RowInterface {

	private static final long serialVersionUID = 1L;
	int rownum;
	int numseats;
	//Constructor creates a row with a row number and specific amount of seats
	public Row(int numseats, int rownum) {
		this.numseats = numseats;
		for (int i = 0; i < numseats; i++) {
			add(new Seat(i+1));
		}
		
	}
	//return the number of seats
	int getNumberOfSeats() {
		return numseats;
	}
	//see if the row is full/all seats reserved
	public boolean isFull() {
		for (Seat s : this) {
			if (!s.isReserved()) {
				return false;
			}
		}
		return true;
	}
	//return a specific seat in the row
	public Seat getSeat(int i) {
		return get(i);
	}
	
}
