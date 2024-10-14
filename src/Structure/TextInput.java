package Structure;
import Elements.DataCache;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Font;


public class TextInput extends Button {
    private String contents = "";
    private TextInterpreter textInterpreter = new TextInterpreter();
    private int characterLimit;
    private int fontSize;
    private Color fontColor;
    private boolean multiLineEnabled;
    private int lineCharLim;
    private boolean outlineTextBox;

    public TextInput(){

    }

    public TextInput(int _x, int _y, int _characterLimit, int _fontSize, Color _fontColor, boolean _multiLineEnabled, int _characterLimitPerLine, boolean _outlineTextBox, String _defaultText){
        super("XXX", _x, _y, (int)(_characterLimit*_fontSize*0.517), _fontSize + (int)(_fontSize*0.2), () -> {});

        if(_multiLineEnabled){
            this.setW((int)(_characterLimitPerLine*_fontSize*0.517));
            this.setH(_characterLimit*(_fontSize+10)+(int)(_fontSize*0.2));
        }

        outlineTextBox = _outlineTextBox;
        contents = _defaultText;
        characterLimit = _characterLimit;
        fontSize = _fontSize;
        fontColor = _fontColor;
        multiLineEnabled = _multiLineEnabled;
        lineCharLim = _characterLimitPerLine;

        System.out.println(this.w() + ", " + this.h());
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

    public void drawButton(){
        Game.Graphics().setColor(fontColor);
        Game.Graphics().setFont(new Font("Times New Roman",Font.BOLD,fontSize));
        
        if(outlineTextBox || DataCache.debug){
            Game.Graphics().drawRect(super.x()-10,super.y()-10,super.w()+20,super.h()+20);
        }
        
        if(System.currentTimeMillis()%1000 < 500 && DataCache.inputStatus && DataCache.inputBox == this) {
            textInterpreter.drawText(Game.Graphics(),contents + "|", super.x(), super.y()+fontSize, lineCharLim);
        } else {
            textInterpreter.drawText(Game.Graphics(),contents, super.x(), super.y()+fontSize, lineCharLim);
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

    public boolean check(int mouseX, int mouseY) {
        Rectangle mouse = new Rectangle(mouseX,mouseY,1,1);
        Rectangle me = new Rectangle(super.x(), super.y(), super.w(), super.h());

        if(mouse.intersects(me)){
            actionOnClick();
        } 
        return mouse.intersects(me);
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
