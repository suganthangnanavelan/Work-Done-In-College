import java.awt.*;
import java.awt.event.*;

class LoginFrame{
	Frame f;
	Panel p;
	TextField login;
	TextField password;
	Button submit;
	Button cancel;
	Label msg;
	Label hint;
	Label l1;
	Label l2;
	LoginFrame(){
		f=new Frame();
		f.setVisible(true);
		f.setLayout(null);
		f.setSize(500,500);
		f.setForeground(Color.black);
		f.setFont(new Font("Arial",Font.BOLD,15));
		f.setTitle("Login Window");
                p=new Panel();
                p.setLayout(new GridLayout(3,2,15,15));
		msg=new Label();
                hint=new Label("Hint:Login id and password are the same");
		l1=new Label("Login ID: ");
		l2=new Label("Password: ");
		login=new TextField();
		password=new TextField();	
		submit=new Button("SUBMIT");
		cancel=new Button("CANCEL");
		p.add(l1);p.add(login);
		p.add(l2);p.add(password);
		p.add(submit);p.add(cancel);
                msg.setBounds(150,180,200,15);
                msg.setFont(new Font("Arial",Font.PLAIN,10));
		msg.setForeground(Color.red);
                hint.setBounds(150,310,200,15);
                hint.setFont(new Font("Arial",Font.PLAIN,10));
                p.setBounds(150,200,200,100);
		f.add(msg);
                f.add(hint);
                f.add(p);
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if((login.getText().equalsIgnoreCase("JAVA"))&&(password.getText().equalsIgnoreCase("JAVA")))
			        	new PaintFrame();
				else
					msg.setText("Incorrect login id and password");
				
			}	
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				login.setText("");
				password.setText("");
                                msg.setText("");
			}	
		});
                f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
	}
	public static void main(String args[]){
		new LoginFrame();
	}	
}

class PaintFrame extends Frame{
	int xpressed,ypressed;
	int xdragged,ydragged;
	PaintFrame(){
		setVisible(true);
		setLayout(null);
		setSize(500,500);
		setForeground(Color.black);
		setFont(new Font("Arial",Font.BOLD,15));
		setTitle("Paint Frame");
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				xpressed=me.getX();
				ypressed=me.getY();
			}
		});
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent me){
				xdragged=me.getX();
				ydragged=me.getY();	
				Graphics2D g=(Graphics2D)getGraphics();
				g.setStroke(new BasicStroke(2));
				g.drawLine(xpressed,ypressed,xdragged,ydragged);	
				xpressed=xdragged;
				ypressed=ydragged;
			}
		});
                addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				setVisible(false);	
			}
		});
	}
}
				