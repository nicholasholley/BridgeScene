package sceneBuild;

import shapesAtomic.ALine;
import shapesAtomic.ARectangle;



public class AGorge implements Gorge {

	Object leftSide, rightSide, threeDeeBridge, threeDeeA, threeDeeB, threeDeeC,
			threeDeeD, threeDeeE, threeDeeF, threeDeeG, bridge;
	
	public AGorge() {
		leftSide = new ALine(200+150, 0, 0, 400);
		rightSide = new ALine(600+150, 0, 0, 400);
		bridge = new ARectangle(200+150, 180, 400, 40);
		threeDeeBridge = new ALine(200+150, 215, 400, 0);
		threeDeeA = new ALine(350+150, 0, 0, 180);
		threeDeeB = new ALine(350+150, 220, 0, 50);
		threeDeeC = new ALine(450+150, 0, 0, 180);
		threeDeeD = new ALine(450+150, 220, 0, 50);
		threeDeeE = new ALine(450+150, 270, 150, 130);
		threeDeeF = new ALine(350+150, 270, -150, 130);
		threeDeeG = new ALine(350+150, 270, 100, 0);
	}

	public Object getLeftSide() {
		return leftSide;
	}

	public Object getRightSide() {
		return rightSide;
	}

	public Object getBridge() {
		return bridge;
	}

	public Object getThreeDeeA() {
		return threeDeeA;
	}

	public Object getThreeDeeB() {
		return threeDeeB;
	}

	public Object getThreeDeeC() {
		return threeDeeC;
	}

	public Object getThreeDeeD() {
		return threeDeeD;
	}

	public Object getThreeDeeE() {
		return threeDeeE;
	}

	public Object getThreeDeeF() {
		return threeDeeF;
	}

	public Object getThreeDeeBridge() {
		return threeDeeBridge;
	}

	public Object getThreeDeeG() {
		return threeDeeG;
	}

}
