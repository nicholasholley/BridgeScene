package shapesComposite;

import shapesAtomic.ALabel;
import shapesAtomic.ALine;
import shapesAtomic.ARectangle;
import shapesAtomic.AnOval;
import shapesAtomic.Label;
import shapesAtomic.Shape;

public abstract class AFigure implements Figure {
	Shape armA, armB, legA, legB, body, cudgel, rechead, ovhead;
	Label name;
	String type;
	private int x, y, width, height;

	public AFigure(int initX, int initY, int initWidth, int initHeight,
			String figType) {
		x = initX;
		y = initY;
		width = initHeight;
		height = initWidth;
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
			name = new ALabel(x, y - 2 * height / 3, 900, 40, "Sir Knight");
		}
		if (type == "Guard") {
			ovhead = new AnOval(x, y, width, height);
			armA = new ALine(x + width / 2, y + height, width, height);
			armB = new ALine(x + width / 2, y + height, width * -1, height);
			body = new ALine(x + width / 2, y + height, width * 0, height * 2);
			legA = new ALine(x + width / 2, y + height * 3, width, height);
			legB = new ALine(x + width / 2, y + height * 3, width * -1, height);

			name = new ALabel(x, y - 2 * height / 3, 900, 40, "Guard");
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
		}
		if (type == "Guard") {
			ovhead.setX(x);
			armA.setX(x + width / 2);
			armB.setX(x + width / 2);
			body.setX(x + width / 2);
			legA.setX(x + width / 2);
			legB.setX(x + width / 2);
			name.setX(x);
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
		}
		if (type == "Guard") {
			ovhead.setY(x);
			armA.setY(y + height);
			armB.setY(y + height);
			body.setY(y + height);
			legA.setY(y + height * 3);
			legB.setY(y + height * 3);
			name.setY(y - 2 * height / 3);
		}
	}

	public Shape getArmA() {
		return armA;
	}

	public Shape getArmB() {
		return armB;
	}

	public Shape getBody() {
		return body;
	}

	public Shape getLegA() {
		return legA;
	}

	public Shape getLegB() {
		return legB;
	}

	public Shape getCudgel() {
		return cudgel;
	}

	public Label getName() {
		return name;
	}

	public Shape getRecHead() {
		return rechead;
	}

	public Shape getOvHead() {
		return ovhead;
	}

}
