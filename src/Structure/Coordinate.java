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
}
