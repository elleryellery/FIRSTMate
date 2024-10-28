package Structure;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.*;

import javax.swing.ImageIcon;

public class Drawing {
    private ArrayList<Coordinate> points = new ArrayList<Coordinate>();
    private Image picture;
    private int width, height;

    public Drawing(){

    }

    public Drawing(ArrayList<Coordinate> _points){
        points = _points;
    }


    public void savePoints(ArrayList<Coordinate> _points){
        points = _points;
    }

    public void draw(){
        for(Coordinate p: points){
            p.drawCoordinate();
        }
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
        int x1 = points.get(0).x();
        int x2 = points.get(0).x();
        int y1 = points.get(0).y();
        int y2 = points.get(0).y();
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
        int width = x1 - x2;
        int height = y1-y2;

        System.out.println(width + ", " + height);

        back = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = back.createGraphics();
        for(Coordinate p: points){
            p.drawCoordinate(g);
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

}
