package somepkg;

import javax.swing.JButton;

public class TTTLabel extends JButton {

	
	int column;
	int row;
	
	public TTTLabel(int row, int col) {
		this.row = row;
		column = col;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}
}
