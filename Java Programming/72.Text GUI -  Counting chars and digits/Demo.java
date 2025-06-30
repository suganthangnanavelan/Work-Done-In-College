/*
Create a GUI with appropriate components to accept input from the user
and to display the output. Count and display the number of characters and
digits in the input using mouse and key event.
*/
import java.awt.*;
import java.awt.event.*;

class CharacterDigitCounterGUI extends Frame {
    private TextField inputField;
    private Label resultLabel;

    CharacterDigitCounterGUI() {
        setTitle("Character and Digit Counter");
        setSize(400, 150);

        // Initialize components
        inputField = new TextField();
        resultLabel = new Label("Result: ");

        // Set layout manager
        setLayout(new GridLayout(2,1));

        // Add components to the content pane
        add(inputField);
        add(resultLabel);

        // Add action listener to the button
        inputField.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
		countCharactersAndDigits();
            }
        });
    }

    void countCharactersAndDigits() {
        String inputText = inputField.getText();
        int charCount = 0;
        int digitCount = 0;
        for (char c : inputText.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            } else if (Character.isLetter(c)) {
                charCount++;
            }
        }
        String resultText = "Result: Characters - " + charCount + ", Digits - " + digitCount;
        resultLabel.setText(resultText);
    }

    public static void main(String[] args) {
        new CharacterDigitCounterGUI().setVisible(true);
    }
}