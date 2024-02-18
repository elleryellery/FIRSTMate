package Screens;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;

public class CreditsScreen extends Screen{

    Color blue = new Color(	89, 142, 244);
    int creditsIndex = 0;

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
    public void drawScreenFeatures(Graphics g2d){
        g2d.setColor(blue);
        g2d.fillRect(100,100,1000,400);

        g2d.setColor(Color.WHITE);
        g2d.drawString("Type: " + this.credits[creditsIndex].type(),150,150);
        g2d.drawString("Item: " + this.credits[creditsIndex].item(),150,180);
        g2d.drawString("Source: " + this.credits[creditsIndex].source(),150,210);
        g2d.drawString("License: " + this.credits[creditsIndex].license(),150,240);


    }
}
