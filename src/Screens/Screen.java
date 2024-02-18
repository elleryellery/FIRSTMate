package Screens;
import java.awt.Graphics;
import javax.swing.ImageIcon;

import General.Credit;

public class Screen {

	private ImageIcon back;
    private String tag;
    private int ID;
    Credit[] credits;

    public Screen() {
        back = new ImageIcon("IMG-Screens/SCREEN-ImageNotFound.png");
        tag = "Empty Constructor";
        ID = 0;
	}

	public Screen(int inputID, String inputTag, ImageIcon inputBack) {
        ID = inputID;
        tag = inputTag;
        back = inputBack;
	}

    public void drawScreen(Graphics g2d, int screenWidth, int screenHeight){
        g2d.drawImage(back.getImage(),0,0,screenWidth,screenHeight,null);
    }

    public int ID(){
        return ID;
    }
    
    public String tag() {
        return tag;
    }

    public ImageIcon back() {
        return back;
    }

    public Credit[] credits(){
        return credits;
    }

    public void setCredits(Credit[] inputCredits){
        credits = inputCredits;
    }

}


