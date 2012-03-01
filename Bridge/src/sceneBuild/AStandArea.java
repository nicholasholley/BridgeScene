package sceneBuild;

import shapesAtomic.AnOval;

public class AStandArea implements StandArea {

	Object knightStand, guardStand;
	private int x, y, width, height;
	
	public AStandArea(int initX, int initY, int initWidth, int initHeight){
		x = initX;
		y = initY;
		width = initHeight;
		height = initWidth;
		knightStand = new AnOval(x, y, width+50, height);
		guardStand = new AnOval(x + width+50, y, width, height);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int newVal) {
		x = newVal;
	}

	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		y = newVal;
	}
	public Object getKnightStand() {
		return knightStand;
	}

	public Object getGuardStand() {
		return guardStand;
	}

}
