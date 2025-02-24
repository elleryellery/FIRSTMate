package Structure;
import Elements.Settings;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;

public class SoundPlayer {

	private ArrayList<Sound> currentlyPlaying = new ArrayList();

	public void playmusic(Sound sound) {
        File soundFile = new File(sound.fileName());
		boolean allowedSound = (sound.type() == 'S' && Settings.enabledSoundEffects);
		boolean isMusic = sound.type() == 'M';
		boolean notPlaying = (playing(sound) == null);

		try {
			if((allowedSound || isMusic) && notPlaying) {

				sound.setClip(AudioSystem.getClip());
				AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile);
				sound.clip().open(inputStream);

				float volume = sound.volume() * (Settings.volume / 100.0f);

				FloatControl gainControl = (FloatControl) sound.clip().getControl(FloatControl.Type.MASTER_GAIN);
				float range = gainControl.getMaximum() - gainControl.getMinimum();
				float gain = (range * volume / 100.0f) + gainControl.getMinimum();
				gainControl.setValue(gain);

				if (!sound.clip().isControlSupported(FloatControl.Type.MASTER_GAIN)) {
					System.err.println("SoundPlayer.java: Volume changes are not supported.");
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

	public Sound playing(Sound sound){
		if(currentlyPlaying.size() == 0){
			return null;
		} else {
			for(Sound s: currentlyPlaying){
				if(s.fileName().equals(sound.fileName())){
					return s;
				}
			}
			return null;
		}
	}
	
	public void stopMusic() {
		if(currentlyPlaying.size()>0){
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

	public void stopNonDuplicateSounds(Sound[] sounds){
		ArrayList<Sound> keepPlaying = new ArrayList<Sound>();

		for(Sound playing: currentlyPlaying){
			for(Sound sound: sounds){
				if(sound.fileName().equals(playing.fileName())){
					keepPlaying.add(sound);
				}
			}
		}

		for(Sound s: currentlyPlaying){
			if(!keepPlaying.contains(s)){
				if (s.clip().isRunning()) {
					s.clip().stop();
				}
			}
		}

		currentlyPlaying = keepPlaying;
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