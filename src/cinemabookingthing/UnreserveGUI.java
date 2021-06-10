package cinemabookingthing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//GUI used for unreserving a seat for some customer.
public class UnreserveGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public UnreserveGUI(Customer c) {
		initialize(c);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Customer c) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(26, 13, 366, 39);
		frame.getContentPane().add(comboBox);
		for (Reservation s : c.getReserves()) {
			comboBox.addItem(s);
		}
		
		JButton btnUnreserve = new JButton("Unreserve");
		btnUnreserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainGUI.sys.unReserve(c, (Reservation) comboBox.getSelectedItem());
				frame.dispose();
			}
		});
		btnUnreserve.setBounds(13, 122, 171, 41);
		frame.getContentPane().add(btnUnreserve);
		frame.setTitle("Reservations for " + c.toString());
		frame.setVisible(true);
	}

}
