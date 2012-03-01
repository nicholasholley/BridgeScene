package shapesAtomic;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import collections.ASetXCommand;


public class ALabel implements Label {
	int x, y, width, height;
	String text, imageFile;
	ArrayList<PropertyChangeListener> observers = new ArrayList<PropertyChangeListener>();
	
	public ALabel(int initX, int initY, int initWidth, int initHeight,
			String initText/*, String theImageFile*/) {
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
		text = initText;
		//imageFile = theImageFile;
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (!observers.contains(listener)) {
			observers.add(listener);
		}
	}

	void notifyAllListeners(PropertyChangeEvent event) {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).propertyChange(event);
		}
	}


	public int getWidth() {
		return width;
	}

	public void setWidth(int newVal) {
		width = newVal;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int newHeight) {
		height = newHeight;
	}

	public String getText() {
		return text;
	}

	public void setText(String newVal) {
		text = newVal;
	}

	public String getImageFileName() {
		return imageFile;
	}

	public void setImageFileName(String newVal) {
		imageFile = newVal;
	}

	public int getX() {
		return x;
	}

	public void setX(int newVal) {
		int oldVal = x;
		x = newVal;	
		notifyAllListeners(new PropertyChangeEvent(this, "x", oldVal, newVal));
	}

	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		int oldVal = y;
		y = newVal;
		notifyAllListeners(new PropertyChangeEvent(this, "y", oldVal, newVal));
	}

	public void move(int intX, int intY) {
		setX(intX);
		setY(intY);	}
	public void animateSetX(int newX){
		//Create a new ASetXCommand instance and a new thread then start the thread.
		Runnable xComm = new ASetXLabelCommand(this, newX, 60, 20);
		Thread thread = new Thread(xComm);
		thread.setName("XComm");
		thread.start();
	}
	
	public synchronized void animateSetX(int newX, int steps, int pauseTime){
		//get the old value and then create a loop which goes through "steps" steps
		// calculate a current x value, calling this.setX on the new current value 
		// then call sleep.
		int oldVal = getX();
		int amount = (newX - oldVal)/steps;
		for(int i = 1; i <=steps; i++){
			this.setX(oldVal + amount * i);
			sleep(pauseTime);
		}
	}
	public void sleep(int pauseTime) {
		try {
			// OS suspends program for pauseTime
			Thread.sleep(pauseTime);
		} catch (InterruptedException e) {
			// program may be forcibly interrupted while sleeping
			e.printStackTrace();
		}
	}
}
