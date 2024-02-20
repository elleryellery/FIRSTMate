package General;

import javax.sound.sampled.*;
import java.io.*;

public class SoundPlayer {

    public void playmusic(String musicfile, boolean repeat, float volume) {
        File soundFile = new File(musicfile);
        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
            clip.open(inputStream);

			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float range = gainControl.getMaximum() - gainControl.getMinimum();
            float gain = (range * volume / 100.0f) + gainControl.getMinimum();
            gainControl.setValue(gain);

			if (!clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
				System.err.println("In SoundPlayer.java: Volume changes are not supported.");
			}

            if (repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            clip.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}