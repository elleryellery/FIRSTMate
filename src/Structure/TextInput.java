package Structure;
import Elements.DataCache;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Font;


public class TextInput extends Button {
    private String contents = "";
    private int x, y, h, w;
    private String id;
    private TextInterpreter textInterpreter = new TextInterpreter();
    private int characterLimit;
    private int fontSize;
    private Color fontColor;
    private boolean multiLineEnabled;
    private int lineCharLim;
    private boolean outlineTextBox;

    public TextInput(){

    }

    public TextInput(String _id, int _x, int _y, int _characterLimit, int _fontSize, Color _fontColor, boolean _multiLineEnabled, int _characterLimitPerLine, boolean _outlineTextBox, String _defaultText){
        super(_id, _x, _y, (int)(_characterLimitPerLine*_fontSize*0.517), _characterLimit*(_fontSize+10)+(int)(_fontSize*0.2), () -> {});

        if(_multiLineEnabled){
            h = _characterLimit*(_fontSize+10)+(int)(_fontSize*0.2);
            w = (int)(_characterLimitPerLine*_fontSize*0.517);
        }

        outlineTextBox = _outlineTextBox;
        id = _id;
        contents = _defaultText;
        characterLimit = _characterLimit;
        fontSize = _fontSize;
        fontColor = _fontColor;
        multiLineEnabled = _multiLineEnabled;
        lineCharLim = _characterLimitPerLine;
    }

    public void actionOnClick(){
        DataCache.inputStatus = true;
        DataCache.inputBox = this;
    }

    public void addCharacter(char c){
        if(contents.length()<characterLimit || (multiLineEnabled && textInterpreter.simulateLines(contents + c + '|', lineCharLim) <= characterLimit) ){
            contents += c;
        }
    }

    public void setContents(String inputContents){
        contents = inputContents;
    }

    public void drawBox(Graphics g2d){
        g2d.setColor(fontColor);
        g2d.setFont(new Font("Times New Roman",Font.BOLD,fontSize));
        
        if(outlineTextBox){
            g2d.drawRect(x-10,y-10,w+20,h+20);
        }
        
        if(System.currentTimeMillis()%1000 < 500 && DataCache.inputStatus && DataCache.inputBox == this) {
            textInterpreter.drawText(g2d,contents + "|",x,y+fontSize, lineCharLim);
        } else {
            textInterpreter.drawText(g2d,contents,x,y+fontSize, lineCharLim);
        }

    }

    public void newLine(){
        contents += textInterpreter.newLineKey;
    }
    
    public void deleteCharacter(){
        if(contents.length()>0){
            contents = contents.substring(0,contents.length()-1);
        }
    }

    public void check(int mouseX, int mouseY) {
        Rectangle mouse = new Rectangle(mouseX,mouseY,1,1);
        Rectangle me = new Rectangle(x,y,w,h);

        if(mouse.intersects(me)){
            actionOnClick();
        } 
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
