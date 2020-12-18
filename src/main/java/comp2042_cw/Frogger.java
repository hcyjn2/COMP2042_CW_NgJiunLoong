package comp2042_cw;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;


/**
 * This is the Frogger class, the main character of the game.
 * This class handles a lot of different activities/actions that are associated with Frogger like movement of Frogger, what happen if Frogger die, so on and so forth.
 */
public class Frogger extends Actor {
	//-------------------------------------------------------Variables Initialization-------------------------------------------------------
	private Image facingUp;
	private Image facingLeft;
	private Image facingDown;
	private Image facingRight;
	private Image movingUp;
	private Image movingLeft;
	private Image movingDown;
	private Image movingRight;
	private int points;
	private int life;
	private int end = 0;
	private boolean switchImage = false;
	private boolean canMove = true;
	private double movement = 13.3333333*2;
	private double movementX = 10.666666*2;
	private int imgSize = 40;
	private boolean carDeath = false;
	private boolean waterDeath = false;
	private boolean stop = false;
	private int carD = 0;
	private double previousY = 800;
	public boolean changeScore = false;
	ArrayList<End> inter = new ArrayList<>();
	//------------------------------------------------------/Variables Initialization-------------------------------------------------------

	/**
	 * This is the Frogger class constructor.
	 * @param imageLink Image path
	 * @param score Game score
	 */
	public Frogger(String imageLink, int score, int life) {
		this.points = score;
		this.life = life;
		setImage(new Image(imageLink, imgSize, imgSize, true, true));
		resetFroggerLocation();
		facingUp = new Image("file:src/main/resources/froggerUp.png", imgSize, imgSize, true, true);
		facingLeft = new Image("file:src/main/resources/froggerLeft.png", imgSize, imgSize, true, true);
		facingDown = new Image("file:src/main/resources/froggerDown.png", imgSize, imgSize, true, true);
		facingRight = new Image("file:src/main/resources/froggerRight.png", imgSize, imgSize, true, true);
		movingUp = new Image("file:src/main/resources/froggerUpJump.png", imgSize, imgSize, true, true);
		movingLeft = new Image("file:src/main/resources/froggerLeftJump.png", imgSize, imgSize, true, true);
		movingDown = new Image("file:src/main/resources/froggerDownJump.png", imgSize, imgSize, true, true);
		movingRight = new Image("file:src/main/resources/froggerRightJump.png", imgSize, imgSize, true, true);

		froggerMovementControl();
	}

