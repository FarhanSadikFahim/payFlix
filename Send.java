import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SendMoney extends JFrame {
    private JLabel titleLabel, amountLabel, phoneNumberLabel;
    private JTextField amountField, phoneNumberField;
    private JButton sendButton, cancelButton, send100Button, send500Button, send1000Button;
    private JPanel panel;

    // Store the correct password here
    private static final String CORRECT_PASSWORD = "password";

    public SendMoney() {
        super("Send Money");
        super.setBounds(600, 200, 800, 600);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        titleLabel = new JLabel("Send Money");
        titleLabel.setBounds(150, 20, 100, 20);
        panel.add(titleLabel);

        phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberLabel.setBounds(30, 60, 100, 20);
        panel.add(phoneNumberLabel);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(130, 60, 200, 20);
        panel.add(phoneNumberField);

        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(30, 100, 100, 20);
        panel.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(130, 100, 200, 20);
        panel.add(amountField);

        sendButton = new JButton("Send");
        sendButton.setBounds(80, 200, 100, 30);
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Prompt for password
                String password = JOptionPane.showInputDialog(SendMoney.this, "Enter password:");
                if (password != null && password.equals(CORRECT_PASSWORD)) {
                    // Password is correct, proceed with sending money
                    String amount = amountField.getText();
                    String phoneNumber = phoneNumberField.getText();
                    JOptionPane.showMessageDialog(SendMoney.this, "Money sent successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Password is incorrect
                    JOptionPane.showMessageDialog(SendMoney.this, "Password incorrect", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(sendButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200, 200, 100, 30);
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the window
            }
        });
        panel.add(cancelButton);

        // Button for sending 100 taka
        send100Button = new JButton("100");
        send100Button.setBounds(80, 150, 150, 30);
        send100Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountField.setText("100");
            }
        });
        panel.add(send100Button);

        // Button for sending 500 taka
        send500Button = new JButton("500");
        send500Button.setBounds(250, 150, 150, 30);
        send500Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountField.setText("500");
            }
        });
        panel.add(send500Button);

        // Button for sending 1000 taka
        send1000Button = new JButton("1000");
        send1000Button.setBounds(420, 150, 150, 30);
        send1000Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountField.setText("1000");
            }
        });
        panel.add(send1000Button);

        super.add(panel);
        super.setVisible(true);
    }

    public static void main(String[] args) {
        new SendMoney();
    }
}
