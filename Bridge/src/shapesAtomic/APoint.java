package shapesAtomic;


public class APoint implements Point {
	private int x;
	private int y;
	
	public APoint(int intX, int intY) {
		x = intX;
		y = intY;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}