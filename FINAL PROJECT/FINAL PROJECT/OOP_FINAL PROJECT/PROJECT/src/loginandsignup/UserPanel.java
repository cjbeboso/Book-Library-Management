package loginandsignup;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


class UserPanel extends JPanel implements ActionListener{
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
        headerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerLabel.setForeground(Color.WHITE); // Set label text color to white
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Buttons
        viewBooksButton = createButton("View Available Books");
        buyBookButton = createButton("Buy Book");
        backButton = createButton("Back to Admin Panel");

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());  // Use GridBagLayout to center buttons
        buttonPanel.setBackground(Color.BLACK);  // Set background to black
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);  // Add some space between buttons

        // Centering buttons on the panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(viewBooksButton, gbc);
        gbc.gridy++;
        buttonPanel.add(buyBookButton, gbc);
        gbc.gridy++;
        buttonPanel.add(backButton, gbc);

        // Add components to the main panel
        add(headerLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBackground(Color.BLUE); // Set button color to blue
        button.setForeground(Color.WHITE); // Set text color to white
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
            libraryManagement.switchToUserPanel();
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
                    "Do you want to buy \"" + book.title + "\" for PHP" + book.price + "?",
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
