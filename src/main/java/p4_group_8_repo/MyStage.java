package p4_group_8_repo;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MyStage extends World{

	private int level;
	private boolean isMusicPlaying;
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}

	public void generateLevel(int level){
		Log firstRowLog1 = new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75);
		Log firstRowLog2 = new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75);
		Log firstRowLog3 = new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75);
		Log firstRowLog4 = new Log("file:src/main/resources/log3.png", 150, 680, 166, 0.75);
		Log secondRowLog1 = new Log("file:src/main/resources/logs.png", 300, 0, 276, -2);
		Log secondRowLog2 = new Log("file:src/main/resources/logs.png", 300, 400, 276, -2);
		Log thirdRowLog1 = new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75);
		Log thirdRowLog2 = new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75);
		Log thirdRowLog3 = new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75);
		Turtle firstRowTurtle1 = new Turtle(600, 217, -1, 130, 130);
		Turtle firstRowTurtle2 = new Turtle(400, 217, -1, 130, 130);
		WetTurtle firstRowWetTurtle1 = new WetTurtle(200, 217, -1, 130, 130);
		Turtle secondRowTurtle1 = new Turtle(500, 376, -1, 130, 130);
		Turtle secondRowTurtle2 = new Turtle(300, 376, -1, 130, 130);
		Turtle secondRowTurtle3 = new Turtle(700, 376, -1, 130, 130);
		End end1 = new End(10,96);
		End end2 = new End(130,96);
		End end3 = new End(250,96);
		End end4 = new End(371,96);
		End end5 = new End(493,96);

//		backgroundStage.add(new End(130,96));
//		backgroundStage.add(new End(250,96));
//		backgroundStage.add(new End(371,96));
//		backgroundStage.add(new End(493,96));



		if(level == 1){
				this.add(firstRowLog1);
				this.add(firstRowLog2);
				this.add(firstRowLog3);
				this.add(firstRowLog4);
				this.add(secondRowLog1);
				this.add(secondRowLog2);
				this.add(thirdRowLog1);
				this.add(thirdRowLog2);
				this.add(thirdRowLog3);
				this.add(firstRowTurtle1);
				this.add(firstRowTurtle2);
				this.add(firstRowWetTurtle1);
				this.add(secondRowTurtle1);
				this.add(secondRowTurtle2);
				this.add(secondRowTurtle3);
				this.add(end1);
				this.add(end2);
				this.add(end3);
				this.add(end4);
				this.add(end5);

		}
		else if(level == 2){
			resetEnds(end1,end2,end3,end4,end5);

			this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
			this.add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));

		}


	}

	private void resetEnds(End end1, End end2, End end3, End end4, End end5) {
		this.remove(end1);
		this.remove(end2);
		this.remove(end3);
		this.remove(end4);
		this.remove(end5);

		end1 = new End(10,96);
		end2 = new End(130,96);
		end3 = new End(250,96);
		end4 = new End(371,96);
		end5 = new End(493,96);


	}

	public void playMusic() {
		String musicFile = "src/main/resources/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.play();
		isMusicPlaying = true;
	}

	public void stopMusic() {
		mediaPlayer.stop();
		isMusicPlaying = false;
	}

	public boolean isMusicPlaying() {
		return isMusicPlaying;
	}

}

//		this.add(new Log("file:src/main/resources/log3.png", 150, 0, 166, 0.75));
//		this.add(new Log("file:src/main/resources/log3.png", 150, 220, 166, 0.75));
//		this.add(new Log("file:src/main/resources/log3.png", 150, 440, 166, 0.75));
//
//		this.add(new Log("file:src/main/resources/logs.png", 300, 0, 276, -2));
//		this.add(new Log("file:src/main/resources/logs.png", 300, 400, 276, -2));
//
//		this.add(new Log("file:src/main/resources/log3.png", 150, 50, 329, 0.75));
//		this.add(new Log("file:src/main/resources/log3.png", 150, 270, 329, 0.75));
//		this.add(new Log("file:src/main/resources/log3.png", 150, 490, 329, 0.75));
//
//
//				this.add(new Turtle(500, 376, -1, 130, 130));
//				this.add(new Turtle(300, 376, -1, 130, 130));
//				this.add(new WetTurtle(700, 376, -1, 130, 130));
//				this.add(new WetTurtle(600, 217, -1, 130, 130));
//				this.add(new WetTurtle(400, 217, -1, 130, 130));
//				this.add(new WetTurtle(200, 217, -1, 130, 130));
//
//
//				this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 0, 649, 1, 120, 120));
//				this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 300, 649, 1, 120, 120));
//				this.add(new Obstacle("file:src/main/resources/truck1"+"Right.png", 600, 649, 1, 120, 120));
//				this.add(new Obstacle("file:src/main/resources/car1Left.png", 100, 597, -1, 50, 50));
//				this.add(new Obstacle("file:src/main/resources/car1Left.png", 250, 597, -1, 50, 50));
//				this.add(new Obstacle("file:src/main/resources/car1Left.png", 400, 597, -1, 50, 50));
//				this.add(new Obstacle("file:src/main/resources/car1Left.png", 550, 597, -1, 50, 50));
//				this.add(new Obstacle("file:src/main/resources/truck2Right.png", 0, 540, 1, 200, 200));
//				this.add(new Obstacle("file:src/main/resources/truck2Right.png", 500, 540, 1, 200, 200));
//				this.add(new Obstacle("file:src/main/resources/car1Left.png", 500, 490, -5, 50, 50));