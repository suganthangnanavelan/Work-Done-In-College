/*

MouseEvent
MouseMotionEvent
MouseListener
MouseMotionListener
Color
Graphics
Graphics2D
MouseEvent
==========
  public int getX();
  public int getY();
  public java.awt.Point getPoint();
  public synchronized void translatePoint(int, int);
  public int getClickCount();
  public int getButton();

MouseListener
=============
  public abstract void mouseClicked(java.awt.event.MouseEvent);
  public abstract void mousePressed(java.awt.event.MouseEvent);
  public abstract void mouseReleased(java.awt.event.MouseEvent);
  public abstract void mouseEntered(java.awt.event.MouseEvent);
  public abstract void mouseExited(java.awt.event.MouseEvent);

MouseMotionListener
===================
  public abstract void mouseDragged(java.awt.event.MouseEvent);
  public abstract void mouseMoved(java.awt.event.MouseEvent);

Graphics
========
 public abstract void drawLine(int, int, int, int);

*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintFrame extends JFrame implements MouseListener, MouseMotionListener{
	int x1, y1;
        int x2, y2;
        PaintFrame(){
		setLayout(null);setVisible(true);
                setSize(500,500);setTitle("Paint");
                setForeground(Color.green); 
                addMouseListener(this);
                addMouseMotionListener(this);
		repaint();
        }
        public void paint(Graphics g){
                Graphics2D g2=(Graphics2D)this.getGraphics();
                g2.setStroke(new BasicStroke(2));
                g2.drawLine(x1,y1,x2,y2);
		x1=x2;
		y1=y2;
		getContentPane().setBackground(Color.white);             
        }
	//Mouse Listeners
        public void mouseClicked(MouseEvent me){
		x2=me.getX();
                y2=me.getY();
		repaint();
	}
        public void mousePressed(MouseEvent me){
		x1=me.getX();
                y1=me.getY();
	}
        public void mouseReleased(MouseEvent me){}
        public void mouseEntered(MouseEvent me){}
        public void mouseExited(MouseEvent me){}
        //Mouse Motion Listeners
        public void mouseDragged(MouseEvent me){
		x2=me.getX();
                y2=me.getY();
		repaint();
	}
        public void mouseMoved(MouseEvent me){}
	public static void main(String[] args){
            new PaintFrame();
        }   
}
