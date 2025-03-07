package Structure;
import java.awt.Color;
import java.awt.Font;

import Elements.DataCache;
import Elements.Settings;

public class TutorialBox {
    private int x, y, w, h, chars;
    private Condition condition;
    private String text;
    private TextInterpreter t;

    public TutorialBox(String text, Condition condition){
        this.text = text;
        t = new TextInterpreter();
        x = 442;
        y = 419;
        w = 321;
        h = 140;
        chars = 34;
        this.condition = condition;
    }

    public TutorialBox(String text, Condition condition, int x, int y){
        this.text = text;
        t = new TextInterpreter();
        this.x = x;
        this.y = y;
        w = 321;
        h = 140;
        chars = 34;
        this.condition = condition;
    }

    public interface Condition {
        boolean evaluate();
    }

    public void drawTutorialBox(){
        int xPadding = 20;
        int yPadding = 35;
        Game.Graphics().setColor(Color.WHITE);
        Game.Graphics().fillRoundRect(x-xPadding, y-yPadding, w+xPadding, h+yPadding, 30, 30);
        Game.Graphics().setColor(Color.BLACK);
        Game.Graphics().setFont(new Font("Times New Roman", Font.BOLD, 20));
        t.drawText(Game.Graphics(), text, x, y, chars);
    }

    public void check(){
        if(condition.evaluate() && Settings.tutorialModeEnabled){
            if(DataCache.tutorials.peek() == null){
                DataCache.tutorials.pop();
            }
        } else if(DataCache.tutorials.peek() != null){
            DataCache.tutorials.add(0, null);
        }
    }

    public String toString(){
        return text;
    }


}
