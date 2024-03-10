package Screens;
import General.*;

import java.awt.Color;
import java.awt.Graphics;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class Transition {
    private ImageIcon transitionImage;
    private String name;
    private double timeInSeconds;
    private String transitionTo;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    Game game = new Game();
    
    public Transition(){
        name = "Blank Constructor Object in: Transition.java";
        transitionImage = new ImageIcon("IMG-Screens/SCREEN-ImageNotFound.png");
        timeInSeconds = 5;
        transitionTo = "No Input";
    }
    public Transition(String inputName, ImageIcon inputTransitionImage, double inputTimeInSeconds, String inputTransitionTo){
        name = inputName;
        transitionImage = inputTransitionImage;
        timeInSeconds = inputTimeInSeconds;
        transitionTo = inputTransitionTo;
    }

    public void completeTransition(){
        
        game.setBlankScreen(transitionImage);
        game.setScreen("Blank Screen");
        scheduler.schedule(() -> {
            game.setScreen(transitionTo);
        }, (long)timeInSeconds, TimeUnit.SECONDS);
    }
}
