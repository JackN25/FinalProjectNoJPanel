import com.formdev.flatlaf.FlatLightLaf;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

public class MainFrame extends JFrame{

    private JProgressBar starupLoading;

    public MainFrame(String display) throws InterruptedException {
        super(display);
        FlatLightLaf.setup();
        this.setLayout(new BorderLayout());
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setResizable(true);
        this.setLocation(0,0);
        this.setVisible(true);
        this.getContentPane().setBackground( Color.BLACK );
        displayHomeScreen();
    }

    private void displayHomeScreen() throws InterruptedException {
        ImageIcon door = new ImageIcon("images/door.png");
        JLabel imageHolder = new JLabel(door);
        imageHolder.setLocation(0, 0);
        this.add(imageHolder, BorderLayout.CENTER);
        starupLoading = new JProgressBar(0, 100);
        starupLoading.setBounds(0, 0,100, 50);
        this.add(starupLoading, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
        Thread.sleep(100);
        starupLoading.setValue(100);
        Thread.sleep(1000);

        this.remove(starupLoading); this.remove(imageHolder);
        JLabel test = new JLabel("",SwingConstants.CENTER);
        test.setFont(new Font("Arial", Font.PLAIN, 20));
        test.setText("Open a door to a new world");
        test.setForeground(Color.WHITE);
        this.add(test, BorderLayout.CENTER);
        this.revalidate(); this.repaint();
        Thread.sleep(500);

        this.remove(test);
        for (Apps app : Apps.apps) {
            this.add(new JLabel(app.getFilePath(), BorderLayout.WEST));
        }
        this.revalidate(); this.repaint();
    }

}
