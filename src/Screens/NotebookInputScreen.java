package Screens;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;
import Screens.Screen;

public class NotebookInputScreen extends Screen{
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
        Button[] myButtons = {
            new TextInput("Title", 400, 60, 24, 30, Color.BLACK,false,73, false),
            new TextInput("Type here...", 400, 100, 15, 23, Color.BLACK,true,32, false),
            // new Button("Continue", new ImageIcon("IMG-Buttons/BUTTON-NextComponent.png"),new ImageIcon("IMG-Buttons/BUTTON-NextComponentHover.png"),10, 10,250,78,
            // () -> {

            // }),
            new Button("Back Button", new ImageIcon("IMG-Buttons/BUTTON-Back.png"),new ImageIcon("IMG-Buttons/BUTTON-BackHover.png"),25, 25,60,60, () -> {
                Game.setScreen(Game.previousString());
            }),
        };
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    // public void setContinueButtonAction(Runnable inputAction){
    //     this.buttons()[2].setAction(inputAction);
    // }

    public void putTitle(String inputTitle){
        if(this.buttons()[0] instanceof TextInput){
            TextInput(this.buttons()[0]).setContents(inputTitle);
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

