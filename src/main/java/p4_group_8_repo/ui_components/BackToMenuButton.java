package p4_group_8_repo.ui_components;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import p4_group_8_repo.Actor;
import p4_group_8_repo.BackgroundImage;
import p4_group_8_repo.MyStage;

public class BackToMenuButton extends Actor{

    public BackToMenuButton(int x, int y, MyStage myStage){

        Image backToMenu = new Image("file:src/main/resources/backToMenu.png",35, 35, true, true);
        setImage(backToMenu);
        setX(x);
        setY(y);

        DropShadow dropShadow = new DropShadow(25, Color.WHITE);
        dropShadow.setInput(new Glow());


        setOnMousePressed(event -> {
            myStage.stop();
            myStage.stopMusic();

        });

        setOnMouseReleased(event -> setEffect(null));
    }


    @Override
    public void act(long now) {

    }

}
