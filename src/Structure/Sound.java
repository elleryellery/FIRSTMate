package Structure;
import javax.sound.sampled.*;

public class Sound {

	private String fileName;
    private Clip clip;
    private char type;
    private boolean repeat;
    private int volume;

    public Sound() {
        fileName = "No file";
        type = 'N';
        repeat = false;
    }

	public Sound (String inputFileName, char inputType, boolean inputRepeat) {
        String basepath = "FIRSTMate-Assets\\";
        if(inputType == 'M'){
            basepath += "MUS\\";
        } else {
            basepath += "SFX\\";
        }
        fileName = basepath + inputFileName + ".wav";
        type = inputType;
        repeat = inputRepeat;
        volume = 100;
	}
    
    public Sound (String inputFileName, char inputType, boolean inputRepeat, int inputVolume) {
        String basepath = "FIRSTMate-Assets\\";
        if(inputType == 'M'){
            basepath += "MUS\\";
        } else {
            basepath += "SFX\\";
        }
        fileName = basepath + inputFileName + ".wav";        type = inputType;
        repeat = inputRepeat;
        volume = inputVolume;
	}

    public String fileName(){
        return fileName;
    }

    public Clip clip() {
        return clip;
    }

    public char type(){
        return type;
    }

    public boolean repeat(){
        return repeat;
    }

    public float volume(){
        return volume;
    }
    
    public void setClip(Clip inputClip){
        clip = inputClip;
    }
}