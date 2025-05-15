package loginandsignup;

import javax.swing.*;
import java.util.ArrayList;

public class SignUp extends javax.swing.JFrame {
    public static ArrayList<User> users = new ArrayList<>(); // Store users in memory

    public SignUp() {
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        IconLabel = new javax.swing.JLabel();
        CompDescLabel = new javax.swing.JLabel();
        CompDescLabel2 = new javax.swing.JLabel();
        CompTextLabel = new javax.swing.JLabel();
        LeftPanel = new javax.swing.JPanel();
        SignupLabel = new javax.swing.JLabel();
        FullNameLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        EmailLabel = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        HaveanAccLabel = new javax.swing.JLabel();
        SignupButton = new javax.swing.JButton();
        LoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign Up");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        RightPanel.setBackground(new java.awt.Color(0, 102, 102));

        IconLabel.setIcon(new javax.swing.ImageIcon(""));

        CompDescLabel.setFont(new java.awt.Font("Showcard Gothic", 1, 26));
        CompDescLabel.setForeground(new java.awt.Color(255, 255, 255));
        CompDescLabel.setText("LIBRARY MANAGEMENT");

        CompDescLabel2.setFont(new java.awt.Font("Showcard Gothic", 1, 26));
        CompDescLabel2.setForeground(new java.awt.Color(255, 255, 255));
        CompDescLabel2.setText("MANAGEMENT");

        CompTextLabel.setFont(new java.awt.Font("DIALOG_INPUT", 1, 16));
        CompTextLabel.setForeground(new java.awt.Color(204, 204, 204));
        CompTextLabel.setText("copyright © company name All rights reserved");

        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RightPanelLayout.createSequentialGroup()
                    .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(RightPanelLayout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(IconLabel))
                        .addGroup(RightPanelLayout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(CompTextLabel))
                        .addGroup(RightPanelLayout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(CompDescLabel)))
                    .addContainerGap(49, Short.MAX_VALUE))
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(RightPanelLayout.createSequentialGroup()
                    .addGap(129, 129, 129)
                    .addComponent(IconLabel)
                    .addGap(100, 100, 100)
                    .addComponent(CompDescLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                    .addComponent(CompTextLabel)
                    .addGap(64, 64, 64))
        );

        jPanel1.add(RightPanel);
        RightPanel.setBounds(0, 0, 400, 700);
        LeftPanel.setBackground(new java.awt.Color(255, 255, 255));
        LeftPanel.setMinimumSize(new java.awt.Dimension(800, 700));
        LeftPanel.setBounds(400, 0, 400, 700);

        SignupLabel.setForeground(new java.awt.Color(0x12c6ea));
        SignupLabel.setFont(new java.awt.Font("DIALOG_INPUT", 1, 36));
        SignupLabel.setText("SIGN UP");

        FullNameLabel.setBackground(new java.awt.Color(102, 102, 102));
        FullNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        FullNameLabel.setText("Full name");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));

        EmailLabel.setBackground(new java.awt.Color(102, 102, 102));
        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        EmailLabel.setText("Email");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextField2.setForeground(new java.awt.Color(102, 102, 102));

        PasswordLabel.setBackground(new java.awt.Color(102, 102, 102));
        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        PasswordLabel.setText("Password");

        jPasswordField1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jPasswordField1.setForeground(new java.awt.Color(102, 102, 102));

        HaveanAccLabel.setText("I already have an account.");

        SignupButton.setBackground(new java.awt.Color(0, 102, 102));
        SignupButton.setForeground(new java.awt.Color(255, 255, 255));
        SignupButton.setText("Sign Up");
        SignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupButtonActionPerformed(evt);
            }
        });

        LoginButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        LoginButton.setForeground(new java.awt.Color(255, 51, 51));
        LoginButton.setText("Sign in");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LeftPanelLayout.createSequentialGroup()
                    .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(LeftPanelLayout.createSequentialGroup()
                            .addGap(145, 145, 145)
                            .addComponent(SignupLabel))
                        .addGroup(LeftPanelLayout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(FullNameLabel)
                                    .addComponent(jTextField1)
                                    .addComponent(EmailLabel)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                    .addComponent(PasswordLabel)
                                    .addComponent(jPasswordField1))
                                .addComponent(SignupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(LeftPanelLayout.createSequentialGroup()
                                    .addComponent(HaveanAccLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(24, Short.MAX_VALUE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(LeftPanelLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(SignupLabel)
                    .addGap(29, 29, 29)
                    .addComponent(FullNameLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(EmailLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(29, 29, 29)
                    .addComponent(PasswordLabel)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(SignupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(HaveanAccLabel)
                        .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1.add(LeftPanel);
        LeftPanel.setBounds(400, 0, 400, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 126, Short.MAX_VALUE))
        );

        pack();
    }

    private void SignupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String fullName = jTextField1.getText();
        String email = jTextField2.getText();
        String password = new String(jPasswordField1.getPassword());

        
        if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        
        for (User  user : users) {
            if (user.getEmail().equals(email)) {
                JOptionPane.showMessageDialog(this, "Email is already registered.");
                jTextField1.setText("");
                jTextField2.setText("");
                jPasswordField1.setText("");
                return;
            }
        }

        
        users.add(new User(fullName, email, password));
        JOptionPane.showMessageDialog(this, "Sign up successful! You can now log in.");
        jTextField1.setText("");
        jTextField2.setText("");
        jPasswordField1.setText("");
    }

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SignIn loginFrame = new SignIn();
        loginFrame.setVisible(true);
        loginFrame.pack();
        loginFrame.setLocationRelativeTo(null);
        this.dispose();
    }

    private javax.swing.JButton SignupButton;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel IconLabel;
    private javax.swing.JLabel CompDescLabel;
    private javax.swing.JLabel CompDescLabel2;
    private javax.swing.JLabel CompTextLabel;
    private javax.swing.JLabel SignupLabel;
    private javax.swing.JLabel FullNameLabel;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel HaveanAccLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}


