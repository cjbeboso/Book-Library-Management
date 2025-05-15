package LibraryManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Main class for Library Management System
public class LibraryManagement extends JFrame {
	
	// Holds the Book's Information
    private List<Books> library;
    
    // Text fields for user input (Book information)
    private JTextField titleField;
    private JTextField isbnField;
    private JTextField genreField;
    private JTextField publishYearField;
    private JTextField quantityField;
    private JTextField authorField;
    private JTextField starField;
    
    // Text fields for user input (Member information)
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField addressField;
    private JTextField registrationField;
     
    // Label to display status or message
    private JLabel statusLabel;
    
    // Connection for MySQL database
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library?user=root&password=1234";
    private Connection connection;
   
    // Constructor
    public LibraryManagement() {
        // Set up the main frame
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800, 1500);
       

        // Initialize the library list
        library = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(JDBC_URL);
        } catch (SQLException e) {
            showError("Failed to connect to the database: " + e.getMessage());
        }

        // Create components
        JLabel titleLabel = new JLabel("Book Title:");
        JLabel isbnLabel = new JLabel("ISBN:");
        JLabel genreLabel = new JLabel("Genre:");
        JLabel publishYearLabel = new JLabel("Publish Year:");
        JLabel quantityLabel = new JLabel("Quantity:");
        JLabel authorLabel = new JLabel("Author:");
        JLabel starLabel = new JLabel("Stars (Out of 5):");

        // Text fields for user input
        titleField = new JTextField(45);
        isbnField = new JTextField(45);
        genreField = new JTextField(45);
        publishYearField = new JTextField(45);
        quantityField = new JTextField(45);
        authorField = new JTextField(45);
        starField = new JTextField(45);
        statusLabel = new JLabel();
        
        // Create components
        JLabel nameLabel = new JLabel("Member Name:");
        JLabel phoneLabel = new JLabel("Phone Number:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel addressLabel = new JLabel("Address:");
        JLabel registrationLabel = new JLabel("Registration Date:");
        

        // Text fields for user input
        nameField = new JTextField(45);
        phoneField = new JTextField(45);
        emailField = new JTextField(45);
        addressField = new JTextField(45);
        registrationField = new JTextField(45);
        statusLabel = new JLabel();
        
        // Buttons for various actions
        JButton addButton = new JButton("Add Book");
        JButton removeButton = new JButton("Remove Book");
        JButton updateButton = new JButton("Update Record");
        JButton findButton = new JButton("Find Book");
        JButton findMemberButton = new JButton("Find Member's Info");
        JButton displayMostLikedButton = new JButton("Display Top 5 Liked Books");
        JButton addMemberButton = new JButton("Add Member");
        JButton removeMemberButton = new JButton("Remove Member");

        // Set layout manager
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Input Section
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Book Information"));
   
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(titleLabel, gbc);
        gbc.gridx = 1;
        
        inputPanel.add(titleField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(isbnLabel, gbc);
        gbc.gridx = 1;
        
        inputPanel.add(isbnField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(genreLabel, gbc);
        gbc.gridx = 1;
        
        inputPanel.add(genreField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(publishYearLabel, gbc);
        gbc.gridx = 1;
        
        inputPanel.add(publishYearField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(quantityLabel, gbc);
        gbc.gridx = 1;
        
        inputPanel.add(quantityField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(authorLabel, gbc);
        gbc.gridx = 1;
       
        inputPanel.add(authorField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(starLabel, gbc);
        gbc.gridx = 1;
        
        inputPanel.add(starField, gbc);
        
        
        setLayout(new GridBagLayout());
        GridBagConstraints abc = new GridBagConstraints();
        abc.insets = new Insets(5, 5, 5, 5);
        
        // Data Section (Member Information)
        JPanel dataPanel = new JPanel(new GridBagLayout());
        dataPanel.setBorder(BorderFactory.createTitledBorder("Member Information"));
   
        gbc.gridx = 0;
        gbc.gridy = 0;
        dataPanel.add(nameLabel, gbc);
        gbc.gridx = 1;
        
        dataPanel.add(nameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        dataPanel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        
        dataPanel.add(phoneField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        dataPanel.add(emailLabel, gbc);
        gbc.gridx = 1;
        
        dataPanel.add(emailField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        dataPanel.add(addressLabel, gbc);
        gbc.gridx = 1;
        
        dataPanel.add(addressField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        dataPanel.add(registrationLabel, gbc);
        gbc.gridx = 1;
        
        dataPanel.add(registrationField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
       
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(dataPanel, gbc);
        

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(displayMostLikedButton);
        buttonPanel.add(findButton);
        buttonPanel.add(addMemberButton);
        buttonPanel.add(findMemberButton);
       

        // Adds the button panel to the main frame
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

    
        // Creates a panel to hold the Find buttons
        JPanel findPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        findPanel.setBorder(BorderFactory.createTitledBorder("Find Information"));
        findPanel.add(addMemberButton);
        findPanel.add(removeMemberButton);
        findPanel.add(findMemberButton);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        dataPanel.add(findPanel, gbc); 
 
        // Adds input and display panels to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(inputPanel, gbc);
        
        // Adds Find panel below the inventoryTextArea
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(findPanel, gbc);
        
     
        // Action listeners for buttons
        // Action listener for the "Add Book" button
        addButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		addBook();
        	}
        });
        

        // Action listener for the "Remove Book" button
        removeButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		removeBook();
        	}
        });

        // Action listener for the "Update Record" button
        updateButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		updateRecord();
        	}
        });
        
        // Action listener for the "Find Book" button
        findButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		findBook();
        	}
        });
     
        // Action listener for the "Find Member" button
        findMemberButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		findMember();
        	}
        });
        
        // Action listener for the "Find Customer" button
        addMemberButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		addMember();
        	}
        });
        
        // Action listener for the "Display 5 Top Rated Books" button
        displayMostLikedButton.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		displayTopLikedBooks();
        	}
        });
        
     // Action listener for the "Remove Member Button" button
        removeMemberButton.addActionListener(new ActionListener() {
         	@Override
         	public void actionPerformed(ActionEvent e) {
             	removeMember();
         	}
     	});
    }
    // Function to add a book
    private void addBook() {
        String title = titleField.getText();
        String isbn = isbnField.getText();
        String genre = genreField.getText();
        int publishYear = 0;
        int quantity = 0;
        String author = authorField.getText();
        int stars = 0;

        try {
            publishYear = Integer.parseInt(publishYearField.getText());
            quantity = Integer.parseInt(quantityField.getText());
            stars = Integer.parseInt(starField.getText());
        } catch (NumberFormatException ex) {
            showError("Invalid input. Please enter valid numbers.");
            return;
        }

        Books book = new Books(title, isbn, genre, publishYear, quantity, author, stars);
        library.add(book);

        // Stores the book in the database
        addBookToDatabase(book);

        // Clears the fields
        clearBookFields();
    }
    
    // Function to remove a book
    private void removeBook() {
        String bookTitleToRemove = JOptionPane.showInputDialog("Enter the book title to remove:");

        if (bookTitleToRemove != null && !bookTitleToRemove.isEmpty()) {
            try {
                // Check if the book exists in the database
                String checkQuery = "SELECT * FROM books WHERE title = ?";
                try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                    checkStatement.setString(1, bookTitleToRemove);
                    ResultSet resultSet = checkStatement.executeQuery();

                    if (resultSet.next()) {
                        // Book found, proceed with removal
                        String removeQuery = "DELETE FROM books WHERE title = ?";
                        try (PreparedStatement removeStatement = connection.prepareStatement(removeQuery)) {
                            removeStatement.setString(1, bookTitleToRemove);
                            removeStatement.executeUpdate();
                        }

                        JOptionPane.showMessageDialog(null, "Book removed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Book not found.");
                    }
                }
            } catch (SQLException ex) {
                showError("Error removing book: " + ex.getMessage());
            }
        } else {
            showError("Please enter a book title.");
        }
    }
    
    // Function to find a book
    private void findBook() {
        String bookTitleToFind = JOptionPane.showInputDialog("Enter the book title to find:");

        if (bookTitleToFind != null && !bookTitleToFind.isEmpty()) {
            try {
                String query = "SELECT * FROM books WHERE title = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, bookTitleToFind);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        // Book found, retrieve information
                        String title = resultSet.getString("title");
                        String isbn = resultSet.getString("isbn");
                        String genre = resultSet.getString("genre");
                        int publishYear = resultSet.getInt("publish_year");
                        int quantity = resultSet.getInt("quantity");
                        String author = resultSet.getString("author_name");
                        int stars = resultSet.getInt("stars");

                        // Display the information
                        JOptionPane.showMessageDialog(null,
                                "Title: " + title +
                                        "\nISBN: " + isbn +
                                        "\nGenre: " + genre +
                                        "\nPublish Year: " + publishYear +
                                        "\nQuantity: " + quantity +
                                        "\nAuthor: " + author +
                                        "\nStars: " + stars,
                                "Book Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Book not found.");
                    }
                }
            } catch (SQLException ex) {
                showError("Error finding book: " + ex.getMessage());
            }
        } else {
            showError("Please enter a book title.");
        }
    }

    // Function to display top liked books
    private void displayTopLikedBooks() {
        try {
            String query = "SELECT * FROM books ORDER BY stars DESC LIMIT 5";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    StringBuilder bookInfo = new StringBuilder();
                    int count = 1;

                    do {
                        String title = resultSet.getString("title");
                        String isbn = resultSet.getString("isbn");
                        String genre = resultSet.getString("genre");
                        int publishYear = resultSet.getInt("publish_year");
                        int quantity = resultSet.getInt("quantity");
                        String author = resultSet.getString("author_name");
                        int stars = resultSet.getInt("stars");

                        // Append book information to StringBuilder
                        bookInfo.append("Rank ").append(count).append(":\n")
                                .append("Title: ").append(title).append("\n")
                                .append("ISBN: ").append(isbn).append("\n")
                                .append("Genre: ").append(genre).append("\n")
                                .append("Publish Year: ").append(publishYear).append("\n")
                                .append("Quantity: ").append(quantity).append("\n")
                                .append("Author: ").append(author).append("\n")
                                .append("Stars: ").append(stars).append("\n\n");

                        count++;
                    } while (resultSet.next());

                    // Display the top 5 liked books
                    JOptionPane.showMessageDialog(null, bookInfo.toString(), "Top 5 Liked Books", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "No books found in the database.");
                }
            }
        } catch (SQLException ex) {
            showError("Error displaying top liked books: " + ex.getMessage());
        }
    }
    
    // Function to find a member
    private void findMember() {
        String memberNameToFind = JOptionPane.showInputDialog("Enter the member name to find:");
        if (memberNameToFind != null && !memberNameToFind.isEmpty()) {
            try {
                String query = "SELECT * FROM members WHERE member_name = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, memberNameToFind);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        // Member found, retrieve information
                        String name = resultSet.getString("member_name");
                        String phone = resultSet.getString("contact_number");
                        String email = resultSet.getString("email");
                        String address = resultSet.getString("address");
                        String registrationDate = resultSet.getString("registration_date");

                        // Display the information
                        JOptionPane.showMessageDialog(null,
                                "Member Name: " + name +
                                        "\nPhone Number: " + phone +
                                        "\nEmail: " + email +
                                        "\nAddress: " + address +
                                        "\nRegistration Date: " + registrationDate,
                                "Member Information", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Member not found.");
                    }
                }
            } catch (SQLException ex) {
                showError("Error finding member: " + ex.getMessage());
            }
        } else {
            showError("Please enter a member name.");
        }
    }
    
    // Function to update a book record
    private void updateRecord() {
        String bookTitleToUpdate = JOptionPane.showInputDialog("Enter the book title to update:");
        if (bookTitleToUpdate != null && !bookTitleToUpdate.isEmpty()) {
            try {
                String query = "SELECT * FROM records WHERE book_name = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    preparedStatement.setString(1, bookTitleToUpdate);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        // Book found, retrieve current information
                        String memberName = resultSet.getString("member_name");
                        String issueDate = resultSet.getString("issue_date");
                        String returnDate = resultSet.getString("return_date");
                        String dueDate = resultSet.getString("due_date");

                        // Prompt user for updated information
                        String newMemberName = JOptionPane.showInputDialog("Enter new member name:", memberName);
                        String newIssueDate = JOptionPane.showInputDialog("Enter new issue date:", issueDate);
                        String newReturnDate = JOptionPane.showInputDialog("Enter new return date:", returnDate);
                        String newDueDate = JOptionPane.showInputDialog("Enter new due date:", dueDate);

                        // Update the 'records' table with the new information
                        resultSet.updateString("member_name", newMemberName);
                        resultSet.updateString("issue_date", newIssueDate);
                        resultSet.updateString("return_date", newReturnDate);
                        resultSet.updateString("due_date", newDueDate);

                        resultSet.updateRow();

                        JOptionPane.showMessageDialog(null, "Record updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Book not found in records.");
                    }
                }
            } catch (SQLException ex) {
                showError("Error updating book record: " + ex.getMessage());
            }
        } else {
            showError("Please enter a book title.");
        }
    }
    
    // Function to add a member
    private void addMember() {
        String name = nameField.getText();
        String phone = phoneField.getText();
        String email = emailField.getText();
        String address = addressField.getText();
        

        // Validate input and handle any errors
        if (name.isEmpty()) {
            showError("Please enter both member name.");
            return;
        }

        try {
            // Creates a new Member object
            Member member = new Member(name, phone, email, address);

            // Adds the member to the 'members' table in the database
            addMemberToDatabase(member);

            // Clears the fields
            clearMemberFields();
        } catch (Exception ex) {
            showError("Error adding member: " + ex.getMessage());
        }
    }

    // Function to remove a member
    private void removeMember() {
        String memberNameToRemove = JOptionPane.showInputDialog("Enter the member name to remove:");

        if (memberNameToRemove != null && !memberNameToRemove.isEmpty()) {
            try {
                // Check if the member exists in the database
                String checkQuery = "SELECT * FROM members WHERE member_name = ?";
                try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
                    checkStatement.setString(1, memberNameToRemove);
                    ResultSet resultSet = checkStatement.executeQuery();

                    if (resultSet.next()) {
                        // Member found, proceed with removal
                        String removeQuery = "DELETE FROM members WHERE member_name = ?";
                        try (PreparedStatement removeStatement = connection.prepareStatement(removeQuery)) {
                            removeStatement.setString(1, memberNameToRemove);
                            removeStatement.executeUpdate();
                        }

                        JOptionPane.showMessageDialog(null, "Member removed successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Member not found.");
                    }
                }
            } catch (SQLException ex) {
                showError("Error removing member: " + ex.getMessage());
            }
        } else {
            showError("Please enter a member name.");
        }
    }



	// Clears the information from the fields 
    private void clearBookFields() {
        titleField.setText("");
        isbnField.setText("");
        genreField.setText("");
        publishYearField.setText("");
        quantityField.setText("");
        authorField.setText("");
        starField.setText("");
    }
    
    // Clears the information from the fields 
    private void clearMemberFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
        addressField.setText("");
        registrationField.setText("");
    }
    
    // Adds book information to the database
    private void addBookToDatabase(Books books) {
        try {
            String query = "INSERT INTO books (title, isbn, genre, publish_year, quantity, author_name, stars) " +
                           "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, books.title);
                preparedStatement.setString(2, books.isbn);
                preparedStatement.setString(3, books.genre);
                preparedStatement.setInt(4, books.publishYear);
                preparedStatement.setInt(5, books.quantity);
                preparedStatement.setString(6, books.author);
                preparedStatement.setInt(7, books.stars);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            showError("Failed to add book to the database: " + ex.getMessage());
        }
    }
    
    // Adds member information to the database
    private void addMemberToDatabase(Member member) {
        try {
            String query = "INSERT INTO members (member_name, contact_number, email, address) " +
                           "VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, member.name);
                preparedStatement.setString(2, member.phone);
                preparedStatement.setString(3, member.email);
                preparedStatement.setString(4, member.address);

                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            showError("Failed to add member to the database: " + ex.getMessage());
        }
    }

    // Nested class for Book
    private static class Books {
    	// Book attributes
        String title; // Title of the book
        String isbn; // ISBN of the book
        String genre; // The genre of the book
        int publishYear; // The year the book was published
        int quantity; // Number of books available to issue
        String author; // Name of the author
        int stars; // Number of stars out of 5

        /**
         * Constructor for creating a new Product object with the specified attributes.
         *
         * @param title            Title of the book
         * @param isbn        	   ISBN of the book
         * @param genre			   The genre of the book
         * @param publishYear      The year the book was published
         * @param quantity         Number of books available to issue
         * @param author    	   Name of the author
         * @param stars            Number of stars out of 5
         */
        
        public Books(String title, String isbn, String genre, int publishYear, int quantity, String author, int stars) {
        	// Initialize the book object with the provided attributes
        	this.title = title;
            this.isbn = isbn;
            this.genre = genre;
            this.publishYear = publishYear;
            this.quantity = quantity;
            this.author = author;
            this.stars = stars;
        }
    }
    
    // Nested class for Member
    private static class Member {
    	// Member attributes
        String name; // Name of the member
        String phone; // Member's Phone Number
        String email; // Member's Email
        String address; // Member's Address

        /**
         * Constructor for creating a new Product object with the specified attributes.
         *
         * @param name             Title of the book
         * @param phone        	   ISBN of the book
         * @param email			   The genre of the book
         * @param address	       The year the book was published
         * @param registration     Number of books available to issue
         */
        
        public Member(String name, String phone, String email, String address) {
        	// Initialize the Member object with the provided attributes
        	this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }
    }
    
    // Creates the error message
    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryManagement().setVisible(true);
            }
        });
    }
}