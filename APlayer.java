public abstract class APlayer {
	
	private String name;
	private Character mark;
	
	public APlayer(String name, Character mark) {
		setName(name);
		setMark(mark);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Character getMark() {
		return mark;
	}
	public void setMark(Character mark) {
		this.mark = mark;
	}
	
	public abstract int selectRowValue();
	public abstract int selectColValue();
	public abstract int boardFullRow();
	public abstract int boardFullCol();

}
