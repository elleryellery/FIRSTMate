package General;

import java.awt.Color;
import java.awt.Graphics;

public class Coordinate {
    int x, y;
    Color color;
    int size;

    public Coordinate(int inputX, int inputY, Color inputColor, int inputSize){
        x = inputX;
        y = inputY;
        color = inputColor;
        size = inputSize;
    }

    public int x(){
        return x;
    }

    public int y(){
        return y;
    }

    public void drawCoordinate(Graphics g2d){
        g2d.setColor(color);
        g2d.fillOval(x,y,size,size);
    }
}
