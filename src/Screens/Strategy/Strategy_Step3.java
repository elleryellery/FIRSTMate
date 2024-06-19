package Screens.Strategy;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;
import Screens.Screen;
import Screens.NotebookInputScreen;

import java.util.ArrayList;


public class Strategy_Step3 extends Screen{
    Button[] myButtons2 = new Button[] {};
    int choice;
    private TextInterpreter text = new TextInterpreter();
    Notebook myNotebook;
    int componentIndex =0;

    ArrayList<TextInput> needs = new ArrayList <TextInput> ();
    ArrayList<TextInput> wants = new ArrayList <TextInput> ();
    ArrayList<TextInput> dreams = new ArrayList <TextInput> ();

    ArrayList<Button> totalTextBoxes = new ArrayList <Button> ();

    Credit[] myCredits = {

    };
    Button[] myButtons = {
        new Button("Add Need", new ImageIcon("IMG-Buttons/BUTTON-Add.png"),new ImageIcon("IMG-Buttons/BUTTON-AddHover.png"),170, 180,50,50, () -> {
            addNeed();
        }),
        new Button("Add Want", new ImageIcon("IMG-Buttons/BUTTON-Add.png"),new ImageIcon("IMG-Buttons/BUTTON-AddHover.png"),550, 180,50,50, () -> {
            addWant();
        }),
        new Button("Add Dream", new ImageIcon("IMG-Buttons/BUTTON-Add.png"),new ImageIcon("IMG-Buttons/BUTTON-AddHover.png"),930, 180,50,50, () -> {
            addDream();
        })
    };

    public Strategy_Step3(){
        super(10,"Needs, Wants, Dreams",new ImageIcon("IMG-Screens/SCREEN-NeedsWantsDreams.png"));

        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-Ballerina.wav",'M',true,75.0f)
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    public void addNeed(){
        myButtons[0].addY(150);
        Color needsText = new Color(145,0,0);
        needs.add(new TextInput("Need " + (needs.size()+ 1),125,170 + 150*needs.size(),3,18, needsText,true,14,false));
    }
    public void addWant(){
        myButtons[1].addY(150);
        Color wantsText = new Color(46,128,53);
        wants.add(new TextInput("Want " + (wants.size()+ 1),525,170 + 150*wants.size(),3,18, wantsText,true,14,false));
    }
    public void addDream(){
        myButtons[2].addY(150);
        Color dreamsText = new Color(55,46,128);
        dreams.add(new TextInput("Dream " + (dreams.size()+ 1),895,170 + 150*dreams.size(),3,18, dreamsText,true,14,false));
    }

    public void combineLists(){
        totalTextBoxes.addAll(needs);
        totalTextBoxes.addAll(wants);
        totalTextBoxes.addAll(dreams);
    }

    public void drawAllInList(Graphics g2d, ArrayList<TextInput> a, int x){
        if(a.size()>0){
            int y = 140;
            for(TextInput n: a){
                g2d.drawImage(new ImageIcon("IMG-Miscellaneous/MISC-StickyNote.png").getImage(),x,y, 150,150,null);
                n.drawButton(g2d);
                y += 150;
            }
        }
    }

    public void drawScreenFeatures(Graphics g2d){
        combineLists();
        Game.setAdditionalButtons(totalTextBoxes);
        drawAllInList(g2d, needs, 110);
        drawAllInList(g2d, wants, 510);
        drawAllInList(g2d, dreams, 880);
    }
}

