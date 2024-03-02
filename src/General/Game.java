package General;
import Screens.*;

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

	//Objects
	private static OpeningScreen openingScreen = new OpeningScreen();
	private static CreditsScreen creditsScreen = new CreditsScreen();
	private static ReleasesScreen releasesScreen = new ReleasesScreen();
	private static Settings settingsScreen = new Settings();

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
				
		Graphics g2d = back.createGraphics();
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setFont( new Font("Courier New", Font.BOLD, 20));
		g2d.setColor(Color.GREEN);
		((Graphics2D) g2d).setStroke(new BasicStroke(10));

		//Draw all characteristics of the current screen
		setScreen();
		myScreen.drawScreen(g2d,getWidth(),getHeight());
						
		twoDgraph.drawImage(back, null, 0, 0);
	}
	
	public static void setScreen(String inputString){ //Set the current and previous screens and reset background music
		myScreen.sfx().stopAllSounds();
		previousScreen = screen;
		previousScreenObject = myScreen;
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
		}
	}

	public static String previousString(){
		return previousScreen;
	}

	public static Screen previousScreen(){
		return previousScreenObject;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		key= e.getKeyCode();
		keyChar = e.getKeyChar();		
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

		//Checks whether the user has clicked any buttons
		for(Button b: myScreen.buttons()){
			b.check(e.getX(),e.getY());
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
