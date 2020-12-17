package comp2042_cw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyStageTest {

    MyStage myStage = new MyStage();

    @Test
    void playMusicTest() {
        myStage.playMusic();
        Assertions.assertTrue(myStage.isMusicPlaying());
    }

    @Test
    void stopMusicTest() {
        myStage.stopMusic();
        Assertions.assertFalse(myStage.isMusicPlaying());
    }

}