package Structure;

import java.awt.Color;
import java.awt.Graphics;

public class Coordinate {
    int x, y;
    Color color;
    int size;

    public Coordinate(){
        x = 0;
        y = 0;
    }

    public Coordinate(String x, String y, String color, String size){
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.size = Integer.parseInt(size);
    }

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

    public void drawCoordinate(){
        Game.Graphics().setColor(color);
        Game.Graphics().fillOval(x,y,size,size);
    }

    public void drawCoordinate(Graphics g, int xModifier, int yModifier){
        g.setColor(color);
        g.fillOval(x + xModifier, y + yModifier,size,size);
    }

    public String toString(){
        return x + " " + y + " " + color + " " + size;
    }
}
