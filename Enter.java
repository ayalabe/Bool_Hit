import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
//*Serve: Ayala Badi 315206839 & rachel gamrian 208179267*
public class Enter extends JPanel{

	private JButton Exit;//Exit button
	private JButton Instructions;//Information about the rules of the game
	private JButton userInformation;//User info
	private Image img1;//Background picture
	
	//constructor
	public Enter (){
		setLayout(new GridLayout(3,1,10,10));
		MyListener l = new MyListener();//Create a listener
		
		JPanel p = new JPanel();//Another pane
		p.setLayout(new GridLayout(1,1));
		
		JPanel p1 = new JPanel();//Another pane
		p1.setLayout(new GridLayout(1,1));
		
		JPanel p2 = new JPanel();//Another pane
		p2.setLayout(new GridLayout(1,3));
		

		img1 = Toolkit.getDefaultToolkit().createImage("src/EnterPicture1.png");//The picture will begin
		Exit = new JButton();//Get started
		Instructions=new JButton("Instructions");//Get started
		userInformation=new JButton("userInformation");//Get started
		
		
		p2.add(Instructions);//Added to the panel
		p2.add(userInformation);//Added to the panel
		p2.add(Exit);//Added to the panel
		Exit.addActionListener(l);//Link to listener
		Instructions.addActionListener(l);//Link to listener
		userInformation.addActionListener(l);//Link to listener
		Exit.setContentAreaFilled(false);//Transparent button
		Instructions.setContentAreaFilled(false);//Transparent button
		userInformation.setContentAreaFilled(false);//Transparent button
		Exit.setBorder(null);//Without a frame
		Instructions.setBorder(null);//Without a frame
		userInformation.setBorder(null);//Without a frame
		p.setOpaque(false);//Transparent panel
		p1.setOpaque(false);//Transparent panel
		p2.setOpaque(false);//Transparent panel
		
		add(p1);//Added to the main panel
		add(p);//Added to the main panel
		add(p2);//Added to the main panel
		
	}
	
	public void paintComponent(Graphics g) {//A method that paints the grounding
		super.paintComponent(g);
		g.drawImage(img1, 0,0,getWidth(),getHeight(),this);

	}
	
	class MyListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource().equals(Instructions)) {
				
				JFrame frame2 = new JFrame("Instructions");//new frame
		    	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	Instru s = new Instru();
		    	frame2.setVisible(true);//do it Visible
				frame2.setSize(1500, 1500);
				frame2.add(s);
		    	}
		    	
			if(e.getSource().equals(userInformation)) {
				JFrame frame3 = new JFrame("userInformation");//new frame
		    	frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	userIn us = new userIn();
		    	frame3.add(us);
		    	frame3.setVisible(true);//do it Visible
				frame3.setSize(1500, 1500);
				
			}
			
			if(e.getSource().equals(Exit)) {
				java.awt.Window win[]=java.awt.Window.getWindows();//Close the windows
				for(int i=0;i<win.length;i++)
						win[i].dispose();
			}

			}
				
		}
	
	
	
		}