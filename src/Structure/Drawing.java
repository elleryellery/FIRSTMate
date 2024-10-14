package Structure;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Drawing {
    private ArrayList<Coordinate> points = new ArrayList<Coordinate>();

    public Drawing(){

    }

    public Drawing(ArrayList<Coordinate> _points){
        points = _points;
    }

    public ImageIcon constructImage(){
        //TODO convert points into an ImageIcon by adding them onto a BufferedImage and typecasting to ImageIcon
        return new ImageIcon();
    }

    public void savePoints(ArrayList<Coordinate> _points){
        points = _points;
    }

    public void draw(){
        for(Coordinate p: points){
            p.drawCoordinate();
        }
    }

}
