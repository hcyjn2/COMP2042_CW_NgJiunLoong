package comp2042_cw;

import javafx.scene.image.Image;

/**
 * This is the Digit class where it will show the score of the game.
 * It will change the digit images to represent the score.
 */
public class Digit extends Actor{
	Image image;

	@Override
	public void act(long now) {}

	/**
	 * This is the constructor of Digit class
	 * @param number Game score number
	 * @param dimension Score interface dimensions
	 * @param x Score Interface X-position
	 * @param y Score Interface Y-position
	 */
	public Digit(int number, int dimension, int x, int y) {
		image = new Image("file:src/main/resources/"+number+".png", dimension, dimension, true, true);
		setImage(image);
		setX(x);
		setY(y);
	}
	
}
