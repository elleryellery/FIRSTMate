package Screens.Strategy;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;
import Screens.Screen;

public class Strategy_Step2 extends Screen{
    Button[] myButtons2 = new Button[] {};
    int choice;
    private TextInterpreter text = new TextInterpreter();
    Notebook myNotebook;

    public Strategy_Step2(){
    super(6,"New Ship Screen",new ImageIcon("IMG-Screens/SCREEN-NotebookEntry.png"));
        Credit[] myCredits = {

        };

        Button[] myButtons = {
            
        };

        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-LazyLaura.wav",'M',true,75.0f)
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    public void drawScreenFeatures(Graphics g2d){
        g2d.setColor(Color.BLACK);
        java.time.LocalDateTime date = java.time.LocalDateTime.now();
        text.drawText(g2d,date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute(),400,50,30);
    }
}

