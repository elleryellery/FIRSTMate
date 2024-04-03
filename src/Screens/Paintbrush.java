package Screens;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Paintbrush {
    private boolean fill;
    private int size;
    private ImageIcon icon;
    private ImageIcon selectedIcon;
    private boolean eraser;

    public Paintbrush(int inputSize, boolean inputFill, ImageIcon inputIcon, ImageIcon inputSelectedIcon, boolean inputEraser){
        fill = inputFill;
        size = inputSize;
        icon = inputIcon;
        selectedIcon = inputSelectedIcon;
        eraser = inputEraser;
    }

    public boolean eraser(){
        return eraser;
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

    public ImageIcon selectedIcon(){
        return selectedIcon;
    }

    public void drawOption(int x, int y, Graphics g2d){
        g2d.drawImage(icon.getImage(),x,y,70,70,null);
    }
}
