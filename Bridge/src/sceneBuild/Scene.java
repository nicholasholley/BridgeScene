package sceneBuild;

import shapesComposite.Figure;

public interface Scene {
	public int getX();

	public void setX(int newVal);

	public int getY();

	public void setY(int newVal);

	public Gorge getGorge();

	public Figure getGuard();
	
	public StandArea getStandingArea();

}
