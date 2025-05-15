package loginandsignup;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

class UserFrame1 extends JFrame {
    private Library_management libraryManagement;

    public UserFrame1(Library_management libraryManagement) {
        this.libraryManagement = libraryManagement;
        setTitle("User  Page - Browse and Purchase Books");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Integrating UserPanel into UserFrame
        UserPanel userPanel = new UserPanel(libraryManagement);
        add(userPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // For testing purposes only
    public static void main(String[] args) {
        // Replace with actual libraryManagement instance
        Library_management libraryManagement = new Library_management();
        new UserFrame1(libraryManagement);
    }
}

class UserPanel extends JPanel implements ActionListener {
    private Library_management libraryManagement;
    private JButton viewBooksButton, buyBookButton, backButton;

    public UserPanel(Library_management libraryManagement) {
        this.libraryManagement = libraryManagement;

        // Set background color and text color
        setBackground(Color.BLACK); // Set background color to black
        setForeground(Color.WHITE); // Set text color to white
        setLayout(new BorderLayout()); // Use BorderLayout for overall layout

        // Header
        JLabel headerLabel = new JLabel("User  Page - Browse and Purchase Books", JLabel.CENTER);
        headerLabel.setFont(new Font("Algerian", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Buttons
        int buttonWidth = 150; // Adjust as needed
        int buttonHeight = 40; // Adjust as needed
        viewBooksButton = createButton("View Available Books", buttonWidth, buttonHeight);
        buyBookButton = createButton("Buy Book", buttonWidth, buttonHeight);
        backButton = createButton("Back", buttonWidth, buttonHeight);

        // Panel for buttons - using FlowLayout for equal button sizing
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Added spacing
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(viewBooksButton);
        buttonPanel.add(buyBookButton);
        buttonPanel.add(backButton);
        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
        buttonPanel.setAlignmentY(CENTER_ALIGNMENT);


        add(headerLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(width, height)); // Set preferred size
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewBooksButton) {
            viewAvailableBooks();
        } else if (e.getSource() == buyBookButton) {
            buyBook();
        } else if (e.getSource() == backButton) {
            new Dashboard1().setVisible(true); // Assuming Dashboard1 class exists
            JOptionPane.showMessageDialog(this, "Going back to the previous screen...");

        }
    }

    private void viewAvailableBooks() {
        String[] columns = {"Book ID", "Book Title", "Author", "Price"};
        ArrayList<Book> books = libraryManagement.getBooks();

        if (books.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No books are available.", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        Object[][] data = new Object[books.size()][4];
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            data[i][0] = book.id;
            data[i][1] = book.title;
            data[i][2] = book.author;
            data[i][3] = book.price;
        }

        JTable table = new JTable(data, columns);
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);

        JFrame frame = new JFrame("Available Books");
        frame.add(scrollPane);
        frame.setSize(600, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(this);
    }

    private void buyBook() {
        String id = JOptionPane.showInputDialog(this, "Enter the Book ID to buy:");
        if (id == null || id.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Book ID cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Book book : libraryManagement.getBooks()) {
            if (book.id.equals(id)) {
                int response = JOptionPane.showConfirmDialog(
                        this,
                        "Do you want to buy \"" + book.title + "\" for  PHP" + book.price + "?",
                        "Confirm Purchase",
                        JOptionPane.YES_NO_OPTION
                );

                if (response == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, "Thank you for your purchase!", "Purchase Successful", JOptionPane.INFORMATION_MESSAGE);
                    return;
                } else {
                    return;
                }
            }
        }
        JOptionPane.showMessageDialog(this, "Book not found. Please check the ID.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


//Dummy Class -  Replace with your actual Library_management and Book classes
class Library_management {
    public ArrayList<Book> getBooks() {
        return new ArrayList<>(); //Replace with your actual book list
    }
}

class Book {
    String id;
    String title;
    String author;
    double price;

    public Book(String id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

class Dashboard1 extends JFrame{
    public Dashboard1(){
        setSize(400,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(false);
    }
}