import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class SignUp extends JFrame implements ActionListener {
    private JLabel titleLabel, label6;
    private JLabel nameLabel, passLabel;
    private JTextField nameField;
    private JPasswordField passField;
    private JTextField mobileNumberField;
    private JLabel mobileNumberLabel;
    private JLabel mobileOperatorLabel;
    private JPanel panel;
    private ButtonGroup operatorButtonGroup;
    private JRadioButton[] operatorButtons;
    private JLabel accountTypeLabel;
    private JRadioButton regularRadioButton;
    private JRadioButton islamicRadioButton;
    private JButton signbtn;
    private JButton exitbtn;
    private JButton signUpBtn, updateBtn, deleteBtn, backBtn; // Added back button
    private Color mycolor, mycolor1;
    private Font myfont;
	private ImageIcon img;

    public SignUp() {
        super("SignUp");
        this.setBounds(230, 100, 800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(null);

        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(50, 30, 100, 30);
        //nameLabel.setBackground(Color.RED);
        //nameLabel.setOpaque(false);
        //nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(myfont);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(160, 30, 100, 20);
        panel.add(nameField);

        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 60, 100, 30);
        //passLabel.setBackground(Color.RED);
        //passLabel.setOpaque(false);
        panel.add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(160, 60, 100, 20);
        panel.add(passField);

        mobileNumberLabel = new JLabel("Mobile Number:");
        mobileNumberLabel.setBounds(50, 90, 100, 30);
        panel.add(mobileNumberLabel);

        mobileNumberField = new JTextField();
        mobileNumberField.setBounds(160, 90, 100, 20);
        panel.add(mobileNumberField);

        mobileOperatorLabel = new JLabel("Mobile Operator:");
        mobileOperatorLabel.setBounds(50, 120, 100, 30);
        panel.add(mobileOperatorLabel);

        String[] operatorOptions = {"Teletalk", "Grameenphone", "Robi", "Airtel", "Banglalink"};
        operatorButtons = new JRadioButton[operatorOptions.length];
        operatorButtonGroup = new ButtonGroup();
        for (int i = 0; i < operatorOptions.length; i++) {
            operatorButtons[i] = new JRadioButton(operatorOptions[i]);
            operatorButtons[i].setBounds(160, 120 + i * 25, 120, 20);
			operatorButtons[i].setBackground(Color.LIGHT_GRAY);
            panel.add(operatorButtons[i]);
            operatorButtonGroup.add(operatorButtons[i]);
        }

        accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setBounds(50, 270, 100, 20);
        panel.add(accountTypeLabel);

        regularRadioButton = new JRadioButton("Regular");
        regularRadioButton.setBounds(160, 270, 100, 20);
        panel.add(regularRadioButton);

        islamicRadioButton = new JRadioButton("Islamic");
        islamicRadioButton.setBounds(260, 270, 100, 20);
        panel.add(islamicRadioButton);

        ButtonGroup accountTypeButtonGroup = new ButtonGroup();
        accountTypeButtonGroup.add(regularRadioButton);
        accountTypeButtonGroup.add(islamicRadioButton);

        signbtn = new JButton("Signup");
        signbtn.setBounds(50, 400, 80, 30);
        signbtn.setBackground(Color.RED);
        panel.add(signbtn);
        signbtn.addActionListener(this);
        		
		updateBtn = new JButton("Update");
        updateBtn.setBounds(250, 400, 80, 30);
        updateBtn.setBackground(Color.YELLOW);
        updateBtn.addActionListener(this);
        panel.add(updateBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(450, 400, 80, 30);
        deleteBtn.setBackground(Color.GREEN);
        deleteBtn.addActionListener(this);
        panel.add(deleteBtn);
        
        // Add back button
        backBtn = new JButton("Back");
        backBtn.setBounds(650, 400, 80, 30);
        backBtn.setBackground(Color.BLUE);
        panel.add(backBtn);
        backBtn.addActionListener(this);
		
	    img = new ImageIcon("LT.jpg");
        label6 = new JLabel(img);
        panel.add(label6);

        // Adding a component listener to the panel to handle resizing
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                label6.setBounds(0, 0, panel.getWidth(), panel.getHeight());
            }
        });
        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == signbtn) {
            String s1 = nameField.getText();
            String s2 = String.valueOf(passField.getPassword());
            if (s1.isEmpty() || s2.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill up all the information");
            } else {
                Account acc = new Account(s1, s2);
                if (acc.checkAccount(s1, s2)) {
                    JOptionPane.showMessageDialog(this, "Username & password already exist");
                } else {
                    acc.addAccount();
                    JOptionPane.showMessageDialog(this, "Registration Successful");
                    nameField.setText("");
                    passField.setText("");
                    Tkash obj1 = new Tkash();
                    obj1.setVisible(true);
                    this.setVisible(false);
                }
            }
        } else if (ae.getSource() == updateBtn) {
            // Update logic
            String name = nameField.getText();
            String oldPassword = String.valueOf(passField.getPassword());
            if (name.isEmpty() || oldPassword.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill up all the information");
            } else {
                String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
                if (newPassword != null && !newPassword.isEmpty()) {
                    Account acc = new Account();
                    if (acc.checkAccount(name, oldPassword)) {
                        acc.updatePassword(name, newPassword);
                        JOptionPane.showMessageDialog(this, "Password updated successfully");
                    } else {
                        JOptionPane.showMessageDialog(this, "Username/Password wrong");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Password cannot be empty");
                }
            }
        } else if (ae.getSource() == deleteBtn) {
            // Delete logic
            String name = nameField.getText();
            String password = String.valueOf(passField.getPassword());
            if (name.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill up all the information");
            } else {
                Account acc = new Account();
                if (acc.checkAccount(name, password)) {
                    int choice = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete your account?", "Delete Account", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        acc.deleteAccount(name);
                        JOptionPane.showMessageDialog(this, "Account deleted successfully");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username/Password wrong");
                }
            }
        } else if (ae.getSource() == backBtn) {
            // Back to Tkash window
            Tkash obj1 = new Tkash();
            obj1.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == exitbtn) {
            System.exit(0);
        }
    }

 
   
}
