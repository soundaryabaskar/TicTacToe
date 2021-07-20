import java.util.Scanner;

public class HumanPlayer extends APlayer{

	Scanner input = new Scanner(System.in);  
	public HumanPlayer(String name, Character mark) {
		super(name, mark);
	}

	
	@Override
	public int selectRowValue() {
		System.out.println("\nPlease enter a valid row number (0 to 2)");
		int row;
		do {
			row = input.nextInt();
		} while(row < 0 || row > 2);

		return row;
	}

	@Override
	public int selectColValue() {
		System.out.println("\nPlease enter a valid column number (0 to 2)");
		int col;
		do {
			col = input.nextInt();
		} while(col < 0 || col > 2);
		
		return col;
	}
	
	// if board is full let user select row
	public int boardFullRow() {
		int val = 0;
		do {
			System.out.println("\nPlease enter a valid board row from 0 to 2");
			 val = input.nextInt();
		} while(val < 0 || val > 2);
		
		return val;
		
	}
	
	// if board is full let user select col
	public int boardFullCol() {
		int val = 0;
		do {
			System.out.println("\nPlease enter a valid board column from 0 to 2");
			 val = input.nextInt();
		} while(val < 0 || val > 2);
		
		return val;
		
	}
	
}
