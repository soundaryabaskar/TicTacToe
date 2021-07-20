
public class Box {
	
	Character Mark;
	
	public Box(Character mark) {
		this.Mark = mark;
	}
	
	public boolean setMark(Character mark) {
		if(isAvailable()) {
			Mark = mark;
			return true;
		} 
		 return false;
	}
	
	public Character getMark() {
		return Mark;
	}
	
	
	public boolean isAvailable() {
		return Mark.equals('-');
	}
	
	public void print() {
		System.out.print(Mark);
	}
	
}
