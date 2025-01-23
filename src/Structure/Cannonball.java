package Structure;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Elements.DataCache;

public class Cannonball extends Wind {
    private double dy;
    private double ay;
    private int lives = 10;

    private ArrayList<Drawing> sketchesCopy = new ArrayList <Drawing> ();

    public Cannonball(int dx, int dy){
        super(258, dx);
        this.dy = dy;
        ay = 0.05;

        Drawing[] sketches = DataCache.myShip.retrieveData().ShipSketches;
        sketchesCopy = new ArrayList <Drawing> ();
        for(Drawing d: sketches){
            Drawing copy = new Drawing(d.getPoints());
            // copy.giveDraggable(d.draggable());
            // copy.constructImage();
            copy.setX(d.x());
            copy.setY(d.y());
            copy.constructImage();
            sketchesCopy.add(copy);
        }
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

            for(Drawing d: sketchesCopy){
                for(int i = 0; i < d.getPoints().size(); i++){
                    Coordinate c = d.getPoints().get(i);
                    Rectangle coordinate = new Rectangle (c.x() + d.x() - d.x2() - 150, c.y() + d.y() - d.y2(), c.size, c.size);

                    if(DataCache.debug){
                        Game.Graphics().setColor(c.color);
                        Game.Graphics().drawRect(coordinate.x, coordinate.y, coordinate.width, coordinate.height);
                    }  

                    if(coordinate.intersects(me)){
                        slow(-3);
                        d.getPoints().remove(c);
                        i ++;
                    }
                }  
            }
        
    }
}
