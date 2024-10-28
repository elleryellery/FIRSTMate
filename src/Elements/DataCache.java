package Elements;
import Structure.Coordinate;

import java.awt.Color;
import java.util.ArrayList;

import Structure.*;

public class DataCache {
    public static boolean debug = false;
    public static boolean inputStatus = false;
    public static TextInput inputBox = new TextInput();
    public static Screen myScreen;
    public static ArrayList<Screen> history = new ArrayList<Screen> ();
    public static Ship myShip = new Ship();
    public static ArrayList<Ship> ships = new ArrayList<Ship>();
    public static int pageNumber = 0;
    public static ArrayList<Coordinate> drawing = new ArrayList<Coordinate> ();
    public static int penSize = Constants.mediumPen;
    public static Color penColor;
    public static String penType = "Scribble";
    public static boolean drawingEnabled = false;
    public static Coordinate previousCoordinate = new Coordinate();
    public static boolean connectPoints = false;
    public static boolean inFrame = true;
    public static int componentIndex = 0;
    public static Draggable holding;
}
