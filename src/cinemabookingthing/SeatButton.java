package cinemabookingthing;

import javax.swing.JButton;
//Seat button for use in the theatregui class, needed to assign row and number to a seat.
public class SeatButton extends JButton{

	
	private int row;
	private int seatnum;
	//creates new button with a row number and seat number
	public SeatButton(int row, int seatnum) {
		this.row = row;
		this.seatnum = seatnum;
	}
	
	//gets the row number
	public int getRow() {
		return row;
	}
	
	//gets the seat number
	public int getSeatNum() {
		return seatnum;
	}
}
