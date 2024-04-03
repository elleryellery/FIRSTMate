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
    private Paintbrush[] paintbrushes = {new Paintbrush(1,true, new ImageIcon("IMG-Buttons/BUTTON-Crayon.png"))};
    private Paintbrush selectedPaintbrush = paintbrushes[0];
    private boolean erase = false;

    public BlueprintScreen(){
    super(6,"Blueprint Screen",new ImageIcon("IMG-Screens/SCREEN-BlueprintScreen.png"));
        Credit[] myCredits = {
            
        };

        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-LazyLaura.wav",'M',true,75.0f)
        };
        Button[] myButtons = {
            new Button("Back Button", new ImageIcon("IMG-Buttons/BUTTON-Back.png"),new ImageIcon("IMG-Buttons/BUTTON-BackHover.png"),25, 25,60,60, () -> {
                erase = !erase;
            }),
        };
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    // public void setContinueButtonAction(Runnable inputAction){
    //     this.buttons()[2].setAction(inputAction);
    // }

    public void addCoordinate(int x, int y, Color color, int size){
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

    public TextInput TextInput(Button b){
        return (General.TextInput)(b);
    }

    public void drawScreenFeatures(Graphics g2d){
        for(Coordinate c: coordinates){
            c.drawCoordinate(g2d);
        }

        g2d.setColor(Color.WHITE);

        g2d.fillRect(0,0,200,650);

        int paintbrushY = 5;

        for(Paintbrush p: paintbrushes){
            p.drawOption(5,paintbrushY,g2d);
            paintbrushY += 50;
        }

        g2d.setColor(Color.BLACK);

        g2d.drawLine(200,0,200,650);
    }
}

