package General;
import Screens.*;

//Imports
import javax.swing.*;

import Screens.Screen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*; 

//Management Method
public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	//TODO Variable Declaration
	
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

	//Miscellaneous

	//TODO Management

	public Game() {
		
		//Thread Setup
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
			
	}

	//Run Method
	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e) {
	   			
	      }
	  	}
	
	// TODO Main Editor
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if(back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
				
		//Back Graphics and Setup
		Graphics g2d = back.createGraphics();
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setFont( new Font("Courier New", Font.BOLD, 20));
		g2d.setColor(Color.GREEN);
		((Graphics2D) g2d).setStroke(new BasicStroke(10));
		setScreen();
		myScreen.drawScreen(g2d,getWidth(),getHeight());
						
		//Management
		twoDgraph.drawImage(back, null, 0, 0);
}
	
	//TODO Getters and Setters

	public static void setScreen(String inputString){

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

	public static String previousString(){
		return previousScreen;
	}

	public static Screen previousScreen(){
		return previousScreenObject;
	}

	public static void setScreen(){
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

	//TODO Draw Methods

	
	
	//TODO Screen Methods
	

	
	//TODO Display
		
	

	//TODO Key Listener Methods
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		key= e.getKeyCode();
		keyChar = e.getKeyChar();
		System.out.println(key);
		
	}

	//Key Release
	@Override
	public void keyReleased(KeyEvent e) {
		
		key = e.getKeyCode();
		keyChar = e.getKeyChar();

	}


	//TODO Mouse Listener Methods
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	//Mouse Moved Events
	
	@Override
	public void mouseMoved(MouseEvent e) {
		for(Button b: myScreen.buttons()){
			b.checkHover(e.getX(),e.getY());
		}
	}

	//Mouse Clicked Methods
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}


	//Auto Generated MouseListener Methods
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println(e.getX() + ", " + e.getY());

		for(Button b: myScreen.buttons()){
			b.check(e.getX(),e.getY());
		}
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	

	//TODO File Methods
	
		//Create File
		public void createFile() {
			try {
				if(file.createNewFile()) {
					System.out.println("File Created");
				}
				else
					System.out.println("File Already Exists");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//Read File
		public void readFromFile() {
			try {
				Scanner sc = new Scanner(file);
				//while(sc.hasNextLine()) {
					//System.out.println(sc.nextLine());
				
					
					
				//}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
		//Save File
		public void saveFile() {
			try {
				FileWriter myWriter = new FileWriter(file);

				myWriter.write("Keycode: " + key);
		
				myWriter.close();
				System.out.println("Successfully wrote to file");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error writing to file");
			}
		}
		
		//Refresh File
		public void refreshFromFile() {
			
		}
}
