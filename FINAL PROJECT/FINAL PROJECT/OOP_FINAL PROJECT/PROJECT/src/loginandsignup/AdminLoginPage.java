package loginandsignup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AdminLoginPage extends JFrame {
    
    public AdminLoginPage() {
        
        setTitle("Admin Login");
        
       
        setSize(800, 600);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        setLocationRelativeTo(null);
        
       
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.BLACK); 
        
       
        JLabel titleLabel = new JLabel("Admin / Librarians Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 30)); 
        titleLabel.setForeground(Color.WHITE); 
        
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        JTextField usernameField = new JTextField(15);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        JPasswordField passwordField = new JPasswordField(15);
        
       
        JButton loginButton = new JButton("Login");
        loginButton.setBackground(Color.RED);
        loginButton.setForeground(Color.WHITE);
        
        
        JButton backButton = new JButton("Back");
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        
      
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
               
                if (username.equals("admin") && password.equals("admin123")) { // Example validation
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    Library_management library = new Library_management();
                    library.setVisible(true);
                    library.setLocationRelativeTo(null);
                    dispose();
                } else if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Do not leave blanks");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                    usernameField.setText("");
                    passwordField.setText("");

                    
                }
            }
            
        });
        
        JTextField textField = new JTextField(20);
        
        
        // Add action listener for the back button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Logic to go back to the previous screen
                new Dashboard1().setVisible(true);
                dispose(); // Close the current frame
                // Optionally, you can open the main menu or previous screen here
                // new MainMenuPage().setVisible(true); // Uncomment and implement MainMenuPage
            }
        });
        
        // Create GridBagConstraints for layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        
        // Add components to the main panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span across two columns
        mainPanel.add(titleLabel, gbc);
        
        gbc.gridwidth = 1; // Reset to default
        gbc.gridy++;
        mainPanel.add(usernameLabel, gbc);
        
        gbc.gridx = 1;
        mainPanel.add(usernameField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        mainPanel.add(passwordLabel, gbc);
        
        gbc.gridx = 1;
        mainPanel.add(passwordField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2; // Span across two columns
        mainPanel.add(loginButton, gbc);
        
        gbc.gridy++;
        mainPanel.add(backButton, gbc); // Add the back button
        
        // Add the main panel to the frame
        add(mainPanel);
    }
    
    public static void main(String[] args) {
        // Create and display the admin login page
        SwingUtilities.invokeLater(() -> {
            AdminLoginPage loginPage = new AdminLoginPage();
            loginPage.setVisible(true);
        });
    }
}