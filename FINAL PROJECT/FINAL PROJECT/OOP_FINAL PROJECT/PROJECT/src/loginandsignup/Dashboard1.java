package loginandsignup;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Dashboard1 extends JFrame {
    
    public Dashboard1() {
        // Set the title of the frame
        setTitle("Book Library Management System");
        
        // Set the size of the frame
        setSize(800, 600);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Center the frame on the screen
        setLocationRelativeTo(null);
        
        // Create a main panel with a vertical box layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        
        
        JPanel spacerPanel = new JPanel();
        spacerPanel.setPreferredSize(new Dimension(600, 288)); // Set height for the gap (approximately 3 inches)
        spacerPanel.setBackground(Color.BLACK); // Keep the background consistent
        mainPanel.add(spacerPanel, BorderLayout.NORTH);
        
        // Create a title label
        JLabel titleLabel = new JLabel("Book Library Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 30)); // Set font to Algerian and size to 30
        titleLabel.setForeground(Color.WHITE); // Set title color to white
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        
        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(new Color(0, 0, 0, 0)); // Set button panel background to transparent
        
        // Create buttons with larger size
        JButton adminButton = new JButton("librarians / Admin Login");
        JButton userButton = new JButton("User     ");
        JButton logoutButton = new JButton("Logout");
        
        // Set button size
        Dimension buttonSize = new Dimension(200, 60);
        adminButton.setPreferredSize(buttonSize);
        userButton.setPreferredSize(buttonSize);
        logoutButton.setPreferredSize(buttonSize);
        
        // Set button colors
        adminButton.setBackground(Color.RED);
        userButton.setBackground(Color.BLUE);
        logoutButton.setBackground(Color.GRAY);
        
        // Set button text color
        adminButton.setForeground(Color.WHITE);
        userButton.setForeground(Color.WHITE);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        
        // Add action listener for Admin button
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminLoginPage().setVisible(true);
            }
        });
        
        // Add action listener for User button
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserFrame1 userFrame = new UserFrame1( null);
                userFrame.setVisible(true);
                userFrame.setLocationRelativeTo(null);
                
            }
        });
        
        // logoutButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         // Show confirmation dialog
        //         int response = JOptionPane.showConfirmDialog(null, 
        //             "Do you want to exit?", 
        //             "Confirm Logout", 
        //             JOptionPane.YES_NO_CANCEL_OPTION, 
        //             JOptionPane.QUESTION_MESSAGE);
                
        //         // Handle the response
        //         if (response == JOptionPane.YES_OPTION) {
        //             // User chose to log out
        //             JOptionPane.showMessageDialog(null, "Logged out successfully.");
        //             SignIn SignInFrame = new SignIn();
        //             SignInFrame.setVisible(true);
        //             SignInFrame.pack();
        //             SignInFrame.setLocationRelativeTo(null); 
        //             SignInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                
        //         } else if (response == JOptionPane.NO_OPTION) {
        //             // User chose not to log out
        //             JOptionPane.showMessageDialog(null, "Logout canceled.");
        //         } else if (response == JOptionPane.CANCEL_OPTION) {
        //             // User chose to cancel the action
        //             JOptionPane.showMessageDialog(null, "Logout action canceled.");
        //         }
        //     }
        // });
        
        // Add buttons to the button panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 20, 20, 20);
        buttonPanel.add(adminButton, gbc);
        
        gbc.gridy = 1;
        buttonPanel.add(userButton, gbc);
        
        gbc.gridy = 2;
        buttonPanel.add(logoutButton, gbc);
        
        // Add the button panel to the main panel
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        // Add the main panel to the frame
        add(mainPanel);
    }
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int response = JOptionPane.showConfirmDialog(null, 
                    "Do you want to Logout?", 
                    "Confirm Logout", 
                    JOptionPane.YES_NO_CANCEL_OPTION, 
                    JOptionPane.QUESTION_MESSAGE);
                
                // Handle the response
                if (response == JOptionPane.YES_OPTION) {
                    // User chose to log out
                    SignIn SignInFrame = new SignIn();
                    SignInFrame.setVisible(true);
                    SignInFrame.pack();
                    SignInFrame.setLocationRelativeTo(null); 
                    SignInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    this.dispose();
                                
                } else if (response == JOptionPane.NO_OPTION) {
                    
                    JOptionPane.showMessageDialog(null, "Logout canceled.");
                } else if (response == JOptionPane.CANCEL_OPTION) {
                    
                    JOptionPane.showMessageDialog(null, "Logout action canceled.");
                }
    }
    
    public static void main(String[] args) {
        // Create and display the dashboard
        SwingUtilities.invokeLater(() -> {
            Dashboard1 dashboard = new Dashboard1();
            dashboard.setVisible(true);
        });
    }
}

