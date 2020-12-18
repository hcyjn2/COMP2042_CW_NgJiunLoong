package comp2042_cw;

import javafx.scene.image.Image;

/**
 * This is the Turtle class where it will create turtles for Frogger to step over in the game.
 */
public class Turtle extends Actor{
	private Image turtle1;
	private Image turtle2;
	private Image turtle3;
	private int speed;

	@Override
	public void act(long now) {

		updateTurtleImage(now);

		move(speed , 0);

		resetTurtleLocation();
	}

	/**
	 * This is the Turtle class constructor.
	 * @param xpos Turtle X-position
	 * @param ypos Turtle Y-position
	 * @param s Speed of the turtle
	 * @param w Width of the turtle
	 * @param h Height of the turtle
	 */
	public Turtle(int xpos, int ypos, int s, int w, int h) {
		turtle1 = new Image("file:src/main/resources/TurtleAnimation1.png", w, h, true, true);
		turtle2 = new Image("file:src/main/resources/TurtleAnimation2.png", w, h, true, true);
		turtle3 = new Image("file:src/main/resources/TurtleAnimation3.png", w, h, true, true);
		setX(xpos);
		setY(ypos);
		speed = s;
		setImage(turtle2);
	}

	//---------------------------------------------------------Methods----------------------------------------------------------------------

	/**
	 * This method will reset the turtle location if it reach the end of the game window.
	 */
	private void resetTurtleLocation() {
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}


	/**
	 * This method changes the image of the turtle to create an animation of turtle is moving.
	 * @param now	This parameter determines the current game time.
	 */
	private void updateTurtleImage(long now) {
		if (now /900000000  % 3 ==0) {
			setImage(turtle2);
		}
		else if (now /900000000 % 3 == 1) {
			setImage(turtle1);
		}
		else if (now /900000000 %3 == 2) {
			setImage(turtle3);
		}
	}
	//--------------------------------------------------------/Methods----------------------------------------------------------------------


}
