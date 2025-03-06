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
    private int xMax, xMin, yMax, yMin;
    private int order = 0;

    public Drawing(){
        x = -3141592;
    }

    public Drawing(ArrayList<Coordinate> _points){
        points = _points;
        x = -3141592;
    }


    public void savePoints(ArrayList<Coordinate> _points){
        points = _points;
        if(order == 0){
            order = DataCache.componentIndex + 1;
        }
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

    public void setOrder(int _order){
        order = _order;
    }

    public int order(){
        return order;
    }

    public void constructImage(){
        try{
            BufferedImage back;
            xMax = points.get(0).x();
            xMin = points.get(0).x();
            yMax = points.get(0).y();
            yMin = points.get(0).y();
            for(Coordinate p: points){
                if(p.x() > xMax){
                    xMax = p.x() + DataCache.penSize;
                } else if(p.x() < xMin){
                    xMin = p.x();
                }

                if(p.y() > yMax){
                    yMax = p.y();
                } else if(p.y() < yMin){
                    yMin = p.y();
                }
            }

            int width = xMax - xMin + DataCache.penSize;
            int height = yMax - yMin + DataCache.penSize;

            back = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = back.createGraphics();
            for(Coordinate p: points){
                p.drawCoordinate(g, -xMin, -yMin);
            }

            g.dispose();
            picture = back;

            this.width = width;
            this.height = height;
        } catch(IndexOutOfBoundsException e){

        }
    }

    public void saveCoords(){
        x = draggable.x();
        y = draggable.y();
    }

    public Image asPicture(){
        return picture;
    }

    public Image asRotatingPicture(double angle){
        ImageRotator rotator = new ImageRotator();
        Image pic = rotator.rotate(picture, angle, (Graphics2D)Game.Graphics());
        return pic;
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

    public int xMax() {
        return xMax;
    }

    public int yMax() {
        return yMax;
    }

    public int xMin() {
        return xMin;
    }

    public int yMin() {
        return yMin;
    }

}
