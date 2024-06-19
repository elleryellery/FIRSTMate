package Screens;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import General.*;
import Screens.Screen;

public class BlueprintScreen extends Screen{
    int choice;
    private TextInterpreter text = new TextInterpreter();
    Notebook myNotebook;
    private ArrayList <Coordinate> coordinates = new ArrayList<Coordinate>();
    private static Color selectedColor = Color.BLACK;
    private static String selectedColorName = "Black";

    private boolean erase = false;

    private static Paintbrush crayon = new Paintbrush(1,true, new ImageIcon("IMG-Buttons/BUTTON-Crayon.png"), new ImageIcon("IMG-Buttons/BUTTON-CrayonSelected.png"), false);

    private static Paintbrush selectedPaintbrush = crayon;

    public BlueprintScreen(){
    super(6,"Blueprint Screen",new ImageIcon("IMG-Screens/SCREEN-BlueprintScreen.png"));
        Credit[] myCredits = {
            
        };
        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-LazyLaura.wav",'M',true,75.0f)
        };
        Button[] myButtons = {
            new Button("Crayon", crayon, 5,5),
                        
            new Button("AAAA", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-AAAA.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-AAAAHover.png"), 90,0,80,80, () -> { //AAAA
                setSelectedColor(new Color(0,0,0)); //AAAA
                selectedColorName = "AAAA";
            }, () -> selectedColorName.equals("AAAA"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-AAAASelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-AAAASelectedHover.png")),


            new Button("Black", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Black.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BlackHover.png"), 90,0,80,80, () -> {
                setSelectedColor(new Color(0,0,0));
                selectedColorName = "Black";
            }, () -> selectedColorName.equals("Black"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BlackSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BlackSelectedHover.png")),

            new Button("White", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-White.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-WhiteHover.png"), 90,70,80,80, () -> {
                setSelectedColor(new Color(255,255,255));
                selectedColorName = "White";
            }, () -> selectedColorName.equals("White"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-WhiteSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-WhiteSelectedHover.png")),

            new Button("Burgundy", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Burgundy.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BurgundyHover.png"), 0,140,80,80, () -> {
                setSelectedColor(new Color(130, 19, 19));
                selectedColorName = "Burgundy";
            }, () -> selectedColorName.equals("Burgundy"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BurgundySelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BurgundySelectedHover.png")),

            new Button("Teracotta", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Teracotta.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-TeracottaHover.png"), 0,210,80,80, () -> { 
                setSelectedColor(new Color(182, 78, 78));
                selectedColorName = "Teracotta";
            }, () -> selectedColorName.equals("Teracotta"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-TeracottaSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-TeracottaSelectedHover.png")),

            new Button("Orange", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Orange.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-OrangeHover.png"), 0,280,80,80, () -> {
                setSelectedColor(new Color(219, 143, 81));
                selectedColorName = "Orange";
            }, () -> selectedColorName.equals("Orange"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-OrangeSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-OrangeSelectedHover.png")),

            new Button("Yellow", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Yellow.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-YellowHover.png"), 0,350,80,80, () -> {
                setSelectedColor(new Color(235, 212, 91));
                selectedColorName = "Yellow";
            }, () -> selectedColorName.equals("Yellow"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-YellowSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-YellowSelectedHover.png")),

            new Button("Lime", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Lime.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-LimeHover.png"), 0,420,80,80, () -> {
                setSelectedColor(new Color(160, 223, 134));
                selectedColorName = "Lime";
            }, () -> selectedColorName.equals("Lime"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-LimeSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-LimeSelectedHover.png")),

            new Button("Forest", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Forest.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-ForestHover.png"), 0,490,80,80, () -> {
                setSelectedColor(new Color(98, 139, 98));
                selectedColorName = "Forest";
            }, () -> selectedColorName.equals("Forest"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-ForestSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-ForestSelectedHover.png")),

            new Button("Toothpaste", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Toothpaste.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-ToothpasteHover.png"), 90,140,80,80, () -> { //AAAA
                setSelectedColor(new Color(159, 215, 225));
                selectedColorName = "Toothpaste";
            }, () -> selectedColorName.equals("Toothpaste"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-ToothpasteSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-ToothpasteSelectedHover.png")),

            new Button("Teal", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Teal.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-TealHover.png"), 90,210,80,80, () -> {
                setSelectedColor(new Color(59, 144, 171)); 
                selectedColorName = "Teal";
            }, () -> selectedColorName.equals("Teal"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-TealSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-TealSelectedHover.png")),

            new Button("Ice", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Ice.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-IceHover.png"), 90,280,80,80, () -> {
                setSelectedColor(new Color(187, 208, 255));
                selectedColorName = "Ice";
            }, () -> selectedColorName.equals("Ice"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-IceSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-IceSelectedHover.png")),

            new Button("Blueberry", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Blueberry.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BlueberryHover.png"), 90,350,80,80, () -> { 
                setSelectedColor(new Color(83, 94, 150)); 
                selectedColorName = "Blueberry";
            }, () -> selectedColorName.equals("Blueberry"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BlueberrySelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-BlueberrySelectedHover.png")),

            new Button("Midnight", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Midnight.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-MidnightHover.png"), 90,420,80,80, () -> {
                setSelectedColor(new Color(73, 49, 118));
                selectedColorName = "Midnight";
            }, () -> selectedColorName.equals("Midnight"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-MidnightSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-MidnightSelectedHover.png")),

            new Button("Lavender", new ImageIcon("IMG-Buttons\\Colors\\BUTTON-Lavender.png"),new ImageIcon("IMG-Buttons\\Colors\\BUTTON-LavenderHover.png"), 90,490,80,80, () -> { //AAAA
                setSelectedColor(new Color(214, 162, 219));
                selectedColorName = "Lavender";
            }, () -> selectedColorName.equals("Lavender"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-LavenderSelected.png"), new ImageIcon("IMG-Buttons\\Colors\\BUTTON-LavenderSelectedHover.png")),

            new Button("Eraser", new Paintbrush(1,true, new ImageIcon("IMG-Buttons/BUTTON-Eraser.png"), new ImageIcon("IMG-Buttons/BUTTON-EraserSelected.png"), true), 5,75)

        };
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    // public void setContinueButtonAction(Runnable inputAction){
    //     this.buttons()[2].setAction(inputAction);
    // }

    public void addCoordinate(int x, int y, Color color, int size){
        erase = selectedPaintbrush.eraser();
        if(!erase){
            coordinates.add(new Coordinate(x,y,color,size));
        } else {
            ArrayList<Coordinate> temp = new ArrayList<Coordinate>(coordinates);
            for(Coordinate c: coordinates){
                Rectangle mouse = new Rectangle(x,y,size,size);
                Rectangle coordinate = new Rectangle(c.x(),c.y(),size,size);

                if(mouse.intersects(coordinate)){
                    temp.remove(c);
                }
            }
            coordinates = temp;
        }
    }

    public static void setSelectedColor(Color inputColor){
        selectedColor = inputColor;
    }

    public static Color selectedColor(){
        return selectedColor;
    }

    public void putTitle(String inputTitle){
        if(this.buttons()[0] instanceof TextInput){
            TextInput(this.buttons()[0]).setContents(inputTitle);
        }
    }

    public static void setSelectedPaintbrush (Paintbrush inputPaintbrush){
        selectedPaintbrush = inputPaintbrush;
    }
    public static Paintbrush selectedPaintbrush(){
        return selectedPaintbrush;
    }
    public TextInput TextInput(Button b){
        return (General.TextInput)(b);
    }

    public void drawScreenFeatures(Graphics g2d){
        for(Coordinate c: coordinates){
            c.drawCoordinate(g2d);
        }

        g2d.setColor(Color.WHITE);

        g2d.fillRect(0,0,200,650);

        g2d.setColor(Color.BLACK);

        g2d.drawLine(200,0,200,650);
    }
}

