package cinemabookingthing;

import java.util.ArrayList;

public class Customer implements CustomerInterface {
	private int phonenumber;
	private String name;
	private int age;
	private ArrayList<Reservation> reservations; //for holding reservations, customer may have more than 1
	
	public Customer(String name,int phonenumber, int age) {
		reservations = new ArrayList<>();
		this.name = name;
		this.phonenumber = phonenumber;
		this.age = age;
	}
	//returns phone number of customer
	public int getNumber() {
		return phonenumber;
	}
	//adds a reservation to reservation list
	public void addReservation(Reservation r) {
		reservations.add(r);
	}
	//removes a reservation and unreserves seat
	public void unReserve(Reservation r) {
		r.getSeat().unReserve();
		reservations.remove(r);
	}
	//returns name of customer
	public String toString() {
		return name;
	}
	//gets reservations for customer
	public ArrayList<Reservation> getReserves() {
		return reservations;
	}

	@Override
	//returns name of customer
	public String getName() {
		return name;
	}
	//returns age of customer
	public int getAge() {
		return age;
	}
}
