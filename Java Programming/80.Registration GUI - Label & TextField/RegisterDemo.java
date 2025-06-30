//BorderLayout
//Demo for Menu-Driven Program
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class Student implements Serializable{
	int regno,age;
	String name,department;
	Student(int regno,String name,String department,int age){
		this.regno=regno;
		this.name=name;
		this.department=department;
		this.age=age;
	}
	public String toString(){
		return "RegNo: "+regno+"\tName: "+name+"\tDepartment: "+department+"\tAge: "+age;
	}
}
	
public class RegisterDemo{
	public RegisterDemo(){
		JFrame jfrm=new JFrame("Text Editor");
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfrm.setSize(500,500);
		jfrm.setVisible(true);
		jfrm.setLayout(new BorderLayout());
		JLabel b_top=new JLabel("Registration From", SwingConstants.CENTER);
		JLabel b_bottom=new JLabel("Enter registration detail", SwingConstants.LEFT);
		JLabel b_left=new JLabel("       ");
		JLabel b_right=new JLabel("       ");
		
		JPanel b_center=new JPanel(new GridLayout(6,2,30,40));	
		
		JLabel regno=new JLabel("REGISTER NO:");
		JLabel name=new JLabel("NAME:");
		JLabel dept=new JLabel("DEPARTMENT:");
		JLabel age=new JLabel("AGE:");

		JTextField txtregno=new JTextField(15);
		JTextField txtname=new JTextField(15);
		JTextField txtdept=new JTextField(15);
		JTextField txtage=new JTextField(15);

		JButton clear=new JButton("Clear");
		JButton submit=new JButton("Submit");

		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try{
					File f=new File("Student.dat");
					FileOutputStream fout=new FileOutputStream(f,true);
					ObjectOutputStream out;
					if(f.length()==0)
						out=new ObjectOutputStream(fout);
					else
						out=new ObjectOutputStream(fout){
							public void writeStreamHeader(){}
						};
					out.writeObject(new Student(Integer.parseInt(txtregno.getText()),txtname.getText(),txtdept.getText(),Integer.parseInt(txtage.getText())));
					JOptionPane.showMessageDialog(jfrm,"Registered Successfully");					
					out.close();
					fout.close();
				}catch(NumberFormatException nf){
					JOptionPane.showMessageDialog(jfrm,"Invalid Entry");
				}catch(Exception e){
					System.out.println(e);
				}
			}
		});
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				txtregno.setText("");
				txtname.setText("");
				txtdept.setText("");
				txtage.setText("");
			}
		});
		b_center.add(regno);
		b_center.add(txtregno);
		b_center.add(name);
		b_center.add(txtname);
		b_center.add(dept);
		b_center.add(txtdept);
		b_center.add(age);
		b_center.add(txtage);
		b_center.add(submit);
		b_center.add(clear);

		//PAGE_START, PAGE_END, LINE_START, LINE_END, CENTER
		jfrm.add(b_top,BorderLayout.PAGE_START);
		jfrm.add(b_bottom,BorderLayout.PAGE_END);
		jfrm.add(b_left,BorderLayout.LINE_START);
		jfrm.add(b_right,BorderLayout.LINE_END);
		jfrm.add(b_center,BorderLayout.CENTER);
		
	}
	public static void main(String args[]){
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					new RegisterDemo();
				}
			}
		);
	}
}














