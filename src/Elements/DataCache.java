package Elements;
import Structure.Coordinate;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;

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
    public static int dragXOffset;
    public static int dragYOffset;
    public static int shipIndex;
    public static int waterLevel = 0;
    public static int shipLevel = 0;
    public static ArrayList<Wind> winds = new ArrayList <Wind> ();
    public static Cannonball cannonball = null;
    public static ArrayList <Coordinate> sketchCopy = new ArrayList <Coordinate> ();
    public static String failureMessage = "";
    public static int shipTestPos = -150;
    public static boolean enabledCannons = false;
    public static LinkedList<TutorialBox> tutorials = new LinkedList<TutorialBox>();
    public static int numCannonballsReleased = 0;
    public static int creditIndex = 0;
    public static int releaseIndex = 0;
    public static Coordinate lineStart = null;
    public static Coordinate lineEnd = null;
    public static double steeringRotation = 0.0;
}
