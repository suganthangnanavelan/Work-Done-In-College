/*

Create class called employees with empno name and salary
Split frame into two panels
Left panel to be designed to get details from user
Right panel should display empno empname basicpay hra(10% baspay) da(50% of baspay) pf(2% of baspay). gross pay (baspay+hra+da) netpay (grosspay - pf)

Include add delete update search buttons to perform relevant task in the table

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class Employee{
	int empno;
	String empname;
	double salary;
	Employee(int empno,String empname,double salary){
		this.empno=empno;
		this.empname=empname;
		this.salary=salary;
	}
	String[] toStringArray(){
		String[] row={String.valueOf(empno),empname,String.valueOf(salary),String.valueOf(10.0/100*salary),String.valueOf(50.0/100*salary),String.valueOf(2.0/100*salary),String.valueOf(salary+(10.0/100*salary)+(50.0/100*salary)),String.valueOf(salary+(10.0/100*salary)+(50.0/100*salary)-(2.0/100*salary))};
		return row;
	}
}

class EmployeeDemo{
	JFrame jf;
	JPanel jp;
	JScrollPane js;
	JTable jt;
	JLabel lempno,lempname,lbp;
	JTextField tempno,tempname,tbp;
	JButton badd,bdel,bsearch,fupdate;

	EmployeeDemo(){
		jf=new JFrame("Employee");
		jf.setVisible(true);
		jf.setSize(1000,500);
		jf.setLayout(new GridLayout(1,2));
		jp=new JPanel();
		jp.setLayout(new GridLayout(6,2,10,50));
		jp.setFont(new Font("Arial",Font.BOLD,30));

		lempno=new JLabel("Employee No:"); jp.add(lempno);
		tempno=new JTextField(10); 	jp.add(tempno);	
		lempname=new JLabel("Name:"); 	jp.add(lempname);
		tempname=new JTextField(10); 	jp.add(tempname);	
		lbp=new JLabel("Salary:"); 	jp.add(lbp);
		tbp=new JTextField(10); 	jp.add(tbp);

		badd=new JButton("ADD"); 	jp.add(badd);
		bdel=new JButton("DELETE"); 	jp.add(bdel);
		bsearch=new JButton("SEARCH"); 	jp.add(bsearch);
		fupdate=new JButton("UPDATE"); 	jp.add(fupdate);

		DefaultTableModel model=new DefaultTableModel();
		model.addColumn("EmpNo");
		model.addColumn("Name");
		model.addColumn("Basic Pay");
		model.addColumn("HRA");
		model.addColumn("DA");
		model.addColumn("PF");
		model.addColumn("Gross Pay");
		model.addColumn("Net Pay");

		jf.add(jp);
		jt=new JTable(model);
		js=new JScrollPane(jt);
		jf.add(js);
		
		badd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
					if(tempno.getText().equals("")){
						JOptionPane.showMessageDialog(jf,"Employee Number Is Empty");
						return;
					}
					else{
						try{Integer.parseInt(tempno.getText());}
						catch(NumberFormatException exp){
							JOptionPane.showMessageDialog(jf,"Invalid Input for EmpNo");
						tempno.setText("");
						return;
						}
					}
					if(tempname.getText().equals("")){
						JOptionPane.showMessageDialog(jf,"Employee Name Is Empty");
						return;
					}
					if(tbp.getText().equals("")){
						JOptionPane.showMessageDialog(jf,"Employee Salary Is Empty");
						return;
					}
					else{
						try{Double.parseDouble(tbp.getText());}
						catch(NumberFormatException exp){
							JOptionPane.showMessageDialog(jf,"Invalid Input for Salary");
							tbp.setText("");
							return;
						}
					}
					Employee emp=new Employee(Integer.parseInt(tempno.getText()),tempname.getText(),Double.parseDouble(tbp.getText()));
					model.addRow(emp.toStringArray());
					tempno.setText("");tempname.setText("");tbp.setText("");
					jf.getContentPane().repaint();	
			}
		});

		bdel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(tempno.getText().equals("")){
					JOptionPane.showMessageDialog(jf,"Employee Number Is Empty");
					return;
				}
				else{
					try{Integer.parseInt(tempno.getText());}
					catch(NumberFormatException exp){
						JOptionPane.showMessageDialog(jf,"Invalid Input for EmpNo");
						tempno.setText("");
						return;
					}
				}
				boolean flag=false;
				for(int i=0;i<model.getRowCount();i++)
					if(tempno.getText().equals(model.getValueAt(i,0))){
						flag=true;
						model.removeRow(i);
					}
				if(!flag)
					JOptionPane.showMessageDialog(jf,"Couldn't Delete Employee Not Found");
					
				jf.getContentPane().repaint();
			}
		});
		bsearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(tempno.getText().equals("")){
					JOptionPane.showMessageDialog(jf,"Employee Number Is Empty");
					return;
				}
				else{
					try{Integer.parseInt(tempno.getText());}
					catch(NumberFormatException exp){
						JOptionPane.showMessageDialog(jf,"Invalid Input for EmpNo");
						tempno.setText("");
						return;
					}
				}
				boolean flag=false;
				for(int i=0;i<model.getRowCount();i++)
					if(tempno.getText().equals(model.getValueAt(i,0))){
						flag=true;
						jt.setRowSelectionInterval(i,i);
				}
				if(!flag)
					JOptionPane.showMessageDialog(jf,"Employee Not Found");
				jf.getContentPane().repaint();

			}
		});
		fupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				if(tempno.getText().equals("")){
					JOptionPane.showMessageDialog(jf,"Employee Number Is Empty");
					return;
				}
				else{
					try{Integer.parseInt(tempno.getText());}
					catch(NumberFormatException exp){
						JOptionPane.showMessageDialog(jf,"Invalid Input for EmpNo");
					tempno.setText("");
					return;
					}
				}
				if(tempname.getText().equals("")){
					JOptionPane.showMessageDialog(jf,"Employee Name Is Empty");
					return;
				}
				if(tbp.getText().equals("")){
					JOptionPane.showMessageDialog(jf,"Employee Salary Is Empty");
					return;
				}
				else{
					try{Double.parseDouble(tbp.getText());}
					catch(NumberFormatException exp){
						JOptionPane.showMessageDialog(jf,"Invalid Input for Salary");
						tbp.setText("");
						return;
					}
				}
				boolean flag=false;
				int i;
				for(i=0;i<model.getRowCount();i++)
					if(tempno.getText().equals(model.getValueAt(i,0))){
						flag=true;
						model.removeRow(i);
						break;
					}
				if(flag){
					Employee emp=new Employee(Integer.parseInt(tempno.getText()),tempname.getText(),Double.parseDouble(tbp.getText()));
					model.insertRow(i,emp.toStringArray());
					tempno.setText("");tempname.setText("");tbp.setText("");
					jf.getContentPane().repaint();
				}
				else{
					JOptionPane.showMessageDialog(jf,"Employee Not Found");
				}
				jf.getContentPane().repaint();

			}
		});
		jf.validate();
		jf.repaint();	
	}
	public static void main(String args[]){
		new EmployeeDemo();
	}
}