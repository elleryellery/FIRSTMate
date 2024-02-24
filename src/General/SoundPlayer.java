package General;
import Screens.*;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;

public class SoundPlayer {

	private ArrayList<Sound> currentlyPlaying = new ArrayList();

    // public void playmusic(char type, String musicfile, boolean repeat, float volume) {
    //     File soundFile = new File(musicfile);
    //     try {
	// 		if((type == 'S' && Settings.enabledSoundEffects()) || type == 'M') {
	// 			Clip clip = AudioSystem.getClip();
	// 			AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
	// 			clip.open(inputStream);

	// 			volume *= (Settings.volume());

	// 			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	// 			float range = gainControl.getMaximum() - gainControl.getMinimum();
	// 			float gain = (range * volume / 100.0f) + gainControl.getMinimum();
	// 			gainControl.setValue(gain);

	// 			if (!clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
	// 				System.err.println("In SoundPlayer.java: Volume changes are not supported.");
	// 			}

	// 			if (repeat) {
	// 				clip.loop(Clip.LOOP_CONTINUOUSLY);
	// 			}

	// 			clip.start();
	// 		}
    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }
    // }

	public void playmusic(Sound sound) {
        File soundFile = new File(sound.fileName());
        try {
			if((sound.type() == 'S' && Settings.enabledSoundEffects()) || sound.type() == 'M') {
				sound.setClip(AudioSystem.getClip());
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
				sound.clip().open(inputStream);

				float volume = sound.volume() * (Settings.volume());

				FloatControl gainControl = (FloatControl) sound.clip().getControl(FloatControl.Type.MASTER_GAIN);
				float range = gainControl.getMaximum() - gainControl.getMinimum();
				float gain = (range * volume / 100.0f) + gainControl.getMinimum();
				gainControl.setValue(gain);

				if (!sound.clip().isControlSupported(FloatControl.Type.MASTER_GAIN)) {
					System.err.println("In SoundPlayer.java: Volume changes are not supported.");
				}

				if (sound.repeat()) {
					sound.clip().loop(Clip.LOOP_CONTINUOUSLY);
				}

				currentlyPlaying.add(sound);

				sound.clip().start();
			}
        } catch (Exception e) {
            System.out.println(e);
        }
    }

	public void stopAllSounds() {
		if(currentlyPlaying.size()>0){
			for (Sound sound : currentlyPlaying) {
				if (sound.clip().isRunning()) {
					sound.clip().stop();
				}
			}
			currentlyPlaying.clear();
		}
    }
	public void stopMusic() {
		if(currentlyPlaying.size()>0){
			//for (Sound sound : currentlyPlaying) {
			for(int i = 0; i< currentlyPlaying.size(); i++){
				Sound sound = currentlyPlaying.get(i);
				if (sound.clip().isRunning() && sound.type() == 'M') {
					sound.clip().stop();
					currentlyPlaying.remove(sound);
					i--;
				}
			}
		}
    }
	public void stopSoundEffects() {
		if(currentlyPlaying.size()>0){
			for (Sound sound : currentlyPlaying) {
				if (sound.clip().isRunning() && sound.type() == 'S') {
					sound.clip().stop();
				}
			}
		}
    }

	public ArrayList <Sound> currentlyPlaying(){
		return currentlyPlaying;
	}
}