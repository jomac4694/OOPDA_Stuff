package cinemabookingthing;
//Show class, represents a specific show in a cinema house.
public class Show implements ShowInterface {
	
	
	String showtitle;
	Theatre theatre; //each show has its own theatre
	String showtime;
	//Constructor with just showtitle
	public Show(String showtitle) {
		this.showtitle = showtitle;
		theatre = null;
		showtime = null;
	}
	//Constructor with title, theatre, and time.
	public Show(String showtitle, Theatre t, String time) {
		
		this.showtitle = showtitle;
		theatre = t;
		this.showtime = time;
	}
	
	//returns the title of the show
	public String getTitle() {
		return showtitle;
	}
	//returns whether or not the theatre of the show is full.
	public boolean isBooked() {
		return theatre.isFull();
	}
	//returns the showtitle, number of seats available in theatre, time of show, and theatre type.
	public String toString() {
		String ttype = "";
		if (theatre instanceof ThreeDTheatre && theatre != null) {
			ttype = "3D";
		}
		else if (theatre instanceof ImaxTheatre && theatre != null) {
			ttype = "Imax";
		}
		else if (theatre instanceof RegularTheatre && theatre != null) {
			ttype = "Regular";
		}
		if (theatre == null && showtime == null) {
			return showtitle;
		} else {
			
		return showtitle + "," + theatre.getAvailable() + "," + showtime + "," + ttype;
		}
}
	//returns just showtitle and number of seats available in theatre
	public String movieInfo() {
		return showtitle + "," + theatre.getAvailable();
	}
	//returns theatre show is playing in
	public Theatre getTheatre() {
		return theatre;
	}
	//returns time of the show
	public String getTime()  {
		return showtime;
	}
	//copys the show, can change time and theatre of show.
	public Show copy(Theatre theatre, String showtime) {
		return new Show(showtitle, theatre,showtime );
	}

}
