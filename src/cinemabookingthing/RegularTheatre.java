package cinemabookingthing;
//Regular theatre class.
public class RegularTheatre extends Theatre implements TheatreInterface {

	public RegularTheatre(int theatrenum, int numrows, int numseats) {
		super(theatrenum, numrows, numseats);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Theatre copy() {
		return new RegularTheatre(theatrenum, numrows, seatPerRow);
	}

}
