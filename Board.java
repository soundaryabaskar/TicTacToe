
public class Board {

	Box[][] Board;
	boolean hasWon;
	Character winner ='-';

	public Board() {
		Board = new Box[3][3];
		hasWon = false;
		// initialize the board
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				Board[i][j] = new Box('-');
			}
		}

	}

	public boolean makeMove(Character mark, int row, int col) {
		if(Board[row][col].setMark(mark)) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		// chekc if available, and if it is make the move
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(Board[i][j].isAvailable())
					return false;
			}
		}
		return true;
	}

	public void setWinner(Character winner) {
		this.winner = winner;
	}

	public Character getWinner() {
		// checks if winner is already in that specific board
		if(hasWon) {
			return winner;
		} else {
			winner = isWinner();
			if(winner == 'X' || winner == 'O') {
				hasWon = true;
			} 
			return winner;
		}
	}

	public boolean checkWinner(){
		if(!winner.equals('-')) {
			return true;
		}
		return false;
	}


	// checks for winner in that board
	public char isWinner() {

		//check row
		int winCount1= 0;
		for (int i = 0; i < 3; i++) {	
			winCount1= 0;
			for(int j = 0; j < 2; j++) {           
				if(!Board[i][j].isAvailable() && Board[i][j].getMark().equals(Board[i][j+1].getMark())) {
					winCount1++;
				}
				if(winCount1 == 2) {
					//winner = Board[i][j].getMark();
					//System.out.println("Row winner " + winner);
					return Board[i][j].getMark();
				}
			}
		}

		//check col
		int winCount2= 0;
		for (int j = 0; j < 3; j++) {
			winCount2= 0;
			for(int i = 0; i < 2; i++) {           
				if(!Board[i][j].isAvailable() && Board[i][j].getMark().equals(Board[i+1][j].getMark())) {
					winCount2++;
				}
				
				if(winCount2 == 2) {
				//	winner = Board[i][j].getMark();
				//	System.out.println("Col winner " + winner);

					//System.out.println("Col " + i + ", " + j);
					return Board[i][j].getMark();
				}
			}
			
		}
		

		//check diagonal
		int winCount3 = 0;
		for (int i = 0; i < 2; i++) {
			if (!Board[i][i].isAvailable() && Board[i][i].getMark().equals(Board[i+1][i+1].getMark())) {
				winCount3++;
			}
			if (winCount3 == 2) {
				return Board[i][i].getMark();
			}
		}
		

		//check left diagonal
		int winCount4 = 0;
		for (int i = 0; i < 2; i++) {
			if (!Board[i][3-i-1].isAvailable() && Board[i][3-i-1].getMark().equals(Board[i+1][3-i-2].getMark())) {
				winCount4++;
			}
			if (winCount4 == 2) {
				return Board[i][3-i-1].getMark();
			}
		}
		
		return '-';

	}
}
