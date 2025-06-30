import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Contact {
    String name;
    String address;
    String phone;

    Contact(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone;
    }
}
class AddressBookApp extends JFrame {

    JTextField nameField;
    JTextField addressField;
    JTextField phoneField;
    JTextArea displayArea;
    ArrayList<Contact> contacts;

    AddressBookApp() {
        setTitle("Address Book");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        nameField = new JTextField(20);
        addressField = new JTextField(20);
        phoneField = new JTextField(20);
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);
        contacts = new ArrayList<Contact>();

        JButton addButton = new JButton("Add Contact");
        JButton displayButton = new JButton("Display Contacts");

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the content pane
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Address:"));
        inputPanel.add(addressField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);
        inputPanel.add(addButton);
        inputPanel.add(displayButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayContacts();
            }
        });
    }

    void addContact() {
        String name = nameField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

        if (!name.isEmpty() && !address.isEmpty() && !phone.isEmpty()) {
            Contact contact = new Contact(name, address, phone);
            contacts.add(contact);
            nameField.setText("");
            addressField.setText("");
            phoneField.setText("");
        }else
            JOptionPane.showMessageDialog(this, "Please enter all fields.");
    }

    void displayContacts() {
        if (contacts.isEmpty())
            displayArea.setText("No contacts available.");
        else{
            StringBuilder displayText = new StringBuilder();
            for (Contact contact : contacts) {
                displayText.append(contact).append("\n");
            }
            displayArea.setText(displayText.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AddressBookApp().setVisible(true);
            }
        });
    }
}