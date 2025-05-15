package loginandsignup;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class Book {
    String id, title, author, publisher, year, isbn, copies;
    double price;

    public Book(String id, String title, String author, String publisher, String year, String isbn, String copies, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.isbn = isbn;
        this.copies = copies;
        this.price = price;
    }
}

public class Library_management extends JFrame implements ActionListener {
    private ArrayList<Book> books = new ArrayList<>();
    private AdminPanel adminPanel;
    private UserPanel userPanel;

    public Library_management() {
        setTitle("Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);

        adminPanel = new AdminPanel(this);
        userPanel = new UserPanel(this);

        setContentPane(adminPanel);
        setVisible(true);
    }

    public void switchToUserPanel() {
        setContentPane(userPanel);
        revalidate();
        repaint();
    }

    public void switchToAdminPanel() {
        setContentPane(adminPanel);
        revalidate();
        repaint();
    }

    public void addBook(Book book) {
        books.add(book);
        JOptionPane.showMessageDialog(this, "Book added successfully");
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public static void main(String[] args) {
        new Library_management();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Not used in this context
    }
}

class AdminPanel extends JPanel implements ActionListener {
    private JTextField[] textFields;
    private Library_management libraryManagement;
    private JButton addButton, viewButton, userButton, exitButton, editButton, deleteButton, clearButton;

    public AdminPanel(Library_management libraryManagement) {
        this.libraryManagement = libraryManagement;

        setLayout(new BorderLayout());
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        headerPanel.setBackground(Color.BLACK);
        JLabel titleLabel = new JLabel("Admind and Librarians", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 30));
        titleLabel.setForeground(Color.WHITE);
        headerPanel.add(titleLabel);
        add(headerPanel, BorderLayout.NORTH);

        // Side Panel for buttons (left side)
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new GridLayout(0, 1, 10, 10));
        sidePanel.setPreferredSize(new Dimension(300, 25));
        sidePanel.setBackground(Color.BLACK);
        
       

        addButton = createButton("Add Book");
        viewButton = createButton("View Books");
        userButton = createButton("User  Page");
        exitButton = createButton("Logout Librarian");
        editButton = createButton("Edit Book");
        deleteButton = createButton("Delete Book");
        clearButton = createButton("Clear Books");

        sidePanel.add(addButton);
        sidePanel.add(viewButton);
        sidePanel.add(userButton);
        sidePanel.add(exitButton);
        sidePanel.add(editButton);
        sidePanel.add(deleteButton);
        sidePanel.add(clearButton);

        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout()); 
        formPanel.setBackground(Color.BLACK);
        formPanel.setForeground(Color.WHITE);
        formPanel.setOpaque(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(15, 15, 15, 15); 

        String[] labels = {"Book ID", "Book Title", "Author", "Publisher", "Year of Publication", "ISBN", "Number of Copies", "Price"};
        textFields = new JTextField[8];



        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; 
            gbc.gridy = i; 
            gbc.anchor = GridBagConstraints.CENTER; 
            formPanel.add(new JLabel(labels[i]), gbc);

            gbc.gridx = 1; 
            textFields[i] = new JTextField(20);
            gbc.anchor = GridBagConstraints.CENTER; // Center the text field
            formPanel.add(textFields[i], gbc);
        }

        add(formPanel, BorderLayout.CENTER);
        add(sidePanel, BorderLayout.WEST);

