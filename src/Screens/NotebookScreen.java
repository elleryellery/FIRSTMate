package Screens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;

public class NotebookScreen extends Screen{

    Color blue = new Color(	89, 142, 244);
    private static int page = 0;
    private TextInterpreter text = new TextInterpreter();
    Notebook myNotebook;


    public NotebookScreen(){
        super(2,"Credits Screen",new ImageIcon("IMG-Screens/SCREEN-Notebook.png"));

        Button[] myButtons = {
            new Button("Left Arrow Button",new ImageIcon("IMG-Buttons/BUTTON-Left.png"),new ImageIcon("IMG-Buttons/BUTTON-LeftHover.png"),200,500,50,50, () -> {
                if (page > 0) {
                    page --;
                }
            }, () -> !(page > 0), new ImageIcon("IMG-Buttons/BUTTON-LeftDisabled.png"), new ImageIcon("IMG-Buttons/BUTTON-LeftDisabled.png")),
            new Button("Right Arrow Button",new ImageIcon("IMG-Buttons/BUTTON-Right.png"),new ImageIcon("IMG-Buttons/BUTTON-RightHover.png"),940,500,50,50, () -> {
                if (page < myNotebook.fields().size() -2) {
                    page +=2;
                }
            }, () -> !(page < myNotebook.fields().size() -2), new ImageIcon("IMG-Buttons/BUTTON-RightDisabled.png"), new ImageIcon("IMG-Buttons/BUTTON-RightDisabled.png"))
        };
        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-Ballerina.wav",'M',true,75.0f)
        };

        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }
    
    public void drawScreenFeatures(Graphics g2d){        
        g2d.setColor(Color.BLACK);
        g2d.setFont( new Font("Times New Roman", Font.BOLD, 23));

        text.drawText(g2d,myNotebook.fieldDates().get(page) + "`" +
        myNotebook.fields().get(page).name() + "``" +
        myNotebook.fields().get(page).entry() + "`",220,90,30);

        if(myNotebook.fields().size()%2 == 0){
            text.drawText(g2d,myNotebook.fieldDates().get(page+1) + "`" +
            myNotebook.fields().get(page+1).name() + "``" +
            myNotebook.fields().get(page+1).entry(),640,90,35);
        }
    }

    public void setNotebook(Notebook inputNotebook){
        myNotebook = inputNotebook;
    }

    public void setPage(int inputPage){
        page = inputPage;
    }
}
