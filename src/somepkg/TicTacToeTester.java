package somepkg;

import java.util.Scanner;

public class TicTacToeTester {
	/*Big messy function that allows you to play a game of tictactoe vs AI, or simulate an AI vs AI game. Can also print
	 * row information at the start of each turn if you want.*/
	public void start() throws InterruptedException {
		int input;
		Scanner in = new Scanner(System.in);
		String player = "X";
		String opponent = "O";
		TicTacToe game = new TicTacToe();
		TicTacToeComputer computer = new TicTacToeComputer(game, player);
		TicTacToeComputer computer2 = new TicTacToeComputer(game, opponent);
		System.out.print("Welcome to tictactoe, please select an input (1 == Play game vs AI, 2 == simulate game (AI vs AI)): ");
		input = in.nextInt();
		//code where the human vs the AI.
		if (input == 1) {
		while (true) {
			System.out.print("Please select an input (1 == take turn, 2 == print vector information): ");
			input = in.nextInt();
		if (input == 1) {
		System.out.println(game.toString());
		System.out.print("Enter row: ");
		int row = in.nextInt();
		System.out.print("Enter colulmn: ");
		int column = in.nextInt();
		game.set(row, column, player);
			if (game.boardFull()) {
				System.out.println("no one wins");
				break;
				
			}
			else if(game.gameWon()) {
				System.out.println("player x wins");
				break;
			}
		System.out.println("Computer plays a turn");
		computer2.placeChar();
		System.out.println(game.toString());
		if (game.gameWon()) {
			System.out.println("player o wins");
			break;
		}
		}
		else if (input == 2) {
			game.printVectors();
		}
		}
		System.out.print("Final Board \n" + game.toString());
		}
		//code for when the computers verse each other.
		else if (input == 2) {
			while (true) {
			System.out.println("Computer 1 is making a move....");
			Thread.sleep(2000);
			computer.placeChar();
			System.out.print(game.toString());
				if (game.boardFull()) {
					System.out.println("no one wins");
					break;
					
				}
				else if(game.gameWon()) {
					System.out.println("player X wins");
					break;
				}
			System.out.println("Computer 2 is making a move....");
			Thread.sleep(2000);
			computer2.placeChar();
			System.out.print(game.toString());
			if (game.gameWon()) {
				System.out.println("player O wins");
				break;
			}
			else if (game.boardFull()) {
				System.out.println("no one wins");
				break;
			}
		}
			System.out.println("Final Board \n" + game.toString());
		}

		
	}
	
//to start the program
	public static void main(String[] args) throws InterruptedException  {
		TicTacToeTester t = new TicTacToeTester();
		t.start();
	}
	
	
}
