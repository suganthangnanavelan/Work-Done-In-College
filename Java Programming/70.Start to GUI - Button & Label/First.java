/*
//Window...Frame...Panel
//containers

//frame - that have title bar, menu bar, tool bar - text editor
//panel - no menu bar, status bar - cannot have controls - painting 

Window - Abstract class
Frame, Panel inherits from Window

*/
import java.awt.*;
import java.awt.event.*;

class First extends Frame{
    Button btnClick;//1.create a reference
    Button btnClear;
    Label lblDisp;
    First(){
        setLayout(null);
        setVisible(true);
        setSize(500,500);
        setFont(new Font("Arial",Font.BOLD,20));
        setTitle("FirstFrame");
        btnClick=new Button("Click");//2.initialize by calling constructor
        btnClear=new Button("Clear");
        lblDisp=new Label();
        lblDisp.setForeground(Color.red);
        add(btnClick);//3.add it to the Frame
        add(lblDisp);
        add(btnClear);
        btnClear.setBounds(250,100,100,50);
        btnClick.setBounds(150,100,100,50);//setBounds(x,y,width,height);
        lblDisp.setBounds(150,150,300,100);
        btnClick.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    lblDisp.setText("SASTRA UNIVERSITY");
                }
        });
        btnClear.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    lblDisp.setText("");
                }
        });
    }
    public static void main(String[] args){
        new First();//launch GUI
    }
}