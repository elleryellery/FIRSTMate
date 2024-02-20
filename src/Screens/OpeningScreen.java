package Screens;
import General.*;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class OpeningScreen extends Screen {

    public OpeningScreen(){
        super(1,"Opening Screen",new ImageIcon("IMG-Screens/SCREEN-OpeningScreen.gif"));
        Credit[] myCredits = {
            new Credit("Image","Seagull","pngimg.com: https://pngimg.com/image/5403","No Attribution Required"),
            new Credit("Image","Pirate Ship","Vecteezy: https://www.vecteezy.com/png/21515322-seagull-flying-on-transparent-background-png-file","Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)"),
            new Credit("Sound","Seagull Sounds","'sg03' by Pixabay on Pixabay: https://pixabay.com/sound-effects/sg03-55932/","No Attribution Required"),
            new Credit("Music","Title Screen Background Music","'Emerald Seas' by Aaron Kenny on YouTube Studio Audio Library: https://www.youtube.com/channel/UCVAggfwI4hnkA2WO6-xC06Q","YouTube Audio Library License (No Attribution Required)")
        };

        Button[] myButtons = {
            new Button("Credits Button", new ImageIcon("IMG-Buttons/BUTTON-Credits.png"),new ImageIcon("IMG-Buttons/BUTTON-CreditsHover.png"),1137, 561,50,50, () -> {
                Game.setScreen("Credits Screen");
            }),
            new Button("Releases Button", new ImageIcon("IMG-Buttons/BUTTON-ReleaseNotes.png"),new ImageIcon("IMG-Buttons/BUTTON-ReleaseNotesHover.png"),1080, 561,50,50, () -> {
                Game.setScreen("Releases Screen");
            }),
            new Button("Settings Button", new ImageIcon("IMG-Buttons/BUTTON-Settings.png"),new ImageIcon("IMG-Buttons/BUTTON-SettingsHover.png"),1137, 10,50,50, () -> {
                Game.setScreen("Settings Screen");
            }, () -> Settings.volume()>50.0, new ImageIcon("IMG-Buttons/BUTTON-ReleaseNotes.png"))
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
    }

    public void drawScreenFeatures(Graphics g2d){
        if(startPlayer()){
            sfx().playmusic('M',"SFX-SoundEffects/SOUNDEFFECT-Seagulls.wav", true,95.0f);
            sfx().playmusic('S',"SFX-Music/MUSIC-EmeraldSeas.wav", true,85.0f);
            setStartPlayer(false);
        }
    }

}