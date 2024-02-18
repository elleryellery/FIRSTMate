package Screens;

import javax.swing.ImageIcon;

import General.Button;
import General.Credit;
import General.Game;

public class CreditsScreen extends Screen{
    
    public CreditsScreen(){
        super(2,"Credits Screen",new ImageIcon("IMG-Screens/SCREEN-Credits.png"));
        Credit[] myCredits = {
            new Credit("Image","Seagull","pngimg.com: https://pngimg.com/image/5403","No Attribution Required"),
            new Credit("Image","Pirate Ship","Vecteezy: https://www.vecteezy.com/png/21515322-seagull-flying-on-transparent-background-png-file","Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)")
        };

        Button[] myButtons = {
            new Button("Credits Button", new ImageIcon("IMG-Buttons/BUTTON-Back.png"),new ImageIcon("IMG-Buttons/BUTTON-BackHover.png"),25, 25,60,60, () -> {
                Game.setScreen(Game.previousString());
            })
        };

        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
    }
}
