/**
 * Pacman Game (a little bit different than the original version)
 * missing features: 
 * - able to eat ghosts
 * - ghosts do not have different behaviors instead move randomly -> increase amount of ghosts
 * 
 * @author Jari Polm
 *
 */
public class Play {
	
	/**
	 * main Game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// boolean 2D - Array to represent where "pacman food" is left
		Grid foodGrid = new Grid();
		// boolean 2D - Array representing where ghosts and pacman are allowed to move
		Grid playGrid = new Grid();
		
		// drawing of the boarders and rectangels on the field
		GameField field = new GameField();
		
		// Pacman moved by the user
		Pacman pacman = new Pacman();
		
		// 7 ghosts moving randomly through the field
		Ghosts Pinky = new Ghosts(1, 29);
		Ghosts Inky = new Ghosts(1, 1);
		Ghosts Blinky = new Ghosts(26, 1);
		Ghosts Clyde = new Ghosts(26, 29);
		Ghosts Extra1 = new Ghosts(21, 16);
		Ghosts Extra2 = new Ghosts(9, 16);
		Ghosts Extra3 = new Ghosts(9, 16);
		
		//desiscionPoints points = new desiscionPoints();
		
		// Countdown to start the game
		Countdown countdown = new Countdown();
		
		// setting the color for the countdown to red
		StdDraw.setPenColor(255, 0, 0);
		
		// counting down from 3
		for (int i = 3; i > 0; i--) {
			StdDraw.clear(StdDraw.BLACK); // background to black
			countdown.countdown(i); // show number i in red
			StdDraw.show(1000); // show each number for 1 second 
		}
		
		
		// main game loop
		while (true) {
			
			// background of the field to black
			StdDraw.clear(StdDraw.BLACK);
			
			// update pacman according to the users movement 
			pacman.update(playGrid);
			
			// check if pacman can "eat" the food if one was available at its position
			pacman.checkFood(foodGrid);
			
			// move the ghosts
			Pinky.update(playGrid);
			Inky.update(playGrid);
			Blinky.update(playGrid);
			Clyde.update(playGrid);
			Extra1.update(playGrid);
			Extra2.update(playGrid);
			Extra3.update(playGrid);
			
			// end the game if pacman and any ghost collide
			if (Pinky.collidesWith(pacman) || Inky.collidesWith(pacman) || 
				Blinky.collidesWith(pacman) || Clyde.collidesWith(pacman) || 
				Extra1.collidesWith(pacman) || Extra2.collidesWith(pacman) ||
				Extra3.collidesWith(pacman)) {
				
				// show message when game ends
				StdDraw.setPenColor(255, 0, 0);
				StdDraw.text(15, 15, "Better Luck Next Time!");
				StdDraw.show(20);
				break;
			}
			
			// check if pacman won and ate all the food
			if (foodGrid.areAllFalse()) {
				
				// show message at the end of the game
				StdDraw.setPenColor(0, 255, 0);
				StdDraw.text(15, 15, "Congratulations, you won!");
				StdDraw.show(20);
				break;
			}
			
			// draw the updated field, food, ghosts and pacman
			field.draw();
			foodGrid.drawPacmanFood();
			pacman.draw();
			// ghost's colors can bet using the RGB system
			Pinky.draw(255, 0, 0);
			Inky.draw(0, 255, 0);
			Blinky.draw(0, 0, 255);
			Clyde.draw(200, 50, 130);
			Extra1.draw(0, 250, 255);
			Extra2.draw(60, 150, 130);
			Extra3.draw(90, 40, 220);
			
			// test if all decision Points for ghost are correctly added
			// points.testPoints();
			
			// show the new field for 20ms
			StdDraw.show(20);
		}
		
		
		System.out.print("Finished");
	}
}
