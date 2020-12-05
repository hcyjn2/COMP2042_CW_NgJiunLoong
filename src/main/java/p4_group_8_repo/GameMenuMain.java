package p4_group_8_repo;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import p4_group_8_repo.ui_components.GameMenu;


public class GameMenuMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setResizable(false);

        Pane pane = new Pane();
        pane.setPrefSize(566,800);

        BackgroundImage backgroundImage = new BackgroundImage("file:src/main/resources/FroggerGameBackDrop.png");

        GameMenu gameMenu = new GameMenu();

        pane.getChildren().addAll(backgroundImage,gameMenu);

        Scene scene = new Scene(pane);

        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ESCAPE){
                if(!gameMenu.isVisible()){
                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    fadeTransition.setFromValue(0);
                    fadeTransition.setToValue(1);

                    gameMenu.setVisible(true);
                    fadeTransition.play();
                }
                else{
                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), gameMenu);
                    fadeTransition.setFromValue(1);
                    fadeTransition.setToValue(0);
                    fadeTransition.setOnFinished(event1 -> gameMenu.setVisible(false));
                    fadeTransition.play();
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }

}