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
        this.dy = dy * lagFactor();
        this.factorLag(lagFactor());
        ay = 0.4*lagFactor();
    }

    public void drawCannonball(int xOffset, int yOffset){
        Game.Graphics().drawImage(new ImageIcon("FIRSTMate-Assets\\M\\Cannonball.png").getImage(), (int)this.x(), this.y(), 100, 100, null);
        move(xOffset, yOffset);
    }

    public void move(int xOffset, int yOffset) {
        this.moveX();
        this.moveY((int)dy);
        dy += ay;

        Rectangle me = new Rectangle ((int)super.x(), super.y(), 100, 100);

        for(int i = 0; i < DataCache.sketchCopy.size(); i++){
            Coordinate c = DataCache.sketchCopy.get(i);
            Rectangle coordinate = new Rectangle (c.x() + xOffset, c.y() + yOffset, c.size(), c.size());

            if(coordinate.intersects(me)){
                slow(slowRate, lagFactor());
                DataCache.sketchCopy.remove(c);
                i ++;
            }
        }
    }

    public double lagFactor(){
        return 0.000054*(DataCache.myShip.numPoints()) + 0.3;
    }
}
