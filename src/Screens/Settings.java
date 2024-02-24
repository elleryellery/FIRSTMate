package Screens;
import General.*;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Settings extends Screen {

    private static boolean enabledSoundEffects = true;
    private static boolean enabledMusic = true;
    private static float volume = 1.0f;

    public static float volume(){
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
            }),
            new Button("Music Toggle", new ImageIcon("IMG-Buttons/BUTTON-EnabledToggle.png"),new ImageIcon("IMG-Buttons/BUTTON-EnabledToggleHover.png"), 800,400,200,100, () -> {
                enabledMusic = !enabledMusic;
                if(!enabledMusic){
                    sfx().stopAllSounds();
                } else {
                    setStartPlayer(true);
                }
            }, () -> !enabledMusic, new ImageIcon("IMG-Buttons/BUTTON-DisabledToggle.png"), new ImageIcon("IMG-Buttons/BUTTON-DisabledToggleHover.png"))
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
    }

    public void drawScreenFeatures(Graphics g2d){
        if(startPlayer() && enabledMusic){
            sfx().playmusic('M',"SFX-Music/MUSIC-Ballerina.wav", true,75.0f);
            setStartPlayer(false);
        }
        g2d.drawImage(new ImageIcon("IMG-Miscellaneous/MISC-PlatypusAndGears.png").getImage(),108,103,628,431,null);
    }

}