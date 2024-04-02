package Screens;
import General.*;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Demo extends Screen {

    public Demo(){
        super(0,"Demo Screen",new ImageIcon("IMG-Screens/SCREEN-Demo.png"));
        Credit[] myCredits = {
            
        };

        Button[] myButtons = {
            new Button("Full Gameplay", new ImageIcon("IMG-Buttons/BUTTON-FullGameplay.png"),new ImageIcon("IMG-Buttons/BUTTON-FullGameplayHover.png"),200, 200,200,200, () -> {
                Game.setScreen("Opening Screen");
            })
        };

        Sound[] myBackgroundSounds = {
            new Sound("SFX-SoundEffects/SOUNDEFFECT-Seagulls.wav", 'M', true, 95.0f),
            new Sound("SFX-Music/MUSIC-EmeraldSeas.wav", 'M', true,85.0f)
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    public void drawScreenFeatures(Graphics g2d){

    }
}