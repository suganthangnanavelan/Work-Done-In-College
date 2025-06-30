import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Book {
    String title;
    String author;
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String toString() {
        return title + " by " + author;
    }
}

class LibrarySystemGUI extends JFrame {
    JTextField titleField;
    JTextField authorField;
    JButton addButton;
    JTextArea bookListArea;
    ArrayList<Book> libraryBooks;

    LibrarySystemGUI() {
        setTitle("Library System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        titleField = new JTextField();
        authorField = new JTextField();
        addButton = new JButton("Add Book");
        bookListArea = new JTextArea();
        libraryBooks = new ArrayList<>();

        // Set layout manager
        setLayout(new GridLayout(4, 2, 10, 10)); // 4 rows, 2 columns, horizontal and vertical gap

        // Add components to the content pane
        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Author:"));
        add(authorField);
        add(new JLabel()); // Placeholder for spacing
        add(addButton);
        add(new JLabel("Book List:"));
        add(new JScrollPane(bookListArea));

        // Add action listener to the button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();

        if (!title.isEmpty() && !author.isEmpty()) {
            Book newBook = new Book(title, author);
            libraryBooks.add(newBook);
            updateBookList();
            titleField.setText("");
            authorField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both title and author.");
        }
    }

    void updateBookList() {
        bookListArea.setText("");
        for(Book book : libraryBooks) {
            bookListArea.append(book.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibrarySystemGUI().setVisible(true);
            }
        });
    }
}