package General;
import Screens.*;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;

public class SoundPlayer {

	private ArrayList<Clip> currentlyPlaying = new ArrayList();

    public void playmusic(char type,String musicfile, boolean repeat, float volume) {
        File soundFile = new File(musicfile);
        try {
			if((type == 'S' && Settings.enabledSoundEffects()) || type == 'M') {
				Clip clip = AudioSystem.getClip();
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
				clip.open(inputStream);

				volume *= (Settings.volume());

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

				currentlyPlaying.add(clip);

				clip.start();
			}
        } catch (Exception e) {
            System.out.println(e);
        }
    }

	public void stopAllSounds() {
		if(currentlyPlaying.size()>0){
			for (Clip clip : currentlyPlaying) {
				if (clip.isRunning()) {
					clip.stop();
				}
			}
			currentlyPlaying.clear();
		}
    }
}