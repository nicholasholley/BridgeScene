package shapesComposite;

import shapesAtomic.Label;
import shapesAtomic.Shape;

public abstract interface Figure {
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);

	public Shape getRecHead();
	
	public Shape getOvHead();

	public Shape getArmA();

	public Shape getArmB();

	public Shape getBody();

	public Shape getLegA();

	public Shape getLegB();

	public Shape getCudgel();

	public Label getName();
	
}
