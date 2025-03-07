package Structure;

import javax.swing.ImageIcon;

public class Wind {
    private double x = -100;
    private int y = 0;
    private double dx = 5;

    public Wind(){
        y = (int)(Math.random() * 500);
        dx = (int)(Math.random() * 6) + 1;
    }

    public Wind(int y, int dx){
        this.y = y;
        this.dx = dx;
    }

    public void move(){
        x += dx;
        if(x >= 1200){
            x = -100;
            y = (int)(Math.random() * 500);
            dx = (int)(Math.random() * 6) + 4;
        }
    }


    public void drawWind(){
        Game.Graphics().drawImage(new ImageIcon("FIRSTMate-Assets\\M\\Wind.png").getImage(), (int)x, y, 100, 100, null);
        move();
    }

    public double x() {
        return x;
    }

    public int y() {
        return y;
    }

    public void moveX(){
        x += dx;
    }

    public void moveY(int dy){
        y += dy;
    }

    public void stop(){
        dx = 0;
    }

    public void slow(double slowRate, double lagRate) {
        dx *= (1-(Math.pow(10, slowRate))*lagRate);
    }

    public void factorLag(double lagFactor){
        dx *= lagFactor;
    }
}
