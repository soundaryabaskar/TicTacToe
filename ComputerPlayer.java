
public class ComputerPlayer extends APlayer {
	public ComputerPlayer(String name, Character mark) {
		super(name, mark);
	}


	private int randomNumber() {
		return (int) (Math.random() * 3);
	}

	@Override
	public int selectRowValue() {
		return randomNumber();
	}
	
	@Override
	public int selectColValue() {
		return randomNumber();
	}
	
	public int boardFullRow() {
		return randomNumber();
	}
	
	public int boardFullCol() {
		return randomNumber();
	}
}
