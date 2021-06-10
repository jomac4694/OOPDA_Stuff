package cinemabookingthing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class MainGUI extends JFrame  {
	
	public static CinemaBookingSystem sys = new CinemaBookingSystem();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnUnreserve;
	private JComboBox<Show> comboBox_2;
	private JLabel lblShowTimes;
	private JLabel label;
	private JLabel lblName;
	private JLabel lblPhoneNumber;
	private JLabel lblAge;
	private JLabel lblCustomers;
	private JTextField textField_3;
	private JComboBox<Show> comboBox_3;
	private JButton btnNewButton_1;
	private JComboBox<Show> comboBox_4;
	private JComboBox<String> comboBox_5;
	private JComboBox<Show> comboBox_6;
	private JButton btnNewButton_2;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		this.setTitle("Cinema Booking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 778);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<>();
		//fills comboBox with times from map
		for (String s: sys.getMap().keySet()) {
			comboBox.addItem(s);
		}
		comboBox.addItemListener(new ItemListener() {
			//fills comboBox_2 with shows based off the selection of comboBox
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getSource().equals(comboBox)) {
				comboBox_2.removeAllItems();
				for (Show s : sys.getMap().get(comboBox.getSelectedItem().toString())) {
					comboBox_2.addItem(s);
				}
				label.setText("Shows at " + comboBox.getSelectedItem().toString());
			}
			}
			
		});
	
		comboBox.setBounds(14, 80, 269, 41);
		contentPane.add(comboBox);
		
		JButton btnShowTheatre = new JButton("Show Theatre");
		btnShowTheatre.addActionListener(new ActionListener() {
			//Creates a new theatreGUI for the selected show.
			public void actionPerformed(ActionEvent e) {
				Show s = (Show) comboBox_2.getSelectedItem();
				new TheatreGUI(s);
			}
		});
		btnShowTheatre.setBounds(24, 275, 219, 41);
		contentPane.add(btnShowTheatre);
		
		JComboBox<Customer> comboBox_1 = new JComboBox<Customer>();
		comboBox_1.setBounds(460, 16, 295, 39);
		contentPane.add(comboBox_1);
		//fills comboBox_1 with customers in the customer list
		for (Customer c : sys.getCustomers()) {
			comboBox_1.addItem(c);
		}
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sys.addCustomer(Integer.parseInt(textField_1.getText()), textField.getText(), Integer.parseInt(textField_2.getText()));
				comboBox_1.removeAllItems();
				for (Customer c : sys.getCustomers()) {
					comboBox_1.addItem(c);
				}
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnAddCustomer.setBounds(336, 302, 205, 41);
		contentPane.add(btnAddCustomer);
		
		textField = new JTextField();
		textField.setBounds(470, 81, 285, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(470, 148, 285, 39);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(470, 214, 285, 39);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnUnreserve = new JButton("Unreserve");
		btnUnreserve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer c = (Customer) comboBox_1.getSelectedItem();
				if (comboBox_1.getItemCount() != 0) {
					if (c.getReserves().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Customer has no reservations");
					}
					else {
						new UnreserveGUI(c);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No customer entries");
				}
			}
		});
		btnUnreserve.setBounds(567, 302, 192, 41);
		contentPane.add(btnUnreserve);
		
		comboBox_2 = new JComboBox<>();
		comboBox_2.setBounds(14, 197, 269, 39);
		contentPane.add(comboBox_2);
		lblShowTimes = new JLabel("Show Times");
		lblShowTimes.setBounds(14, 19, 205, 33);
		contentPane.add(lblShowTimes);
		
		label = new JLabel("");
		label.setBounds(14, 149, 115, 33);
		contentPane.add(label);
		label.setText("Shows at " + comboBox.getSelectedItem().toString());
		
		lblName = new JLabel("Name:");
		lblName.setBounds(350, 84, 115, 33);
		contentPane.add(lblName);
		
		lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setBounds(336, 151, 192, 33);
		contentPane.add(lblPhoneNumber);
		
		lblAge = new JLabel("Age:");
		lblAge.setBounds(350, 217, 115, 33);
		contentPane.add(lblAge);
		
		lblCustomers = new JLabel("Customers: ");
		lblCustomers.setBounds(335, 19, 144, 33);
		contentPane.add(lblCustomers);
		
		textField_3 = new JTextField();
		textField_3.setBounds(16, 344, 236, 39);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Search by name");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_3.removeAllItems();
				boolean showfound = false;
				for (Show s : sys.getShowMap().keySet()) {
					if (s.getTitle().toLowerCase().contains(textField_3.getText().toLowerCase())) {
						comboBox_3.addItem(s);
						showfound = true;
					}
				}
				if (showfound == false)
					JOptionPane.showMessageDialog(null, "No movies with this name");
			}
		});
		btnNewButton.setBounds(14, 581, 229, 41);
		contentPane.add(btnNewButton);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(17, 400, 235, 39);
		contentPane.add(comboBox_3);
		comboBox_3.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
					comboBox_4.removeAllItems();
					for (Show s : sys.getShowMap().get(comboBox_3.getSelectedItem())) {
						comboBox_4.addItem(s);
					}
				
			}
		});
		btnNewButton_1 = new JButton("Show Theatre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Show s = (Show) comboBox_4.getSelectedItem();
				new TheatreGUI(s);
			}
		});
		btnNewButton_1.setBounds(14, 632, 229, 41);
		contentPane.add(btnNewButton_1);
		
		comboBox_4 = new JComboBox<Show>();
		comboBox_4.setBounds(14, 489, 238, 39);
		contentPane.add(comboBox_4);
		setVisible(true);
		comboBox.setSelectedIndex(1);
		comboBox.setSelectedIndex(0);
		
		comboBox_5 = new JComboBox<String>();
		comboBox_5.setBounds(447, 437, 262, 39);
		contentPane.add(comboBox_5);
		for (String s : sys.getTheatreMap().keySet()) {
			comboBox_5.addItem(s);
		}
		comboBox_5.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				comboBox_6.removeAllItems();
				for (Show s : sys.getTheatreMap().get(comboBox_5.getSelectedItem())) {
					comboBox_6.addItem(s);
				}
				
			}
			
		});
		comboBox_6 = new JComboBox<Show>();
		comboBox_6.setBounds(447, 534, 262, 39);
		contentPane.add(comboBox_6);
		
		btnNewButton_2 = new JButton("Show Theatre");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Show s = (Show) comboBox_6.getSelectedItem();
				new TheatreGUI(s);
			}
		});
		btnNewButton_2.setBounds(447, 601, 262, 41);
		contentPane.add(btnNewButton_2);
		
		JLabel lblMovieType = new JLabel("Theatre Type:");
		lblMovieType.setBounds(516, 376, 174, 33);
		contentPane.add(lblMovieType);
		
		JLabel lblNewLabel = new JLabel("Movies Playing:");
		lblNewLabel.setBounds(504, 492, 205, 33);
		contentPane.add(lblNewLabel);
		comboBox_5.setSelectedIndex(1);
		comboBox_5.setSelectedIndex(0);
	}
}
