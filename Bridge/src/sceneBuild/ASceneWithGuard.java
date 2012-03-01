package sceneBuild;

import shapesComposite.AGuardAvatar;
import shapesComposite.Figure;

public class ASceneWithGuard implements Scene {

	Gorge gorge;
	Figure guard;
	StandArea standingArea;
	private int x, y, width, height;
	
	public ASceneWithGuard(int initX, int initY, int initWidth, int initHeight){
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
		gorge = new AGorge();
		guard = new AGuardAvatar(x + width, y, width, height);
		standingArea = new AStandArea(105, 180, 40, 40);
	}
	
	public int getX() {
		return x;
		
	}

	public void setX(int newVal) {
		x = newVal;
		guard = new AGuardAvatar(x + width, y, width, height);
	}

	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		y = newVal;
		guard = new AGuardAvatar(x + width, y, width, height);
	}

	public Gorge getGorge() {
		return gorge;
	}

	public Figure getGuard() {
		return guard;
	}

	public StandArea getStandingArea() {
		return standingArea;
	}

}
