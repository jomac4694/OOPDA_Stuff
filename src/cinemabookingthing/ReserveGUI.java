package cinemabookingthing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//Used to reserve a seat by selecting a customer and clicking the reserve button
public class ReserveGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public ReserveGUI(Show s, int rownum, int seatnum) {
		initialize(s, rownum, seatnum);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Show s, int rownum, int seatnum) {
		frame = new JFrame();
		frame.setBounds(100, 100, 348, 300);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 15, 145, 39);
		frame.getContentPane().add(comboBox);
		for (Customer c : MainGUI.sys.getCustomers()) {
			comboBox.addItem(c);
		}
		JButton btnReserveSeat = new JButton("Reserve Seat!");
		btnReserveSeat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reserves a seat for the selected seat and customer.
				MainGUI.sys.reserveSeat(s, rownum, seatnum
						, (Customer) comboBox.getSelectedItem());
				System.out.println(s.getTheatre().getAvailable());
				Customer c = (Customer) comboBox.getSelectedItem();
				System.out.println(s.getTheatre().getRow(0).get(0).isReserved());
				frame.dispose();
			}
		});
		btnReserveSeat.setBounds(10, 143, 237, 41);
		
		frame.getContentPane().add(btnReserveSeat);
		frame.setVisible(true);
	}
	
}
