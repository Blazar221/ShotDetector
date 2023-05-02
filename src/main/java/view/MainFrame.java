package view;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    private JFrame frame;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public MainFrame(){
        frame = new JFrame();

        frame.setBounds(new Rectangle(200, 200, 800, 600));

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        FileChooser fileChooser = new FileChooser(cardPanel, cardLayout);
        VideoPlayer videoPlayer = new VideoPlayer();

        cardPanel.add(fileChooser, "FC");
        cardPanel.add(videoPlayer, "VP");

        frame.getContentPane().add(cardPanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
