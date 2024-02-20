package Screens;
import General.*;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Settings extends Screen {

    private static boolean enabledSoundEffects = true;
    private static boolean enabledMusic = true;
    private static double volume = 100.0;

    public static double volume(){
        return volume;
    }


    public static boolean enabledSoundEffects(){
        return enabledSoundEffects;
    }

    public static boolean enabledMusic(){
        return enabledMusic;
    }

    public Settings(){
        super(4,"Settings Screen",new ImageIcon("IMG-Screens/SCREEN-Settings.png"));
        Credit[] myCredits = {
        };

        Button[] myButtons = {
            new Button("Back Button", new ImageIcon("IMG-Buttons/BUTTON-Back.png"),new ImageIcon("IMG-Buttons/BUTTON-BackHover.png"),25, 25,60,60, () -> {
                Game.setScreen(Game.previousString());
            })
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
    }

    public void drawScreenFeatures(Graphics g2d){
        if(startPlayer()){
            sfx().playmusic('M',"SFX-Music/MUSIC-Ballerina.wav", true,75.0f);
            setStartPlayer(false);
        }
    }

}