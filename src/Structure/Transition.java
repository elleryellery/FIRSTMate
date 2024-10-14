package Structure;

import java.awt.Color;
import java.awt.Graphics;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;

public class Transition extends Screen{
    private double timeInSeconds;
    private Screen transitionTo;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    
    public Transition(){
        super();
    }

    public Transition(String _tag, ImageIcon _transitionImage, double _timeInSeconds, Screen _transitionTo){
        super(_tag);
        timeInSeconds = _timeInSeconds;
        transitionTo = _transitionTo;
        Runnable script = () -> scheduler.schedule(() -> {
            Game.setScreen(transitionTo);
        }, (long)timeInSeconds, TimeUnit.SECONDS);
        this.addScript(script);
    }
}
