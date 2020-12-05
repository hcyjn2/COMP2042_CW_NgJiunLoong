package p4_group_8_repo.ui_components;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import p4_group_8_repo.Actor;

public abstract class Button extends Actor {

    public Button(String imageURL){
        Image image = new Image(imageURL, 617, 262, true, true);
        setImage(image);

        DropShadow dropShadow = new DropShadow(25, Color.LIGHTGREEN);
        dropShadow.setInput(new Glow());

        setOnMousePressed(event -> setEffect(dropShadow));
        setOnMouseReleased(event -> setEffect(null));

        setOnMouseClicked(event -> ButtonAction());
    }


    @Override
    public void act(long now) {

    }

    abstract void ButtonAction();
}

//    private Text text;
//
//    public MenuButton(String buttonText){
//        Text text = new Text(buttonText);
//        text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 28));
//        text.setFill(Color.WHITE);
//
//        Rectangle background = new Rectangle(330,50);
//        background.setOpacity(0.6);
//        background.setFill(Color.GREEN);
//        background.setEffect(new GaussianBlur(3.5));
//
//        setAlignment(Pos.CENTER);
//        getChildren().addAll(background,text);
//
//        setOnMouseEntered(event -> {
//            background.setTranslateX(10);
//            text.setTranslateX(10);
//            background.setFill(Color.LIGHTGREEN);
//            text.setFill(Color.DARKGREEN);
//
//        });
//
//        setOnMouseExited(event -> {
//            background.setTranslateX(0);
//            text.setTranslateX(0);
//            background.setFill(Color.GREEN);
//            text.setFill(Color.WHITE);
//        });
//
//        DropShadow dropShadow = new DropShadow(25, Color.LIGHTGREEN);
//        dropShadow.setInput(new Glow());
//
//        setOnMousePressed(event -> setEffect(dropShadow));
//        setOnMouseReleased(event -> setEffect(null));
//    }