	@Override
	public void act(long now) {
		int bounds = 0;

		//if the Frogger is out of game map, then reset its location.
		if (getY()<0 || getY()>734)
			resetFroggerLocation();

		//if the Frogger is at the edge of screen(left/right) and still going towards it, then move it backwards.
		if (getX()<0)
			move(movement*2, 0);
		if (getX()>600)
			move(-movement*2, 0);

		//if the Frogger hit by a car, it will trigger the death scene and death action.
		if (carDeath) {
			canMove = false;

			incrementCarD(now);

			if (carD == 1)
				setImage(new Image("file:src/main/resources/cardeath1.png", imgSize, imgSize, true, true));
			else if (carD == 2)
				setImage(new Image("file:src/main/resources/cardeath2.png", imgSize, imgSize, true, true));
			else if (carD == 3)
				setImage(new Image("file:src/main/resources/cardeath3.png", imgSize, imgSize, true, true));
			else if (carD == 4){
				carDeath = false;
				deathAction();
			}
		}

		//if the Frogger fell into the river, it will trigger the death scene and death action.
		if (waterDeath) {
			canMove = false;

			incrementCarD(now);

			if (carD==1)
				setImage(new Image("file:src/main/resources/waterdeath1.png", imgSize,imgSize , true, true));
			else if (carD==2)
				setImage(new Image("file:src/main/resources/waterdeath2.png", imgSize,imgSize , true, true));
			else if (carD==3)
				setImage(new Image("file:src/main/resources/waterdeath3.png", imgSize,imgSize , true, true));
			else if (carD == 4)
				setImage(new Image("file:src/main/resources/waterdeath4.png", imgSize,imgSize , true, true));
			else if (carD == 5){
				waterDeath = false;
				deathAction();
			}

		}

		//check if the Frogger is hit by the car and set carDeath to true if yes.
		if (getIntersectingObjects(Obstacle.class).size() >= 1)
			carDeath = true;

		//if the Frogger is standing on the Log, it will move along with the Log.
		if (getIntersectingObjects(Log.class).size() >= 1 && canMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		//if the Frogger is standing on the Turtle/WetTurtle, it will move along with the Log.
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && canMove)
			move(-1,0);
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			//trigger death if the turtle had dove into the water and Frogger is on top of it.
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()){
				waterDeath = true;
			}
			else
				move(-1,0);

		}
		//if the Frogger reaches End Portal and activates it.
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			//if >1 End Portal is activated, it will decrease score when the Frogger die.
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=10;
			}
			//add score if the End Portal is activated.
			points+=10;
			changeScore = true;
			previousY = 800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			resetFroggerLocation();
		}

		//trigger death if the Frogger stepped on the water.
		else if (getY()<413) {
			waterDeath = true;
		}

	}



	//---------------------------------------------------------Methods----------------------------------------------------------------------

	/**
	 * This method control the movement of Frogger whenever a key is pressed.
	 */
	private void froggerMovementControl() {
		setOnKeyPressed(event -> {
			if (canMove) {
				if (switchImage) {
					if (event.getCode() == KeyCode.W) {
						move(0, -movement);
						changeScore = false;
						setImage(facingUp);
						switchImage = false;
					}
					else if (event.getCode() == KeyCode.A) {
						move(-movementX, 0);
						setImage(facingLeft);
						switchImage = false;
					}
					else if (event.getCode() == KeyCode.S) {
						move(0, movement);
						setImage(facingDown);
						switchImage = false;
					}
					else if (event.getCode() == KeyCode.D) {
						move(movementX, 0);
						setImage(facingRight);
						switchImage = false;
					}
				}

				else if (event.getCode() == KeyCode.W) {
					move(0, -movement);
					setImage(movingUp);
					switchImage = true;
				}
				else if (event.getCode() == KeyCode.A) {
					move(-movementX, 0);
					setImage(movingLeft);
					switchImage = true;
				}
				else if (event.getCode() == KeyCode.S) {
					move(0, movement);
					setImage(movingDown);
					switchImage = true;
				}
				else if (event.getCode() == KeyCode.D) {
					move(movementX, 0);
					setImage(movingRight);
					switchImage = true;
				}
			}

		});

		setOnKeyReleased(event -> {
			if (canMove) {
				if (event.getCode() == KeyCode.W) {
					if (getY() < previousY) {
						changeScore = true;
						previousY = getY();
						points+=1;
					}
					move(0, -movement);
					setImage(facingUp);
					switchImage = false;
				}
				else if (event.getCode() == KeyCode.A) {
					move(-movementX, 0);
					setImage(facingLeft);
					switchImage = false;
				}
				else if (event.getCode() == KeyCode.S) {
					move(0, movement);
					setImage(facingDown);
					switchImage = false;
				}
				else if (event.getCode() == KeyCode.D) {
					move(movementX, 0);
					setImage(facingRight);
					switchImage = false;
				}}
		});
	}

	/**
	 * This method reset Frogger to the starting location.
	 */
	private void resetFroggerLocation() {
		setX(265);
		setY(679.8 + movement);
	}

	/**
	 * This method trigger the next animation of the Frogger if death occurred.
	 * @param now Current game time
	 */
	private void incrementCarD(long now) {
		if ((now) % 11 == 0)
			carD++;
	}

	/**
	 * This method resets the Frogger location, carD and deducts the score.
	 */
	private void deathAction() {
		life = life - 1;
		resetFroggerLocation();
		carD = 0;
		setImage(new Image("file:src/main/resources/froggerUp.png", imgSize, imgSize, true, true));
		canMove = true;
		if (points>10) {
			points-=10;
			changeScore = true;
		}
	}

	//return true if all End Portals are activated.
	public boolean getStop() {
		return end==5;
	}

	//return current score.
	public int getPoints() {
		return points;
	}

	//return frogger life count.
	public int getLife() {
		return life;
	}

	public boolean isDead() {
		return carDeath || waterDeath;
	}

	//return true if score is chang-able else false.
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}


	//--------------------------------------------------------/Methods----------------------------------------------------------------------


}
