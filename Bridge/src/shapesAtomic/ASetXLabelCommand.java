package shapesAtomic;

public class ASetXLabelCommand implements Runnable{
	
	ALabel fig;
	int newX;
	int steps;
	int pauseTime;

	public ASetXLabelCommand(ALabel fig, int newX, int steps, int pauseTime){
		this.fig=fig;
		this.newX=newX;
		this.steps=steps;
		this.pauseTime=pauseTime;
	}
	
	public void run() {
		/// One line which calls the correct animation method on line.
		fig.animateSetX(newX, steps, pauseTime);
	}

}