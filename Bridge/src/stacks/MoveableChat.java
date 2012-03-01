package stacks;

import shapesAtomic.Label;
import stacks.ATransparentLabelStack;
import util.models.VectorListener;


public class MoveableChat implements Chat {
	int x, y, width, height;
	String text, newtext;
	Label one, move, two;
	public ATransparentLabelStack stackA = new ATransparentLabelStack();

	public MoveableChat(int initX, int initY, int initWidth, int initHeight,
			String initText) {
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
		text = initText;
		one = new MoveableLabel(x, y, 200, 15, text);
		stackA.push(one);
	}

	public int getX() {
		return x;
	}

	public void setX(int newVal) {
		x = newVal;
		for (int i = 0; i < stackA.size(); i++) {
			stackA.elementAt(i).setX(x);

		}
	}

	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		y = newVal;
		for (int i = 0; i < stackA.size(); i++) {
			stackA.elementAt(i).setY(y - 15 * i);
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void removeLast() {
		stackA.pop();
	}

	public void addLabel(String newText) {
		newtext = newText;
		move = new MoveableLabel(x, y, width, height, newtext);
		stackA.push(move);
	}

	public ATransparentLabelStack getStackA() {
		return stackA;
	}

	
	public void addVectorListener(VectorListener listener) {
		
	}

	public void moveXAnimate(int newX) {
		x = newX;
		for (int i = 0; i < stackA.size(); i++) {
			stackA.elementAt(i).animateSetX(x);

		}		
	}

}
