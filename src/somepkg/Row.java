package somepkg;

import java.util.ArrayList;
/*Object used for representing and accessing information on a collection of cells within the tictactoe board*/
public class Row {

	ArrayList<Cell> cells;
	private TicTacToe game;
	int rownum;
	
	//Row constructor, takes an array list of cells, instance of the game, and a row number
	public Row(ArrayList<Cell> list, TicTacToe game, int rownum) {
		cells = list;
		this.game = game;
		this.rownum = rownum;
	}
	//gets a specific cell within the row via the cell collection
	public Cell getCell(int ind) {
		return cells.get(ind);
	}
	//returns the row cell values as a concatenated string, example: "OO ", "XXX", "X X"
	public String toString() {
		String result = "";
		for (Cell c : cells) {
			result = result + game.getCharAt(c.getRow(),c.getColumn());
		}
		return result;
	}
	
	//returns true if there is a free cell in the cell list(cell contains " "), false if not.
	public boolean hasFreeCell() {
		boolean freecell = false;
	
		for (Cell c : cells) {
			if (c.getCellValue().equals(" ")) {
			freecell = true;
			break;
			}
		}
		return freecell;
	}
	
	//gets the numbers of X's in the row.
	public int getXCount() {
		int xcount = 0;
		for (Cell c : cells) {
			if (c.getCellValue().equals("X")) {
				xcount++;
			}
		}
		return xcount;
	}
	//gets the numbers of O's in the row.
	public int getOCount() {
		int ocount = 0;
		for (Cell c: cells) {
			if (c.getCellValue().equals("O")) {
				ocount++;
			}
		}
		return ocount;
	}
	//Gets the numbers of free spaces in a row
	public int getFreeCount() {
		int fcount = 0;
		for (Cell c: cells) {
			if (c.getCellValue().equals(" ")) {
				fcount++;
			}
		}
		return fcount;
	}
	//prints all relevant informations about the specific row.
	public String getInfo() {
		String output;
		output =
				"Row number: " + rownum + "\n" +
				" Number of X: " + getXCount() + "\n" +
				" Number of O: " + getOCount() + "\n" +
				" Number of Free: " + getFreeCount() + "\n";
				
		return output;
	}
	
	//returns the first free cell it finds, if it doesn't find one it returns null
	public Cell getFreeCell() {
	 Cell cell = null;
	 for (Cell c : cells) {
		 if (game.getCharAt(c.getRow(), c.getColumn()).equals(" ")) {
			 cell = c;
			 break;
		 }
	 }
	 return cell;
	}
	
	
	
}
