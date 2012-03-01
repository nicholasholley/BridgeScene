package stacks;

public class AlignedMoveableChat extends MoveableChat {
	public AlignedMoveableChat(int initX, int initY, int initWidth, int initHeight,
			String initText){
		super(initX, initY, initWidth, initHeight,
			initText);
		
	}
	public void addLabel(String newText) {
		newtext = newText;
		y =  Yposition.tellYPos();
		move = new MoveableLabel(x, y, width, height, newtext);
		stackA.push(move);
	}
	
}
