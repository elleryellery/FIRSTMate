package Structure;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Elements.DataCache;

public class Cannonball extends Wind {
    private double dy;
    private double ay;
    private int slowRate = -3;

    public Cannonball(int dx, int dy){
        super(258, dx);
        this.dy = dy;
        ay = 0.05;
    }

    public void drawCannonball(){
        Game.Graphics().drawImage(new ImageIcon("FIRSTMate-Assets\\M\\Cannonball.png").getImage(), (int)this.x(), this.y(), 100, 100, null);
        move();
    }

    public void move() {
        this.moveX();
        this.moveY((int)dy);
        dy += ay;

        Rectangle me = new Rectangle ((int)super.x(), super.y(), 100, 100);

        for(Drawing d: DataCache.sketchCopy){
            for(int i = 0; i < d.getPoints().size(); i++){
                Coordinate c = d.getPoints().get(i);
                Rectangle coordinate = new Rectangle (c.x() + d.x() - d.x2() - 150, c.y() + d.y() - d.y2(), c.size(), c.size());

                if(coordinate.intersects(me)){
                    slow(slowRate);
                    d.getPoints().remove(c);
                    i ++;
                }
            }  
        }
        
    }
}
