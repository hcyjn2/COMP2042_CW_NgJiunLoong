package comp2042_cw;

import javafx.scene.image.Image;

/**
 * This is the Log class where it will create obstacle to prevent Frogger going towards End Portal smoothly.
 */
public class Obstacle extends Actor {
	private int speed;

	@Override
	public void act(long now) {
		move(speed , 0);

		resetObstacleLocation();
	}

	/**
	 * This is the obstacle class constructor.
	 * @param imageLink Image path
	 * @param xpos Obstacle X-position
	 * @param ypos Obstacle Y-position
	 * @param s Speed of the obstacle.
	 * @param w Width of the obstacle.
	 * @param h Height of the obstacle.
	 */
	public Obstacle(String imageLink, int xpos, int ypos, int s, int w, int h) {
		setImage(new Image(imageLink, w,h, true, true));
		setX(xpos);
		setY(ypos);
		speed = s;
	}

	//Method

	/**
	 * This method will reset the obstacle location if it reach the end of the game window.
	 */
	private void resetObstacleLocation() {
		if (getX() > 600 && speed > 0)
			setX(-200);
		if (getX() < -50 && speed < 0)
			setX(600);
	}


}
