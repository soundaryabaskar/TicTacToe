
public class TTTgame {

	public Board[][] BigBoard;
	public APlayer[] players = new APlayer[2]; // created an object of players
	public int currIndex;
	public int boardSelectRow;
	public int boardSelectCol;
	public int prevRow;
	public int prevCol;
	public char overallWinner;


	public TTTgame() {
		BigBoard = new Board[3][3];
		// initialize the BigBoard
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				BigBoard[i][j] = new Board();
			}
		}
		currIndex = 1;
	}


	public void start() {
		System.out.print("Game has started...\n");
		// initialize variables
		boolean val = true;
		int tempRow = 0;
		int tempCol = 0;
		prevRow = 0;
		prevCol = 0;

		do {		
			print();
			// print who is the winner of each board 
			printWinner();

			switchPlayer();

			// for first move or if the board is full
			if(val || BigBoard[prevRow][prevCol].isFull()) {
				val = false;
				boardSelectRow = players[currIndex].boardFullRow();
				boardSelectCol = players[currIndex].boardFullCol();
			} else {
				boardSelectRow = prevRow;
				boardSelectCol = prevCol;
			}
			// print the current board we are playing in
			System.out.print("\nPlayer " + players[currIndex].getMark() + "\nCurrent Board Row: " + boardSelectRow + "\nCurrent Board Column: " + boardSelectCol + "\n");

			tempRow = prevRow;
			tempCol = prevCol;

			prevRow = players[currIndex].selectRowValue();
			prevCol = players[currIndex].selectColValue();

			// if the space is a available make a move
			if(BigBoard[boardSelectRow][boardSelectCol].makeMove(players[currIndex].getMark(), prevRow, prevCol)) {
				continue;
			} else {
				// go back to the previous row/col
				System.out.print("\nMove not made\n");
				prevRow = tempRow;
				prevCol = tempCol;
				switchPlayer();
			}

			//BigBoard[boardSelectRow][boardSelectCol].isWinner();

		} while(!gameOver());
		// print the final board and show the winner and out put game is over
		print();
		showWinner();
		System.out.println("Game over!");
	}

	public void setPlayer(APlayer player1, APlayer player2) {
		players[0] = player1;
		players[1] = player2;
	}

	public void switchPlayer() {
		if(currIndex == 1) {
			currIndex = 0;
		}
		else currIndex = 1;
	}

	public void showWinner() {
		// if x or o, show winner else there is no winner
		if(overallWinner == 'X' || overallWinner == 'O')
			System.out.print("The Winner is " + overallWinner + "\n");
		else 
			System.out.print("There is no winner\n");
	}

	public boolean isFull() {
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(!BigBoard[i][j].isFull())
					return false;
			}
		}
		return true;
	}

	public boolean gameOver() {
		if(isOverallWinner() || isFull())
			return true;
		return false;
	}

	// check for overall winner in the game
	private boolean isOverallWinner() {
		//check row
		int winCount1= 0;
		for (int i = 0; i < 3; i++) {
			winCount1= 0;
			for(int j = 0; j < 2; j++) { 
				if(BigBoard[i][j].getWinner() == (BigBoard[i][j+1].getWinner()) && BigBoard[i][j].getWinner() != '-') {
					winCount1++;
				}
				if(winCount1 == 2) {
					overallWinner = BigBoard[i][j].getWinner();
					return true;
				}
			}

		}

		//check col
		int winCount2= 0;
		for (int j = 0; j < 3; j++) {
			winCount2= 0;
			for(int i = 0; i < 2; i++) {               
				if(BigBoard[i][j].getWinner() == (BigBoard[i+1][j].getWinner()) && BigBoard[i][j].getWinner() != '-') {
					winCount2++;
				}
				if(winCount2 == 2) {
					overallWinner = BigBoard[i][j].getWinner();
					return true;
				}
			}

		}

		//check diagonal
		int winCount3 = 0;
		for (int i = 0; i < 2; i++) {
			if (BigBoard[i][i].getWinner() == (BigBoard[i+1][i+1].getWinner()) && BigBoard[i][i].getWinner() != '-') {
				winCount3++;
			}
			if (winCount3 == 2) {
				overallWinner = BigBoard[i][i].getWinner();
				return true;
			}
		}

		//check left diagonal
		int winCount4 = 0;
		for (int i = 0; i < 2; i++) {
			if (BigBoard[i][3-i-1].getWinner() == (BigBoard[i+1][3-i-2].getWinner()) && BigBoard[i][3-i-1].getWinner() != '-') {
				winCount4++;
			}
			if (winCount4 == 2) {
				overallWinner = BigBoard[i][3-i-1].getWinner();
				return true;
			}
		}

		return false;

	}

	public void print() {
		// first three boards
		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[0][i].Board[0][j].getMark() + " ");
			}
		}
		System.out.println();

		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[0][i].Board[1][j].getMark() + " ");
			}
		}

		System.out.println();

		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[0][i].Board[2][j].getMark() + " ");
			}
		}

		System.out.println();

		System.out.println("_____________________");


		// second three boards
		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[1][i].Board[0][j].getMark() + " ");
			}
		}
		System.out.println();

		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[1][i].Board[1][j].getMark() + " ");
			}
		}

		System.out.println();

		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[1][i].Board[2][j].getMark() + " ");
			}
		}

		System.out.println();

		System.out.println("_____________________");


		// third three boards
		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[2][i].Board[0][j].getMark() + " ");
			}
		}
		System.out.println();

		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[2][i].Board[1][j].getMark() + " ");
			}
		}

		System.out.println();

		for (int i = 0; i < 3; i++) {
			System.out.print("|");
			for(int j = 0; j < 3; j++) {
				System.out.print(BigBoard[2][i].Board[2][j].getMark() + " ");
			}
		}

		System.out.println();
		System.out.println("______________________");

	}

	// print the winner of each board
	public void printWinner() {
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.println(" Winner of " + i + " " + j + " = " + BigBoard[i][j].getWinner());
			}

		}
	}
}
