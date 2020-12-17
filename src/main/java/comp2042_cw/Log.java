package comp2042_cw;

import javafx.scene.image.Image;

/**
 * This is the Log class where it will create a Log for Frogger to step over in the game.
 */
public class Log extends Actor {
	private double speed;

	@Override
	public void act(long now) {
		move(speed , 0);

		resetLogLocation();
	}


	/**
	 * This is the Log class constructor.
	 * @param imageLink Image path
	 * @param size Size of the log
	 * @param xpos Log X-position
	 * @param ypos Log Y-position
	 * @param s Speed of the log
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		setImage(new Image(imageLink, size,size, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	//---------------------------------------------------------Methods----------------------------------------------------------------------

	/**
	 * This method will reset the Log location if it reach the end of the game window.
	 */
	private void resetLogLocation() {
		if (getX() > 600 && speed > 0)
			setX(-180);
		if (getX() < -300 && speed < 0)
			setX(700);
	}

	//return true if the log is moving left.
	public boolean getLeft() {
		return speed < 0;
	}
	//--------------------------------------------------------/Methods----------------------------------------------------------------------
}
