package view;

import tool.ProcessTool;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooser extends JPanel {

    private String videoUrl;
    public FileChooser(JPanel cardPanel, CardLayout cardLayout, VideoPlayer videoPlayer){
        setLayout(new FlowLayout());

        JButton mp4Button = new JButton("Choose MP4");
        JButton rgbButton = new JButton("Choose RGB");
        JButton wavButton = new JButton("Choose WAV");
        JButton processButton = new JButton("Start Process");
        add(mp4Button);
        add(rgbButton);
        add(wavButton);
        add(processButton);

        mp4Button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

            FileNameExtensionFilter mp4Filter = new FileNameExtensionFilter("MP4 Files", "mp4");
            fileChooser.setFileFilter(mp4Filter);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                videoUrl = selectedFile.getAbsolutePath();
            }
        });

        rgbButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

            FileNameExtensionFilter mp4Filter = new FileNameExtensionFilter("RGB Files", "rgb");
            fileChooser.setFileFilter(mp4Filter);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // TODO handle with the chosen rgb file
            }
        });

        wavButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));

            FileNameExtensionFilter mp4Filter = new FileNameExtensionFilter("WAV Files", "wav");
            fileChooser.setFileFilter(mp4Filter);

            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                // TODO handle with the chosen wav file
            }
        });

        processButton.addActionListener(e -> {
            videoPlayer.init(ProcessTool.INSTANCE.getMockIndexNodes(), videoUrl);
            cardLayout.show(cardPanel, "VP");
        });
    }
}
