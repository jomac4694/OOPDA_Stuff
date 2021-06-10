package somepkg;

import java.util.ArrayList;
import java.util.Random;
/*
 * Tictactoe AI that can play vs human
 */
public class TicTacToeComputer {
	TicTacToe game;
	String player;
	public TicTacToeComputer(TicTacToe game, String player) {
		this.game = game;
		this.player = player;
	}
	
	/*Places a character (X or O) by doing the following: checks if the AI can win, checks if the AI can lose,
	 * Checks if it is going second AND the middle is available, lastly checks if any corners are available.
	 * If none of those checks pass, it places a character randomly. 
	 * */

	public Cell placeChar() {
		Random rando = new Random();
		final int RANDO_BOUND = 3;
		int row = rando.nextInt(RANDO_BOUND);
		int column = rando.nextInt(RANDO_BOUND);
		ArrayList<Row> rowlist = game.rowList();
		Row cornerrow = cornerRow();
		Cell freecell = null;
		//check if there is a row with win potential
		if (findWinRow(rowlist) != null) {
			Row r = findWinRow(rowlist);//get the row
			freecell = r.getFreeCell();//get the free cell (can only be 1)
			game.set(freecell.getRow(),freecell.getColumn(), player);//place in the free cell
		}
		//check if there is a row with lose potential
		else if (findLoseRow(rowlist) != null) {
			Row r = findLoseRow(rowlist);//get the row
			freecell = r.getFreeCell();//get the empty cell (can only be 1)
			game.set(freecell.getRow(),  freecell.getColumn(), player);//place in the free cell
		}
		//check if the AI is going second and if the middle is not occupied.
		else if (goingSecond() && !game.spaceOccupied(1, 1)) {
			game.set(1, 1, player); //take the middle space
			freecell = new Cell(1,1, game);
		}
		//check for a free corner cell
		else if (cornerrow.hasFreeCell()) {
			
			freecell = cornerrow.getCell(rando.nextInt(4)); //get a random free corner cell
			while (!game.set(freecell.getRow(),freecell.getColumn(), player)) {
				freecell = cornerrow.getCell(rando.nextInt(4));
			}
			
		}
		//place a character in a random free space (should never make it here, added in case).
		else {
			freecell = new Cell(row, column, game);
		while (!game.set(row, column, player)) {
			row = rando.nextInt(RANDO_BOUND);
			column = rando.nextInt(RANDO_BOUND);
			freecell = new Cell(row, column, game);
		}
		}
		return freecell;
	}
	
	//Checks if the computer is going second in the game.
	private boolean goingSecond()  {
		for (Row r : game.rowList()) {
			if ((r.getXCount() == 1 && r.getOCount() == 0) || r.getXCount() == 0 && r.getOCount() == 1) {
				return true;
			}
		}
		return false;
	}
	
	//Checks if the opponent has 2 corners taken.
	private boolean opponentHasCorners() {
		Row r = cornerRow();
		if (player.equals("O")) {
			if (r.getXCount() == 2) {
				return true;
			}
			}
		else {
			if (r.getOCount() == 2) {
				return true;
			}
		}
		return false;
	}
	
	//Checks if there is a row with the potential to cause a game loss, returns the row if there is. Else it returns null 
	private Row findLoseRow(ArrayList<Row> rowlist) {
		Row row = null;
		if (player.equals("O")) {
		for (Row r : rowlist) {
			if (r.toString().replaceAll(" ", "").equals("XX")) {
				row = r;
				break;
			}
		}
		}
		else {
			for (Row r : rowlist) {
				if (r.toString().replaceAll(" ", "").equals("OO")) {
					row = r;
					break;
				}
			}
			
		}
		return row;
		
	}
	//Checks if there is a row with the potential to win. Returns the row if there is, else it returns null
	private Row findWinRow(ArrayList<Row> rowlist) {
		Row row = null;
		if (player.equals("O")) {
		for (Row r : rowlist) {
			if (r.toString().replaceAll(" ", "").equals("OO")) {
				row = r;
				break;
			}
		}
		}
		else {
			for (Row r : rowlist) {
				if (r.toString().replaceAll(" ", "").equals("XX")) {
					row = r;
					break;
				}
			}
		}
		return row;
		
	}
	//Makes a row object of all the corner cells in order to access them more easily. 
	private Row cornerRow() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		cells.add(new Cell(0, 0, game)); 
		cells.add(new Cell(0, 2, game));
		cells.add(new Cell(2, 0, game));
		cells.add(new Cell(2, 2, game));
		return new Row(cells, game, 9);
	}
}
