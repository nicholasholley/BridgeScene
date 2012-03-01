package shapesAtomic;

import java.beans.PropertyChangeListener;

public interface Label  extends Shape{
	
	public void addPropertyChangeListener(PropertyChangeListener listener);
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);
	
	public void move(int intX, int intY);

	public int getWidth();

	public void setWidth(int newVal);

	public int getHeight();

	public void setHeight(int newHeight);

	public String getText();

	public void setText(String newString);

	public String getImageFileName();

	public void setImageFileName(String newVal);
}
