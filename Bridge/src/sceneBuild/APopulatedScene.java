package sceneBuild;

import shapesComposite.AGuardWithChat;
import shapesComposite.Figure;

import collections.AFallenAvatars;
import collections.FallenAvatars;
import collections.MarchingKnightQueue;
import collections.AnAlignedMarchingKnightQueue;

public class APopulatedScene implements Scene {

	Gorge gorge;
	AGuardWithChat guard;
	StandArea standingArea;
	public MarchingKnightQueue notPassed, havePassed;
	FallenAvatars TheFallen;
	public int x, y, width, height;

	public APopulatedScene(int initX, int initY, int initWidth, int initHeight) {
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
		gorge = new AGorge();
		guard = new AGuardWithChat(x + width+150, y, width, height, "Guard",
				"Answer pl0x.");
		standingArea = new AStandArea(105+100, 180, 40, 40);
		notPassed = new AnAlignedMarchingKnightQueue(0, y, width, height);
		havePassed = new AnAlignedMarchingKnightQueue(700+150, y, width, height);
		TheFallen = new AFallenAvatars(200+150, 250, width, height);
	}

	public int getX() {
		return x;

	}

	public void setX(int newVal) {
		x = newVal;
		guard = new AGuardWithChat(x + width, y, width, height, "Guard",
				"Answer pl0x.");
	}

	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		y = newVal;
		guard = new AGuardWithChat(x + width, y, width, height, "Guard",
				"Answer pl0x.");
	}
	

	public void addNotPassed(String aName, String aThought){
		notPassed.addToEnd(aName, aThought);
	}
	
	public void addHavePassed(String aName, String aThought){
		havePassed.addToEnd(aName, aThought);
	}
	
	public void addFallen(int Type, String aName, String aThought){
		TheFallen.addToEnd(Type,aName,aThought);
	}
	public Gorge getGorge() {
		return gorge;
	}

	public Figure getGuard() {
		return null;
	}

	public AGuardWithChat getGuardWithChat() {
		return guard;
	}

	public MarchingKnightQueue getNotPassed() {
		return notPassed;
	}

	public MarchingKnightQueue getHavePassed() {
		return havePassed;
	}
	
	public FallenAvatars getTheFallen(){
		return TheFallen;
	}

	public StandArea getStandingArea() {
		return standingArea;
	}

}
