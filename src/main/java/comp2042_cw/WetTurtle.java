package comp2042_cw;

import javafx.scene.image.Image;

/**
 * This is the Wet Turtle class where it will create wet turtles for Frogger to step over in the game.
 * There is a slight different with its not-wet counterpart, the wet turtles will dive into water from time to time where Frogger won't able to step on it at that status.
 */
public class WetTurtle extends Actor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private Image turtle4;
	final private int speed;
	private boolean sunk = false;
	@Override
	public void act(long now) {

		updateWetTurtleStatus(now);

		move(speed , 0);

		resetWetTurtleLocation();
	}

	/**
	 * This is the Wet Turtle class constructor.
	 * @param xpos Wet Turtle X-position
	 * @param ypos Wet Turtle Y-position
	 * @param s Speed of Wet Turtle
	 * @param w Width of Wet Turtle
	 * @param h Height of Wet Turtle
	 */
	public WetTurtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/main/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/main/resources/TurtleAnimation2Wet.png", w, h, true, true);
		turtle3 = new Image("file:src/main/resources/TurtleAnimation3Wet.png", w, h, true, true);
		turtle4 = new Image("file:src/main/resources/TurtleAnimation4Wet.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	//---------------------------------------------------------Methods----------------------------------------------------------------------

	/**
	 * This method will reset the wet turtle location if it reach the end of the game window.
	 */
	private void resetWetTurtleLocation() {
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}

	/**
	 * 	This method changes the image of the turtle to create an animation of turtle is moving, and changes the status of the wet turtle(surface/sunk).
	 * @param now	This parameter determines the current game time.
	 */
	private void updateWetTurtleStatus(long now) {
		if (now /900000000  % 4 ==0) {
			setImage(turtle2);
			sunk = false;
		}
		else if (now /900000000 % 4 == 1) {
			setImage(turtle1);
			sunk = false;
		}
		else if (now /900000000 %4 == 2) {
			setImage(turtle3);
			sunk = false;
		} else if (now /900000000 %4 == 3) {
			setImage(turtle4);
			sunk = true;
		}
	}

	//return the sunk status of the wet turtle.
	public boolean isSunk() {
		return sunk;
	}
	//--------------------------------------------------------/Methods----------------------------------------------------------------------



}
