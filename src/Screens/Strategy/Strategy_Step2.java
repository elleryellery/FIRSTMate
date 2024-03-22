package Screens.Strategy;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;
import Screens.Screen;
import Screens.NotebookInputScreen;

public class Strategy_Step2 extends NotebookInputScreen{
    Button[] myButtons2 = new Button[] {};
    int choice;
    private TextInterpreter text = new TextInterpreter();
    Notebook myNotebook;

    public Strategy_Step2(){
        super();
        super.putTitle(Game.components()[0]);
    }

    public void drawScreenFeatures(Graphics g2d){
        g2d.setColor(Color.BLACK);
        java.time.LocalDateTime date = java.time.LocalDateTime.now();
        text.drawText(g2d,date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute(),400,50,30);
    }
}

