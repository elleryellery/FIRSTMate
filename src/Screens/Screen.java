package Screens;
import java.awt.Graphics;
import javax.swing.ImageIcon;

import General.*;

public class Screen {

	private ImageIcon back;
    private String tag;
    private int ID;
    private SoundPlayer sfx = new SoundPlayer();
    private boolean startPlayer = true;
    Sound[] backgroundSounds; //Stores any background music or sound effects
    Credit[] credits; //Stores all credits for images and sounds used on the screen
    Button[] buttons; //Stores all of the buttons associated with the screen

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

    public void drawScreen(Graphics g2d, int screenWidth, int screenHeight){ //Draws the screen's background image, features, and buttons and, if necessary, starts the background music
        g2d.drawImage(back.getImage(),0,0,screenWidth,screenHeight,null);

        if(startPlayer() && Settings.enabledMusic()){
            for(Sound sound: backgroundSounds){
                sfx().playmusic(sound);
            }
            setStartPlayer(false);
        }

        drawScreenFeatures(g2d);

        for(Button b: buttons){
            b.drawButton(g2d);
        }
    }

    public void drawScreenFeatures(Graphics g2d){ //Method that is overriden by an identically named method in each screen class
        System.err.println("In Screen.java: Default drawScreenFeatures(Graphics g2d) method called.");
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

    public void setButtons(Button[] inputButtons){
        buttons = inputButtons;
    }

    public void setBack(ImageIcon inputBack){
        back = inputBack;
    }

    public void setBackgroundSounds(Sound[] inputBackgroundSounds){
        backgroundSounds = inputBackgroundSounds;
    }

    public Button[] buttons(){
        return buttons;
    }

    public Sound[] backgroundSounds(){
        return backgroundSounds;
    }

    public SoundPlayer sfx(){
        return sfx;
    }

    public boolean startPlayer(){
        return startPlayer;
    }
    public void setStartPlayer(boolean inputStartPlayer){
        startPlayer = inputStartPlayer;
    }
    public void clearButtons(){
        Button[] empty = {};
        buttons = empty;
    }
}


