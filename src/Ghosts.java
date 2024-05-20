/**
 * Ghosts to follow pacman
 */

import java.util.ArrayList;
import java.util.Collections;

public class Ghosts {
		
	private double x, y; // center position
	private double radius;
	private int direction; // direction the ghost is moving in
	
	// Ghost can only switch direction at identified "decision points"
	desiscionPoints points = new desiscionPoints();

	/**
	 * Constructor - Let ghost start on decision point or add a starting direction
	 * @param x start position
	 * @param y start position
	 */
	public Ghosts(int x, int y) {
		this.x = x;
		this.y = y;
		this.radius = 0.4;
	}
	
	/**
	 * Automatic moving of the ghost
	 * 
	 * @param grid
	 */
	public void update(Grid grid) {
		
		// convert x and y to integers because decision points
		// method getPoints() only takes an integer as input 
		int x = (int) this.x;
    	int y = (int) this.y;
    	
    	// check if the ghost is at the decision points
		if (x == this.x && y == this.y && points.getPoint(x, y)) {
			
			// create an array list to add all directions 
			// the ghost theoretically could move from this 
			// decision point
	    	ArrayList<Integer> dir = new ArrayList<Integer>();
	    	
	    	// check if the ghost can move up
	    	// if yes, add the direction to the list except if the ghost
	    	// moved down before to prevent the ghost from moving back and forth
			if (grid.getGrid(x, y + 1)) {
				if (direction != 2) {
					dir.add(1);
				}
			}
			
			// do the same for down, left and right
			if (grid.getGrid(x, y - 1)) {
				if (direction != 1) {
					dir.add(2);
				}
			}
			if (grid.getGrid(x + 1, y)) {
				if (direction != 4) {
					dir.add(3);
				}
			}
			if (grid.getGrid(x - 1, y)) {
				if (direction != 3) {
					dir.add(4);
				}
			}
			
			// randomize the direction
			Collections.shuffle(dir);
			this.direction = dir.remove(0);
		}
    	
		// make the ghost move in its direction
		switch(direction) {
		
			// up
			case 1:
				this.y += 0.125;
				break;
		
			// down
			case 2:
				this.y -= 0.125;
				break;
			
			// right
			case 3:
				magicMove(27, 0);
				this.x += 0.125;
				break;
		
			// left
			case 4:
				magicMove(0, 27);
				this.x -= 0.125;
				break;
				
		}
	}
	
	/**
	 * Check the collision between pacman and the ghost
	 * 
	 * @param p
	 * @return
	 */
	public boolean collidesWith(Pacman p) {

        // Calculate edges of the ghost
        double right = this.x + this.radius;
        double left = this.x - this.radius;
        double top = this.y + this.radius * 2 - 0.2;
        double bottom = this.y - this.radius - 0.2;
        
        // Test if the ghost's RIGHT side is LESS THAN of the pacman's LEFT side
        // This condition puts the ghost  COMPELTELY LEFT of the pacman 
        // If the player is completely left, they can't overlap
        if (p.right() < left) {
            return false;
        }
        
        // Test the same thing for the three other sides
        if (p.left() > right) {
            return false;
        }
        if (p.top() < bottom) {
            return false;
        }
        if (p.bottom() > top) {
            return false;
        }
        
        // If all of the previous tests fail, pacman must be in collision
        // with the ghost
        return true;
    }
	
	/**
	 * Ghost can move off the screen on one side to appear on the other
	 * 
	 * @param oldX
	 * @param newX
	 */
	private void magicMove(int oldX, int newX) {
    	if (x == oldX && y == 16) {
  		  this.x = newX;
    	}	
    }
	
	
	
	/*** Draw this ghost using StdDraw ***/
    public void draw(int red, int green, int blue) {
    	StdDraw.setPenColor(red, green, blue);

    	// Created the ghost with one square and a half circle on top
        StdDraw.filledSquare(this.x, this.y - 0.2, this.radius);
        StdDraw.filledCircle(this.x , this.y + this.radius - 0.2, this.radius);
        
        // set color to black to draw eyes and the something of the bottom of the square
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(this.x + 0.15, this.y - this.radius - 0.2, 0.1);
        StdDraw.filledCircle(this.x - 0.15, this.y - this.radius - 0.2, 0.1);
        StdDraw.filledCircle(this.x + 0.15, this.y + 0.1, 0.1);
        StdDraw.filledCircle(this.x - 0.15, this.y + 0.1, 0.1);
    }
}
