package somepkg;

import java.util.ArrayList;
/*Object used to represent and access information for a tictactoe board*/
public class TicTacToe {
//Constructor that creates a 2D array to represent the tictactoe board. Fills the array with spaces.
	public TicTacToe() {
		board = new String[ROWS][COLUMNS];
		turnCount =0;
		for(int i=0; i < ROWS; i++)
			for(int j=0; j < COLUMNS; j++)
				board[i][j] = " ";

	}
	
	//Places a character (player parameter) in the specified spot
	public boolean set(int i, int j, String player) {
		if(!spaceOccupied(i, j) && !boardFull())
		{
			board[i][j] = player;
			turnCount++;
			return true;
		}
		return false;
	}
	//Returns a string representation of the board matrix.
	public String toString() {
		String r = "";
		for(int i=0; i < ROWS; i++) {
			r = r + "|";
			for(int j=0; j < COLUMNS; j++) r = r + board[i][j];
			r = r + "|\n";

		}
		return r;
	}
	
	//Checks if the board is full
	public boolean boardFull() {
		
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				if (board[i][j].equals(" ")) {
					return false;
				}
				else {
					continue;
				}
			}
		}
		return true;
	}
	//Checks if there is a win by iterating through row and checking if any contain "OOO" or "XXX"
	public boolean gameWon() {
		for (Row r : rowList()) {
			if (r.toString().equals("XXX") || r.toString().equals("OOO")) {
				return true;
			}
		}
		return false;
		
	}
	
	//A bunch of for loops that creates cells, creates a new row with the cells, and add the row to a row list. Returns the row list.
	public ArrayList<Row> rowList() {
		ArrayList<Row> list = new ArrayList<Row>();
		ArrayList<Cell> cells;
		int rownum = 0;
		//For horizontal
		for (int i = 0; i < 3; i++) {
			cells = new ArrayList<Cell>();
			for (int j = 0; j < 3; j++ ) {
					cells.add(new Cell(i, j,this));
			}
			rownum++;
			list.add(new Row(cells, this, rownum));
		}
		//For vertical
		for (int i = 0; i < 3; i++) {
			cells = new ArrayList<Cell>();
			for (int j = 0; j < 3; j++ ) {
					cells.add(new Cell(j, i, this));
			}
			rownum++;
			list.add(new Row(cells, this, rownum));
		}
		//For diagonal 1
		for (int i = 0; i < 3; i++) {
			cells = new ArrayList<Cell>();
			for (int j = 0; j < 3; j++ ) {
					cells.add(new Cell(i, j, this));
					i++;
			}
			rownum++;
			list.add(new Row(cells,this, rownum));
		}
		//For diagonal 2
		for (int i = 0; i < 3; i++) {
			cells = new ArrayList<Cell>();
			for (int j = 2; j >= 0; j-- ) {
					cells.add(new Cell(i,j, this));
					i++;
			}
			rownum++;
			list.add(new Row(cells,this, rownum));
		}
		
		return list;
	}
	public int getTurn() {
		return turnCount;
	}
	//Checks if a specific cell is occupied
	public boolean spaceOccupied(int row, int column) {
		return !board[row][column].equals(" ");
	}
	//Gets the character at a certain cell
	public String getCharAt(int row, int column) {
		return board[row][column];
	}
	//Prints all the information of the rows in the rowlist
	public void printVectors() {
		for (Row r : rowList()) {
			System.out.println(r.getInfo());
		}
	}
private int turnCount;
private String[][] board;
private static final int ROWS = 3;
private static final int COLUMNS = 3;

}