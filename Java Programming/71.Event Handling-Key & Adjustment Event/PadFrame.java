/*
KeyEvent
========
  public int getKeyCode();
  public void setKeyCode(int);
  public char getKeyChar();
  public void setKeyChar(char);
  public void setModifiers(int);
  public int getKeyLocation();
KeyListener
===========
  public abstract void keyTyped(java.awt.event.KeyEvent);
  public abstract void keyPressed(java.awt.event.KeyEvent);
  public abstract void keyReleased(java.awt.event.KeyEvent);
Source KeyEvent..Frame, TextField,TextArea...
============================================================
AdjustmentEvent
===============
public int getValue();
AdjustmentListener
==================
 public abstract void adjustmentValueChanged(java.awt.event.AdjustmentEvent);
Event Source: Scrollbar
  public int getValue();

*/
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class PadFrame extends Frame{
	String msg="";
	Scrollbar sc;
	PadFrame(){
		Random r=new Random();
		setVisible(true);		
		setSize(500,500);
		setLayout(null);
		setFont(new Font("Arial",Font.BOLD,30));
		setForeground(new Color(255,r.nextInt(255),r.nextInt(255)));
		sc=new Scrollbar(Scrollbar.VERTICAL,0,10,10,100);
		sc.setValue(30);
		add(sc); sc.setBounds(50,50,20,150);
		sc.addAdjustmentListener(new AdjustmentListener(){
			public void adjustmentValueChanged(AdjustmentEvent ae){
				setFont(new Font("Arial",Font.BOLD,ae.getValue()));
				repaint();
			}
		});
		addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent ke){
				System.out.println("keytyped = "+ke.getKeyChar());
				msg+=ke.getKeyChar();
				repaint();
			}
		});
	}
	public void paint(Graphics g){
		g.drawString(msg,100,150);
	}
	public static void main(String args[]){
		new PadFrame();
	}
}
