package Structure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.ImageIcon;

import Elements.DataCache;

public class Drawing {
    private ArrayList<Coordinate> points = new ArrayList<Coordinate>();
    private Image picture;
    private int width, height;
    private Draggable draggable;
    private int x, y;
    private int x1, x2, y1, y2;

    public Drawing(){
        x = -3141592;
    }

    public Drawing(ArrayList<Coordinate> _points){
        points = _points;
        x = -3141592;
    }


    public void savePoints(ArrayList<Coordinate> _points){
        points = _points;
    }

    public void draw(){
        for(Coordinate p: points){
            p.drawCoordinate();
        }
    }

    public void giveDraggable(Draggable d){
        draggable = d;
    }

    public Draggable draggable() {
        return draggable;
    }

    public boolean isEmpty(){
        return points.size() == 0;
    }

    public ArrayList<Coordinate> getPoints(){
        return points;
    }

    public String toString(){
        return "Drawing with " + points.size() + " points";
    }

    public void constructImage(){
        BufferedImage back;
        x1 = points.get(0).x();
        x2 = points.get(0).x();
        y1 = points.get(0).y();
        y2 = points.get(0).y();
        for(Coordinate p: points){
            if(p.x() > x1){
                x1 = p.x();
            } else if(p.x() < x2){
                x2 = p.x();
            }

            if(p.y() > y1){
                y1 = p.y();
            } else if(p.y() < y2){
                y2 = p.y();
            }
        }

        int width = x1 - x2 + DataCache.penSize;
        int height = y1-y2 + DataCache.penSize;

        back = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = back.createGraphics();
        for(Coordinate p: points){
            p.drawCoordinate(g, -x2-DataCache.dragXOffset, -y2-DataCache.dragYOffset);
        }

        g.dispose();
        picture = back;

        this.width = width;
        this.height = height;
    }

    public Image asPicture(){
        return picture;
    }

    public int width(){
        return width;
    }
    
    public int height(){
        return height;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int x1() {
        return x1;
    }

    public int y1() {
        return y1;
    }

    public int x2() {
        return x2;
    }

    public int y2() {
        return y2;
    }

}
