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
import de.jcm.discordgamesdk.Core;
import de.jcm.discordgamesdk.CreateParams;
import de.jcm.discordgamesdk.activity.Activity;
import java.time.Instant;

public class App {
    public static void main(String[] args) {
        // Set parameters for the Core
        try (CreateParams params = new CreateParams()) {
            params.setClientID(1249184866709536788L);
            params.setFlags(CreateParams.getDefaultFlags());

            // Create the Core
            try (Core core = new Core(params)) {
                // Create the Activity
                try (Activity activity = new Activity()) {
                    activity.setDetails("Rebirth 1");
                    activity.setState("Playing Solo");
                    activity.timestamps().setStart(Instant.now());
                    activity.party().size().setMaxSize(1);
                    activity.party().size().setCurrentSize(1);
                    activity.assets().setLargeImage("icon");
                    activity.party().setID("Party!");
                    activity.secrets().setJoinSecret("Join!");

                    // Finally, update the current activity to our activity
                    core.activityManager().updateActivity(activity);

                    // Set up the GUI
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

                    // Run callbacks forever
                    while (true) {
                        core.runCallbacks();
                        try {
                            // Sleep a bit to save CPU
                            Thread.sleep(16);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
