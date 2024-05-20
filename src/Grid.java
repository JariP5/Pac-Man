/**
 * Create a boolean 2D - Array to draw the pacman field
 * Set all fields were pacman is allowed to move to true and all other ones to false
 * 
 * @author Jari Polm
 *
 */


public class Grid {
	
	private boolean[][] boolGrid = new boolean[28][31];
	
	/**
	 * Constructor
	 */
	public Grid() {
		setStartingBooleans();
	}
	
	
	/*
	 * Set necessary true values
	 */
	private void setStartingBooleans() {
		// row 1 and row 25
		for (int i = 1; i < 27; i++) {
			boolGrid[i][1] = true;
			boolGrid[i][25] = true;
		}
		
		// row 29 and row 10
		for (int i = 1; i < 13; i++) {
			boolGrid[i][29] = true;
			boolGrid[i + 14][29] = true;
			boolGrid[i][10] = true;
			boolGrid[i + 14][10] = true;
		}
		
		// middle row
		for (int i = 0; i < 10; i++) {
			boolGrid[i][16] = true;
			boolGrid[i + 18][16] = true;
		}
		
		// row 7
		for (int i = 1; i < 27; i++) {
			if (i != 4 && i != 5 && i != 22 && i != 23) {
				boolGrid[i][7] = true;
			}
		}
		
		// row 28 and row 27 and row 26
		for (int i = 26; i < 29; i++) {
			boolGrid[1][i] = true;
			boolGrid[6][i] = true;
			boolGrid[12][i] = true;
			boolGrid[15][i] = true;
			boolGrid[21][i] = true;
			boolGrid[26][i] = true;
		}
		
		// row 24 and row 23
		for (int i = 23; i < 25; i++) {
			boolGrid[1][i] = true;
			boolGrid[6][i] = true;
			boolGrid[9][i] = true;
			boolGrid[18][i] = true;
			boolGrid[21][i] = true;
			boolGrid[26][i] = true;
		}
		
		
		// row 22 and row 4
		for (int i = 1; i < 7; i++) {
			boolGrid[i][22] = true;
			boolGrid[i + 20][22] = true;
			boolGrid[i][4] = true;
			boolGrid[i + 20][4] = true;
		}
		for (int i = 1; i < 5; i++) {
			boolGrid[i + 8][22] = true;
			boolGrid[i + 14][22] = true;
			boolGrid[i + 8][4] = true;
			boolGrid[i + 14][4] = true;
		}
		
		// row 8 and row 9 
		for (int i = 8; i < 10; i++) {
			boolGrid[1][i] = true;
			boolGrid[6][i] = true;
			boolGrid[12][i] = true;
			boolGrid[15][i] = true;
			boolGrid[21][i] = true;
			boolGrid[26][i] = true;
		}
		
		// row 20 and row 21
		for (int i = 20; i < 22; i ++) {
			boolGrid[12][i] = true;
			boolGrid[15][i] = true;
		}
		
		
		// row 2 and row 3 
		for (int i = 2; i < 4; i++) {
			boolGrid[1][i] = true;
			boolGrid[12][i] = true;
			boolGrid[15][i] = true;
			boolGrid[26][i] = true;
		}
		
		// row 5 and row 6
		for (int i = 5; i < 7; i++) {
			boolGrid[3][i] = true;
			boolGrid[9][i] = true;
			boolGrid[18][i] = true;
			boolGrid[24][i] = true;
		}
		
		// filling columns
		for (int i = 4; i < 22; i++) {
			boolGrid[6][i] = true;
			boolGrid[21][i] = true;
		}
		
		for (int i = 11; i < 20; i++) {
			boolGrid[9][i] = true;
			boolGrid[18][i] = true;
		}
		
		for (int i = 9; i < 18; i++) {
			boolGrid[i][13] = true;
			boolGrid[i][19] = true;
		}
		
		
		
	}
	
	/**
	 * Update the boolean Grid used to represent the pacman food
	 */
	public void drawPacmanFood() {
		
		// Set Pen Color to Yellow
		StdDraw.setPenColor(StdDraw.YELLOW);

		// set pacman food to all fields which are set to true
		for (int x = 0; x < boolGrid.length; x++) {
		  for (int y = 0; y < boolGrid[x].length; y++) {
			  if (boolGrid[x][y]) {
				  StdDraw.filledCircle(x, y, 0.2);
			  }
		  }
		}	
	}
	
	/**
	 * Check if all fields are set to false
	 * @return boolean
	 */
	public boolean areAllFalse()
	{
	    for(int row = 0; row < boolGrid.length; row++) {
	    	for (int col = 0; col < boolGrid[row].length; col++) {
	    		if (boolGrid[row][col]) {
	    			return false;
	    		}
	    	}
	    }
	    return true;
	}
	
	/**
	 * Set a field to false
	 * 
	 * @param row
	 * @param column
	 */
	public void setGrid(int row, int column) {
		boolGrid[row][column] = false;
	}
	
	/**
	 * return the boolean value of a certain field
	 * 
	 * @param row
	 * @param column
	 * @return boolean
	 */
	public boolean getGrid(int row, int column) {
		return boolGrid[row][column];
	}
}

