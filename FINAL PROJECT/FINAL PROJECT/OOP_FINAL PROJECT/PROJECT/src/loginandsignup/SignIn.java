package loginandsignup;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SignIn extends javax.swing.JFrame {

    private static final String USERNAME = "admin"; 
    private static final String PASSWORD = "admin123"; 
    // Declare message label
    private JLabel messageLabel;

    public SignIn() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        RightPanel = new javax.swing.JPanel();
        IconLabel1 = new javax.swing.JLabel();
        CompDescLabel = new javax.swing.JLabel();
        CompTextLabel = new javax.swing.JLabel();
        LeftPanel = new javax.swing.JPanel();
        LoginLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        PasswordTextField = new javax.swing.JTextField();
        PasswordLabel = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        LoginButton = new javax.swing.JButton();
        DontHaveAccount = new javax.swing.JLabel();
        SignupButton = new javax.swing.JButton();


        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        messageLabel = new JLabel();
        messageLabel.setForeground(Color.RED);
        messageLabel.setBounds(30, 300, 300, 30); 
        jPanel1.add(messageLabel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(0x12c6ea));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(null);

        RightPanel.setBackground(new java.awt.Color(0, 102, 102));
        RightPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        CompDescLabel.setFont(new java.awt.Font("Showcard Gothic", 1, 26));
        CompDescLabel.setForeground(new java.awt.Color(255, 255, 255));
        CompDescLabel.setText("LIBRARY MANAGEMENT");

        CompTextLabel.setFont(new java.awt.Font("DIALOG_INPUT", 1, 16));
        CompTextLabel.setForeground(new java.awt.Color(204, 204, 204));
        CompTextLabel.setText("wa raghud");
        
        javax.swing.GroupLayout RightPanelLayout = new javax.swing.GroupLayout(RightPanel);
        RightPanel.setLayout(RightPanelLayout);
        RightPanelLayout.setHorizontalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RightPanelLayout.createSequentialGroup()
                .addGap(0, 81, Short.MAX_VALUE)
                .addComponent(CompTextLabel)
                .addGap(40, 40, 40))
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGroup(RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(RightPanelLayout.createSequentialGroup()
                        .addGap( 40, 40, 40)
                        .addComponent(CompDescLabel))
                    .addGroup(RightPanelLayout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(IconLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        RightPanelLayout.setVerticalGroup(
            RightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightPanelLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(IconLabel1)
                .addGap(100, 100, 100)
                .addComponent(CompDescLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(CompTextLabel)
                .addGap(78, 78, 78))
        );

        jPanel1.add(RightPanel);
        RightPanel.setBounds(0, 0, 400, 700);
        
        LeftPanel.setBackground(new java.awt.Color(255, 255, 255));
        LeftPanel.setMinimumSize(new java.awt.Dimension(800, 700));
        LeftPanel.setBounds(0,0,400,800);

        LoginLabel.setFont(new java.awt.Font("DIALOG_INPUT", 1, 36));
        LoginLabel.setForeground(new java.awt.Color(0x12c6ea));
        LoginLabel.setText("SIGN IN");

        ImageIcon icon = new ImageIcon("mail.png");
        JLabel iconLabel = new JLabel(icon);
        EmailLabel.setBackground(new java.awt.Color(102, 102, 102));
        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        EmailLabel.setText("Email");
        jPanel1.add(iconLabel);

        PasswordTextField.setFont(new java.awt.Font("Segoe UI", 0, 14));
        PasswordTextField.setForeground(new java.awt.Color(102, 102, 102));
        PasswordLabel.setBackground(new java.awt.Color(102, 102, 102));
        PasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 14));
        PasswordLabel.setText("Password");

        LoginButton.setBackground(new java.awt.Color(0, 102, 102));
        LoginButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("Login");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        DontHaveAccount.setText("I don't have an account.");

        SignupButton.setFont(new java.awt.Font("Segoe UI", 0, 14));
        SignupButton.setForeground(new java.awt.Color(255, 51, 51));
        SignupButton.setText("Sign Up");
        SignupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LeftPanelLayout = new javax.swing.GroupLayout(LeftPanel);
        LeftPanel.setLayout(LeftPanelLayout);
        LeftPanelLayout.setHorizontalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(LoginLabel))
                    .addGroup(LeftPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(EmailLabel)
                                .addComponent(PasswordTextField)
                                .addComponent(PasswordLabel)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(LeftPanelLayout.createSequentialGroup()
                                .addComponent(DontHaveAccount)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SignupButton)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        LeftPanelLayout.setVerticalGroup(
            LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftPanelLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(LoginLabel)
                .addGap(40, 40, 40)
                .addComponent(EmailLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(LeftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DontHaveAccount)
                    .addComponent(SignupButton))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel1.add(LeftPanel);
        LeftPanel.setBounds(400, 0, 400, 700);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 149, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("LOGIN");

        pack();
    }

    private void SignupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        SignUp SignUpFrame = new SignUp();
        SignUpFrame.setVisible(true);
        SignUpFrame.pack();
        SignUpFrame.setLocationRelativeTo(null); 
        this.dispose();
    }

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String email = PasswordTextField.getText();
        String password = new String(jPasswordField1.getPassword());
        
        for (User  user : SignUp.users) { // Access the static users list
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(null, "Login successful!");
                messageLabel.setForeground(Color.BLUE);
                Dashboard1 dashboardFrame = new Dashboard1();
                dashboardFrame.setVisible(true);
                dashboardFrame.setLocationRelativeTo(null); 
                this.dispose();
                return;
            }
            else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);

                PasswordTextField.setText("");
                jPasswordField1.setText("");
            }
        }  
    }

    private javax.swing.JPanel LeftPanel;
    private javax.swing.JPanel RightPanel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JButton SignupButton;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel DontHaveAccount;
    private javax.swing.JLabel IconLabel1;
    private javax.swing.JLabel CompDescLabel;
    private javax.swing.JLabel CompTextLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField PasswordTextField;
}