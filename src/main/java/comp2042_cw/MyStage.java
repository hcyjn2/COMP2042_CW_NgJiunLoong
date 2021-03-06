package comp2042_cw;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import comp2042_cw.ui_components.MusicButton;

import java.io.File;

/**
 * This is the MyStage class where it inherits from abstract class World.
 * It handles animation, spawn game assets based on game level and game background music as well.
 */
public class MyStage extends World{
	private boolean isMusicPlaying;
	private MediaPlayer mediaPlayer;
	private MusicButton musicButton = new MusicButton(520,756, this);

	@Override
	public void act(long now) {}

	//---------------------------------------------------------Methods----------------------------------------------------------------------

	/**
	 * This method generates game level(Log, Turtle, Car, Truck) based on the game level.
	 * @param level	   This parameter is the current game level.
	 */
	public void generateLevel(int level){
		if(level == 1){
			//clear the previous level game assets before generating the new one
			this.getChildren().clear();

			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 680, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new Turtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new Turtle(500, 376, -1, 130, 130));
			this.add(new Turtle(300, 376, -1, 130, 130));
			this.add(new Turtle(700, 376, -1, 130, 130));
			generateEnds();
		}
		else if(level == 2){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 680, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new Turtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new Turtle(500, 376, -1, 130, 130));
			this.add(new Turtle(300, 376, -1, 130, 130));
			this.add(new Turtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			generateEnds();
		}
		else if(level == 3){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 680, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new Turtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new Turtle(500, 376, -1, 130, 130));
			this.add(new Turtle(300, 376, -1, 130, 130));
			this.add(new Turtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			generateEnds();
		}
		else if(level == 4){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 680, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new Turtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new WetTurtle(500, 376, -1, 130, 130));
			this.add(new Turtle(300, 376, -1, 130, 130));
			this.add(new Turtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			generateEnds();
		}
		else if(level == 5){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new Turtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new WetTurtle(500, 376, -1, 130, 130));
			this.add(new Turtle(300, 376, -1, 130, 130));
			this.add(new WetTurtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			generateEnds();
		}
		else if(level == 6){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new Turtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new WetTurtle(500, 376, -1, 130, 130));
			this.add(new Turtle(300, 376, -1, 130, 130));
			this.add(new WetTurtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
			generateEnds();
		}
		else if(level == 7){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new WetTurtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new WetTurtle(500, 376, -1, 130, 130));
			this.add(new Turtle(300, 376, -1, 130, 130));
			this.add(new WetTurtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
			generateEnds();
		}
		else if(level == 8){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new WetTurtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new WetTurtle(500, 376, -1, 130, 130));
			this.add(new Turtle(300, 376, -1, 130, 130));
			this.add(new WetTurtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
			generateEnds();
		}
		else if(level == 9){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDrop" + level + ".png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new WetTurtle(600, 217, -1, 130, 130));
			this.add(new Turtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new WetTurtle(500, 376, -1, 130, 130));
			this.add(new WetTurtle(300, 376, -1, 130, 130));
			this.add(new WetTurtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
			generateEnds();
		}
		else if(level == 10){
			this.getChildren().clear();
			this.add(new BackgroundImage("file:src/main/resources/FroggerGameBackDropFinal.png"));
			this.add(musicButton);
			this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
			this.add( new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
			this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
			this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
			this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
			this.add(new WetTurtle(600, 217, -1, 130, 130));
			this.add(new WetTurtle(400, 217, -1, 130, 130));
			this.add(new WetTurtle(200, 217, -1, 130, 130));
			this.add(new WetTurtle(500, 376, -1, 130, 130));
			this.add(new WetTurtle(300, 376, -1, 130, 130));
			this.add(new WetTurtle(700, 376, -1, 130, 130));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));
			this.add(new Obstacle("file:src/main/resources/car1Left.png", 300, 490, -5, 50, 50));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
			generateEnds();
		}
	}

	/**
	 * This method plays game background music.
	 */
	public void playMusic() {
		String musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		isMusicPlaying = true;
	}

	/**
	 * This method stops game background music.
	 */
	public void stopMusic() {
		mediaPlayer.stop();
		isMusicPlaying = false;
	}

	//return true if the background music is playing.
	public boolean isMusicPlaying() {
		return isMusicPlaying;
	}

	//generates all End Portals.
	private void generateEnds() {
		this.add(new End(10, 96));
		this.add(new End(130, 96));
		this.add(new End(250, 96));
		this.add(new End(371, 96));
		this.add(new End(493, 96));
	}
	//--------------------------------------------------------/Methods----------------------------------------------------------------------
}
