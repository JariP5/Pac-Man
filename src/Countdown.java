/**
 * A countdown before the game starts
 */
public class Countdown {
	
	/**
	 * Constructor
	 */
	public Countdown() {
		StdDraw.setScale(0, 30);
	}
	
	/**
	 * Countdown
	 * @param i index variable to show where the countdown starts
	 */
	public void countdown(int i) {
		if (i == 1) {
			one();
		}
		else if(i == 2) {
			two();
		}
		else if (i == 3) {
			three();
		}
	}
	
	/*
	 * Create the number three
	 */
	private void three() {
		horizontal(27);
		vertical(21, 22);
		horizontal(16);
		vertical(21, 10);
		horizontal(5);
		
	}
	
	/**
	 * Create the number two
	 */
	private void two() {
		horizontal(27);
		vertical(21, 22);
		horizontal(16);
		vertical(7, 10);
		horizontal(5);
	}
	
	/**
	 * Create the number one
	 */
	private void one() {
		vertical(21, 22);
		vertical(21, 10);
	}
	
	/**
	 * All horizontals used to create a number 
	 * @param y
	 */
	private void horizontal(int y) {
		StdDraw.filledRectangle(14, y, 8, 1);
	}
	
	/**
	 * All verticals used to create number
	 * @param x
	 * @param y
	 */
	private void vertical(int x, int y) {
		StdDraw.filledRectangle(x, y, 1, 6);
	}
}
