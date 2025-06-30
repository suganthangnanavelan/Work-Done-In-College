import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

class StockDetails{
    String name;
    int stockid;
    double cost;
    StockDetails(String name,int stockid,double cost){
        this.name=name;
        this.stockid=stockid;
        this.cost=cost;
    }
    public String toString(){
        return name+"\t\t"+stockid+"\t\t"+cost;
    }
}

class StockManagement{
    ArrayList<StockDetails> al;
    JFrame jf;
    JPanel jp;
    JTextArea jt;
    JScrollPane js;
    JLabel lname,lid,lcost;
    JTextField tname,tid,tcost;
    JButton add,display;
    StockManagement(){
        al=new ArrayList<StockDetails>();
        jf=new JFrame();
        jf.setVisible(true);jf.setSize(750,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new GridLayout(1,2));
        jp=new JPanel();jp.setLayout(new GridLayout(5,2,30,30));
        lname=new JLabel("Name:");     jp.add(lname);
        tname=new JTextField();        jp.add(tname);
        lid=new JLabel("Stock Id:");   jp.add(lid);
        tid=new JTextField();          jp.add(tid);
        lcost=new JLabel("Cost:");     jp.add(lcost);
        tcost=new JTextField();        jp.add(tcost);
        add=new JButton("Add");        jp.add(add);
        display=new JButton("Display");jp.add(display);
        JLabel msg=new JLabel();       jp.add(msg);
        Timer t=new Timer(10,null);
        t.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                if(msg.getX()>jp.getWidth()){
                        msg.setText("");
                        msg.setLocation(0,msg.getY());
                }	
                else
	                msg.setLocation(msg.getX()+1,msg.getY());			
            }
        });
   	add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                StockDetails sd=new StockDetails(tname.getText(),Integer.parseInt(tid.getText()),Double.parseDouble(tcost.getText()));
                addStockDetails(sd);
                tname.setText("");tid.setText("");tcost.setText("");
                msg.setText("Added Successfully");
                t.start();
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(jf,"Invalid Input");
                    tname.setText("");tid.setText("");tcost.setText("");
                }    
            }
        });
        display.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                displayStockDetails();
            }
        });
        jt=new JTextArea();
        jt.setFont(new Font("Arial",Font.BOLD,12));            
        js=new JScrollPane(jt);
        jf.add(jp);
        jf.add(js);
        jf.validate();jf.repaint();
    }
    void addStockDetails(StockDetails sd){
        al.add(sd);
    }
    void displayStockDetails(){
        jt.setText("Name\t\tStock Id\t\tCost\n");
        for(StockDetails sd:al)jt.append(sd+"\n");   
    }
    public static void main(String[] args){
        new StockManagement();
    }
}
