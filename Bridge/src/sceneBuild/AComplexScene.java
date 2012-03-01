package sceneBuild;

public class AComplexScene extends APopulatedScene {

	private boolean turn = true;
	private boolean animate = true;
	private boolean passed = false;
	private boolean guardFail = false;
	private boolean inStandArea = false;
	private boolean notPassedEmpty = false;
	private int answers = 0;
	private int undoMove = 0;
	private int redoMove = 0;
	private int xs = 0;

	public AComplexScene(int initX, int initY, int initWidth, int initHeight) {
		super(initX, initY, initWidth, initHeight);
	}

	public void moveGuard(int intX, int intY) {

		guard.setX(intX);
		guard.setY(y + intY);
	}
	
	public void moveApproaching(int intX, int intY) {
		notPassed.setX(intX);
		notPassed.setY(y + intY);
		if (notPassed.getStackB().elementAt(0).getX() >= 155) {
			inStandArea = true;
		}
	}

	public void moveApproachingX(int intX) {
		xs = intX;
		redoMove = 2*intX;
		undoMove = notPassed.getStackB().elementAt(0).getX();
		xs = xs + intX;
		if(animate){
			if (!notPassedEmpty) {
				notPassed.animatedSetX(intX);
			} else if (notPassedEmpty) {
				havePassed.animatedSetX(intX);
			}}
		else if(!animate){
		if (!notPassedEmpty) {
			notPassed.setX(xs);
		} else if (notPassedEmpty) {
			havePassed.setX(xs);
		}}
		if (notPassed.getStackB().elementAt(0).getX() >= 240
				&& notPassed.getStackB().elementAt(0).getX() <= 290) {
			inStandArea = true;
		}
	}

	public void leadKnightPasses() {
		if ((guardFail || answers >= 3 || passed)) {
			havePassed.addToFrontDos(notPassed.findFirstKnight());
			havePassed.getStackB().elementAt(0).setX(x + 650);
			notPassed.removeLatest();
			answers = 0;
			if (notPassed.getStackB().size() <= 0) {
				notPassedEmpty = true;
			}
		}
	}

	public void leadKnightFails() {
		TheFallen.addToFrontDos(notPassed.findFirstKnight());
		TheFallen.getStackB().elementAt(0).setX(x + 300);
		TheFallen.getStackB().elementAt(0).setY(y + 140);
		notPassed.removeLatest();
		if (notPassed.getStackB().size() <= 0) {
			notPassedEmpty = true;
		}
	}

	public void guardFails() {
		TheFallen.addToFrontDos(guard);
		guard.setX(x + 300);
		guard.setY(y + 140);
	}

	public void leadKnightSpeaks(String spoken) {
		notPassed.findFirstKnight().addLabel(spoken);
	}

	public void guardSpeaks(String spoken) {
		guard.addLabel(spoken);
	}

	public void speak(String spoke) {
		if (turn) {
			guardSpeaks(spoke);
			turn = false;
		} else{ 
			leadKnightSpeaks(spoke);
			answers++;
			turn = true;
		}
	}

	public void fail() {
		if (turn) {
			leadKnightFails();
		} else {
			guardFails();
			guardFail = true;
		}
	}
	
	public void undo(){
		moveApproachingX(undoMove);
	}
	
	public void redo(){
		moveApproachingX(redoMove);
	}

	public void testSetPassed() {
		passed = true;
	}
	
	public void changeAnimate(){
		if(animate){
			animate = false;
		}
		else if(!animate){
			animate = true;
		}
	}

}
