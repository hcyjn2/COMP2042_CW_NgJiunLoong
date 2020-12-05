package p4_group_8_repo.ui_components;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BackButton extends StackPane {
    private Text text;

    public BackButton(String buttonText){
        Text text = new Text(buttonText);
        text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, FontPosture.REGULAR, 24));
        text.setFill(Color.WHITE);

        Rectangle background = new Rectangle(150,60);
        background.setOpacity(0.6);
        background.setFill(Color.GRAY);
        background.setEffect(new GaussianBlur(3.5));

        setAlignment(Pos.CENTER);
        getChildren().addAll(background,text);

        setOnMouseEntered(event -> {
            background.setFill(Color.WHITE);
            text.setFill(Color.BLACK);

        });

        setOnMouseExited(event -> {
            background.setFill(Color.GRAY);
            text.setFill(Color.BLACK);
        });

        DropShadow dropShadow = new DropShadow(25, Color.WHITE);
        dropShadow.setInput(new Glow());

        setOnMousePressed(event -> setEffect(dropShadow));
        setOnMouseReleased(event -> setEffect(null));
    }


}