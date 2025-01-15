import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton backBtn, stButton, ctButton, rtButton, xtButton; // Buttons for each image
    private JLabel label1, label2, label3, label4, label5, label6;
    private ImageIcon img, stIcon, ctIcon, xtIcon;
    private String username; // Username passed from Tkash
    private String password; // Password passed from Tkash

    public Home(String s1, String s2) {
        super("HomePage");
        super.setBounds(230, 100, 800, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        username = s1; // Store the passed username
        password = s2; // Store the passed password

        panel = new JPanel();
        panel.setLayout(null);

        label1 = new JLabel("payFELX");
        label1.setBounds(380, 30, 100, 20);
        label1.setFont(new Font("Arial", Font.PLAIN, 22));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        label2 = new JLabel("Digital Banking Management System");
        label2.setBounds(310, 60, 300, 20);
        label2.setFont(new Font("Arial", Font.PLAIN, 18));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        label3 = new JLabel("Send Money");
        label3.setBounds(200, 200, 150, 30);
        label3.setFont(new Font("Arial", Font.PLAIN, 20));
        label3.setForeground(Color.YELLOW);
        panel.add(label3);

        label4 = new JLabel("Cash Out");
        label4.setBounds(500, 200, 150, 30);
        label4.setFont(new Font("Arial", Font.PLAIN, 20));
        label4.setForeground(Color.YELLOW);
        panel.add(label4);
		
		label5 = new JLabel("Settings");
        label5.setBounds(350, 280, 150, 30);
        label5.setFont(new Font("Arial", Font.PLAIN, 20));
        label5.setForeground(Color.YELLOW);
        panel.add(label5);

        backBtn = new JButton("Back");
        backBtn.setBounds(350, 400, 100, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        // Creating buttons for each image
        stIcon = new ImageIcon("ST.jpg");
        ctIcon = new ImageIcon("CT.jpg");
        xtIcon = new ImageIcon("XT.jpg");

        stButton = new JButton(stIcon);
        stButton.setBounds(200, 100, stIcon.getIconWidth(), stIcon.getIconHeight());
        stButton.addActionListener(this);
        panel.add(stButton);

        ctButton = new JButton(ctIcon);
        ctButton.setBounds(500, 100, ctIcon.getIconWidth(), ctIcon.getIconHeight());
		ctButton.addActionListener(this);
        panel.add(ctButton);

        xtButton = new JButton(xtIcon);
        xtButton.setBounds(375, 250, xtIcon.getIconWidth(), xtIcon.getIconHeight());
        xtButton.addActionListener(this);
        panel.add(xtButton);

        // Creating label6 with background image
        img = new ImageIcon("GT.jpg");
        label6 = new JLabel(img);
        panel.add(label6);

        // Adding a component listener to the panel to handle resizing
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                label6.setBounds(0, 0, panel.getWidth(), panel.getHeight());
            }
        });

        super.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backBtn) {
            Tkash obj2 = new Tkash();
            obj2.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == stButton) {
            System.out.println("SendMoney button clicked");
            SendMoney sendMoneyWindow = new SendMoney(username, password); // Pass username and password
            sendMoneyWindow.setVisible(true);
            this.setVisible(false);
        } else if (ae.getSource() == xtButton) {
            System.out.println("Settings button clicked");
            Settings set = new Settings(this); // Pass current instance of Home
            set.setVisible(true);
            this.setVisible(false);
        }else if (ae.getSource() == ctButton) {
            System.out.println("Cash Out button clicked");
            CashOut cashOutWindow = new CashOut(username, password, this); // Pass reference to Home window
            cashOutWindow.setVisible(true);
            this.setVisible(false); 
        }
    }
}


