package Screens;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;

public class BlankScreen extends Screen{


    public BlankScreen(){
        super(5,"Blank Screen",new ImageIcon("IMG-Screens/SCREEN-ImageNotFound.png"));
        Sound[] myBackgroundSounds = {
        };
        Button[] myButtons = {
        };
        
        this.setBackgroundSounds(myBackgroundSounds);
        this.setButtons(myButtons);
    }
    public BlankScreen(ImageIcon image){
        super(5,"Blank Screen",image);
        Sound[] myBackgroundSounds = {
            new Sound("SFX-SoundEffects/SOUNDEFFECT-StageChange.wav",'S',true,85.0f)
        };
        Button[] myButtons = {
        };
        
        this.setBackgroundSounds(myBackgroundSounds);
        this.setButtons(myButtons);
    }
    
    public void drawScreenFeatures(Graphics g2d){
        
    }
}
