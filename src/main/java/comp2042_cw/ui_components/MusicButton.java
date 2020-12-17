package comp2042_cw.ui_components;

import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import comp2042_cw.Actor;
import comp2042_cw.MyStage;

/**
 * This is the MusicButton class where this button can mute/unmute the game background music.
 */
public class MusicButton extends Actor {

    /**
     * This is the constructor of MusicButton class.
     * @param x Button X-position
     * @param y Button Y-position
     * @param myStage MyStage instance
     */
    public MusicButton(int x, int y, MyStage myStage){
        Image playAudio = new Image("file:src/main/resources/play.png",35, 35, true, true);
        Image muteAudio = new Image("file:src/main/resources/mute.png",35, 35, true, true);
        setImage(muteAudio);
        setX(x);
        setY(y);

        //button shadow properties.
        DropShadow dropShadow = new DropShadow(25, Color.WHITE);
        dropShadow.setInput(new Glow());

        //apply button shadow and mute/unmute background music when clicked.
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