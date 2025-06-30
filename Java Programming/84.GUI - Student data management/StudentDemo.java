//JTable, JScrollPane
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class StudentDemo{
	JFrame jf;
	JPanel jp;
	JScrollPane js;
	JTable jt;
	JLabel lrno,lname,lm1,lm2,lm3;
	JTextField trno,tname,tm1,tm2,tm3;
	JButton badd,bdel,bfind,fupdate;

	StudentDemo(){
		jf=new JFrame("Student");
		jf.setVisible(true);
		jf.setSize(500,500);
		jf.setLayout(new GridLayout(1,2));
		jp=new JPanel();
		jp.setLayout(new GridLayout(10,2,10,10));
		lrno=new JLabel("RNO:"); jp.add(lrno);
		trno=new JTextField(10); jp.add(trno);	

		lname=new JLabel("Name:"); jp.add(lname);
		tname=new JTextField(10); jp.add(tname);	

		lm1=new JLabel("MARK 1:"); jp.add(lm1);
		tm1=new JTextField(10); jp.add(tm1);
		lm2=new JLabel("MARK 2:"); jp.add(lm2);
		tm2=new JTextField(10); jp.add(tm2);
		lm3=new JLabel("MARK 3:"); jp.add(lm3);
		tm3=new JTextField(10); jp.add(tm3);
		badd=new JButton("ADD"); jp.add(badd);
		bdel=new JButton("DELETE"); jp.add(bdel);
		bfind=new JButton("SEARCH"); jp.add(bfind);
		fupdate=new JButton("UPDATE"); jp.add(fupdate);
		jf.add(jp);
		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("RNO");
		model.addColumn("NAME");
		model.addColumn("MARK1");
		model.addColumn("MARK2");
		model.addColumn("MARK3");
	
		jt=new JTable(model);
		js=new JScrollPane(jt);
		jf.add(js);
		
		badd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				model.addRow(new Object[]{trno.getText(),tname.getText(),tm1.getText(),tm2.getText(),tm3.getText()});
				trno.setText("");tname.setText("");tm1.setText("");tm2.setText("");tm3.setText("");
				jf.getContentPane().repaint();
			}
		});

		bdel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				for(int i=0;i<model.getRowCount();i++)
					if(trno.getText().equals(model.getValueAt(i,0)))
						model.removeRow(i);
				jf.getContentPane().repaint();

			}
		});
		bfind.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				boolean flag=false;
				for(int i=0;i<model.getRowCount();i++)
					if(trno.getText().equals(model.getValueAt(i,0))){
						flag=true;
						jt.setRowSelectionInterval(i,i);
				}
				if(!flag)
					JOptionPane.showMessageDialog(jf,"Invalid Rollno");
				jf.getContentPane().repaint();

			}
		});

		fupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				boolean flag=false;
				int i;
				for(i=0;i<model.getRowCount();i++)
					if(trno.getText().equals(model.getValueAt(i,0))){
						flag=true;
						model.removeRow(i);
						break;
				}
				if(flag){
					model.insertRow(i,new Object[]{trno.getText(),tname.getText(),tm1.getText(),tm2.getText(),tm3.getText()});
					trno.setText("");tname.setText("");tm1.setText("");tm2.setText("");tm3.setText("");
				}
				jf.getContentPane().repaint();

			}
		});









		jf.validate();
		jf.repaint();	
	}
	public static void main(String args[]){
		new StudentDemo();
	}
}
