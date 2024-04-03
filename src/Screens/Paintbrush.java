package Screens;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Paintbrush {
    private boolean fill;
    private int size;
    private ImageIcon icon;

    public Paintbrush(int inputSize, boolean inputFill, ImageIcon inputIcon){
        fill = inputFill;
        size = inputSize;
        icon = inputIcon;
    }

    public boolean fill(){
        return fill;
    }

    public int size(){
        return size;
    }

    public ImageIcon icon(){
        return icon;
    }

    public void drawOption(int x, int y, Graphics g2d){
        g2d.drawImage(icon.getImage(),x,y,70,70,null);
    }
}
