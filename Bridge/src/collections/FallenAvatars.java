package collections;

import shapesComposite.FigureWithChat;
import stacks.ATransparentChatFigureStack;
import util.models.VectorListener;

public interface FallenAvatars {
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);
	
	public int getHeight();
	
	public int getWidth();
	
	public void removeLatest();
	
	public void addToEnd(int type, String aName, String aThought);
	
	public ATransparentChatFigureStack getStackB();

	public void addToFrontDos(FigureWithChat TheKnight);
	
	public void addVectorListener(VectorListener listener);
}