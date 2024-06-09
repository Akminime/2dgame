package dgame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class App {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Dino's Idle Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("C:\\Users\\akmin\\Desktop\\EVERYTHING\\Code Things\\2dGame\\app\\src\\main\\resources\\Icon.jpg");
        Image image = icon.getImage();
        frame.setIconImage(image);

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.LIGHT_GRAY);
        menuPanel.add(new JLabel("Menu"));
        menuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        menuPanel.setPreferredSize(new Dimension(200, 0));

        JPanel topBarPanel = new JPanel();
        topBarPanel.setBackground(Color.GRAY);
        topBarPanel.add(new JLabel("Top Bar"));
        topBarPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topBarPanel.setPreferredSize(new Dimension(0, 50));

        JPanel bottomBarPanel = new JPanel();
        bottomBarPanel.setBackground(Color.GRAY);
        bottomBarPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bottomBarPanel.setPreferredSize(new Dimension(0, 50));

        JButton exitButton = new JButton("Exit");
        exitButton.setPreferredSize(new Dimension(100, 40));
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        bottomBarPanel.add(exitButton, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(new JLabel("Center Section"));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        frame.setLayout(new BorderLayout());

        frame.add(menuPanel, BorderLayout.EAST);
        frame.add(topBarPanel, BorderLayout.NORTH);
        frame.add(bottomBarPanel, BorderLayout.SOUTH);
        frame.add(centerPanel, BorderLayout.CENTER);

        // Make the frame fullscreen
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        frame.setUndecorated(true);
        ge.getDefaultScreenDevice().setFullScreenWindow(frame);

        frame.setVisible(true);
    }
}