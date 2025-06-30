import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TemperatureConverterGUI extends JFrame {
    JTextField celsiusField;
    JTextField fahrenheitField;
    JButton convertButton;
    JButton cancelButton;
    TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        celsiusField = new JTextField(10);
        fahrenheitField = new JTextField(10);
        fahrenheitField.setEditable(false); // Make Fahrenheit field read-only
        convertButton = new JButton("Convert");
        cancelButton =new JButton("Cancel");
        // Set layout manager
        setLayout(new GridLayout(3,2,10,10));

        // Add components to the content pane
        add(new JLabel("Celsius:"));
        add(celsiusField);
        add(new JLabel("Fahrenheit:"));
        add(fahrenheitField);
        add(convertButton);
	add(cancelButton);

        // Add action listener to the button
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                celsiusField.setText("");
                fahrenheitField.setText("");
            }
        });
    }

    void convertTemperature() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = (celsius * 9/5) + 32;
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number for Celsius.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TemperatureConverterGUI().setVisible(true);
            }
        });
    }
}