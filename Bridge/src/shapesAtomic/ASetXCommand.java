package shapesAtomic;

public class ASetXCommand implements Runnable{
	
	AShape fig;
	int newX;
	int steps;
	int pauseTime;

	public ASetXCommand(AShape fig, int newX, int steps, int pauseTime){
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