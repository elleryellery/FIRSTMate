package Screens;
import General.*;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class NewShipScreen extends Screen {

    public NewShipScreen(){
        super(6,"New Ship Screen",new ImageIcon("IMG-Screens/SCREEN-NewShip.png"));
        Credit[] myCredits = {

        };

        Button[] myButtons = {
            new Button("Create Ship Button", new ImageIcon("IMG-Buttons/BUTTON-CreateShip.png"),new ImageIcon("IMG-Buttons/BUTTON-CreateShipHover.png"),470, 400,250,78, () -> {
                Transition strategyScreen = new Transition("Strategy Screen Transition",new ImageIcon("IMG-Screens\\SCREEN-StrategyTransition.png"),2.0,"Strategy Step 1 Screen");
                strategyScreen.completeTransition();
                Game.setShip(new Ship(((TextInput)(this.buttons()[1])).contents()));
            }),
            new TextInput("Input Ship Name", 298, 293, 24, 50, Color.WHITE,false,73)
        };

        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-Ballerina.wav",'M',true,75.0f)
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    public void drawScreenFeatures(Graphics g2d){
        
    }
    
}