package cinemabookingthing;


//Class for ThreeDTheatre
public class ThreeDTheatre extends Theatre implements TheatreInterface{

	public ThreeDTheatre(int theatrenum, int numrows, int numseats) {
		super(theatrenum, numrows, numseats);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Theatre copy() {
		return new ThreeDTheatre(theatrenum, numrows, seatPerRow);
	}

}
