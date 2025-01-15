import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tkash extends JFrame implements MouseListener, ActionListener {
    private JPanel panel;
    private JLabel user, label6, pass, title2, title5, title6, title8, title10;
    private JPasswordField passfield;
    private JTextField text;
    private ImageIcon img, locIcon, oipIcon, oppIcon; // Declare ImageIcon variables
    private Color color1;
    private JButton login, bt1, bt2, signup, locButton, oipButton, oppButton; // Declaring buttons

    public Tkash() {
        super("Tkash");
        super.setBounds(230, 100, 800, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        color1 = new Color(250, 250, 250);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color1);

        user = new JLabel("Name");
        user.setBounds(250, 115, 100, 20);
        panel.add(user);

        text = new JTextField();
        text.setBounds(300, 115, 200, 30);
        panel.add(text);

        passfield = new JPasswordField();
        passfield.setBounds(300, 150, 200, 20);
        panel.add(passfield);
        passfield.setEchoChar('*');

        title5 = new JLabel("Near Store");
        title5.setBounds(90, 360, 100, 20);
        panel.add(title5);

        title6 = new JLabel("Offer");
        title6.setBounds(380, 360, 100, 20);
        panel.add(title6);

        title8 = new JLabel("Helpline");
        title8.setBounds(690, 360, 100, 20);
        panel.add(title8);

        img = new ImageIcon("payFelx.jpg");
        title2 = new JLabel(img);
        title2.setBounds(350, 30, 100, 67);
        panel.add(title2);

        // Load images for buttons
        locIcon = new ImageIcon("loc.jpg");
        oipIcon = new ImageIcon("OIP.jpg");
        oppIcon = new ImageIcon("Opp.jpg");

        // Create buttons with icons
        locButton = new JButton(locIcon);
        locButton.setBounds(90, 305, locIcon.getIconWidth(), locIcon.getIconHeight());
		locButton.addActionListener(this);
        panel.add(locButton);

        oppButton = new JButton(oppIcon);
        oppButton.setBounds(370, 305, oppIcon.getIconWidth(), oipIcon.getIconHeight());
        panel.add(oppButton);

        oipButton = new JButton(oipIcon);
        oipButton.setBounds(685, 305, oipIcon.getIconWidth(), oppIcon.getIconHeight());
        panel.add(oipButton);
        
        img = new ImageIcon("lock.jpg");
        title10 = new JLabel(img);
        title10.setBounds(250, 130, 30, 50);
        panel.add(title10);

        login = new JButton("SIGN IN");
        login.setBounds(330, 200, 150, 30);
        login.addMouseListener(this);
        login.addActionListener(this);
        panel.add(login);

        bt1 = new JButton("Close");
        bt1.setBounds(330, 400, 150, 30);
		bt1.setBackground(Color.BLUE);
        bt1.addActionListener(this);
        panel.add(bt1);

        signup = new JButton("ProfilePalace");
        signup.setBounds(330, 240, 150, 30);
        signup.addMouseListener(this);
        signup.addActionListener(this);
        panel.add(signup);
		
		img = new ImageIcon("BT.jpg");
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

    public void mouseClicked(MouseEvent me) {
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
        if (me.getSource() == login) {
            login.setBackground(Color.RED);
        } else if (me.getSource() == signup) {
            signup.setBackground(Color.RED);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == login) {
            login.setBackground(UIManager.getColor("Button.background"));
        } else if (me.getSource() == signup) {
            signup.setBackground(UIManager.getColor("Button.background"));
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String name = text.getText();
            String password = String.valueOf(passfield.getPassword());

            Account acc = new Account(name, password);
            if (acc.checkAccount(name, password)) {
                JOptionPane.showMessageDialog(this, "SIGN IN Successful");
                Home obj1 = new Home(name, password);
                obj1.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Username/Password wrong Or No Input");
            }
        } else if (ae.getSource() == signup) {
            SignUp r1 = new SignUp();
            r1.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == bt1) { // Close button
             System.exit(0); // Close the window
        } else if (ae.getSource() == bt2) { // Show button
            // Implement show functionality
		} else if (ae.getSource() == locButton) {
        System.out.println("Location button clicked"); // Add this line for debugging
        Location locationWindow = new Location();
        locationWindow.setVisible(true);
        this.setVisible(false);
        }  else if (ae.getSource() == oipButton) {
        System.out.println("HelpLine button clicked");
        HelpLine helpLineWindow = new HelpLine(this); // Pass the Tkash instance
        helpLineWindow.setVisible(true);
        this.setVisible(false);
       }

    }
}
