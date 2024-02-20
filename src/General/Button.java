package General;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Button {
    
    private String name;
    private int x,y,w,h;
    private ImageIcon icon;
    private ImageIcon iconRegular;
    private ImageIcon iconHover;
    private Runnable action;
    private Condition condition;
    private ImageIcon conditionalAppearance;

    public Button(){
        name = "Button.java: Empty Constructor";
        x = 0;
        y = 0;
        w = 0;
        h = 0;
        icon = new ImageIcon("Empty.png");
    }

    public Button(String inputName, ImageIcon inputIconRegular, ImageIcon inputIconHover, int inputX, int inputY, int inputW, int inputH, Runnable inputAction){
        name = inputName;
        iconRegular = inputIconRegular;
        iconHover = inputIconHover;
        icon = iconRegular;
        x = inputX;
        y = inputY;
        w = inputW;
        h = inputH;
        action = inputAction;
    }

    public Button(String inputName, ImageIcon inputIconRegular, ImageIcon inputIconHover, int inputX, int inputY, int inputW, int inputH, Runnable inputAction, Condition inputCondition, ImageIcon inputConditionalAppearance){
        name = inputName;
        iconRegular = inputIconRegular;
        iconHover = inputIconHover;
        icon = iconRegular;
        x = inputX;
        y = inputY;
        w = inputW;
        h = inputH;
        action = inputAction;
        condition = inputCondition;
        conditionalAppearance = inputConditionalAppearance;
    }

    public interface Condition {
        boolean evaluate();
    }

    public void executeButtonAction(){
        action.run();
    }

    public void drawButton (Graphics g2d){
        g2d.drawImage(icon.getImage(),x,y,w,h,null);
        if (condition == null || condition.evaluate()) {
            g2d.drawImage(icon.getImage(),x,y,w,h,null);
        } else {
            if(icon != iconHover){
                icon = conditionalAppearance;
            }
            g2d.drawImage(icon.getImage(),x,y,w,h,null);
        }
    }

    public void check(int mouseX, int mouseY){
        Rectangle mouse = new Rectangle(mouseX,mouseY,1,1);
        Rectangle me = new Rectangle(x,y,w,h);

        if(mouse.intersects(me)){
            executeButtonAction();
            icon = iconRegular;
        }
    }

    public void checkHover(int mouseX, int mouseY){
        Rectangle mouse = new Rectangle(mouseX,mouseY,1,1);
        Rectangle me = new Rectangle(x,y,w,h);

        if(mouse.intersects(me)){
            icon = iconHover;
        } else {
            icon = iconRegular;
        }
    }
}
