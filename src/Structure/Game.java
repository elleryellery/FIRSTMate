package Structure;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.*; 

import Elements.*;

public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{
	
	private BufferedImage back; 
	private static Graphics g2d;

	public Game() {
		
		//Create a new thread that handles input from the keyboard and mouse
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		GraphicsDatabase.init();
		DataCache.myScreen = GraphicsDatabase.S01;			
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
		g2d.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g2d.setColor(Color.GREEN);
		((Graphics2D) g2d).setStroke(new BasicStroke(10));
		
		DataCache.myScreen.drawScreen(g2d, getWidth(), getHeight());

		twoDgraph.drawImage(back, null, 0, 0);
		//System.out.println("a: " + DataCache.coordinates1 + " b: " + DataCache.coordinates2);
	}

	public static Graphics Graphics(){
		return g2d;
	}

	public static void previousScreen() {
		setScreen(DataCache.history.get(DataCache.history.size()-1));
		DataCache.history.remove(DataCache.history.size()-1);
		DataCache.history.remove(DataCache.history.size()-1);
	}

	public static void setScreen(Screen _screen){
		if(DataCache.myScreen.includeInHistory()){
			DataCache.history.add(DataCache.myScreen);
		}
		DataCache.myScreen = _screen;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key= e.getKeyCode();
		char keyChar = e.getKeyChar();	

		if(DataCache.inputStatus){
			if(key == 8){
				if(DataCache.inputBox.contentsLength()>0) {
					DataCache.inputBox.deleteCharacter();
				}
			} else if(key == 10) {
				if(DataCache.inputBox.multiLineEnabled()){
					DataCache.inputBox.newLine();
				}
			} else if(key == 37){
				DataCache.inputBox.arrowLeft();
			} else if(key == 39){
				DataCache.inputBox.arrowRight();
			} else if(key != 16){
				DataCache.inputBox.addCharacter(keyChar);
			}
		}	

		if(keyChar == '~'){
			DataCache.debug = !DataCache.debug;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(DataCache.drawingEnabled && DataCache.inFrame){
			ScreenScripts.drawAt(e.getX(), e.getY());
		}
		if(DataCache.holding != null && DataCache.inFrame){
			DataCache.holding.setCoords(e.getX() - DataCache.dragXOffset, e.getY() - DataCache.dragYOffset);
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(DataCache.tutorials.peek() == null)
			for(Button b: DataCache.myScreen.buttons()){
				b.checkHover(e.getX(), e.getY());
			}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		DataCache.inFrame = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		DataCache.inFrame = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(DataCache.tutorials.peek() == null){
			for(Button b: DataCache.myScreen.buttons()){
				if(b.check(e.getX(), e.getY())){
					break;
				}
			}
			for(int i = DataCache.myScreen.buttons().length - 1; i >= 0; i--){
				Button b = DataCache.myScreen.buttons()[i];
				if(b instanceof Draggable){
					if(b.check(e.getX(), e.getY())){
						DataCache.holding = (Draggable)b;
						DataCache.dragXOffset = e.getX()-b.x();
						DataCache.dragYOffset = e.getY()-b.y();
						DataCache.myScreen.rearrangeToLast(b);
						break;
					}
				} else {
					b.checkHover(e.getX(), e.getY());
				}
			}
			if(DataCache.debug){
				System.out.println("DEBUG: Mouse coordinates: (" + e.getX() + ", " + e.getY() + ")");
			}
			if(DataCache.inputStatus && !DataCache.inputBox.check(e.getX(), e.getY())){
				DataCache.inputStatus = false;
			}
		} else {
			DataCache.tutorials.pop();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(DataCache.holding == GraphicsDatabase.D05 && DataCache.enabledCannons){
			int dx = (int)((GraphicsDatabase.D05.x()-40)/15);
			int dy = (int)((GraphicsDatabase.D05.y()-258)/15);
			DataCache.cannonball = new Cannonball(dx, dy);
			GraphicsDatabase.D05.setCoords(40, 258);
			DataCache.myShip.retrieveData().makeSketchCopy();
		}
		DataCache.previousCoordinate = null;
		DataCache.holding = null;
	}
}