        // Button listeners
        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        userButton.addActionListener(this);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
    }
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt){
        int response = JOptionPane.showConfirmDialog(null, 
                    "Are YOu Sure You Want to Logout?", 
                    "Confirm Logout", 
                    JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
                
                // Handle the response
                if (response == JOptionPane.YES_OPTION) {
                    // User chose to log out
                    JOptionPane.showMessageDialog(null, "Logged out successfully.");
                    Dashboard1 dashboard1 = new Dashboard1();
                    dashboard1.setVisible(true);
                    dashboard1.setLocationRelativeTo(null);
                    Library_management management = new Library_management();
                    management.dispose();
                                
                } else if (response == JOptionPane.NO_OPTION) {
                    
                    JOptionPane.showMessageDialog(null, "Logout canceled.");
                } else if (response == JOptionPane.CANCEL_OPTION) {
                    
                    //JOptionPane.showMessageDialog(null, "Logout action canceled.");
                }
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(180, 50));  // Set a fixed size for all buttons
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(70, 130, 180)); // Set button color
        button.setForeground(Color.WHITE); // Set text color to white
        button.setFocusPainted(false); // Remove focus border
        button.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        return button;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Book")) {
            addBook();
        } else if (e.getActionCommand().equals("View Books")) {
            viewBooks();
        } else if (e.getActionCommand().equals("Edit Book")) {
            editBook();
        } else if (e.getActionCommand().equals("Delete Book")) {
            deleteBook();
        } else if (e.getActionCommand().equals("Clear Books")) {
            clearBooks();
        } else if (e.getActionCommand().equals("User  Page")) {
            libraryManagement.switchToUserPanel();
        }
    }

    private void addBook() {
        String id = textFields[0].getText();
        String title = textFields[1].getText();
        String author = textFields[2].getText();
        String publisher = textFields[3].getText();
        String year = textFields[4].getText();
        String isbn = textFields[5].getText();
        String copies = textFields[6].getText();
        double price = Double.parseDouble(textFields[7].getText());

        Book book = new Book(id, title, author, publisher, year, isbn, copies, price);
        libraryManagement.addBook(book);
        clearFields();
    }

    private void viewBooks() {
        String[] columns = {"Book ID", "Book Title", "Author", "Publisher", "Year of Publication", "ISBN", "Number of Copies", "Price"};
        ArrayList<Book> books = libraryManagement.getBooks();
        Object[][] data = new Object[books.size()][8];

        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            data[i][0] = book.id;
            data[i][1] = book.title;
            data[i][2] = book.author;
            data[i][3] = book.publisher;
            data[i][4] = book.year;
            data[i][5] = book.isbn;
            data[i][6] = book.copies;
            data[i][7] = book.price;
        }

        JTable table = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(table);
        JFrame frame = new JFrame("View Books");
        frame.add(scrollPane);
        frame.setSize(800, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private void editBook() {
        String id = JOptionPane.showInputDialog(this, "Enter book ID to edit:");
        for (Book book : libraryManagement.getBooks()) {
            if (book.id.equals(id)) {
                book.title = JOptionPane.showInputDialog(this, "Enter new Book Title:");
                book.author = JOptionPane.showInputDialog(this, "Enter new Book Author:");
                book.publisher = JOptionPane.showInputDialog(this, "Enter new Book Publisher:");
                book.year = JOptionPane.showInputDialog(this, "Enter new Book Year - Published:");
                book.isbn = JOptionPane.showInputDialog(this, "Enter new Book ISBN:");
                book.copies = JOptionPane.showInputDialog(this, "Enter new Book Copies:");
                book.price = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter new Book Price:"));

                int response = JOptionPane.showConfirmDialog(null, "Are You Sure You want do Edit?", "Confirm", JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Book updated successfully");
                    clearFields();
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Book not found.");
    }
    

    private void deleteBook() {
        String id = JOptionPane.showInputDialog(this, "Enter book ID to delete:");
        for (int i = 0; i < libraryManagement.getBooks().size(); i++) {
            if (libraryManagement.getBooks().get(i).id.equals(id)) {
                libraryManagement.getBooks().remove(i);
                JOptionPane.showMessageDialog(this, "Book deleted successfully");
                clearFields();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Book not found.");
    }

    private void clearBooks() {
        libraryManagement.getBooks().clear();
        JOptionPane.showMessageDialog(this, "All books cleared successfully");
    }

    private void clearFields() {
        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }
}