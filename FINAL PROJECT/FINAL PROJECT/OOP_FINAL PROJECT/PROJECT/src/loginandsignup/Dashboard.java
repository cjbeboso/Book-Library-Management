package loginandsignup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends javax.swing.JFrame {

    public Dashboard() {
        initComponents();
        setTitle("Library Management System");
        setPreferredSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        // Create components
        jLabel1 = new JLabel("Library Management System", SwingConstants.CENTER);
        jLabel1.setFont(new Font("Arial", Font.BOLD, 30));
        jLabel1.setForeground(Color.WHITE);
        jLabel1.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Add some padding

        jButton1 = createButton("New Book");
        jButton2 = createButton("New Student");
        jButton3 = createButton("Statistics");
        jButton4 = createButton("Issue Book");
        jButton5 = createButton("Return Book");
        jButton6 = createButton("Logout");

        // Set layout and background for the main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(34, 34, 34));

        // Create a right panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(new Color(51, 51, 51));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add buttons to the button panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        buttonPanel.add(jButton1, gbc);

        gbc.gridy = 1;
        buttonPanel.add(jButton2, gbc);

        gbc.gridy = 2;
        buttonPanel.add(jButton3, gbc);

        gbc.gridy = 3;
        buttonPanel.add(jButton4, gbc);

        gbc.gridy = 4;
        buttonPanel.add(jButton5, gbc);

        gbc.gridy = 5;
        buttonPanel.add(jButton6, gbc);

        // Add components to the main panel
        mainPanel.add(jLabel1, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.EAST);
        
        // Set the main layout
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        
        pack();
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(51, 153, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                buttonActionPerformed(evt, text);
            }
        });
        return button;
    }

    private void buttonActionPerformed(ActionEvent evt, String action) {
        switch (action) {
            case "New Book":
                new NewBook().setVisible(true);
                this.dispose();
                break;
            case "New Student":
                // new NewStudent().setVisible(true);
                // this.dispose();
                break;
            case "Statistics":
                // new Statistics().setVisible(true);
                // this.dispose();
                break;
            case "Issue Book":
                // new IssueBook().setVisible(true);
                // this.dispose();
                break;
            case "Return Book":
                // new ReturnBook().setVisible(true);
                // this.dispose();
                break;
            case "Logout":
                // new Login().setVisible(true);
                // this.dispose();
                break;
        }
    }

    // Variables declaration
    private JLabel jLabel1;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    // End of variables declaration

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
        });
    }
}