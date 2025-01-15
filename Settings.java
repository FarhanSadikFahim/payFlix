import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Settings extends JFrame {

    private Home home;
	private ImageIcon img;   

    public Settings(Home home) {
        this.home = home;

        // Set frame properties
        setTitle("Settings");
        setSize(800, 500);
        setLocationRelativeTo(null); // Center the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // Prevent resizing

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(250, 250, 250));
		
		JLabel label6;
        // Create label for Settings

        // Create buttons
        JButton changeNameButton = new JButton("Change Name");
        JButton changePhoneNumberButton = new JButton("Change Phone Number");
        JButton changePasswordButton = new JButton("Change Password");
        JButton addEmailButton = new JButton("Add Email");
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle back button action
                home.setVisible(true);
                dispose();
            }
        });

        // Set button bounds
        int buttonWidth = 200;
        int buttonHeight = 30;
        int xPosition = 300; // Center horizontally
        int yPosition = 100; // 100 pixels below the label
        changeNameButton.setBounds(xPosition, yPosition, buttonWidth, buttonHeight);
        changePhoneNumberButton.setBounds(xPosition, yPosition + 50, buttonWidth, buttonHeight);
        changePasswordButton.setBounds(xPosition, yPosition + 100, buttonWidth, buttonHeight);
        addEmailButton.setBounds(xPosition, yPosition + 150, buttonWidth, buttonHeight);
        backButton.setBounds(xPosition, yPosition + 200, buttonWidth, buttonHeight);

        // Set button background color
        changeNameButton.setBackground(Color.YELLOW);
        changePhoneNumberButton.setBackground(Color.GREEN);
        changePasswordButton.setBackground(Color.PINK);
        addEmailButton.setBackground(Color.ORANGE);
        backButton.setBackground(Color.BLUE);

        // Add buttons to panel
        panel.add(changeNameButton);
        panel.add(changePhoneNumberButton);
        panel.add(changePasswordButton);
        panel.add(addEmailButton);
        panel.add(backButton);
		
		img = new ImageIcon("JT.jpg");
        label6 = new JLabel(img);
        label6.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        panel.add(label6);

        // Add panel to frame
        add(panel);

        // Set frame visibility
        setVisible(true);
    }
}
