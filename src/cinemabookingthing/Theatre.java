package cinemabookingthing;

import java.util.ArrayList;
//Abstract Theatre class, represents a single theatre withing a cinema house
public abstract class Theatre implements TheatreInterface {

	
	protected ArrayList<Row> rows;
	protected int numrows;
	protected int seatPerRow;
	protected int theatrenum;
	//Constructor that specifies theatre number,number of rows in the theatre, and number of seats in each row.
	public Theatre(int theatrenum, int numrows, int numseats) {
		rows = new ArrayList<Row>();
		this.theatrenum = theatrenum;
		this.numrows = numrows;
		this.seatPerRow = numseats;
		for (int i = 0; i < numrows; i++) {
			rows.add(new Row(numseats, i+1));
		}
	}
	//returns whether or not each seat is reserved in the theatre
	public boolean isFull() {
		for (Row r : rows) {
			if (!r.isFull()) {
				return false;
			}
		}
		return true;
	}
	//returns a specific row in the theatre.
	public Row getRow(int i) {
		return rows.get(i);
	}
	//returns the number of seats available in the theatre.
	public int getAvailable() {
		int available = 0;
		for (Row r : rows) {
			for (Seat s : r) {
				if (!s.isReserved()) {
					available++;
				}
			}
		}
		return available;
	}
	//returns number of rows in the theatre
	public int getRowAmount() {
		return numrows;
	}
	//returns number of seats in each row
	public int getSeatsPerRow() {
		return seatPerRow;
	}
	//returns the number of the theatre.
	public int getTheatreNum() {
	 return theatrenum;
	}
	//for copying a specific theatre instance.
	public abstract Theatre copy();
	//checks if 2 theatres are equal by checking if they have the same theatre number
	public boolean equals(Theatre t) {
		return t.getTheatreNum() == this.getTheatreNum();
	}


}
