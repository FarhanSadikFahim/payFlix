import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HelpLine extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JLabel title, label1;
    private JButton emailBtn;
    private JButton callBtn;
    private JButton locationBtn;
    private JButton backBtn;
	
	private Tkash tkashInstance; 

    public HelpLine(Tkash tkashInstance) {
        super("Help Line"); 
        super.setBounds(230, 100, 800, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        panel = new JPanel();
        panel.setLayout(null); 
    
        title = new JLabel("Help Line");
        title.setFont(new Font("Arial", Font.BOLD, 28)); 
        title.setBounds(350, 30, 200, 50); 
        panel.add(title);
    
        // Button for emailing
        emailBtn = new JButton("Email");
        emailBtn.setFont(new Font("Arial", Font.BOLD, 24));
        emailBtn.setBounds(100, 120, 275, 150); 
        emailBtn.setBackground(Color.GREEN);
        emailBtn.setForeground(Color.WHITE);
        panel.add(emailBtn);

        // Button for locating
        locationBtn = new JButton("Location");
        locationBtn.setFont(new Font("Arial", Font.BOLD, 24));
        locationBtn.setBounds(430, 120, 275, 150);
        locationBtn.setBackground(Color.GREEN);
        locationBtn.setForeground(Color.WHITE);
        panel.add(locationBtn);

        // Button for calling
        callBtn = new JButton("Call");
        callBtn.setFont(new Font("Arial", Font.BOLD, 24));
        callBtn.setBounds(250, 325, 275, 150); 
        callBtn.setBackground(Color.GREEN);
        callBtn.setForeground(Color.WHITE);
        panel.add(callBtn);
        
        // Button for going back
        backBtn = new JButton("Back");
        backBtn.setBounds(50, 50, 80, 30);
        backBtn.addActionListener(this); // Add ActionListener to backBtn
        panel.add(backBtn);
		
		panel.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
        label1.setBounds(0, 0, panel.getWidth(), panel.getHeight());
            }
        });

        this.add(panel);
    }

    // Implementing actionPerformed method of ActionListener interface
     public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backBtn) {
            // Toggle visibility between Tkash and HelpLine instances
            tkashInstance.setVisible(true);
            this.setVisible(false);
        }
      }
}

