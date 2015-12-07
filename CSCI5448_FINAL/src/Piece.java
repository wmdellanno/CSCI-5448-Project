import java.awt.Color;

public class Piece {
	
	private int value;
	private String name;
	private Color clr;
	private int xLoc;
	private int yLoc;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public Color getColor() {
		return clr;
	}

	public void setColor(Color clr) {
		this.clr = clr;
	}
	
	

}
