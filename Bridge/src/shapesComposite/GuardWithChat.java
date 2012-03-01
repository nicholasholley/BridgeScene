package shapesComposite;

import shapesAtomic.Label;
import shapesAtomic.Line;
import shapesAtomic.Oval;
import stacks.Chat;

public interface GuardWithChat {
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);

	public Oval getHead();

	public Line getArmA();

	public Line getArmB();

	public Line getBody();

	public Line getLegA();

	public Line getLegB();

	public Label getName();
	
	public Chat getGuardChat();
	
	public void addLabel(String newLabel);
	
	public void removeLast();
}
