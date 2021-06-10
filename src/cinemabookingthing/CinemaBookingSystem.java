package cinemabookingthing;

import java.util.ArrayList;
import java.util.HashMap;
//Name: Joseph Mclvaine
//Date: 12-18-2017
//Class: OOPDA
//Professor: Doug Riecken
public class CinemaBookingSystem {

	private ArrayList<Customer> customerlist; //list of all the customers in the system.
	private HashMap<String, ArrayList<Show>> timemap; //Hashmap that uses a show time as a key, each key points to a list of shows playing at that time.
	private ArrayList<Theatre> theatreList;
	private HashMap<Show, ArrayList<Show>> showmap;
	private HashMap<String, ArrayList<Show>> theatremap;
	
	public CinemaBookingSystem() {
		theatreList = new ArrayList<>();
		customerlist = new ArrayList<Customer>();
		timemap = new HashMap<>();
		showmap = new HashMap<>();
		theatremap = new HashMap<>();
		makeTheatreList();
		makeShowMap();
		makeTimeMap();
		makeTheatreMap();
	}
	//reserves a seat for some customer for some show.
	public void reserveSeat(Show s, int rownum, int seatnum, Customer cust) {
		s.getTheatre().getRow(rownum).getSeat(seatnum).reserve();
		cust.addReservation(new Reservation(s.getTitle(), rownum+1, s.getTheatre().getRow(rownum).getSeat(seatnum)));
	} 
	//unreserves some reservation for some customer
	public void unReserve(Customer c, Reservation r) {
		c.unReserve(r);
	}
	//Adds a customer to the system, returns true if the addition was successful, false otherwise.
	public boolean addCustomer(int phonenumber, String name, int ccnumber) {
		if(getCustomer(phonenumber) == null) {
			customerlist.add(new Customer(name, phonenumber, ccnumber));
			return true;
		}
		return false;
	}
	//finds a customer based off telephone number (unique for each customer). 
	public Customer getCustomer(int number) {
		for (Customer c : customerlist) {
			if (c.getNumber() == number) {
				return c;
			}
		}
		return null;
	}
	//returns the list of customers
	public ArrayList<Customer> getCustomers() {
		return customerlist;
	}
	//returns the time/show map.
	public HashMap<String, ArrayList<Show>> getMap() {
		return timemap;
	}
	//returns showmap
	public HashMap<Show, ArrayList<Show>> getShowMap() {
		return showmap;
	}
	//returns theatre type/shows map.
	public HashMap<String, ArrayList<Show>> getTheatreMap() {
		return theatremap;
	}
	//Makes the show map.
	private void makeShowMap() {
		Show show1 = new Show("Thor: Ragnorok");
		Show show2 = new Show("Justice League");
		Show show3 = new Show("IT");
		Show show4 = new Show("Fernando");
		showmap.put(show1, new ArrayList<Show>());
		showmap.put(show2, new ArrayList<Show>());
		showmap.put(show3, new ArrayList<Show>());
		showmap.put(show4, new ArrayList<Show>());
		showmap.get(show1).add(show1.copy(theatreList.get(0).copy(), "1:30"));
		showmap.get(show2).add(show2.copy(theatreList.get(1).copy(), "1:30"));
		showmap.get(show3).add(show3.copy(theatreList.get(2).copy(), "1:30"));
		showmap.get(show4).add(show4.copy(theatreList.get(3).copy(), "1:30"));
		showmap.get(show1).add(show1.copy(theatreList.get(4).copy(), "4:30"));
		showmap.get(show2).add(show2.copy(theatreList.get(5).copy(), "4:30"));
		showmap.get(show3).add(show3.copy(theatreList.get(3).copy(), "4:30"));
		showmap.get(show4).add(show4.copy(theatreList.get(2).copy(), "4:30"));
		showmap.get(show1).add(show1.copy(theatreList.get(1).copy(), "10:30"));
		showmap.get(show2).add(show2.copy(theatreList.get(0).copy(), "10:30"));
		showmap.get(show3).add(show3.copy(theatreList.get(5).copy(), "10:30"));
		showmap.get(show4).add(show4.copy(theatreList.get(3).copy(), "10:30"));
	}
	//makes a time/shows map
	private void makeTimeMap() {
		timemap.put("1:30", new ArrayList<Show>());
		timemap.put("4:30", new ArrayList<Show>());
		timemap.put("10:30", new ArrayList<Show>());
		for (String s : timemap.keySet()) {
			for (Show sho : showmap.keySet()) {
				for (Show show : showmap.get(sho)) {
					if (show.getTime().equals(s)) {
						timemap.get(s).add(show);
					}
				}
			}
		}
		
	}
	
	//makes a list of the theatres in the cinema house
	private void makeTheatreList() {
		theatreList.add(new RegularTheatre(1, 15, 10));
		theatreList.add(new ImaxTheatre(2, 10, 10));
		theatreList.add(new ThreeDTheatre(3, 5, 10));
		theatreList.add(new RegularTheatre(4, 5, 10));
		theatreList.add(new ThreeDTheatre(5, 10, 15));
		theatreList.add(new ImaxTheatre(6, 6, 6));
	}
	//makes a theatretype/shows map
	private void makeTheatreMap() {
		theatremap.put("Regular", new ArrayList<Show>());
		theatremap.put("3D", new ArrayList<Show>());
		theatremap.put("Imax", new ArrayList<Show>());
		for (String type : theatremap.keySet()) {
			for (Show s : showmap.keySet()) {
				for (Show s1 : showmap.get(s)) {
					if (type.equals("Regular") && s1.getTheatre() instanceof RegularTheatre) {
						theatremap.get("Regular").add(s1);
					}
					else if (type.equals("3D") && s1.getTheatre() instanceof ThreeDTheatre) {
						theatremap.get("3D").add(s1);
					}
					else if (type.equals("Imax") && s1.getTheatre() instanceof ImaxTheatre) {
						theatremap.get("Imax").add(s1);
					}
				}
			}
		}
	}
	//starts the program
	public static void main(String argsp[]) {
		System.out.println(System.getProperty("user.dir"));
		new MainGUI();
	}
}
