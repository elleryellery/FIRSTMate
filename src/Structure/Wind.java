package Structure;

import javax.swing.ImageIcon;

public class Wind {
    private int x = -100;
    private int y = 0;
    private int dx = 5;

    public Wind(){
        y = (int)(Math.random() * 500);
        dx = (int)(Math.random() * 6) + 1;
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
        Game.Graphics().drawImage(new ImageIcon("FIRSTMate-Assets\\M\\Wind.png").getImage(), x, y, 100, 100, null);
        move();
    }
}
