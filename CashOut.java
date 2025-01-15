import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CashOut extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel title, phn_num, amount, usernameLabel, passwordLabel, label6;
    private JTextField phn_num_tf, amount_tf, usernameField;
    private JPasswordField pass_tf;
    private JButton sendButton, backButton;
    private String username; // Username passed from Home
    private String userPassword; // Password passed from Home
    private Home home; 
	private ImageIcon img;                   // Reference to the Home window

    public CashOut(String username, String password, Home home) {
        super("Cash Out");
        this.setBounds(230, 100, 800, 500);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.username = username;
        this.userPassword = password;
        this.home = home;

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(250, 250, 250));
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(30, 70, 100, 20);
		panel.add(usernameLabel);
		
        usernameField = new JTextField(username);
        usernameField.setEditable(false);   
        usernameField.setBounds(230, 70, 200, 30);      
        panel.add(usernameField);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(30, 120, 100, 20);
		panel.add(passwordLabel);
		
        pass_tf = new JPasswordField();
        pass_tf.setBounds(230, 120, 200, 30);
        panel.add(pass_tf);

        phn_num = new JLabel("Number");
        phn_num.setFont(new Font("Arial", Font.BOLD, 18));
        phn_num.setBounds(30, 170, 100, 20);
        panel.add(phn_num);

        phn_num_tf = new JTextField();
        phn_num_tf.setBounds(230, 170, 200, 30);
        panel.add(phn_num_tf);

        amount = new JLabel("Amount");
        amount.setFont(new Font("Arial", Font.BOLD, 18));
        amount.setBounds(30, 220, 100, 20);
        panel.add(amount);

        amount_tf = new JTextField();
        amount_tf.setBounds(230, 220, 200, 30);
        panel.add(amount_tf);

        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 18));
        sendButton.setBounds(250, 400, 100, 30);
		sendButton.setBackground(Color.BLUE);
        sendButton.addActionListener(this); // Add ActionListener
        panel.add(sendButton);

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.setBounds(425, 400, 100, 30);
		backButton.setBackground(Color.RED);
        backButton.addActionListener(this); // Add ActionListener
        panel.add(backButton);
		
		img = new ImageIcon("HT.jpg");
        label6 = new JLabel(img);
        label6.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        panel.add(label6);


        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == sendButton) {
            String enteredPassword = new String(pass_tf.getPassword());

            if (enteredPassword.equals(userPassword)) {
                JOptionPane.showMessageDialog(this, "Money sent successfully!");
                dispose(); // Close CashOut window
                home.setVisible(true); // Show Home window
            } else {
                JOptionPane.showMessageDialog(this, "Password incorrect");
            }
        } else if (ae.getSource() == backButton) {
            // Show the existing instance of the Home window
            home.setVisible(true);
            // Close CashOut window
            dispose();
        }
    }
}



