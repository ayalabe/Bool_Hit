import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//*Serve: Ayala Badi 315206839 & rachel gamrian 208179267*


public class Winner extends JPanel{

	private JButton Exit;
	private JButton play;
	private Image img;
	private Image img1;
	private int bul1;
	
	

	public Winner(int x){
		
		bul1= x;
		Exit = new JButton();
		play = new JButton();

		MyListener l = new MyListener();

		JPanel p = new JPanel();//Another panel
		p.setLayout(new GridLayout(1,1));

		JPanel p1 = new JPanel();//Another panel
		p1.setLayout(new GridLayout(1,1));

		JPanel p2 = new JPanel();//Another panel
		p2.setLayout(new GridLayout(1,2));

		Exit.addActionListener(l);
		play.addActionListener(l);

		img = Toolkit.getDefaultToolkit().createImage("src/WinerPicture.jpg");
		setLayout(new GridLayout(3,1,20,20));
		
		img1 = Toolkit.getDefaultToolkit().createImage("src/LoserPicture.jpg");
		setLayout(new GridLayout(3,1,20,20));


		p2.add(play);
		p2.add(Exit);

		p.setOpaque(false);
		p1.setOpaque(false);
		p2.setOpaque(false);
		Exit.setContentAreaFilled(false);
		play.setContentAreaFilled(false);
		Exit.setBorder(null);
		play.setBorder(null);

		add(p);
		add(p1);
		add(p2);

	}
	Bul a = new Bul();

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(bul1==4) 
			g.drawImage(img, 0,0,getWidth(),getHeight(),this);
		
		else  
			g.drawImage(img1, 0,0,getWidth(),getHeight(),this);
		
	}


	class MyListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(Exit)) {
				java.awt.Window win[]=java.awt.Window.getWindows();//Close the windows
				for(int i=0;i<win.length;i++)
					win[i].dispose();
			}
			if(e.getSource().equals(play)) {
				java.awt.Window win[]=java.awt.Window.getWindows();//Close the windows
				for(int i=0;i<win.length;i++)
					win[i].dispose();
				JFrame frame3 = new JFrame("userInformation");//new frame
				frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Bul b = new Bul();
				frame3.add(b);
				frame3.setVisible(true);//do it Visible
				frame3.setSize(1500, 1500);
			}

		}
	}

}
