import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SimpleCalculator extends JFrame {
    JPanel jp;
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;
    private JButton equalsButton;
    private JButton clearButton;
    private double num1;
    private double num2;
    private String operator;

    SimpleCalculator() {
        setTitle("Simple Calculator");
	setLayout(null);
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Initialize components
        displayField = new JTextField();
        displayField.setBounds(0,0,getWidth(),80);
        displayField.setEditable(false);
	displayField.setFont(new Font("Arial",Font.BOLD,25));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial",Font.BOLD,20));
        }

        operationButtons = new JButton[4];
        operationButtons[0] = new JButton("+");
        operationButtons[0].setFont(new Font("Arial",Font.BOLD,20));
        operationButtons[1] = new JButton("-");
        operationButtons[1].setFont(new Font("Arial",Font.BOLD,20));
        operationButtons[2] = new JButton("*");
        operationButtons[2].setFont(new Font("Arial",Font.BOLD,20));
        operationButtons[3] = new JButton("/");
        operationButtons[3].setFont(new Font("Arial",Font.BOLD,20));

        jp=new JPanel();
	jp.setBounds(5,90,getWidth()-25,getHeight()-70);
        // Set layout manager
        jp.setLayout(new GridLayout(5, 4, 5, 5));

        equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial",Font.BOLD,20));
        clearButton = new JButton("C");
        clearButton.setFont(new Font("Arial",Font.BOLD,20));

        // Add components to the panel
        jp.add(clearButton);
        for (int i = 1; i < 10; i++)
            jp.add(numberButtons[i]);
        jp.add(numberButtons[0]);
        for (int i = 0; i < 4; i++)
            jp.add(operationButtons[i]);

        jp.add(equalsButton);

        // Add action listeners to the buttons
        for (JButton button : numberButtons)
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    displayField.setText(displayField.getText() + source.getText());
                }
            });

        for (JButton button : operationButtons)
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    JButton source = (JButton) e.getSource();
                    num1 = Double.parseDouble(displayField.getText());
                    operator = source.getText();
                    displayField.setText("");
                }
             });

        equalsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num2 = Double.parseDouble(displayField.getText());
                double result = 0;  
                switch (operator){
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0)
                            result = num1 / num2;
                        else{
                            displayField.setText("Error");
                            return;
                        }
                }
                displayField.setText(String.valueOf(result));
            }
	});
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                displayField.setText("");
            }
        });

	add(displayField);
        add(jp);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleCalculator().setVisible(true);
            }
        });
    }
}