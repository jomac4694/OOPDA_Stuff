package test;


import cinemabookingthing.Seat;


//abstract theatre class which can be used as a template to make more concrete theatre classes.
public abstract class Theatre {

	protected int numseats; //number of seats in theatre
	protected int theatrenum; //number of the theatre
	protected Seat seats[]; //seat array
	
	public Theatre(int theaternum) { //constructor takes an int for the theatrenumber
		this.theatrenum = theaternum;
	}
	
	public int getTheatreNumber() { //returns the theatre number
		return theatrenum;
	}

	public abstract int getNumSeats(); //will return the number of seats
	public abstract boolean isFull(); //will check if the theatre is full
	public abstract void startMovie();
	
}

//small theatre implementation
/*public*/ class SmallTheatre extends Theatre {

	public SmallTheatre(int theaternum) {
		super(theaternum);
		numseats = 50;
		seats = new Seat[50];
	}

	
	public int getNumSeats() {
		return numseats;
	}

	
	public boolean isFull() {
		for (Seat s : seats) {
			if (!s.isReserved())
				return false;
		}
		return true;
	}


	@Override
	public void startMovie() {
		System.out.println("starting small theatre movie");
		
	}
	
}
//large theatre implementation
/*public*/ class LargeTheatre extends Theatre {

	public LargeTheatre(int theaternum) {
		super(theaternum);
		numseats = 200;
		seats = new Seat[numseats];
	}

	@Override
	public int getNumSeats() {
		return numseats;
	}

	@Override
	public boolean isFull() {
		for (Seat s : seats) {
			if (!s.isReserved())
				return false;
		}
		return true;
	}

	@Override
	public void startMovie() {
		System.out.println("starting large theatre movie");
	}
}

//large 3d theatre implementation
/*public*/ class ThreeDTheatre extends LargeTheatre {

	public ThreeDTheatre(int theaternum) {
		super(theaternum);
		
	}

	@Override
	public int getNumSeats() {
		return numseats;
	}

	@Override
	public boolean isFull() {
		for (Seat s : seats) {
			if (!s.isReserved())
				return false;
		}
		return true;
	}

	@Override
	public void startMovie() {
		System.out.println("starting 3d movie");
		
	}
	
	
}