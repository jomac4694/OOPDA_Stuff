package cinemabookingthing;
//Customer interface
public interface CustomerInterface {

	void addReservation(Reservation r);
	void unReserve(Reservation r);
	int getNumber();
	String getName();
	int getAge();
}
