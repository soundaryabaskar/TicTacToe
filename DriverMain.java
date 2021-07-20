
// Soundarya Baskar
// CS 2336.0W2

/* Analysis
 * The purpose of this game is that we need to create an ultimate tictactoe with 9 boards. Instead of just winning the main board, 
 * you also need to win each of the smaller boards first until you have a line of three. There a couple of new rules we have to implement
 * to play this game properly. The first rule is that you can only place a mark on the board determined by the position of your
 * opponent’s last placed mark. The second rule is that if the board is already full, you get a free pass to place your mark in
 * any board. So overall, you play tictactoe regularly, but we have to play using 9 boards and this new rule in effect.
 * */

/* Design
 *  In order to create this game, I first started with the box class. My approach was by starting with the smallest thing and then working
 *  out to the bigger picture. I started by creating the box, which has a basic characteristic of a mark. Then we have a setter and getter 
 *  method for it and check if its available. And obviously the print method for it. I then moved on to the board class. In this class I 
 *  created a box object 2d array, since each board has these characteristics. I initialized this board in the constructor and create several 
 *  methods in this class. I created the makeMove method which makes the move and setter and getter methods for the winner variable, which keeps 
 *  track of the winner. Then a check winner and is winner method. The is winner checks for winners in the specific board we are playing in and 
 *  checks for row, column, left and right diagonals. Then I moved on the to the TTTGame method which does all the work. This method is where the
 *  start of the game occurs. I create a board 2d array object called bigboard, which keeps track of the 9 boards. Then created the players array 
 *  which creates two players. I will explain that in a bit. Then a variable to hold the index of the player and the current board row and current
 *  board column. Then the previous row and then previous column and then the overall winner. I start with the constructor which initializes the 
 *  big board it size 3x3. Then the start method which contains a do whiile loop which runs the whole game. The set player method, which sets the 
 *  players. Then the switch players method, then the show winner method, then the isFull method which checks if the board is full),  the isOverallWinner
 *  method, and two print methods. The dowhile checks if its the first move and then lets the players choose the row and column of where they want to play. 
 *  Else, the future move is based on the previous row and previous column. The isOverallWinner method is the one that checks for the overall winner in 
 *  the tictactoe. It will check using the same logic of checking for the winner in a mini board, but checks the entire 9 boards for a winner. That is the 
 *  TTTGame class. The abstract player class will create abtract methods for both the computer and the human players. The human player and computer player 
 *  will extend this class and define those methods. The human and computer player methods will both implement the methods of selectRow and selectCol, and 
 *  boardFullRow, and boardFullCol. The only difference between them is that the computer player will choose the row and column by itself using a random number 
 *  method. But in the human player, the human will choose the row and the column. That is the basic design of this Ultimate TicTacToe Game.
 * */

/* Test
 * There are several inputs you can put to test this. In order to test mine, I analyzed the outputs of the computer vs computer and human vs human. 
 * I ran them each several times and tested the board selection and it worked. The placements of the X's and O's validate who the winner is and I 
 * made sure to test those properly using the print method which prints the winner of each board. SO, after several test cases I was able to see that
 * my project worked in every instance.
 * */
 

public class DriverMain {

	public static void main(String args[]) {
		
		// create game object
		TTTgame game = new TTTgame();
		// computer and human
		//game.setPlayer(new ComputerPlayer("Player 1", 'X'), new HumanPlayer("Player 2", 'O'));
		
		// human and computer
		game.setPlayer(new HumanPlayer("Player 1", 'X'), new ComputerPlayer("Player 2", 'O'));
		
		//computer and computer
		//game.setPlayer(new ComputerPlayer("Player 1", 'X'), new ComputerPlayer("Player 2", 'O'));

		System.out.println("\nWelcome to Ultimate TicTacToe!\n\nPlayer 1: X, Human\nPlayer 2: O, Computer\n");
		
		// start the game
		game.start(); 
		
	}
}
