package p4_group_8_repo;

import java.util.ArrayList;

import javafx.event.EventHandler;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class Frogger extends Actor {
	//initialize variables
	Image facingUp;
	Image facingLeft;
	Image facingDown;
	Image facingRight;
	Image movingUp;
	Image movingLeft;
	Image movingDown;
	Image movingRight;
	int points = 0;
	int end = 0;
	private boolean second = false;
	boolean canMove = true;
	double movement = 13.3333333*2;
	double movementX = 10.666666*2;
	int imgSize = 40;
	boolean carDeath = false;
	boolean waterDeath = false;
	boolean stop = false;
	boolean changeScore = false;
	int carD = 0;
	double previousY = 800;
	ArrayList<End> inter = new ArrayList<End>();

	//constructor
	public Frogger(String imageLink) {
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

		//check if Frogger is facing correct direction, if yes then move else change direction
		setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event){
				if (canMove) {
					if (second) {
						if (event.getCode() == KeyCode.W) {
							move(0, -movement);
							changeScore = false;
							setImage(facingUp);
							second = false;
						}
						else if (event.getCode() == KeyCode.A) {
							move(-movementX, 0);
							setImage(facingLeft);
							second = false;
						}
						else if (event.getCode() == KeyCode.S) {
							move(0, movement);
							setImage(facingDown);
							second = false;
						}
						else if (event.getCode() == KeyCode.D) {
							move(movementX, 0);
							setImage(facingRight);
							second = false;
						}
					}

					else if (event.getCode() == KeyCode.W) {
						move(0, -movement);
						setImage(movingUp);
						second = true;
					}
					else if (event.getCode() == KeyCode.A) {
						move(-movementX, 0);
						setImage(movingLeft);
						second = true;
					}
					else if (event.getCode() == KeyCode.S) {
						move(0, movement);
						setImage(movingDown);
						second = true;
					}
					else if (event.getCode() == KeyCode.D) {
						move(movementX, 0);
						setImage(movingRight);
						second = true;
					}
				}

			}
		});

		setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (canMove) {
					if (event.getCode() == KeyCode.W) {
					if (getY() < previousY) {
						changeScore = true;
						previousY = getY();
						points+=10;
					}
					move(0, -movement);
					setImage(facingUp);
					second = false;
				}
				else if (event.getCode() == KeyCode.A) {
					move(-movementX, 0);
					setImage(facingLeft);
					second = false;
				}
				else if (event.getCode() == KeyCode.S) {
					move(0, movement);
					setImage(facingDown);
					second = false;
				}
				else if (event.getCode() == KeyCode.D) {
					move(movementX, 0);
					setImage(facingRight);
					second = false;
				}}
			}
			
		});
	}

	private void resetFroggerLocation() {
		setX(265);
		setY(679.8 + movement);
	}

	@Override
	public void act(long now) {
		int bounds = 0;
		if (getY()<0 || getY()>734) {
			resetFroggerLocation();
		}
		if (getX()<0) {
			move(movement*2, 0);
		}
		if (carDeath) {
			canMove = false;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/cardeath1.png", imgSize, imgSize, true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/cardeath2.png", imgSize, imgSize, true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/cardeath3.png", imgSize, imgSize, true, true));
			}
			if (carD == 4) {
				resetFroggerLocation();
				carDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/froggerUp.png", imgSize, imgSize, true, true));
				canMove = true;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		if (waterDeath) {
			canMove = false;
			if ((now)% 11 ==0) {
				carD++;
			}
			if (carD==1) {
				setImage(new Image("file:src/main/resources/waterdeath1.png", imgSize,imgSize , true, true));
			}
			if (carD==2) {
				setImage(new Image("file:src/main/resources/waterdeath2.png", imgSize,imgSize , true, true));
			}
			if (carD==3) {
				setImage(new Image("file:src/main/resources/waterdeath3.png", imgSize,imgSize , true, true));
			}
			if (carD == 4) {
				setImage(new Image("file:src/main/resources/waterdeath4.png", imgSize,imgSize , true, true));
			}
			if (carD == 5) {
				resetFroggerLocation();
				waterDeath = false;
				carD = 0;
				setImage(new Image("file:src/main/resources/froggerUp.png", imgSize, imgSize, true, true));
				canMove = true;
				if (points>50) {
					points-=50;
					changeScore = true;
				}
			}
			
		}
		
		if (getX()>600) {
			move(-movement*2, 0);
		}
		if (getIntersectingObjects(Obstacle.class).size() >= 1) {
			carDeath = true;
		}
		if (getX() == 240 && getY() == 82) {
			stop = true;
		}
		if (getIntersectingObjects(Log.class).size() >= 1 && canMove) {
			if(getIntersectingObjects(Log.class).get(0).getLeft())
				move(-2,0);
			else
				move (.75,0);
		}
		else if (getIntersectingObjects(Turtle.class).size() >= 1 && canMove) {
			move(-1,0);
		}
		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).isSunk()) {
				waterDeath = true;
			} else {
				move(-1,0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			inter = (ArrayList<End>) getIntersectingObjects(End.class);
			if (getIntersectingObjects(End.class).get(0).isActivated()) {
				end--;
				points-=50;
			}
			points+=50;
			changeScore = true;
			previousY =800;
			getIntersectingObjects(End.class).get(0).setEnd();
			end++;
			resetFroggerLocation();
		}
		else if (getY()<413){
			waterDeath = true;
			//setX(300);
			//setY(679.8+movement);
		}
	}
	public boolean getStop() {
		return end==5;
	}
	
	public int getPoints() {
		return points;
	}
	
	public boolean changeScore() {
		if (changeScore) {
			changeScore = false;
			return true;
		}
		return false;
		
	}
	

}
