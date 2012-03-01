package collections;

import java.util.ArrayList;

import shapesComposite.AKnightWithChat;
import shapesComposite.FigureWithChat;
import util.models.VectorChangeEvent;
import util.models.VectorListener;

public class AnAlignedMarchingKnightQueue extends AMarchingKnightQueue {
	int colLoc = 0;
	public AnAlignedMarchingKnightQueue(int initX, int initY, int initWidth, int initHeight){
		super(initX, initY, initWidth, initHeight);
	}
	
	ArrayList<VectorListener> observers = new ArrayList<VectorListener>();

	public void addVectorListener(VectorListener listener) {
		if (!observers.contains(listener)) {
			observers.add(listener);
		}
	}

	void notifyAllListeners(VectorChangeEvent event) {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateVector(event);
		}
	}

	public void setX(int newVal) {
		//x = newVal;
		for (int i = 0; i < stackB.size(); i++) {
			stackB.elementAt(i).setX(x + width*3 * i + newVal);
		}
	}
	public void animatedSetX(int newX) {
		//x = newX;
		for (int i = 0; i < stackB.size(); i++) {
			stackB.elementAt(i).animateX(x + width*3 * i+newX);
		}
	}
	public void setY(int newVal) {
		y = newVal;
		for (int i = 0; i < stackB.size(); i++) {
			stackB.elementAt(i).setY(y);
		}
	}
	
	
	public void addToEnd(String aName, String aThought) {
		AKnightWithChat dude = new AKnightWithChat(colLoc,y,width,height, aName, aThought);
		stackB.push(dude);
		colLoc = colLoc + width*3;
		notifyAllListeners(new VectorChangeEvent(this,
				VectorChangeEvent.AddComponentEvent, stackB.size() - 1, null,
				dude, stackB.size()));
	}

	public void addToFront(String aName, String aThought) {
		colLoc = colLoc - width*3 * stackB.size();
		stackB.shiftDown(0);
		stackB.begin(new AKnightWithChat(colLoc,y,width,height, aName, aThought));
	}
	
	public void addToFrontDos(FigureWithChat theKnight) {
		colLoc = colLoc - width*3 * stackB.size();
		stackB.shiftDown(0);
		stackB.begin(theKnight);
		notifyAllListeners(new VectorChangeEvent(this,
				VectorChangeEvent.AddComponentEvent, stackB.size() - 1, null,
				theKnight, stackB.size()));
	}
	
}
