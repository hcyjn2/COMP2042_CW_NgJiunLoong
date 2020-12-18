package comp2042_cw;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import comp2042_cw.ui_components.Button;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

import java.io.File;
import java.util.Optional;
import java.util.Scanner;

/**
 * This is the Main class of the game.
 */
public class Main extends Application {
	//initialize variables
	AnimationTimer timer;
	MyStage backgroundStage;
	Frogger frogger;
	private int froggerLife = 2;
	private int currentLevel = 1;
	private int score = 0;

	public static void main(String[] args) {
		launch(args);
	}

		@Override
	public void start(Stage primaryStage){
		//game window is fixed so the aspect ratio / game asset will not look weird
		primaryStage.setResizable(false);

		//---------------------------------------------------Game Assets initialization-------------------------------------------------------
		backgroundStage = new MyStage();
		frogger = new Frogger("file:src/main/resources/froggerUp.png",score, froggerLife);
		Scene scene  = new Scene(backgroundStage,566,800);
		BackgroundImage gameMenuImage = new BackgroundImage("file:src/main/resources/GameMenu.png");
		BackgroundImage aboutScreenImage = new BackgroundImage("file:src/main/resources/AboutScreen.png");
		Button startButton = new Button("file:src/main/resources/start.png", -28, 310);
		Button aboutButton = new Button("file:src/main/resources/about.png", -28, 430);
		Button exitButton = new Button("file:src/main/resources/exit.png", -28, 530);
		Button backButton = new Button("file:src/main/resources/back.png", -28, 530);
		Life lifeCountUI = new Life("file:src/main/resources/3lifes.png", 10, 755);
		//--------------------------------------------------/Game Assets initialization-------------------------------------------------------

		//---------------------------------------------------Generates Game Asset-------------------------------------------------------------
		backgroundStage.generateLevel(currentLevel);

		backgroundStage.add(frogger);
		backgroundStage.add(new Digit(0, 30, 532, 33));
		backgroundStage.add(lifeCountUI);

		generateGameMenu(gameMenuImage, startButton, aboutButton, exitButton);

		primaryStage.setScene(scene);
		primaryStage.show();
		//--------------------------------------------------/Generates Game Asset-------------------------------------------------------------

		//---------------------------------------------------Button Functions-----------------------------------------------------------------

		//hide the game menu and start the game.
		startButton.setOnMouseClicked(event -> {
			backgroundStage.remove(gameMenuImage);
			backgroundStage.remove(startButton);
			backgroundStage.remove(aboutButton);
			backgroundStage.remove(exitButton);
			//start asset timer
			backgroundStage.start();
			//score and music start
			start();
		});

		//go to about screen.
		aboutButton.setOnMouseClicked(event -> {
			backgroundStage.remove(gameMenuImage);
			backgroundStage.remove(startButton);
			backgroundStage.remove(aboutButton);
			backgroundStage.remove(exitButton);
			backgroundStage.add(aboutScreenImage);
			backgroundStage.add(backButton);

		});

		//go back to the game menu.
		backButton.setOnMouseClicked(event -> {
			backgroundStage.remove(aboutScreenImage);
			backgroundStage.remove(backButton);
			generateGameMenu(gameMenuImage, startButton, aboutButton, exitButton);
		});

		//close the application.
		exitButton.setOnMouseClicked(event -> System.exit(0));
		//--------------------------------------------------/Button Functions-----------------------------------------------------------------

	}



	//---------------------------------------------------------Methods----------------------------------------------------------------------

	/**
	 * This method creates a timer.
	 * This timer handles game level and game score.
	 */
	public void createTimer(){
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {

				//if frogger is dead, update Frogger life count
				if(frogger.isDead()){
					froggerLife = frogger.getLife();
					updateLifeUI();
				}

				//if all End portals has been activated, then trigger level up.
				if(frogger.getStop()){
					setNumber(frogger.getPoints());
					score = frogger.getPoints();

					currentLevel++;
					backgroundStage.generateLevel(currentLevel);
					frogger = new Frogger("file:src/main/resources/froggerUp.png", score, froggerLife);
					backgroundStage.add(frogger);

					//reload UI elements
					updateLifeUI();
					setNumber(frogger.getPoints());
				}

				//update score when it is true.
				if (frogger.changeScore()){
					setNumber(frogger.getPoints());
					score = frogger.getPoints();
				}


				//stop game after beaten level 10 and show the total score.
				if (currentLevel > 10 || froggerLife == 0) {
					int highScore = 0;

					File highScoreRecord = new File("highscore.txt");

					//read high score from txt file
					try {
						Scanner scanner = new Scanner(highScoreRecord);
						highScore = scanner.nextInt();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					if(score > highScore){
						try {
							highScore = score;
							if (highScoreRecord.createNewFile()) {
								System.out.println("File created: " + highScoreRecord.getName());
								FileWriter fileWriter = new FileWriter(highScoreRecord.getName());
								fileWriter.write(String.valueOf(highScore));
								fileWriter.close();
							} else {
								FileWriter fileWriter = new FileWriter(highScoreRecord.getName(),false);
								fileWriter.write(String.valueOf(highScore));
								fileWriter.close();
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}


					backgroundStage.stopMusic();
					stop();
					backgroundStage.stop();


					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("--Game Over--");
					alert.setHeaderText("Your Score: " + frogger.getPoints() + "!");
					alert.setContentText("Current High Score: " + highScore + "\n\nClick OK to exit.");
					alert.setOnHidden(event -> System.exit(0));
					alert.show();

				}
			}

			private void updateLifeUI() {
				if(froggerLife == 3)
					backgroundStage.add(new Life("file:src/main/resources/3lifes.png", 10, 755));
				else if(froggerLife == 2)
					backgroundStage.add(new Life("file:src/main/resources/2lifes.png", 10, 755));
				else if(froggerLife == 1)
					backgroundStage.add(new Life("file:src/main/resources/1life.png", 10, 755));
			}
		};
	}

	//start the game timer, stage time and play music.
	public void start() {
		backgroundStage.playMusic();
		createTimer();
		timer.start();
	}

	//update the score display.
	public void setNumber(int n) {
		int shift = 0;
		while (n > 0) {
			int d = n / 10;
			int k = n - d * 10;
			n = d;
			backgroundStage.add(new Digit(k, 30, 532 - shift, 33));
			shift+=27;
		}
	}

	//generate game menu.
	private void generateGameMenu(BackgroundImage gameMenuImage, Button startButton, Button aboutButton, Button exitButton) {
		backgroundStage.add(gameMenuImage);
		backgroundStage.add(startButton);
		backgroundStage.add(aboutButton);
		backgroundStage.add(exitButton);
	}

	//stops the game timer.
    public void stop() {
        timer.stop();
    }
	//--------------------------------------------------------/Methods----------------------------------------------------------------------
}
