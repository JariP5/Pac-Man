import java.awt.event.KeyEvent;

public class Pacman {

	private double x, y;  // Center position 
    private double radius;  // Size
    private int direction;	// 1 is up, 2 is down, 3 is right and 4 is left
    
    private int counterSwitch; // used for pacman moving its mouth
    
    /*** Constructor ***/
    public Pacman() {
      this.x = 15;
      this.y = 13;
      this.radius = 0.6;
    }
    
    /*** Move Pacman ***/
    public void update(Grid grid) {
    	    	
    	// use integers to make sure that pacman only changes direction
    	// or stops moving when it is an integer position for x and y
    	int x = (int) this.x;
    	int y = (int) this.y;
      	
    	// move up
    	if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
    		if (x == this.x && y == this.y && grid.getGrid(x, y + 1)) {
    			this.y += 0.125; 
    			direction = 1;
    			return;
    		}   
    	}
      
    	// move down
    	else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
    		if (x == this.x && y == this.y && grid.getGrid(x, y - 1)) {
    			this.y -= 0.125; 
    			direction = 2;
    			return;
    		}    
    	}
      
    	// move right
    	else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
    		if (magicMove(27, 0)) {
      		  return;
    		}
  
    		if (x == this.x && y == this.y && grid.getGrid(x + 1, y)) {
    			this.x += 0.125; 
    			direction = 3;
    			return;
      	  } 
      }
      
      // move left
      else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
    	 if (magicMove(0, 27)) {
    		  return;
    	 }
    	 
    	 if (x == this.x && y == this.y && grid.getGrid(x - 1, y)) {
    		 this.x -= 0.125; 
    		 direction = 4;
    		  
  			return;
    	  }   
      }
      
      // keep going in the direction it is moving if the next field is
      // available for pacman
      switch(direction) {
      	
      	case 1:
      		automaticMoving(grid, 0, 1); 
      		break;
	 		
		case 2:
			automaticMoving(grid, 0, -1);
			break;
			
		case 3:
			if (magicMove(27, 0)) {
				return;
			}
			automaticMoving(grid, 1, 0); 
			break;
			
		case 4:
			if (magicMove(0, 27)) {
				return;
			}
			automaticMoving(grid, -1, 0);
			break;
			
		default:
			break;
		}     
    }
  
    /**
     * Once the user has started the direction pacman moves automatically
     * until the user changes the direction or a wall appears
     * 
     * @param grid
     * @param n
     * @param m
     */
    private void automaticMoving(Grid grid, int n, int m) {
    	
    	int x = (int) this.x;
    	int y = (int) this.y;
    	
		if(x == this.x && y == this.y) {
			if(grid.getGrid(x + n, y + m)) {
				
				// change y or x accordingly to its direction
				this.y += 0.125 * m; 
				this.x += 0.125 * n;
			}
			else {
				direction = 0;
			}
			return;
		}
		
		// change y or x accordingly to its direction
		this.y += 0.125 * m;
		this.x += 0.125 * n;
    }
    
    /**
     * Let pacman switch sides when it moves off screen
     * 
     * @param oldX
     * @param newX
     */
    private boolean magicMove(int oldX, int newX) {
    	if (x == oldX && y == 16) {
  		  this.x = newX;
  		  return true;
    	}		
    	return false;
    }
    
    /**
     * Check if pacman is crossing food to let it disappear
     * @param grid
     */
    public void checkFood(Grid grid) {
    	
    	int x = (int) this.x;
    	int y = (int) this.y;
    	
    	if (x == this.x && y == this.y && grid.getGrid(x, y)) {
    		grid.setGrid(x, y);
    	}
    }
    
    /*
     * Position from pacman for Collision testing
     */
    public double right() {
        return this.x + this.radius;
    }
    public double left() {
        return this.x - this.radius;
    }
    public double bottom() {
        return this.y - this.radius;
    }
    public double top() {
        return this.y + this.radius;
    }
    
    /*** Draw Pacman using StdDraw ***/
    public void draw() {
    	
    	// draw pacman
        StdDraw.filledCircle(this.x, this.y, this.radius);

        // create pacmans mouth with a black triangle
        // let the mouth close every second time pacman is drawn
        
        StdDraw.setPenColor(StdDraw.BLACK);

        // open mouth if counterSwitch is set to 1
        // dont draw a mout if counter switch is set to -1 
        if (counterSwitch == 1) {
        	
        	counterSwitch = -1;
        	
        	// adapt the direction of the mouth to the direction of pacman
        	switch(direction) {
            
            case 1:
            	// create a triangle
            	double[] xc1 = {this.x,this.x + 0.4, this.x - 0.4};
                double[] yc1 = {this.y + 0.1, this.y + this.radius, this.y + this.radius};
                StdDraw.filledPolygon(xc1 ,yc1);  
                break;
            case 2:
            	double[] xc2 = {this.x,this.x + 0.4, this.x - 0.4};
                double[] yc2 = {this.y - 0.1, this.y - this.radius, this.y - this.radius};
                StdDraw.filledPolygon(xc2, yc2);
            	break;
            case 3:
            	double[] xc3 = {this.x + 0.1,this.x + this.radius, this.x + this.radius};
                double[] yc3 = {this.y, this.y + 0.4, this.y - 0.4};
                StdDraw.filledPolygon(xc3,yc3);  
                break;
            
            case 4:
            	double[] xc4 = {this.x - 0.1,this.x - this.radius, this.x - this.radius};
                double[] yc4 = {this.y, this.y + 0.4, this.y - 0.4};
                StdDraw.filledPolygon(xc4 ,yc4); 
                break;
            }
            
        }
        else {
        	counterSwitch = 1;
        }
        
         
    }
}
