import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SendMoney extends JFrame implements ActionListener {
    private JLabel titleLabel, amountLabel, phoneNumberLabel, usernameLabel, passwordLabel, label6;
    private JTextField amountField, phoneNumberField, usernameField;
    private JPasswordField passField;
    private JButton sendButton, cancelButton, backButton, send200Button, send100Button, send500Button, send1000Button;
    private JPanel panel;
    private String username; // Username passed from the Home class
    private String password; // Password passed from the Home class
    private ImageIcon img;
    // Constructor modified to accept username and password
    public SendMoney(String username, String password) {
        super("Send Money");
        super.setBounds(230, 100, 800, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.username = username; // Store the passed username
        this.password = password; // Store the passed password

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Send Money");
        titleLabel.setBounds(150, 20, 100, 20);
        panel.add(titleLabel);

        usernameLabel = new JLabel("UserName:");
        usernameLabel.setBounds(30, 60, 100, 30);
        panel.add(usernameLabel);

        usernameField = new JTextField(username); // Display the username
        usernameField.setBounds(130, 60, 100, 30);
        usernameField.setEditable(false); // Disable editing
        panel.add(usernameField);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 100, 100, 30);
        panel.add(passwordLabel);

        passField = new JPasswordField();
        passField.setBounds(130, 100, 100, 30);
        panel.add(passField);
        passField.setEchoChar('*');

        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 150, 100, 30);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(130, 150, 200, 20);
        panel.add(amountField);

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(30, 200, 100, 20);
        panel.add(phoneNumberLabel);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(130, 200, 200, 20);
        panel.add(phoneNumberField);

        backButton = new JButton("Back");
        backButton.setBounds(350, 400, 100, 30);
		backButton.setBackground(Color.BLUE);
        backButton.addActionListener(this);
        panel.add(backButton);

        sendButton = new JButton("Send");
        sendButton.setBounds(350, 300, 100, 30);
		sendButton.setBackground(Color.RED);
        sendButton.addActionListener(this);
        panel.add(sendButton);

        
        send100Button = new JButton("100");
        send100Button.setBounds(100, 250, 100, 30);
		send100Button.setBackground(Color.YELLOW);
        send100Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountField.setText("100");
            }
        });
        panel.add(send100Button);
		
		send200Button = new JButton("200");
        send200Button.setBounds(270, 250, 100, 30);
		send200Button.setBackground(Color.ORANGE);
        send200Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountField.setText("200");
            }
        });
        panel.add(send200Button);

        send500Button = new JButton("500");
        send500Button.setBounds(470, 250, 100, 30);
		send500Button.setBackground(Color.PINK);
        send500Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountField.setText("500");
            }
        });
        panel.add(send500Button);

        send1000Button = new JButton("1000");
        send1000Button.setBounds(670, 250, 100, 30);
		send1000Button.setBackground(Color.RED);
        send1000Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountField.setText("1000");
            }
        });
        panel.add(send1000Button);
		
		
		img = new ImageIcon("VT.jpg");
        label6 = new JLabel(img);
        label6.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        panel.add(label6);

        super.add(panel);
        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sendButton) {
            String enteredPassword = new String(passField.getPassword());

            if (enteredPassword.equals(password)) {
                JOptionPane.showMessageDialog(this, "Money sent successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Password incorrect");
            }
        } else if (ae.getSource() == backButton) {
            Home home = new Home(username, password); // Pass username and password back to the Home class
            home.setVisible(true);
            this.setVisible(false);
        }
    }
  
}