package shapesComposite;

import shapesAtomic.ALabel;
import shapesAtomic.ALine;
import shapesAtomic.ARectangle;
import shapesAtomic.ASetXCommand;
import shapesAtomic.AnOval;
import shapesAtomic.Label;
import shapesAtomic.Line;
import shapesAtomic.Oval;
import shapesAtomic.Rectangle;
import stacks.Chat;
import stacks.AlignedMoveableChat;

public abstract class AFigureWithChatAvatar implements FigureWithChat {
	Line armA, armB, legA, legB, body, cudgel;
	Oval ovhead;
	Rectangle rechead;
	Label name;
	String aname, athought, type;
	Chat thought;
	private int x, y, width, height;

	public AFigureWithChatAvatar(int initX, int initY, int initWidth,
			int initHeight, String aName, String aThought, String figType) {
		x = initX;
		y = initY;
		width = initHeight;
		height = initWidth;
		aname = aName;
		athought = aThought;
		type = figType;
		if (type == "Knight") {
			rechead = new ARectangle(x, y, width, height);
			armA = new ALine(x + width / 2, y + height, width, height);
			armB = new ALine(x + width / 2, y + height, width * -1, height);
			body = new ALine(x + width / 2, y + height, width * 0, height * 2);
			legA = new ALine(x + width / 2, y + height * 3, width, height);
			legB = new ALine(x + width / 2, y + height * 3, width * -1, height);
			cudgel = new ALine(x + width * 2 - height / 2, y + width * 2,
					width, height * -1);
			name = new ALabel(x, y - 2 * height / 3, 900, 40, aname);
			thought = new AlignedMoveableChat(x, y - 2 * height / 3, 200, 15, athought);
		}
		if (type == "Guard") {
			ovhead = new AnOval(x, y, width, height);
			armA = new ALine(x + width / 2, y + height, width, height);
			armB = new ALine(x + width / 2, y + height, width * -1, height);
			body = new ALine(x + width / 2, y + height, width * 0, height * 2);
			legA = new ALine(x + width / 2, y + height * 3, width, height);
			legB = new ALine(x + width / 2, y + height * 3, width * -1, height);
			name = new ALabel(x, y - 2 * height / 3, 900, 40, aname);
			thought = new AlignedMoveableChat(x, y - 2 * height / 3, 200, 15, athought);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int newVal) {
		x = newVal;
		if (type == "Knight") {
			rechead.setX(x);
			armA.setX(x + width / 2);
			armB.setX(x + width / 2);
			body.setX(x + width / 2);
			legA.setX(x + width / 2);
			legB.setX(x + width / 2);
			cudgel.setX(x + width * 2 - height / 2);
			name.setX(x);
			thought.setX(x);
		}
		else if (type == "Guard") {
			ovhead.setX(x);
			armA.setX(x + width / 2);
			armB.setX(x + width / 2);
			body.setX(x + width / 2);
			legA.setX(x + width / 2);
			legB.setX(x + width / 2);
			name.setX(x);
			thought.setX(x);

		}
	}
	
	public void animateX(int newX){
		x = newX;
		if (type == "Knight") {
			rechead.animateSetX(x);
			armA.animateSetX(x + width / 2);
			armB.animateSetX(x + width / 2);
			body.animateSetX(x + width / 2);
			legA.animateSetX(x + width / 2);
			legB.animateSetX(x + width / 2);
			cudgel.animateSetX(x + width * 2 - height / 2);
			name.animateSetX(x);
			thought.moveXAnimate(x);
		}
		else if (type == "Guard") {
			ovhead.setX(x);
			armA.animateSetX(x + width / 2);
			armB.animateSetX(x + width / 2);
			body.animateSetX(x + width / 2);
			legA.animateSetX(x + width / 2);
			legB.animateSetX(x + width / 2);
			name.animateSetX(x);
			thought.moveXAnimate(x);

		}
	}
	
	public int getY() {
		return y;
	}

	public void setY(int newVal) {
		y = newVal;
		if (type == "Knight") {
			rechead.setY(y);
			armA.setY(y + height);
			armB.setY(y + height);
			body.setY(y + height);
			legA.setY(y + height * 3);
			legB.setY(y + height * 3);
			cudgel.setY(y + width * 2);
			name.setY(y - 2 * height / 3);
			thought.setY(y - 2 * height / 3);
		}
		if (type == "Guard") {
			ovhead.setY(y);
			armA.setY(y + height);
			armB.setY(y + height);
			body.setY(y + height);
			legA.setY(y + height * 3);
			legB.setY(y + height * 3);
			name.setY(y - 2 * height / 3);
			thought.setY(y - 2 * height / 3);

		}

	}
	
	public Line getArmA() {
		return armA;
	}

	public Line getArmB() {
		return armB;
	}

	public Line getBody() {
		return body;
	}

	public Line getLegA() {
		return legA;
	}

	public Line getLegB() {
		return legB;
	}

	public Line getCudgel() {
		return cudgel;
	}

	public Label getName() {
		return name;
	}
	
	public String getStringName(){
		return aname;
	}

	public int getCudgelXLocation() {
		return x + width * 2 - height / 2;
	}

	public int getCudgelYLocation() {
		return y + width * 2;
	}

	public void addLabel(String newLabel) {
		thought.addLabel(newLabel);
	}

	public void removeLast() {
		thought.removeLast();
	}

	public void move(int intX, int intY) {
		setX(x+intX);
		setY(y+intY);
	}
	public void animateMove(int intX, int intY) {
		animateX(x+intX);
		setY(y+intY);
	}

	public Rectangle getRecHead() {
		return rechead;
	}

	public Oval getOvHead() {
		return ovhead;
	}

	public Chat getChat() {
		return thought;
	}

}
