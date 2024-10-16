package Structure;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
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
	}

	public static Graphics Graphics(){
		return g2d;
	}

	public static void previousScreen() {
		setScreen(DataCache.history.get(DataCache.history.size()-1));
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
		char key = e.getKeyChar();

		if(key == '`'){
			DataCache.debug = !DataCache.debug;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	@Override
	public void mouseDragged(MouseEvent e) {

	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		for(Button b: DataCache.myScreen.buttons()){
			b.checkHover(e.getX(), e.getY());
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
		for(Button b: DataCache.myScreen.buttons()){
			b.check(e.getX(), e.getY());
		}
		if(DataCache.debug){
			System.out.println("DEBUG: Mouse coordinates: (" + e.getX() + ", " + e.getY() + ")");
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
