package Screens;
import General.*;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class OpeningScreen extends Screen {


    public OpeningScreen(){
        super(1,"Opening Screen",new ImageIcon("IMG-Screens/SCREEN-OpeningScreen.gif"));
        Credit[] myCredits = {
            new Credit("Image","Seagull","pngimg.com: https://pngimg.com/image/5403","No Attribution Required"),
            new Credit("Image","Pirate Ship","Vecteezy: https://www.vecteezy.com/png/21515322-seagull-flying-on-transparent-background-png-file","Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)")
        };

        Button[] myButtons = {
            new Button("Credits Button", new ImageIcon("IMG-Buttons/BUTTON-Credits.png"),new ImageIcon("IMG-Buttons/BUTTON-CreditsHover.png"),1137, 561,50,50, () -> {
                Game.setScreen("Credits Screen");
            })
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
    }

    public void drawScreenFeatures(Graphics g2d){
        
    }

}