package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;

public class ReleasesScreen extends Screen{

    Color blue = new Color(	89, 142, 244);
    private static int releaseIndex = 0;

    String [] patches1_0 = {"None"};
    String [] features1_0 = {"Title screen", "Credits", "In-game release notes", "Sound"};

    Release[] releases = {
        new Release("1.0","February 30, 2024", "Created game foundations", patches1_0, features1_0,new ImageIcon("IMG-ReleaseBanners/RELEASEBANNER-1_0.png"))
    };

    public ReleasesScreen(){
        super(3,"Releases Screen",new ImageIcon("IMG-Screens/SCREEN-Releases.png"));

        Button[] myButtons = {
            new Button("Credits Button", new ImageIcon("IMG-Buttons/BUTTON-Back.png"),new ImageIcon("IMG-Buttons/BUTTON-BackHover.png"),25, 25,60,60, () -> {
                releaseIndex = 0;
                Game.setScreen(Game.previousString());
            }),
            new Button("Left Arrow Button",new ImageIcon("IMG-Buttons/BUTTON-Left.png"),new ImageIcon("IMG-Buttons/BUTTON-LeftHover.png"),420,480,50,50, () -> {
                if (releaseIndex > 0) {
                    releaseIndex --;
                }
            }),
            new Button("Right Arrow Button",new ImageIcon("IMG-Buttons/BUTTON-Right.png"),new ImageIcon("IMG-Buttons/BUTTON-RightHover.png"),720,480,50,50, () -> {
                if (releaseIndex < releases.length -1) {
                    releaseIndex ++;
                }
            })
        };
        
        this.setButtons(myButtons);
    }
    public void drawScreenFeatures(Graphics g2d){
        g2d.setColor(Color.BLACK);
        g2d.fillRect(100,100,1000,450);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setFont( new Font("Times New Roman", Font.PLAIN, 17));
        g2d.drawImage(releases[releaseIndex].bannerImage().getImage(),110,110,980,100,null);
        g2d.drawString("Version Number: " + releases[releaseIndex].versionNumber(),150,250);
        g2d.drawString("Release Date: " + releases[releaseIndex].releaseDate(),150,270);
        g2d.drawString("Summary: " + releases[releaseIndex].summary(),150,290);
        g2d.setColor(Color.WHITE);
        g2d.setFont( new Font("Times New Roman", Font.BOLD, 17));
        g2d.drawString("Features: ",150,310);
        g2d.drawString("Bug Fixes and Patches: ",620,310);

        g2d.drawString("For more detailed release notes, visit our Github page linked on our team website!",310,580);

        g2d.setFont( new Font("Times New Roman", Font.PLAIN, 17));
        g2d.setColor(Color.LIGHT_GRAY);

        int yPlacement = 330;
        for(String f: releases[releaseIndex].features()){
            g2d.drawString("     ‣    " + f,150,yPlacement);
            yPlacement+=20;
        }

        yPlacement = 330;
        for(String p: releases[releaseIndex].patches()){
            g2d.drawString("     ‣    " + p,620,yPlacement);
            yPlacement+=20;
        }

    }
}
