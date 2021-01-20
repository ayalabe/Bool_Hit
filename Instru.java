import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//*Serve: Ayala Badi 315206839 & rachel gamrian 208179267*
public class Instru extends JPanel{
	
	private JTextArea arppp;
	private JButton returns;
	
	
	public Instru() {
		arppp=new JTextArea();
		returns = new JButton("return");
		MyListener l = new MyListener();
		
		returns.addActionListener(l);
		
		File f=new File("src/Instructions.txt");
		try {
		FileReader fr = new FileReader(f);
		BufferedReader br= new BufferedReader(fr);
		String line = br.readLine();
		String str="";
		while(line != null){
		str+=line+"\n";
		line = br.readLine();
		}
		arppp.setText(str);
		br.close();
		}
		catch (IOException e1) {
		System.err.println("Error! Couldn't Write to File");
		}
		add(arppp);
		add(returns);
		
	}
	
	
	class MyListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource().equals(returns)) {
					java.awt.Window win[]=java.awt.Window.getWindows();//Close the windows
					for(int i=0;i<win.length;i++)
							win[i].dispose();
				
				
				JFrame frame = new JFrame("Tasks");//new frame
		    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	Enter e1 = new Enter();
		    	frame.add(e1);
				frame.setVisible(true);//do it Visible
				frame.setSize(500, 500);
			}
				
				
			}
	
		}
	}