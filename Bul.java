import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
//*Serve: Ayala Badi 315206839 & rachel gamrian 208179267*


public class Bul extends JPanel{
	private JButton Enter;
	private Image img;//Background image of the game
	private JButton Colors[];//An array of colors shown to the user
	private JLabel ColorsGuessing[];//An array of colors the computer is dragging
	private JLabel SelectedColors[];//An array of colors that the user chooses
	private Random random ;//Numbers are indexed by the computer
	private int in;//An index that tells how many colors is selected
	int bul;//An index that tells a few bul
	private int Damage;//An index that tells a few Damage
	private Border emptyBorder2;//The frame of the panel
	JLabel nam;//The name the user places in the class userIn
	private JLabel bullbl;//The label of bul
	private JLabel dnaglbl;//The label of dnag
	int options;//An index that tells us how many options we will have for the user to play
	private JLabel optionslbl;//The label of options

	//constructor
	public Bul() {
		Enter = new JButton("Enter");
		options=10;//10 options to play
		in=0;
		bul=0;
		Damage=0;
		random = new Random(); 
		img = Toolkit.getDefaultToolkit().createImage("src/ooo2.png");//The frame in the image
		setLayout(new GridLayout(7,1,20,20));

		JPanel p = new JPanel();//Another pane
		p.setLayout(new GridLayout(3,3));

		JPanel p1 = new JPanel();//Another pane
		p1.setLayout(new GridLayout(1,4,8,8));

		JPanel p2 = new JPanel();//Another pane
		p2.setLayout(new GridLayout(1,4,8,8));

		JPanel p3 = new JPanel();//Another pane
		p3.setLayout(new GridLayout(2,1,8,8));


		optionslbl = new JLabel();
		bullbl = new JLabel();
		dnaglbl = new JLabel();
		nam = new JLabel();
		Colors = new JButton[9];
		ColorsGuessing = new JLabel[4];
		SelectedColors = new JLabel[4];


		emptyBorder2=BorderFactory.createEmptyBorder(10, 500,10, 10);
		setBorder(emptyBorder2);

		p3.add(bullbl);
		p3.add(dnaglbl);

		MyListener l = new MyListener();//Create a listener
		for (int i = 0; i < Colors.length; i++) {
			Colors[i] = new JButton();//Get started
			p.add(Colors[i]);//Add to panel
			Colors[i].addActionListener(l);//Link to listener

		}
		//The array of colors begins to color
		Colors[0].setBackground(Color.black);
		Colors[1].setBackground(Color.blue);
		Colors[2].setBackground(Color.green);
		Colors[3].setBackground(Color.red);
		Colors[4].setBackground(Color.orange);
		Colors[5].setBackground(Color.yellow);
		Colors[6].setBackground(Color.pink);
		Colors[7].setBackground(Color.MAGENTA);
		Colors[8].setBackground(Color.cyan);

		Enter.addActionListener(l);

		for (int i = 0; i < SelectedColors.length; i++) {
			SelectedColors[i] = new JLabel(" ? ");//Get started
			SelectedColors[i].setFont(new Font("Arial Black",Font.ITALIC,70));//Choose a font
			p2.add(SelectedColors[i]);//Add to panel
		}

		for (int i = 0; i < ColorsGuessing.length; i++) {
			ColorsGuessing[i] = new JLabel();//Get started
			p1.add(ColorsGuessing[i]);//Add to panel
		}

		int temp[] = new int [4];//Auxiliary system
		int x = random.nextInt(9);//Random number 0 to 9
		temp[0]=x;//Place the number in the first position in the array
		int index=1;//Index that points to position
		boolean flag = false;
		while(index!=temp.length){//As long as the array is not filled
			flag = false;
			x = random.nextInt(9);
			for (int j = 0; j < temp.length; j++) {
				if(temp[j]==x )//If the same number exists in the array
					flag = true;
			}
			if(flag==false ) {
				temp[index]=x;//Only if the same number does not exist in the array
				index++;
			}

		}

		for (int i = 0; i < ColorsGuessing.length; i++) {
			ColorsGuessing[i].setForeground(Colors[temp[i]].getBackground());//The array is in random colors
		}
		p1.setOpaque(false);//Make the panel transparent
		p2.setOpaque(false);//Make the panel transparent
		p3.setOpaque(false);//Make the panel transparent
		add(nam);//Added to the main panel
		add(Enter);
		Enter.setContentAreaFilled(false);
		add(optionslbl);//Added to the main panel
		add(p3);//Added to the main panel
		//add(p1);//Added to the main panel
		add(p2);//Added to the main panel
		add(p);//Added to the main panel
		add(l);

	}


	public void paintComponent(Graphics g) {//A method that paints the grounding
		super.paintComponent(g);
		g.drawImage(img, 0,0,getWidth(),getHeight(),this);
	}

	class MyListener extends JPanel implements ActionListener{

		public void actionPerformed(ActionEvent e) {

			JPanel p4 = new JPanel();//Another panel
			p4.setLayout(new GridLayout(1,4));
			p4.setOpaque(false);

			if(options>0) {
				if(! e.getSource().equals(Enter)) {
					JButton temp = (JButton) e.getSource();
					SelectedColors[in].setForeground(temp.getBackground());//Update the color array that the user has selected
					temp.setText("selected");
					temp.setFont(new Font("Blackadder ITC",Font.ITALIC,20));//Choose a font
					if(in==SelectedColors.length-1)
						in=0;
					else in++;

				}
				if(e.getSource().equals(Enter)) {

					in=0;
					bul=0;
					Damage=0;
					options--;

					JLabel tempor[] = new JLabel[4];
					for (int k = 0; k < SelectedColors.length; k++) {
						tempor[k] = new JLabel("     "+k);
						tempor[k].setBackground(SelectedColors[k].getForeground());	
						tempor[k].setOpaque(true);
						p4.add(tempor[k]);
					}
					add(p4);


					for (int i = 0; i < ColorsGuessing.length; i++) {
						for (int j = 0; j < SelectedColors.length; j++) {
							if(ColorsGuessing[i].getForeground().equals(SelectedColors[j].getForeground()) && i==j) {//If they are the same color and exact location
								//ColorsGuessing[i].setText("Bool");
								bul++;
								break;
							}
							else
								if(ColorsGuessing[i].getForeground().equals(SelectedColors[j].getForeground()) && i!=j) {//If they are the same color and not the same location
									//ColorsGuessing[j].setText("DAMAGE");
									Damage++;
									break;

								}
						}
					}
					
					bullbl.setText("Bul: "+bul);//Message to use some bul
					dnaglbl.setText("Hit: "+Damage);//Message to use some Damage
					optionslbl.setText("options: "+options);//Message to use some options

					if((bul==4) || (options==0 && bul!=4)) {
						java.awt.Window win[]=java.awt.Window.getWindows();//Close the windows
						for(int i=0;i<win.length;i++)
							win[i].dispose();
						JFrame frame3 = new JFrame("userInformation");//new frame
						frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						Winner w = new Winner(bul);//Message the user has won
						frame3.add(w);
						frame3.setVisible(true);//do it Visible
						frame3.setSize(700, 700);
					}
				}

			}
		}
	}
}