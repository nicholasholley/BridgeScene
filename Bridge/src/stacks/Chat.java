package stacks;

import util.models.VectorListener;

public interface Chat {
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);
	
	public int getHeight();
	
	public int getWidth();
	
	public void removeLast();
	
	public void addLabel(String NewText);
	
	public ATransparentLabelStack getStackA();
	
	public void addVectorListener(VectorListener listener);
	
	public void moveXAnimate(int newX);
}
