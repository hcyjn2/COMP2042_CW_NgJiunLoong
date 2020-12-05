package p4_group_8_repo.ui_components;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import p4_group_8_repo.Actor;
import p4_group_8_repo.MyStage;

public class MusicButton extends Actor {

    public MusicButton(int x, int y, MyStage myStage){

        Image playAudio = new Image("file:src/main/resources/play.png",35, 35, true, true);
        Image muteAudio = new Image("file:src/main/resources/mute.png",35, 35, true, true);
        setImage(muteAudio);
        setX(x);
        setY(y);

        DropShadow dropShadow = new DropShadow(25, Color.WHITE);
        dropShadow.setInput(new Glow());

        setOnMousePressed(event -> {
            setEffect(dropShadow);
            if(myStage.isMusicPlaying()){
                myStage.stopMusic();
                setImage(playAudio);
            }
            else{
                myStage.playMusic();
                setImage(muteAudio);
            }
        });

        setOnMouseReleased(event -> setEffect(null));
    }


    @Override
    public void act(long now) {

    }
}