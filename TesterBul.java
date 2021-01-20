

import java.awt.Panel;


import javax.swing.JFrame;

public class TesterBul {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Tasks");//new frame
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Bul b = new Bul();
    	Enter e = new Enter();
    	frame.add(e);
    	//frame.add(b);
		frame.setVisible(true);//do it Visible
		frame.setSize(1500, 1500);
	
    
	}
	}
