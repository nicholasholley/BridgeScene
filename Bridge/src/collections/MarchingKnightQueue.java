package collections;

import shapesComposite.FigureWithChat;
import stacks.ATransparentChatFigureStack;
import util.models.VectorListener;

public interface MarchingKnightQueue {
	public ATransparentChatFigureStack stackB = new ATransparentChatFigureStack();
	
	public void addVectorListener(VectorListener listener);
	
	public int getX();

	public void setX(int newVal);
	
	public void animatedSetX(int newX);

	public int getY();

	public void setY(int newVal);
	
	public int getHeight();
	
	public int getWidth();
	
	public void removeEarliest();
	
	public void removeLatest();
	
	public void addToEnd(String aName, String aThought);
	
	public void addToFront(String aName, String aThought);
	
	public void addToFrontDos(FigureWithChat theKnight);
	
	public ATransparentChatFigureStack getStackB();

	public int getNumKnights();

	public FigureWithChat findFirstKnight();

	//public String getLastName();

	//public Chat getLastChat();
}
