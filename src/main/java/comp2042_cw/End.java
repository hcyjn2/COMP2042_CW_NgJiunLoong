package comp2042_cw;

import javafx.scene.image.Image;

/**
 * This is the End class to create End Portals for the game.
 */
public class End extends Actor{

	private boolean activated = false;

	@Override
	public void act(long now) {}

	/**
	 * This is the End class constructor.
	 * @param x	End Portal X-position.
	 * @param y End Portal Y-position.
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/main/resources/End.png", 60, 60, true, true));
	}

	//---------------------------------------------------------Methods----------------------------------------------------------------------

	/**
	 * This method change the End Portal image from unactivated End Portal to activated End Portal.
	 * This method also update the status of the End Portal as well.
	 */
	public void setEnd() {
		setImage(new Image("file:src/main/resources/FrogEnd.png", 70, 58, true, true));
		activated = true;
	}

	//This method will return if the End Portal is activated.
	public boolean isActivated() {
		return activated;
	}
	//--------------------------------------------------------/Methods----------------------------------------------------------------------
	

}
