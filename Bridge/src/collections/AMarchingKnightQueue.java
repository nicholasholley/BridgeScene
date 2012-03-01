package collections;

import shapesComposite.AKnightWithChat;
import shapesComposite.FigureWithChat;
import stacks.ATransparentChatFigureStack;
import util.models.VectorListener;

public class AMarchingKnightQueue implements MarchingKnightQueue {
	public int x, y, width, height;
	private int numKnights;
	public ATransparentChatFigureStack stackB = new ATransparentChatFigureStack();
	
	public AMarchingKnightQueue(int initX, int initY, int initWidth, int initHeight){
		x = initX;
		y = initY;
		numKnights = 0;
		width = initHeight;
		height = initWidth;
		}
	public int getX() {
		return x;
	}

	public void setX(int newVal) {
		for (int i = 0; i < stackB.size(); i++) {
			stackB.elementAt(i).setX(newVal);
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		for (int i = 0; i < stackB.size(); i++) {
			stackB.elementAt(i).setY(newVal);

		}
	}
	

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
	public int getNumKnights() {
		return numKnights;
	}

	public void removeEarliest() {
		stackB.shiftUp(0);
	}

	public void removeLatest() {
		stackB.pop();
	}

	public void addToEnd(String aName, String aThought) {	
		stackB.push(new AKnightWithChat(x,y,width,height, aName, aThought));
	}

	public void addToFront(String aName, String aThought) {
		stackB.shiftDown(0);
		stackB.begin(new AKnightWithChat(x,y,width,height, aName, aThought));
	}
	
	public void addToFrontDos(FigureWithChat theKnight) {
		stackB.shiftDown(0);
		stackB.begin(theKnight);
	}
	

	public ATransparentChatFigureStack getStackB() {
		return stackB;
		
	}
	public FigureWithChat findFirstKnight(){
		FigureWithChat theKnight = stackB.elementAt(stackB.size()-1);
		return theKnight;
	}
	
	public void addVectorListener(VectorListener listener) {
			
	}
	public void animateSetX(int newX, int steps, int pauseTime) {
		
	}
	public void animatedSetX(int newX) {
		
	}
	
}
