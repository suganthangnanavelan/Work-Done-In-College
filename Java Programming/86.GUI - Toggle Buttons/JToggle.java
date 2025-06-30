import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.JToggleButton;
import java.awt.*;
 
public class JToggle{
 
    public static void main(String args[])
    {
        JFrame frame = new JFrame("Selecting Toggle");
	JPanel pan=new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JToggleButton toggleButton = new JToggleButton("Toggle Button");
        ItemListener itemListener = new ItemListener() {
            public void itemStateChanged(ItemEvent itemEvent)
            {
                int state = itemEvent.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    System.out.println("Selected");
			pan.setBackground(Color.red);
                }
                else {
                    System.out.println("Deselected");
			pan.setBackground(Color.yellow);
                }
		pan.repaint();
		frame.validate();frame.repaint();
            }
        };
 
        // Attach Listeners
        toggleButton.addItemListener(itemListener);
        frame.add(toggleButton, BorderLayout.NORTH);
	frame.add(pan, BorderLayout.CENTER);
        frame.setSize(300, 125);
        frame.setVisible(true);
	frame.validate();frame.repaint();
    }
}