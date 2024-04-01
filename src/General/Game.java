package General;
import Screens.*;
import Screens.Strategy.*;

import javax.swing.*;
import Screens.Screen;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.*; 

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	
	//Management Variables
	private BufferedImage back; 
	private File file;
		
	//Numbers
	private int key;

	//Strings and Characters
	private char keyChar;
	private static String screen = "Opening Screen";
	private static Screen myScreen;
	private static String previousScreen;
	private static Screen previousScreenObject;

	private static String[] myComponents = new String[] {"empty"};


	//Objects
	private static OpeningScreen openingScreen = new OpeningScreen();
	private static CreditsScreen creditsScreen = new CreditsScreen();
	private static ReleasesScreen releasesScreen = new ReleasesScreen();
	private static Settings settingsScreen = new Settings();
	private static BlankScreen blankScreen = new BlankScreen();
	private static NewShipScreen newShipScreen = new NewShipScreen();
	private static NotebookScreen notebookScreen = new NotebookScreen();
	private static Strategy_Step1 strategyStep1 = new Strategy_Step1();
	private static Strategy_Step2 strategyStep2 = new Strategy_Step2();
	private static Strategy_Step3 strategyStep3 = new Strategy_Step3();

	private static ArrayList <Button> additionalButtons = new ArrayList<Button> ();

	private static Graphics g2d;

	private static boolean inputStatus = false;
	private static TextInput inputBox = new TextInput();

	private static Ship myShip = new Ship();

	private ArrayList <Screen> gameScreens = new ArrayList <Screen> ();

	public Game() {
		
		//Create a new thread that handles input from the keyboard and mouse
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
			
	}

	//Run the thread
	public void run(){
	   	try{
	   		while(true){
	   		   Thread.currentThread().sleep(5);
	        	repaint();
	        }
	    } catch(Exception e) {
	   			
	    }
	}
	
	public void paint(Graphics g){
		
		//Graphics setup
		Graphics2D twoDgraph = (Graphics2D) g; 
		if(back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
				
		g2d = back.createGraphics();
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setFont( new Font("Times New Roman", Font.BOLD, 20));
		g2d.setColor(Color.GREEN);
		((Graphics2D) g2d).setStroke(new BasicStroke(10));

		//Draw all characteristics of the current screen
		setScreen();
		myScreen.drawScreen(g2d,getWidth(),getHeight());
						
		twoDgraph.drawImage(back, null, 0, 0);
	}
	
	public static void setScreen(String inputString){ //Set the current and previous screens and reset background music
		myScreen.sfx().stopAllSounds();
		additionalButtons.clear();

		if(myScreen != blankScreen){
			previousScreen = screen;
			previousScreenObject = myScreen;
		}
		screen = inputString;
		setScreen();

		for(Button b: myScreen.buttons()){
			b.startAppearance();
		}

		myScreen.setStartPlayer(true);
	}

	public static void setScreen(){ //Translates the screenString into an object of the screen class
		switch(screen){
			case "Opening Screen":
				myScreen = openingScreen;
				break;
			case "Credits Screen":
				myScreen = creditsScreen;
				break;
			case "Releases Screen":
				myScreen = releasesScreen;
				break;
			case "Settings Screen":
				myScreen = settingsScreen;
				break;
			case "Blank Screen":
				myScreen = blankScreen;
				break;
			case "New Ship Screen":
				myScreen = newShipScreen;
				break;
			case "Strategy Step 1 Screen":
				myScreen = strategyStep1
				;
				break;
			case "Strategy Step 2 Screen":
				myScreen = strategyStep2;
				break;
			case "Notebook Screen":
				notebookScreen.setNotebook(myShip.myNotebook());
				myScreen = notebookScreen;
				break;
			case "Strategy Step 3 Screen":
				myScreen = strategyStep3;
				break;
		}
	}

	public static void setAdditionalButtons(ArrayList <Button> inputAdditionalButtons){
		additionalButtons = inputAdditionalButtons;
	}

	public static void addArrayToAdditionalButtons(Button[] array){
		for(Button b: array){
			additionalButtons.add(b);
		}
	}

	public static void setBlankScreen(ImageIcon inputImage){
		blankScreen = new BlankScreen(inputImage);
	}

	public static void setInputStatus(boolean inputInputStatus){
		inputStatus = inputInputStatus;
	}

	public static void setInputBox(TextInput inputInputBox){
		inputBox = inputInputBox;
	}

	public static TextInput inputBox(){
		return inputBox;
	}

	public static boolean inputStatus(){
		return inputStatus;
	}

	public static String previousString(){
		return previousScreen;
	}

	public static Screen previousScreen(){
		return previousScreenObject;
	}

	public static String[] components(){
		return myComponents;
	}

	public static void setComponents(String[] inputComponents){
		myComponents = inputComponents;
		strategyStep2.putTitle(myComponents[0]);
	}

	public Graphics2D g2d(){
		return (Graphics2D)g2d;
	}

	public int getWidthOutside(){
		return getWidth();
	}

	public int getHeightOutside(){
		return getHeight();
	}

	public static void setShip(Ship inputShip){
		myShip = inputShip;
	}

	public static Ship ship(){
		return myShip;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		key= e.getKeyCode();
		keyChar = e.getKeyChar();	
		if(inputStatus){
			if(key == 8){
				if(inputBox.contentsLength()>0) {
					inputBox.deleteCharacter();
				}
			} else if(key == 10) {
				if(inputBox.multiLineEnabled()){
					inputBox.newLine();
				}
			} else if(key != 16){
				inputBox.addCharacter(keyChar);
			}
		}	
		// if(keyChar == 'n'){
		// 	setScreen("Notebook Screen");
		// }

	}

	@Override
	public void keyReleased(KeyEvent e) {
		key = e.getKeyCode();
		keyChar = e.getKeyChar();

	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		for(Button b: myScreen.buttons()){
			b.checkHover(e.getX(),e.getY());
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println(e.getX() + ", " + e.getY());
		
		inputStatus = false;
		//Checks whether the user has clicked any buttons
		for(Button b: myScreen.buttons()){
			b.check(e.getX(),e.getY());
		}

		if(additionalButtons.size()>0){
			for(Button b: additionalButtons){
				b.check(e.getX(),e.getY());
			}
		}

		//Changes the appearance of any conditional buttons
		for(Button b: myScreen.buttons()){
			b.startAppearance();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
