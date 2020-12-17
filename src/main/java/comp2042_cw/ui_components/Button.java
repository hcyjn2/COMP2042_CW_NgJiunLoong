package comp2042_cw.ui_components;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import comp2042_cw.Actor;

/**
 * This is the Button class where it handles the click animation of the button and how the button looks like.
 */
public class Button extends Actor {

    /** This is the Button class constructor.
     * @param imageURL Image path
     * @param x Image X-position
     * @param y Image Y-position
     */
    public Button(String imageURL, int x, int y){
        Image image = new Image(imageURL, 617, 262, true, true);
        setImage(image);
        setX(x);
        setY(y);

        //button shadow properties.
        DropShadow dropShadowGreen = new DropShadow(25, Color.LIGHTGREEN);
        dropShadowGreen.setInput(new Glow());
        DropShadow dropShadowWhite = new DropShadow(25, Color.WHITE);
        dropShadowWhite.setInput(new Glow());

        //apply button shadow when hovered or clicked.
        setOnMouseEntered(event -> setEffect(dropShadowWhite));
        setOnMouseExited(event -> setEffect(null));
        setOnMousePressed(event -> setEffect(dropShadowGreen));
        setOnMouseReleased(event -> setEffect(null));

    }


    @Override
    public void act(long now) {

    }

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