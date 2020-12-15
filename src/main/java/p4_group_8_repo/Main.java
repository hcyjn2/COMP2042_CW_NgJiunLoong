package p4_group_8_repo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import p4_group_8_repo.ui_components.BackToMenuButton;
import p4_group_8_repo.ui_components.Button;
import p4_group_8_repo.ui_components.MusicButton;

public class Main extends Application {
	//initialize variables
	AnimationTimer timer;
	MyStage backgroundStage;
	Frogger frogger;
	private int currentLevel = 1;
	private int score = 0;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//game window is fixed so the aspect ratio / game asset will not look weird
		primaryStage.setResizable(false);

		//---------------------------------------------------Game Assets initialization-------------------------------------------------------
		backgroundStage = new MyStage();
		frogger = new Frogger("file:src/main/resources/froggerUp.png",score);
		Scene scene  = new Scene(backgroundStage,566,800);
		BackgroundImage gameMenuImage = new BackgroundImage("file:src/main/resources/GameMenu1.png");
		BackgroundImage aboutScreenImage = new BackgroundImage("file:src/main/resources/AboutScreen.png");
		Button startButton = new Button("file:src/main/resources/start.png", -28, 310);
		Button aboutButton = new Button("file:src/main/resources/about.png", -28, 430);
		Button exitButton = new Button("file:src/main/resources/exit.png", -28, 530);
		Button backButton = new Button("file:src/main/resources/back.png", -28, 530);
		//--------------------------------------------------/Game Assets initialization-------------------------------------------------------

		//---------------------------------------------------Generates Game Asset-------------------------------------------------------------
		backgroundStage.generateLevel(currentLevel);

		backgroundStage.add(frogger);
		backgroundStage.add(new Digit(0, 30, 532, 33));

		generateGameMenu(gameMenuImage, startButton, aboutButton, exitButton);

		primaryStage.setScene(scene);
		primaryStage.show();
		//--------------------------------------------------/Generates Game Asset-------------------------------------------------------------

		//---------------------------------------------------Button Functions-----------------------------------------------------------------
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

		aboutButton.setOnMouseClicked(event -> {
			backgroundStage.remove(gameMenuImage);
			backgroundStage.remove(startButton);
			backgroundStage.remove(aboutButton);
			backgroundStage.remove(exitButton);
			backgroundStage.add(aboutScreenImage);
			backgroundStage.add(backButton);

		});

		backButton.setOnMouseClicked(event -> {
			backgroundStage.remove(aboutScreenImage);
			backgroundStage.remove(backButton);
			generateGameMenu(gameMenuImage, startButton, aboutButton, exitButton);
		});

		exitButton.setOnMouseClicked(event -> System.exit(0));
		//--------------------------------------------------/Button Functions-----------------------------------------------------------------

	}



	//---------------------------------------------------------Methods----------------------------------------------------------------------
	public void createTimer(){
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(frogger.getStop()){
					currentLevel++;
					backgroundStage.generateLevel(currentLevel);
					frogger = new Frogger("file:src/main/resources/froggerUp.png", score);
					backgroundStage.add(frogger);
				}

				if (frogger.changeScore()){
					setNumber(frogger.getPoints());
					score = frogger.getPoints();
				}

				if (currentLevel > 10) {
					System.out.print("STOP:");
					backgroundStage.stopMusic();
					stop();
					backgroundStage.stop();
					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					alert.setTitle("You Have Won The Game!");
					alert.setHeaderText("Your High Score: " + frogger.getPoints() + "!");
					alert.setContentText("Highest Possible Score: 800");
					alert.show();
				}
			}
		};
	}

	public void start() {
		backgroundStage.playMusic();
		createTimer();
		timer.start();
	}

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

	private void generateGameMenu(BackgroundImage gameMenuImage, Button startButton, Button aboutButton, Button exitButton) {
		backgroundStage.add(gameMenuImage);
		backgroundStage.add(startButton);
		backgroundStage.add(aboutButton);
		backgroundStage.add(exitButton);
	}

    public void stop() {
        timer.stop();
    }
	//--------------------------------------------------------/Methods----------------------------------------------------------------------
}
