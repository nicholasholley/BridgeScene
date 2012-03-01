package shapesComposite;

import shapesAtomic.Label;
import shapesAtomic.Line;
import shapesAtomic.Oval;
import shapesAtomic.Rectangle;
import stacks.Chat;

public abstract interface FigureWithChat {
	public int getX();

	public void setX(int newVal);
	
	public void animateX(int newX);
	
	public int getY();

	public void setY(int newVal);

	public Rectangle getRecHead();
	
	public Oval getOvHead();

	public Line getArmA();

	public Line getArmB();

	public Line getBody();

	public Line getLegA();

	public Line getLegB();

	public Line getCudgel();

	public Label getName();
		
	public Chat getChat();
	
	public void addLabel(String newLabel);
	
	public void removeLast();

	public void move(int i, int y);
	public void animateMove(int intX, int intY);

	public String getStringName();

}
