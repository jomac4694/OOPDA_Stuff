package cinemabookingthing;
//Reservation class.
public class Reservation implements ReservationInterface {

	String movietitle;
	Seat seat;
	int rownum;
	
	public Reservation(String movietitle, int rownum, Seat seat) {
		this.movietitle = movietitle;
		this.rownum = rownum;
		this.seat = seat;
	}

	public int getRowNum() {
		return rownum;
	}
	public String getMovieTitle() {
		return movietitle;
	}
	public Seat getSeat() {
		return seat;
	}
	public String toString() {
		return movietitle + "Row number: " + rownum + "Seat number: " + seat.getNumber();
	}
}
