package p4_group_8_repo.ui_components;

import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import p4_group_8_repo.Actor;
import p4_group_8_repo.BackgroundImage;

public class GameMenu extends Actor {

    public GameMenu(){
        BackgroundImage gameMenuImage = new BackgroundImage("file:src/main/resources/GameMenu1.png");


    }

    @Override
    public void act(long now) {

    }
}

//    public GameMenu(){
//        Pane pane = new Pane();
//        pane.setPrefSize(566,800);
//
//        BackgroundImage gameMenuImage = new BackgroundImage("file:src/main/resources/GameMenu.png");
//
//        VBox menu0 = new VBox(12);
//
//        menu0.setTranslateX(115);
//        menu0.setTranslateY(420);
//
//        BackgroundImage aboutScreenImage = new BackgroundImage("file:src/main/resources/AboutScreen.png");
//
//        BackButton backButton = new BackButton("BACK");
//        backButton.setOnMouseClicked(event -> {
//            aboutScreenImage.setVisible(false);
//            backButton.setVisible(false);
//        });
//        backButton.setTranslateX(200);
//        backButton.setTranslateY(650);
//
//        aboutScreenImage.setVisible(false);
//        backButton.setVisible(false);
//
//        MenuButton startButton = new MenuButton("START");
//        startButton.setOnMouseClicked(event -> {
////                    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.5), this);
////                    fadeTransition.setFromValue(1);
////                    fadeTransition.setToValue(0);
////                    fadeTransition.setOnFinished(event1 -> this.setVisible(false));
////                    fadeTransition.play();
//        });
//
//        MenuButton aboutButton = new MenuButton("ABOUT");
//        aboutButton.setOnMouseClicked(event -> {
//            aboutScreenImage.setVisible(true);
//            backButton.setVisible(true);
//        });
//
//        MenuButton exitButton = new MenuButton("EXIT");
//        exitButton.setOnMouseClicked(event -> {System.exit(0);});
//
//        menu0.getChildren().addAll(startButton,aboutButton,exitButton);
//
//        Rectangle menuBackground = new Rectangle(400, 280);
//        menuBackground.setTranslateX(80);
//        menuBackground.setTranslateY(370);
//        menuBackground.setFill(Color.GRAY);
//        menuBackground.setOpacity(0.08);
//        menuBackground.setArcHeight(30);
//        menuBackground.setArcWidth(20);
//
//        getChildren().addAll(gameMenuImage, menuBackground, menu0, aboutScreenImage, backButton);
//    }