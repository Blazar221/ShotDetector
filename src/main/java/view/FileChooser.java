package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileChooser extends JPanel {
    public FileChooser(JPanel cardPanel, CardLayout cardLayout){
        setLayout(new FlowLayout());

        JButton openFileChooserButton = new JButton("Open File Chooser");
        JButton switchInterfaceButton = new JButton("Switch Interface");
        add(openFileChooserButton);
        add(switchInterfaceButton);

        openFileChooserButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            }
        });

        switchInterfaceButton.addActionListener(e -> cardLayout.show(cardPanel, "VP"));
    }
}
