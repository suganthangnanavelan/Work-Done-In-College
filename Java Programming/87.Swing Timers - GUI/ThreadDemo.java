import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

class ThreadDemo{
	JFrame frm;
	JLabel lbl;
	ThreadDemo(){
		frm=new JFrame("ThreadDemo");
		frm.setVisible(true);
		frm.setSize(600,600);
		frm.setLayout(null);
		JPanel pan=new JPanel();
		lbl=new JLabel("SASTRA UNIVERSITY");
		frm.add(lbl);lbl.setBounds(0,50,160,50);
		lbl.setFont(new Font("Arial",Font.BOLD,15));
		lbl.setForeground(Color.red);
		frm.add(pan);pan.setBounds(200,200,200,200);
		Timer t=new Timer(150,new ActionListener(){
			boolean f=true;int x=0,offset=10;
			public void actionPerformed(ActionEvent ae){
				if(f){
					lbl.setForeground(Color.red);f=false;
				}else{
					lbl.setForeground(frm.getBackground());f=true;
				}
				lbl.setLocation(x,50);
                                if(x<0||x+175>frm.getWidth())offset*=-1;
				x+=offset;
			}
		});
		t.start();

		Timer t1=new Timer(300,new ActionListener(){
			Random r=new Random();
			public void actionPerformed(ActionEvent ae){
				pan.setBackground(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
				pan.repaint();
				frm.validate();frm.repaint();
				
			}
		});
		t1.start();
		
		
	}
	public static void main(String args[]){
		new ThreadDemo();
	}
}
	