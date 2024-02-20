package Screens;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;

public class CreditsScreen extends Screen{

    Color blue = new Color(	89, 142, 244);
    private static int creditsIndex = 0;

    public CreditsScreen(){
        super(2,"Credits Screen",new ImageIcon("IMG-Screens/SCREEN-Credits.png"));

        Button[] myButtons = {
            new Button("Credits Button", new ImageIcon("IMG-Buttons/BUTTON-Back.png"),new ImageIcon("IMG-Buttons/BUTTON-BackHover.png"),25, 25,60,60, () -> {
                creditsIndex = 0;
                Game.setScreen(Game.previousString());
            }),
            new Button("Left Arrow Button",new ImageIcon("IMG-Buttons/BUTTON-Left.png"),new ImageIcon("IMG-Buttons/BUTTON-LeftHover.png"),420,430,50,50, () -> {
                if (creditsIndex > 0) {
                    creditsIndex --;
                }
            }),
            new Button("Right Arrow Button",new ImageIcon("IMG-Buttons/BUTTON-Right.png"),new ImageIcon("IMG-Buttons/BUTTON-RightHover.png"),720,430,50,50, () -> {
                if (creditsIndex < Game.previousScreen().credits().length -1) {
                    creditsIndex ++;
                }
            })
        };

        this.setButtons(myButtons);
    }
    public void drawScreenFeatures(Graphics g2d){
        g2d.setColor(blue);
        g2d.fillRect(100,100,1000,400);

        g2d.setColor(Color.WHITE);
        g2d.drawString("Type: " +  Game.previousScreen().credits()[creditsIndex].type(),150,150);
        g2d.drawString("Item: " +  Game.previousScreen().credits()[creditsIndex].item(),150,180);
        g2d.drawString("Source: " +  Game.previousScreen().credits()[creditsIndex].source(),150,210);
        g2d.drawString("License: " +  Game.previousScreen().credits()[creditsIndex].license(),150,240);


    }
}
