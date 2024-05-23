import com.formdev.flatlaf.FlatLightLaf;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.*;

public class MainFrame extends JFrame{

    private JProgressBar starupLoading;

    public MainFrame(String display) throws InterruptedException {
        super(display);
        //FlatLightLaf.setup();
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //this.getContentPane().setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1000, 1000);
        this.setResizable(true);
        this.setLocation(0,0);
        this.setVisible(true);
        displayHomeScreen();
    }

    private void displayHomeScreen() throws InterruptedException {
        ImageIcon door = new ImageIcon("images/door.png");
        JLabel imageHolder = new JLabel(door);
        imageHolder.setLocation(0, 0);
        this.add(imageHolder);
        //starupLoading = new JProgressBar(0, 100);
        //starupLoading.setBounds(0, 0, 100, 10);
        //this.add(starupLoading);
        this.revalidate();
        this.repaint();
        Thread.sleep(100);
    }

}
