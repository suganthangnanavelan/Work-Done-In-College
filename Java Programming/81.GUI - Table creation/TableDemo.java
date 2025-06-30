//JTable, JScrollPane-automatic size adjust of scrollbar

//  public javax.swing.JTable(java.lang.Object[][], java.lang.Object[]);
//first content second parameter is title


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.*;

class Student implements Serializable{
	int rno;
	String name;
	int m1,m2,m3;
	Student(int rno,String name,int m1,int m2,int m3){
		this.rno=rno;
		this.name=name;
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
	}
	//no need for toString()
}


class Demo{
	JFrame jf;
	JTable jt;
	JScrollPane js;
	JButton add;
	JButton del;
	Demo()throws IOException{
		jf=new JFrame("Demo");
		jf.setVisible(true);
		jf.setSize(500,500);
		add=new JButton("ADD");
		del=new JButton("DELETE");
		FileOutputStream fout=new FileOutputStream("student.dat");
		ObjectOutputStream out=new ObjectOutputStream(fout);
		out.writeObject(new Student(3001,"xxx",78,89,90));
		out.writeObject(new Student(3002,"yyy",78,89,90));
		out.writeObject(new Student(3003,"zzz",78,89,90));
		fout.close();out.close();
		String header[]={"Rollno","Name","Mark1","Mark2","Mark3","CGPA"};
		Student sa[]=new Student[10];
		int count=0;
		try{
		FileInputStream fin=new FileInputStream("student.dat");
		ObjectInputStream in=new ObjectInputStream(fin);
		while(true){
			sa[count++]=(Student)in.readObject();
		}
		}catch(Exception e){}
		Object o[][]=new Object[count-1][6];
		for(int i=0;i<count-1;i++){
			o[i][0]=(Object)sa[i].rno;
			o[i][1]=(Object)sa[i].name;
			o[i][2]=(Object)sa[i].m1;
			o[i][3]=(Object)sa[i].m2;
			o[i][4]=(Object)sa[i].m3;	
			o[i][5]=(Object)((sa[i].m1+sa[i].m2+sa[i].m3)/3);
		}
		jt=new JTable(o,header);
		js=new JScrollPane(jt);
		jt.setFont(new Font("Arail",Font.BOLD,10));
		jt.setSize(500,500);
		jf.add(js);
		jf.validate();
		jf.repaint();
		
	}
	public static void main(String args[])throws IOException{
		new Demo();
	}
}
		

