package view;

import uk.co.caprica.vlcj.player.base.ControlsApi;
import uk.co.caprica.vlcj.player.base.StatusApi;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VideoPlayer {
    EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

    JFrame frame = new JFrame();
    JPanel contentPane = new JPanel();

    JPanel buttonBar = new JPanel();
    JButton playButton = new JButton("Play");
    JButton pauseButton = new JButton("Pause");
    JButton stopButton = new JButton("Stop");

    double stoppedTime = -1;

    public void init(){
        frame.setBounds(new Rectangle(200, 200, 800, 600));
        // Add all content to the frame
        contentPane.setLayout(new BorderLayout());
        frame.setContentPane(contentPane);
        // Add media player in the center of content
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);
        // Add buttons and init event listener, then add button to the content
        buttonBar.add(playButton);
        playButton.addActionListener(e -> playVideo());
        buttonBar.add(pauseButton);
        pauseButton.addActionListener(e -> pauseVideo());
        buttonBar.add(stopButton);
        stopButton.addActionListener(e -> stopVideo());
        contentPane.add(buttonBar, BorderLayout.SOUTH);
        // Complete frame
        frame.setBounds(new Rectangle(200, 0, 800, 600));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mediaPlayerComponent.mediaPlayer().media().play("file:///D:/MyDocument/Study/576MultiMedia/proj/Ready_Player_One_rgb/Ready_Player_One_rgb/InputVideo.mp4");
    }

    private void pauseVideo(){
        mediaPlayerComponent.mediaPlayer().controls().pause();
    }

    private void playVideo(){
        if(stoppedTime >= 0){
            mediaPlayerComponent.mediaPlayer().controls().setTime((long)stoppedTime);
            stoppedTime = -1;
        }else{
            mediaPlayerComponent.mediaPlayer().controls().play();
        }
    }

    private void stopVideo(){
        System.out.println(mediaPlayerComponent.mediaPlayer().status().time());
    }
}
