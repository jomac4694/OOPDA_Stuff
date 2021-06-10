package cinemabookingthing;
//Imax theatre type
public class ImaxTheatre extends Theatre implements TheatreInterface {

	public ImaxTheatre(int theatrenum, int numrows, int numseats) {
		super(theatrenum, numrows, numseats);
		// TODO Auto-generated constructor stub
	}

	@Override
	//for copying the theatre
	public Theatre copy() {
		return new ImaxTheatre(theatrenum, numrows, seatPerRow);
	}

}
