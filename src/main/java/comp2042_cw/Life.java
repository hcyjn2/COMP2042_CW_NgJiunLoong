package comp2042_cw;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This is the Digit class where it will show the score of the game.
 * It will change the digit images to represent the score.
 */
public class Life extends Actor{
    private Image image;

    @Override
    public void act(long now) {}

    /**
     * This is the constructor of Life class
     * @param imageLink Image path
     * @param x Score Interface X-position
     * @param y Score Interface Y-position
     */
    public Life(String imageLink, int x, int y) {
        image = new Image(imageLink, 120, 240, true, true);
        setImage(image);
        setX(x);
        setY(y);
    }

}
