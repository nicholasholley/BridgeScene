package shapesAtomic;

import java.beans.PropertyChangeListener;

public interface Shape {
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);
	
	public void move(int intX, int intY);

	public int getWidth();

	public void setWidth(int newVal);

	public int getHeight();

	public void setHeight(int newHeight);
	
	public void addPropertyChangeListener(PropertyChangeListener listener);
	
	public  void animateSetX(int newX, int steps, int pauseTime);
	
	public void animateSetX(int newX);

}
