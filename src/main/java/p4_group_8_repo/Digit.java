package p4_group_8_repo;

import javafx.scene.image.Image;

public class Digit extends Actor{
	int dimension;
	Image image;
	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		
	}
	
	public Digit(int number, int dimension, int x, int y) {
		image = new Image("file:src/main/resources/"+number+".png", dimension, dimension, true, true);
		setImage(image);
		setX(x);
		setY(y);
	}
	
}
