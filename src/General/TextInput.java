package General;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import java.awt.Font;


public class TextInput extends Button {
    private String contents = "Ship Name";
    private String name;
    private TextInterpreter textInterpreter = new TextInterpreter();
    private int characterLimit;
    private int fontSize;
    private Color fontColor;
    private boolean multiLineEnabled;
    private int lineCharLim;

    public TextInput(){

    }
    public TextInput(String inputName, int inputX, int inputY, int inputCharacterLimit, int inputFontSize, Color inputFontColor, boolean inputMultiLineEnabled, int inputLineCharLim){
        super(inputName, new ImageIcon(""), new ImageIcon(""),inputX, inputY, (int)(inputCharacterLimit*inputFontSize*0.517), inputFontSize+(int)(inputFontSize*0.2), () -> {});

        this.setAction(() -> {
            Game.setInputStatus(true);
            Game.setInputBox(this);
        });
        name = inputName;
        characterLimit = inputCharacterLimit;
        fontSize = inputFontSize;
        fontColor = inputFontColor;
        multiLineEnabled = inputMultiLineEnabled;
        lineCharLim = inputLineCharLim;
    }

    public void addCharacter(char c){
        if(contents.length()<characterLimit){
            contents += c;
        }
    } 

    public void drawButton(Graphics g2d){
        g2d.setColor(fontColor);
        g2d.setFont(new Font("Times New Roman",Font.BOLD,fontSize));
        g2d.drawRect(x()-10,y()-10,w()+20,h()+20);

        if(System.currentTimeMillis()%1000 < 500 && Game.inputStatus()) {
            textInterpreter.drawText(g2d,contents + "|",x(),y()+fontSize, lineCharLim);
        } else {
            textInterpreter.drawText(g2d,contents,x(),y()+fontSize, lineCharLim);
        }

    }

    public void newLine(){
        contents += "`";
    }
    
    public void deleteCharacter(){
        if(contents.length()>0){
            contents = contents.substring(0,contents.length()-1);
        }
    }
    public void check(int x, int y) {
        super.check(x, y);
    }

    public int contentsLength() {
        return contents.length();
    }

    public String contents() {
        return contents;
    }

    public boolean multiLineEnabled(){
        return multiLineEnabled;
    }
}
