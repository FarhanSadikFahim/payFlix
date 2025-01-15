import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Location extends JFrame implements ActionListener {
    private JPanel panel;
    private JButton backBtn, stButton;
    private JLabel label1, label2;
    private ImageIcon img;

    public Location() {
        super("Location");
        super.setBounds(230, 100, 800, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        img = new ImageIcon("Map.jpg");
        label1 = new JLabel(img);
        panel.add(label1);

        backBtn = new JButton("Back");
        backBtn.setBounds(50, 50, 80, 30);
        backBtn.addActionListener(this);
        panel.add(backBtn);

        // Adding a component listener to the panel to handle resizing
        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                label1.setBounds(0, 0, panel.getWidth(), panel.getHeight());
            }
        });

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backBtn) {
            Tkash obj3 = new Tkash();
            obj3.setVisible(true);
            this.setVisible(false);
        }
    }
}
