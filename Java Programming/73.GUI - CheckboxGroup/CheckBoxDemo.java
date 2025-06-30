// Demonstrate JCheckbox. 
import java.awt.*; 
import java.awt.event.*; 

class CheckBoxDemo extends Frame implements ItemListener{ 
	CheckboxGroup cbg;
	Checkbox cb1;
	Checkbox cb2;
	Checkbox cb3;
	Checkbox cb4;
	Label lab;
	CheckBoxDemo () {
		setTitle("CheckBoxDemo"); 				
		setLayout(new FlowLayout()); 
		setSize (300, 300);
    		// Add check boxes to the content pane. 
		// Add check boxes to the same group.
		cbg=new CheckboxGroup();
      		cb1 = new Checkbox("White",cbg,true); 
		cb1.addItemListener(this); add(cb1);
      		cb2 = new Checkbox("Red",cbg,false); 
		cb2.addItemListener(this); add(cb2);
      		cb3 = new Checkbox("Yellow",cbg,false); 
		cb3.addItemListener(this); add(cb3);
      		cb4 = new Checkbox("Blue",cbg,false);
		cb4.addItemListener(this); add(cb4);
		// Create the label and add it to the content pane. 
		lab = new Label("Select Any Color");
		lab.setFont(new Font("Arial",Font.BOLD,20)); 
                add(lab);
		// Display the frame. 
		setVisible(true);
	}
	// Handle item events for the check boxes. 
	public void itemStateChanged (ItemEvent ie){ 
		lab.setText("Selected: "+cbg.getSelectedCheckbox().getLabel());
		switch(cbg.getSelectedCheckbox().getLabel()){
			case "Red":setBackground(Color.red);
			           cb1.setBackground(Color.red);
			           cb2.setBackground(Color.red);
			           cb3.setBackground(Color.red);
			           cb4.setBackground(Color.red);
				   lab.setBackground(Color.red);
				   break;
			case "Yellow":setBackground(Color.yellow);
			           cb1.setBackground(Color.yellow);
			           cb2.setBackground(Color.yellow);
			           cb3.setBackground(Color.yellow);
			           cb4.setBackground(Color.yellow);
				   lab.setBackground(Color.yellow);
				   break;
			case "Blue":setBackground(Color.blue);
			           cb1.setBackground(Color.blue);
			           cb2.setBackground(Color.blue);
			           cb3.setBackground(Color.blue);
			           cb4.setBackground(Color.blue);
				   lab.setBackground(Color.blue);
				   break;
			default:setBackground(Color.white);
			           cb1.setBackground(Color.white);
			           cb2.setBackground(Color.white);
			           cb3.setBackground(Color.white);
			           cb4.setBackground(Color.white);
				   lab.setBackground(Color.white);
		}
	}
	public static void main(String[] args) {
		new CheckBoxDemo ();
	}
}