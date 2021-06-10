package cinemabookingthing;

import java.util.ArrayList;
//Represents a single seat in a theatre.
public class Seat implements SeatInterface {

	private int seatnum;
	private boolean isReserved;
	//creates a new seat with a number that is not reserved.
	public Seat(int seatnum) {
		isReserved = false;
		this.seatnum = seatnum;
		
	}
	//gets the seat number
	public int getNumber() {
		return seatnum;
	}
	//checks if seat is reserved
	public boolean isReserved() {
		return isReserved;
	}
	//reserves the seat
	public void reserve() {
		if (!isReserved)
		isReserved = true;
		else
			System.out.println("Already reserved");
	}
	//unreserves the seat
	public void unReserve() {
		isReserved = false;
	}
	//returns seatnumber as a string.
	public String toString() {
		return seatnum + ".";
	}
}

