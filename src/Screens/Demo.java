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
            new Button("Full Gameplay", new ImageIcon("IMG-Buttons/BUTTON-FullGameplay.png"),new ImageIcon("IMG-Buttons/BUTTON-FullGameplayHover.png"),100, 250,200,200, () -> {
                Game.setScreen("Opening Screen");
            }),
            new Button("Notebook Input", new ImageIcon("IMG-Buttons/BUTTON-DesignNotebookEntries.png"),new ImageIcon("IMG-Buttons/BUTTON-DesignNotebookEntriesHover.png"),350, 250,200,200, () -> {
                Game.strategyStep2.putTitle("My Design");
                Game.setScreen("Strategy Step 2 Screen");
            }),
            new Button("Notebook Read", new ImageIcon("IMG-Buttons/BUTTON-DesignNotebookReadHover.png"),new ImageIcon("IMG-Buttons/BUTTON-DesignNotebookRead.png"),600, 250,200,200, () -> {
                Notebook defaultNotebook = new Notebook();
                defaultNotebook.addDefaultEntry();
                Game.myShip().setNotebook(defaultNotebook);
                Game.setScreen("Notebook Screen");
            }),
            new Button("Drawing Blueprints", new ImageIcon("IMG-Buttons/BUTTON-DrawingBlueprints.png"),new ImageIcon("IMG-Buttons/BUTTON-DrawingBlueprintsHover.png"),850, 250,200,200, () -> {
                Notebook defaultNotebook = new Notebook();
                defaultNotebook.addDefaultEntry();
                Game.myShip().setNotebook(defaultNotebook);
                Game.setScreen("Blueprint Screen");
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