package shapesComposite;

import shapesAtomic.Label;
import shapesAtomic.Line;
import shapesAtomic.Rectangle;

public interface Knight {
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);

	public Rectangle getHead();

	public Line getArmA();

	public Line getArmB();

	public Line getBody();

	public Line getLegA();

	public Line getLegB();

	public Line getCudgel();

	public Label getName();
	
	public int getCudgelXLocation();
	
	public int getCudgelYLocation();
}
