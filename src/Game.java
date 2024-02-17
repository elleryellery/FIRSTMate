//Imports
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

//Management Method
public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	/*
	   _       __    ___   _    __    ___   _     ____      ___   ____  __    _      __    ___    __   _____  _   ___   _     
	  \ \  /  / /\  | |_) | |  / /\  | |_) | |   | |_      | | \ | |_  / /`  | |    / /\  | |_)  / /\   | |  | | / / \ | |\ | 
 	   \_\/  /_/--\ |_| \ |_| /_/--\ |_|_) |_|__ |_|__     |_|_/ |_|__ \_\_, |_|__ /_/--\ |_| \ /_/--\  |_|  |_| \_\_/ |_| \| 
 	   
 	   TODO Variable Declaration
	 */
	
	//Management Variables
	private BufferedImage back; 
	private File file;
	
	//Objects
	private Character astronaut = new Character(300, 300, (int)(121/2), (int)(176/2), new ImageIcon("Astronaut.png"));
	
	//Integers
	private int key;
	private int mvmfactor;

	
	/*
	  _       __    _       __    __    ____  _      ____  _     _____ 
	 | |\/|  / /\  | |\ |  / /\  / /`_ | |_  | |\/| | |_  | |\ |  | |  
	 |_|  | /_/--\ |_| \| /_/--\ \_\_/ |_|__ |_|  | |_|__ |_| \|  |_|  
	 
	 TODO Management
	 */
	public Game() {
		
		//Thread Setup
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		mvmfactor = 5;
		
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
	
	/*
 	 _       __    _   _          ____  ___   _  _____  ___   ___  
	| |\/|  / /\  | | | |\ |     | |_  | | \ | |  | |  / / \ | |_) 
	|_|  | /_/--\ |_| |_| \|     |_|__ |_|_/ |_|  |_|  \_\_/ |_| \ 
	
	TODO Main Editor
	 */
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
				
		//Back Graphics and Setup
		Graphics g2d = back.createGraphics();
		g2d.clearRect(0,0,getSize().width, getSize().height);
		g2d.setFont( new Font("Courier New", Font.BOLD, 20));
		g2d.setColor(Color.WHITE);
		((Graphics2D) g2d).setStroke(new BasicStroke(10));
				
		g2d.drawImage(astronaut.getImg().getImage(), astronaut.getX(), astronaut.getY(), astronaut.getW(), astronaut.getH(), this);
		
		//Management
		twoDgraph.drawImage(back, null, 0, 0);
}
	
	/*
 	 ___   ___    __    _           _      ____ _____  _     ___   ___   __  
	| | \ | |_)  / /\  \ \    /    | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	|_|_/ |_| \ /_/--\  \_\/\/     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO Draw Methods
	 */

	
	
	/*
 	 __   __    ___   ____  ____  _          _      ____ _____  _     ___   ___   __  
	( (` / /`  | |_) | |_  | |_  | |\ |     | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	_)_) \_\_, |_| \ |_|__ |_|__ |_| \|     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO Screen Methods
	 */
	
	
	
	
	/*
 	 ___   _   __   ___   _      __    _    
	| | \ | | ( (` | |_) | |    / /\  \ \_/ 
	|_|_/ |_| _)_) |_|   |_|__ /_/--\  |_|  
	
	TODO Display
	 */
	
	//Alien Components
	
	
	/*
	 __    ____  _      ____  ___    __   _____  _   ___   _     
	/ /`_ | |_  | |\ | | |_  | |_)  / /\   | |  | | / / \ | |\ | 
	\_\_/ |_|__ |_| \| |_|__ |_| \ /_/--\  |_|  |_| \_\_/ |_| \| 
	
	TODO Generation
	 */
		
	
	
	
	
	/*
 	 __     __    _      ____  ___   _      __    _         _      ____  __    _      __    _      _   __    __  
	/ /`_  / /\  | |\/| | |_  | |_) | |    / /\  \ \_/     | |\/| | |_  / /`  | |_|  / /\  | |\ | | | / /`  ( (` 
	\_\_/ /_/--\ |_|  | |_|__ |_|   |_|__ /_/--\  |_|      |_|  | |_|__ \_\_, |_| | /_/--\ |_| \| |_| \_\_, _)_) 
	
	TODO Gameplay Mechanics
	 */
	

	
	/*
 	 _     ____  _         _     _   __  _____  ____  _      ____  ___       _      ____ _____  _     ___   ___   __  
	| |_/ | |_  \ \_/     | |   | | ( (`  | |  | |_  | |\ | | |_  | |_)     | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	|_| \ |_|__  |_|      |_|__ |_| _)_)  |_|  |_|__ |_| \| |_|__ |_| \     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO Key Listener Methods
	 */
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		key= e.getKeyCode();
		System.out.println(key);
		
		if(key == 65 || key == 37) { // A or <-
			astronaut.move(-mvmfactor, 0);
		}
		if(key == 87 || key == 38) { // W or ^
			astronaut.move(0, -mvmfactor);
		}
		if(key == 68 || key == 39) { // D or ->
			astronaut.move(mvmfactor, 0);
		}
		if(key == 83 || key == 40) { // D or ->
			astronaut.move(0, mvmfactor);
		}
		
	}

	//Key Release
	@Override
	public void keyReleased(KeyEvent e) {
		
		key = e.getKeyCode();
		
		
		
	}


	/*
 	 _      ___   _     __   ____      _     _   __  _____  ____  _      ____  ___       _      ____ _____  _     ___   ___   __  
	| |\/| / / \ | | | ( (` | |_      | |   | | ( (`  | |  | |_  | |\ | | |_  | |_)     | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	|_|  | \_\_/ \_\_/ _)_) |_|__     |_|__ |_| _)_)  |_|  |_|__ |_| \| |_|__ |_| \     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO Mouse Listener Methods
	 */
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		
	}

	//Mouse Moved Events
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		
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
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	

	/*
 	 ____  _   _     ____      _      ____ _____  _     ___   ___   __  
	| |_  | | | |   | |_      | |\/| | |_   | |  | |_| / / \ | | \ ( (` 
	|_|   |_| |_|__ |_|__     |_|  | |_|__  |_|  |_| | \_\_/ |_|_/ _)_) 
	
	TODO File Methods
	 */
	
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

				myWriter.write("Your cool file!");
		
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
