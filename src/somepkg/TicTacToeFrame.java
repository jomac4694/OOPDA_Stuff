package somepkg;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToeFrame extends JFrame implements MouseListener {
	TTTLabel buttons[][];
	BufferedImage pic;
	BufferedImage pic2;
	TicTacToe game = new TicTacToe();
	TicTacToeComputer comp;
	int gamesPlayed;
	
	public TicTacToeFrame() throws IOException {
		gamesPlayed = 0;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		buttons = new TTTLabel[3][3];
		pic = ImageIO.read(new File("Trump_X.png"));
		pic2 = ImageIO.read(new File("Kim Jong_O.png"));
		GridLayout grid = new GridLayout(3,3, 30, 30);
		comp = new TicTacToeComputer(game, "O");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new TTTLabel(i, j);
				buttons[i][j].setText("");
				buttons[i][j].setBackground(Color.WHITE);
				buttons[i][j].addMouseListener(this);
				add(buttons[i][j]);
			}
		}
		setLayout(grid);
		setTitle("TicTacTrump");
		setVisible(true);
		pack();
	}
	
	
	public static void main(String args[]) throws IOException {
		new TicTacToeFrame();
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		
			Object o = arg0.getSource();
			if (o instanceof TTTLabel) {
				TTTLabel l = (TTTLabel) o;
				
				if (game.set(l.getRow(), l.getColumn(), "X"))
					l.setIcon(new ImageIcon(pic));
				else
					return;
				if (game.gameWon()) {
					JOptionPane.showMessageDialog(this, "YOU WIN");
					playAgain();
					return;
				}
				else if (game.boardFull()) {
					JOptionPane.showMessageDialog(this, "TIE");
					playAgain();
					return;
				}
			}
			
			Cell c = comp.placeChar();
			buttons[c.getRow()][c.getColumn()].setIcon(new ImageIcon(pic2));
			if (game.gameWon()) {
				JOptionPane.showMessageDialog(this, "COMP WINS");
				playAgain();
				return;
			}
		
	}


	void playAgain() {
		if (JOptionPane.showConfirmDialog(this, "Would you like to play another game?") == JOptionPane.YES_OPTION) {
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					buttons[i][j].setIcon(null);
					buttons[i][j].setBackground(Color.WHITE);
				}		
			}
			game = new TicTacToe();
			comp = new TicTacToeComputer(game, "O");
			gamesPlayed++;
			return;
		}
		else {
			System.exit(0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mousePressed(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
}
