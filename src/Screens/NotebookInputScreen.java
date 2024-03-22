package Screens;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;
import Screens.Screen;

public class NotebookInputScreen extends Screen{
    Button[] myButtons = {
        new TextInput("Title", 400, 60, 24, 30, Color.BLACK,false,73),
        new TextInput("Type here...", 400, 100, 15, 23, Color.BLACK,true,32)
    };
    int choice;
    private TextInterpreter text = new TextInterpreter();
    Notebook myNotebook;

    public NotebookInputScreen(){
    super(6,"Notebook Input Screen",new ImageIcon("IMG-Screens/SCREEN-NotebookEntry.png"));
        Credit[] myCredits = {
            
        };

        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-LazyLaura.wav",'M',true,75.0f)
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    public void putTitle(String inputTitle){
        if(myButtons[0] instanceof TextInput){
            TextInput(myButtons[0]).setContents(inputTitle);
        }
    }

    public TextInput TextInput(Button b){
        return (General.TextInput)(b);
    }

    public void drawScreenFeatures(Graphics g2d){
        g2d.setColor(Color.BLACK);
        java.time.LocalDateTime date = java.time.LocalDateTime.now();
        text.drawText(g2d,date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute(),400,50,30);
    }
}

