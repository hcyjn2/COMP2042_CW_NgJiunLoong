package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	Image image;

	@Override
	public void act(long now) {}

	//constructor
	public Digit(int number, int dimension, int x, int y) {
		image = new Image("file:src/main/resources/"+number+".png", dimension, dimension, true, true);
		setImage(image);
		setX(x);
		setY(y);
	}
	
}
