import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
//*Serve: Ayala Badi 315206839 & rachel gamrian 208179267*


public class userIn extends JPanel{

	private JLabel title;
	private JLabel namlbl;
	private JTextField namtxt;
	private JLabel agelbl;
	private JTextField agetxt;
	private JButton enterToThePlay;
	
	public userIn() {
		setLayout(new GridLayout(6,1,10,10));
		
		
		
		enterToThePlay = new JButton("Enter To The Play");
		title = new JLabel("Player details:");
		namlbl = new JLabel("Enter your name");
		namtxt = new JTextField(20);
		agelbl = new JLabel("Enter your age");
		agetxt = new JTextField(20);
		
		MyListener l = new MyListener();
		
		enterToThePlay.addActionListener(l);
		
		add(title);
		add(namlbl);
		add(namtxt);
		add(agelbl);
		add(agetxt);
		add(enterToThePlay);
		
	}
	
	
	
	class MyListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(enterToThePlay)) {
				
				java.awt.Window win[]=java.awt.Window.getWindows();//Close the windows
				for(int i=0;i<win.length;i++)
						win[i].dispose();
				
				JFrame frame4 = new JFrame("userInformation");//new frame
		    	frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	Bul bul = new Bul();
		    	frame4.add(bul);
		    	frame4.setVisible(true);//do it Visible
				frame4.setSize(1500, 1500);
				bul.nam.setText(namtxt.getText());
			
			}
	
	
	
		}
	}
	
	
	
	
	
}
