package comp2042_cw;

import javafx.scene.image.Image;

/**
 * This is a BackgroundImage class where it takes a image and output it with correct size to fit the window.
 */
public class BackgroundImage extends Actor{

	@Override
	public void act(long now) { }

	/**
	 * This is the constructor of BackgroundImage class.
	 * @param imageLink Image path
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 566 , 800, true, true));
	}

}
