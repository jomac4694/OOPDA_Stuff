package cinemabookingthing;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
//Creates a GUI representation of a specific theatre, can be used to reserve seats
public class TheatreGUI extends JFrame implements MouseListener {

	private SeatButton seats[][];
	Show t;
	public TheatreGUI(Show t) {
		setTitle("Theatre");
		this.t = t;
		GridLayout grid = new GridLayout(t.getTheatre().getRowAmount(), t.getTheatre().getSeatsPerRow(), 15, 15);
		seats = new SeatButton[t.getTheatre().getRowAmount()][t.getTheatre().getSeatsPerRow()];
		for (int i = 0; i < t.getTheatre().getRowAmount(); i++) {
			for (int j = 0; j < t.getTheatre().getSeatsPerRow(); j++) {
				seats[i][j] = new SeatButton(i,j);
				if (t.getTheatre().getRow(i).getSeat(j).isReserved()) {
					seats[i][j].setBackground(Color.RED);
				}
				else {
					seats[i][j].setBackground(Color.GREEN);
				}
				seats[i][j].addMouseListener(this);
				seats[i][j].setText("Row: " + new Integer(i+1).toString() + "; " + "Seat: " + new Integer(j+1).toString());
				add(seats[i][j]);
			}
			
		}
		setLayout(grid);
		setSize(500,500);
		setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() instanceof SeatButton) {
			SeatButton button = (SeatButton) arg0.getSource();
			if (!t.getTheatre().getRow(button.getRow()).get(button.getSeatNum()).isReserved()) {
			new ReserveGUI(t, button.getRow(), button.getSeatNum());
			button.setBackground(Color.RED);
			System.out.println(t.getTheatre().getAvailable());
			}
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
