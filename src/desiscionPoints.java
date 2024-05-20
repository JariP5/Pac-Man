
public class desiscionPoints {
	private boolean[][] boolGrid = new boolean[28][31];

	public desiscionPoints() {
		setPoints();
	}
	
	private void setPoints() {
		// row 1
		boolGrid[1][1] = true;
		boolGrid[12][1] = true;
		boolGrid[15][1] = true;
		boolGrid[26][1] = true;
		
		// row 4, 10, 22, 25 and 29
		int[] a = {4, 10, 22, 25, 29};
		for (int i : a) {
			boolGrid[1][i] = true;
			boolGrid[6][i] = true;
			boolGrid[9][i] = true;
			boolGrid[12][i] = true;
			boolGrid[15][i] = true;
			boolGrid[18][i] = true;
			boolGrid[21][i] = true;
			boolGrid[26][i] = true;
		}
		
		// row 4
		boolGrid[3][4] = true;
		boolGrid[24][4] = true;
		
		// row 29
		boolGrid[9][29] = false;
		boolGrid[18][29] = false;
		
		// middle row
		boolGrid[6][16] = true;
		boolGrid[9][16] = true;
		boolGrid[18][16] = true;
		boolGrid[21][16] = true;
		
		// row 13
		boolGrid[9][13] = true;
		boolGrid[18][13] = true;

		// row 19
		boolGrid[9][19] = true;
		boolGrid[12][19] = true;
		boolGrid[15][19] = true;
		boolGrid[18][19] = true;
		
		// row 7
		boolGrid[1][7] = true;
		boolGrid[3][7] = true;
		boolGrid[6][7] = true;
		boolGrid[9][7] = true;
		boolGrid[12][7] = true;
		boolGrid[15][7] = true;
		boolGrid[18][7] = true;
		boolGrid[21][7] = true;
		boolGrid[24][7] = true;
		boolGrid[26][7] = true;
		
	}
	
	public boolean getPoint(int x, int y) {
		if (boolGrid[x][y]) {
			return true;
		}
		return false;
	}
	
	public void testPoints() {
		for(int row = 0; row < boolGrid.length; row++) {
	    	for (int col = 0; col < boolGrid[row].length; col++) {
	    		if (boolGrid[row][col]) {
	    			StdDraw.setPenColor(255, 0, 0);
	    			StdDraw.circle(row, col, 0.7);
	    		}
	    	}
	    }
	}
}
