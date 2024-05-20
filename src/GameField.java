/*
 * Design of the Field including rectangels and boundaries 
 */

public class GameField {
	static int pxSize = 12;
	
	
	public void draw() {
		
		setBoundaries(0); // left side
		setBoundaries(27); // right side
		
		setRectangels(0); // left side
		setRectangels(27); // right side
	}
	
	/**
	 * Set the outer boundaries
	 * 
	 * @param x
	 */
	private void setBoundaries(int x) {
		
		StdDraw.setScale(0,30);
		
		// Set Pen
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.setPenRadius(0.01);
		
		// Vertical
		StdDraw.line(x, 30, x, 21);
		StdDraw.line(x, 21, Math.abs(x - 5), 21);
		StdDraw.line(Math.abs(x - 5), 21, Math.abs(x - 5), 17);
		StdDraw.line(Math.abs(x - 5), 17, x, 17);
		StdDraw.line(x, 15, Math.abs(x - 5), 15);
		StdDraw.line(Math.abs(x - 5), 15, Math.abs(x - 5), 11);
		StdDraw.line(Math.abs(x - 5), 11, x, 11);
		StdDraw.line(x, 11, x, 6);
		StdDraw.line(x, 6, Math.abs(x - 2), 6);
		StdDraw.line(Math.abs(x - 2), 6, Math.abs(x - 2), 5);
		StdDraw.line(Math.abs(x - 2), 5, x, 5);
		StdDraw.line(x, 5, x, 0);
		
		// Horizontal Top
		StdDraw.line(x, 30, Math.abs(x-13), 30);
		StdDraw.line(Math.abs(x-13), 30, Math.abs(x-13), 26);
		StdDraw.line(Math.abs(x-13), 26, Math.abs(x-14), 26);
		
		// Horizontal Bottom
		StdDraw.line(0,0,27,0);
	}
	
	/**
	 * Set the inner ractangels
	 * @param x
	 */
	private void setRectangels(int x) {
		StdDraw.setPenColor(StdDraw.BLUE);
		
		// above cage rectangles
		StdDraw.filledRectangle(Math.abs(x - 3.5), 27, 1.5, 1);
		StdDraw.filledRectangle(Math.abs(x - 3.5), 23.5, 1.5, 0.5);
		StdDraw.filledRectangle(Math.abs(x - 9), 27, 2, 1);
		StdDraw.filledRectangle(Math.abs(x - 7.5), 20.5, 0.5, 3.5);
		
		StdDraw.filledRectangle(Math.abs(x - 9.5), 20.5, 1.5, 0.5);

		StdDraw.filledRectangle(Math.abs(x - 12), 23.5, 2, 0.5);
		StdDraw.filledRectangle(13.5, 21.5, 0.5, 1.5);
		
		// below cage rectangles
		StdDraw.filledRectangle(Math.abs(x - 7.5), 13, 0.5, 2);
		
		StdDraw.filledRectangle(Math.abs(x - 12), 11.5, 2, 0.5);
		StdDraw.filledRectangle(13.5, 9.5, 0.5, 1.5);
		
		StdDraw.filledRectangle(Math.abs(x - 12), 5.5, 2, 0.5);
		StdDraw.filledRectangle(13.5, 3.5, 0.5, 1.5);
		
		StdDraw.filledRectangle(Math.abs(x - 3.5), 8.5, 1.5, 0.5);
		StdDraw.filledRectangle(Math.abs(x - 4.5), 7, 0.5, 2);
		
		StdDraw.filledRectangle(Math.abs(x - 9), 8.5, 2, 0.5);
		
		StdDraw.filledRectangle(Math.abs(x - 6.5), 2.5, 4.5, 0.5);
		StdDraw.filledRectangle(Math.abs(x - 7.5), 4.5, 0.5, 1.5);
		
		// cage
		StdDraw.rectangle(13.5, 16, 3.5, 2);
		StdDraw.setPenColor(150, 0, 0);
		StdDraw.line(12.5, 18, 14.5, 18);
	}
	
}
