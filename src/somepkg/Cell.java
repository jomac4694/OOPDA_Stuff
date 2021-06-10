package somepkg;
/*Object used for representing and accessing information on a specific cell in the tictactoe board.*/
public class Cell {

	private int row;
	private int column;
	private TicTacToe game;
	//cell constructor, takes a row, column, and instance of the game.
	public Cell(int row, int column, TicTacToe game) {
		this.row = row;
		this.column = column;
		this.game = game;
	}
	//returns row value
	public int getRow() {
		return row;
	}
	//returns column value
	public int getColumn() {
		return column;
	}
	//gets the string value of the specific cell
	public String getCellValue() {
		return game.getCharAt((int) row, (int) column);
	}
	//checks if the cell is free, dont think its ever used.
	public boolean isFree() {
		return getCellValue().equals(" ");
	}
}
