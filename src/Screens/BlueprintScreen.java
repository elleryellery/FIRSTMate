package Screens;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import General.*;
import Screens.Screen;

public class BlueprintScreen extends Screen{
    int choice;
    private TextInterpreter text = new TextInterpreter();
    Notebook myNotebook;
    private ArrayList <Coordinate> coordinates = new ArrayList<Coordinate>();

    private boolean erase = false;

    private static Paintbrush crayon = new Paintbrush(1,true, new ImageIcon("IMG-Buttons/BUTTON-Crayon.png"), new ImageIcon("IMG-Buttons/BUTTON-CrayonSelected.png"), false);

    private static Paintbrush selectedPaintbrush = crayon;

    public BlueprintScreen(){
    super(6,"Blueprint Screen",new ImageIcon("IMG-Screens/SCREEN-BlueprintScreen.png"));
        Credit[] myCredits = {
            
        };

        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-LazyLaura.wav",'M',true,75.0f)
        };
        Button[] myButtons = {
            new Button("Crayon", crayon, 5,5),
            new Button("Eraser", new Paintbrush(1,true, new ImageIcon("IMG-Buttons/BUTTON-Eraser.png"), new ImageIcon("IMG-Buttons/BUTTON-EraserSelected.png"), true), 5,75)

        };
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    // public void setContinueButtonAction(Runnable inputAction){
    //     this.buttons()[2].setAction(inputAction);
    // }

    public void addCoordinate(int x, int y, Color color, int size){
        erase = selectedPaintbrush.eraser();
        if(!erase){
            coordinates.add(new Coordinate(x,y,color,size));
        } else {
            ArrayList<Coordinate> temp = new ArrayList<Coordinate>(coordinates);
            for(Coordinate c: coordinates){
                Rectangle mouse = new Rectangle(x,y,size,size);
                Rectangle coordinate = new Rectangle(c.x(),c.y(),size,size);

                if(mouse.intersects(coordinate)){
                    temp.remove(c);
                }
            }
            coordinates = temp;
        }
    }

    public void putTitle(String inputTitle){
        if(this.buttons()[0] instanceof TextInput){
            TextInput(this.buttons()[0]).setContents(inputTitle);
        }
    }

    public static void setSelectedPaintbrush (Paintbrush inputPaintbrush){
        selectedPaintbrush = inputPaintbrush;
    }
    public static Paintbrush selectedPaintbrush(){
        return selectedPaintbrush;
    }
    public TextInput TextInput(Button b){
        return (General.TextInput)(b);
    }

    public void drawScreenFeatures(Graphics g2d){
        for(Coordinate c: coordinates){
            c.drawCoordinate(g2d);
        }

        g2d.setColor(Color.WHITE);

        g2d.fillRect(0,0,200,650);

        g2d.setColor(Color.BLACK);

        g2d.drawLine(200,0,200,650);
    }
}

