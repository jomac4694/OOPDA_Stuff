package AnotherTTT;

/* TicTacToe.java

This program displays a resizeable Tic Tac Toe game.  Play alternates
between the user, who plays O, and the computer, which plays X.
After the game ends the program displays a dialog box announcing the
winner and the total number of wins, losses, and draws by the user, and
asks if the user wants to play again.  If the user clicks YES then the
screen is cleared and a new game started.  Otherwise the program exits.
The computer moves first on alternate games.

At the top of the screen is a slider that allows the user to change
the line thickness of the O's, X's and the 3x3 grid.  There are also
2 buttons allowing the user to change the colors of the O's and X's.
Initially lines are 4 pixels thick, O's are blue and X's are red.

The computer's strategy is first to complete 3 X's in a row, or if that
is not possible, to block a row of 3 O's, or if that is not possible,
to move randomly.
*/

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class TicTacToe extends JFrame implements ChangeListener, ActionListener {
  private static final long serialVersionUID = -6054776926692695920L; //needed because JFrame is serializable
  private JSlider slider; //uninitialized JSlider
  private JButton oButton, xButton; // 2 uninitialized JSlider
  private Board board; //uninitialized Board (JPanel)
  private int lineThickness=4; //linethickness variable
  private Color oColor=Color.BLUE, xColor=Color.RED; //initializes colors
  static final char BLANK=' ', O='O', X='X';
  private char position[]={  // Board position (BLANK, O, or X), used to draw the board.
    BLANK, BLANK, BLANK,
    BLANK, BLANK, BLANK,
    BLANK, BLANK, BLANK};
  private int wins=0, losses=0, draws=0;  // game count by user

  // Start the game
  public static void main(String args[]) {
    new TicTacToe();
  }

  // Initialize
  public TicTacToe() {
    super("Tic Tac Toe demo"); //calls constructor of the parent class (JFrame) for setting the title on the top bar of frame.
    JPanel topPanel=new JPanel(); //creates a new JPanel
    topPanel.setLayout(new FlowLayout()); //sets topPanel (holds slider bar) layout to flowlayout
    topPanel.add(new JLabel("Line Thickness:")); //adds a label with text "Line Thickness:" to topPanel
    topPanel.add(slider=new JSlider(SwingConstants.HORIZONTAL, 1, 20, 4)); //adds a new JSlider to the topPanel
    slider.setMajorTickSpacing(1); //sets tick spacing of JSlider
    slider.setPaintTicks(true); //makes it so the ticks appear under slider
    slider.addChangeListener(this); //adds the TicTactoe class as a changelistener to the slider
    topPanel.add(oButton=new JButton("O Color")); //adds a new button to topPanel with text "O Color"
    topPanel.add(xButton=new JButton("X Color")); //adds a new button to topPanel with text "X color"
    oButton.addActionListener(this); //adds TicTacToe class as an actionlistener to the oButton
    xButton.addActionListener(this); //adds TicTacToe class as an actionlistener to the xButton
    add(topPanel, BorderLayout.NORTH); //adds top panel to JFrame (this) in the north region
    add(board=new Board(), BorderLayout.CENTER); //adds a new board to JFrame (this) in the center region
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes it so when you click on the X in right corner is closes the program
    setSize(500, 500); //sets the default size of the JFrame
    setVisible(true); //makes the JFrame visible
  }

  // Change line thickness
  public void stateChanged(ChangeEvent e) {
    lineThickness = slider.getValue(); //sets line thickness to new slider value
    board.repaint();
  }

  // Change color of O or X
  public void actionPerformed(ActionEvent e) {
    if (e.getSource()==oButton) { //checks if the source of action event was for the oButton
      Color newColor = JColorChooser.showDialog(this, "Choose a new color for O", oColor); //displays color pick interface, returns the color picked
      if (newColor!=null)//sets O color to new color if it is not null
        oColor=newColor;
    }
    else if (e.getSource()==xButton) { //checks if the source of action event was for xButton
      Color newColor = JColorChooser.showDialog(this, "Choose a new color for X", xColor); //displays color pick interface, returns the color picked
      if (newColor!=null) //sets X color to new color if it is not null
        xColor=newColor;
    }
    board.repaint(); //repaints the board to show the color has changed
  }

  // Board is what actually plays and displays the game
  private class Board extends JPanel implements MouseListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Random random=new Random();
    private int rows[][]={{0,2},{3,5},{6,8},{0,6},{1,7},{2,8},{0,8},{2,6}};
      // Endpoints of the 8 rows in position[] (across, down, diagonally)

    public Board() {
      addMouseListener(this);
    }

    // This whole function draws the board itself, and the X and O's which are present in the position array.
    public void paintComponent(Graphics g) {
 
      int w=getWidth(); //gets panel width
      int h=getHeight(); //gets panel height
      Graphics2D g2d = (Graphics2D) g; //casts Graphics argument to a new Graphics2D object

      // Draw the grid
      g2d.setPaint(Color.WHITE);
      g2d.fill(new Rectangle2D.Double(0, 0, w, h)); //fills the panel with a white rectangle
      g2d.setPaint(Color.BLACK); //sets the color of the shapes to be drawn to black
      g2d.setStroke(new BasicStroke(lineThickness)); //sets the stroke of the shapes to be drawn to the current thickness
      g2d.draw(new Line2D.Double(0, h/3, w, h/3));  //draws the first horizontal line of the TTT board
      g2d.draw(new Line2D.Double(0, h*2/3, w, h*2/3)); //draws the second horizontal line of the TTT board
      g2d.draw(new Line2D.Double(w/3, 0, w/3, h)); //draws the first vertical line of the TTT board
      g2d.draw(new Line2D.Double(w*2/3, 0, w*2/3, h));//draws the second vertical line of the TTT board

      // Draw the Os and Xs using a clever math trick.
      for (int i=0; i<9; ++i) { //used to go through the position array and draw all nine elements of it (X, O, or nothing)
        double xpos=(i%3+0.5)*w/3.0; //used to calculate the middle of a cell X position of the shape to be drawn
        double ypos=(i/3+0.5)*h/3.0; //used to calculate the middle of a cell Y position of the shape to be drawn
        double xr=w/8.0; //used to calculate the X position radius of the shape to be drawn
        double yr=h/8.0; //used to calculate Y position radius of the shape to be drawn
        if (position[i]==O) {
          g2d.setPaint(oColor); //sets the color of the O
          g2d.draw(new Ellipse2D.Double(xpos-xr, ypos-yr, xr*2, yr*2)); //draws an O using the x and y positions calculated above as starting position and the radius that was calculated
        }
        else if (position[i]==X) {
          g2d.setPaint(xColor); //sets the color of the X
          g2d.draw(new Line2D.Double(xpos-xr, ypos-yr, xpos+xr, ypos+yr)); //draws a diagonal line using the radii calculated above
          g2d.draw(new Line2D.Double(xpos-xr, ypos+yr, xpos+xr, ypos-yr)); //draws a second diagonal line that is opposite of the first one, makes an X
        }
      }
    }

    //This whole function calculates a position to place an O in the array (0-8) "position" based on where the user clicked
    public void mouseClicked(MouseEvent e) {
      int xpos=e.getX()*3/getWidth(); //gets X coordinate of mouse click, multiplies by 3, and divides by the width of panel
      int ypos=e.getY()*3/getHeight(); //gets Y coordinate of mouse click, multiplies by 3, and divides by the height of panel
      int pos= xpos+ypos*3; //gets a position 0-8 of where to place the O in position array.
      if (pos>=0 && pos<9 && position[pos]==BLANK) { //places position of O based off where they clicked.
        position[pos]=O;
        repaint(); //repaint board to add player move
        putX();  // computer plays
        repaint(); //repaint the board to add computer move
      }
    }

    // Ignore other mouse events
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    // Computer plays X
    void putX() {
      
      // Check if game is over
      if (won(O)) //check if o won
        newGame(O); //make a new game, where o is considered the winner
      else if (isDraw()) //check if draw
        newGame(BLANK); //make a new game where no one is considered winner

      // Play X, possibly ending the game
      else {
        nextMove(); //computer makes next best possible move
        if (won(X)) //check if X won
          newGame(X);// make a new game in which X was the winner
        else if (isDraw()) //check if draw
          newGame(BLANK); //make a new game where no one is considered winner.
      }
    }

    // Return true if player has won
    boolean won(char player) {
      for (int i=0; i<8; ++i) //for iterating through every different row
        if (testRow(player, rows[i][0], rows[i][1])) //test every row combination for a win
          return true;
      return false;
    }

    // Has player won in the row from position[a] to position[b]?
    boolean testRow(char player, int a, int b) { 
    	//tests an individual row to see if the player won, uses a+b/2 to get the middle position
      return position[a]==player && position[b]==player 
          && position[(a+b)/2]==player;
    }

    // Play X in the best spot
    void nextMove() {
      int r=findRow(X);  // complete a row of X and win if possible, if it returns anything > 1 the function skips all other code
      if (r<0)
        r=findRow(O);  // or try to block O from winning, if it returns anything > 1 the function skips all other code
      if (r<0) {  // otherwise move randomly
        do
          r=random.nextInt(9); //genrate random number between 0-8 while position is not blank
        while (position[r]!=BLANK);
      }
      position[r]=X;
    }

    // Return 0-8 for the position of a blank spot in a row if the
    // other 2 spots are occupied by player, or -1 if no spot exists
    int findRow(char player) {
      for (int i=0; i<8; ++i) { //for iterating through every different row
        int result=find1Row(player, rows[i][0], rows[i][1]); //tests every row to see if any contain 2 O's or 2 X's.
        if (result>=0)
          return result;
      }
      return -1;
    }

    // If 2 of 3 spots in the row from position[a] to position[b]
    // are occupied by player and the third is blank, then return the
    // index of the blank spot, else return -1.
    int find1Row(char player, int a, int b) {
      int c=(a+b)/2;  // middle spot
      //each checks if 2 spots contain an X or O by each variation of positions.
      if (position[a]==player && position[b]==player && position[c]==BLANK) //checks for "X X" or "O O"
        return c;
      if (position[a]==player && position[c]==player && position[b]==BLANK) //checks for "XX " or "OO "
        return b;
      if (position[b]==player && position[c]==player && position[a]==BLANK) //checks for " XX" or " OO"
        return a;
      return -1;
    }

    // Are all 9 spots filled?
    boolean isDraw() {
    	//returns false if one of the positions is blank.
      for (int i=0; i<9; ++i) //for checking each position
        if (position[i]==BLANK)
          return false;
      return true;
    }

    // Start a new game
    void newGame(char winner) {
      repaint();

      // Announce result of last game.  Ask user to play again.
      String result;
      if (winner==O) {
        ++wins; //increase wins by 1 if O wins
        result = "You Win!";
      }
      else if (winner==X) {
        ++losses; //increase losses by 1 if X wins
        result = "I Win!";
      }
      else { //increase draw if neither won
        result = "Tie";
        ++draws; 
      }
      if (JOptionPane.showConfirmDialog(null, 
          "You have "+wins+ " wins, "+losses+" losses, "+draws+" draws\n" //creates option selection box with the text inputted.
          +"Play again?", result, JOptionPane.YES_NO_OPTION)			//exits if the person inputs anything but yes.
          !=JOptionPane.YES_OPTION) {
        System.exit(0);
      }

      // Clear the board to start a new game
      for (int j=0; j<9; ++j) //sets every position in the array to blank, which is used to draw the board.
        position[j]=BLANK;

      // Computer starts first every other game
      if ((wins+losses+draws)%2 == 1) //checks if the turn count is odd.
        nextMove();
    }
  } // end inner class Board
  
  
} // end class TicTacToe


