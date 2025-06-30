/*
//swing - MVC(model view component architecture)
multithreading is possible in swing
swing by default is thread in nature

ItemEvent
=========
getSelectedItem();


ItemListener
============
  public abstract void itemStateChanged(java.awt.event.ItemEvent);


Source
======
JList, JChoice, JCheckBox....
*/


import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;


class MyFrame{
	JFrame jf;
	JTextArea jta;
	JButton jb;
	JList<String> jl;
	JScrollPane jsp;
	MyFrame(){
		jf=new JFrame("FirstFrame");
		jf.setVisible(true);
		jf.setSize(500,500);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jta=new JTextArea();
		jta.setFont(new Font("Arial",Font.PLAIN,20));
		jsp=new JScrollPane(jta);
		jsp.setBounds(30,140,430,300);
		jf.add(jsp);
		String s[]={"Font.PLAIN","Font.BOLD","Font.ITALIC"};
		jl=new JList<String>(s);
                jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jf.add(jl);
		jl.setBounds(50,70,70,60);
		jb=new JButton("Click");
		jb.setBounds(150,70,100,50);
		jf.add(jb);
		jl.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent le){
				if(jl.getSelectedValue().equals("Font.PLAIN")){
					jta.setFont(new Font("Arial",Font.PLAIN,20));
				}
				else if(jl.getSelectedValue().equals("Font.BOLD")){
					jta.setFont(new Font("Arial",Font.BOLD,20));
				}
				else if(jl.getSelectedValue().equals("Font.ITALIC")){
					jta.setFont(new Font("Arial",Font.ITALIC,20));
				}
				jf.repaint();
			}
		});
		jb.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				MyFrame sw=new MyFrame();
				sw.jb.setVisible(false);
				sw.jf.setTitle("New Frame");
				sw.jta.setText(jta.getText());
			}
		});
	}
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MyFrame();
			}
		});
	}
}
		