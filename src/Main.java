//Ready for commit

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final int WIDTH =1200;
	private static final int HEIGHT=650;
	
	public Main () {
		super("FIRST Mate");
		setSize(WIDTH, HEIGHT);

		//iPhone: 	1170 x 2532 px
		//Android: 414 × 896 px

		Game play = new Game();
		((Component) play).setFocusable(true);
		
		setBackground(Color.WHITE);
		
		getContentPane().add(play);
		
		setVisible(true);
		
		addWindowListener( new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//play.saveFile();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//play.createFile();
				//play.readFromFile();
			}  });
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
	}
}
