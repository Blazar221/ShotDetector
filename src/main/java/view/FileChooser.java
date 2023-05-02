package view;

import tool.ProcessTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooser extends JPanel {

    private String videoUrl;
    public FileChooser(JPanel cardPanel, CardLayout cardLayout, VideoPlayer videoPlayer){
        setLayout(new FlowLayout());

        JButton openFileChooserButton = new JButton("Open File Chooser");
        JButton switchInterfaceButton = new JButton("Start Process");
        add(openFileChooserButton);
        add(switchInterfaceButton);

        openFileChooserButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                videoUrl = selectedFile.getAbsolutePath();
            }
        });

        switchInterfaceButton.addActionListener(e -> {
            videoPlayer.init(ProcessTool.INSTANCE.getMockIndexNodes(), videoUrl);
            cardLayout.show(cardPanel, "VP");
        });
    }
}
