package view;

import model.IndexNode;
import uk.co.caprica.vlcj.player.base.ControlsApi;
import uk.co.caprica.vlcj.player.base.StatusApi;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class VideoPlayer {
    EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

    JFrame frame = new JFrame();
    JPanel contentPane = new JPanel();

    JPanel buttonBar = new JPanel();
    JButton playButton = new JButton("Play");
    JButton pauseButton = new JButton("Pause");
    JButton stopButton = new JButton("Stop");

    double stoppedTime = -1;

    JPanel indexPanel = new JPanel();

    public void init(List<IndexNode> nodes) {
        frame.setBounds(new Rectangle(200, 200, 800, 600));
        contentPane.setLayout(new BorderLayout());
        frame.setContentPane(contentPane);

        initMedia();

        initButtons();

        initTree(nodes);

        frame.setBounds(new Rectangle(200, 0, 800, 600));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mediaPlayerComponent.mediaPlayer().media().play("file:///D:/MyDocument/Study/576MultiMedia/proj/Ready_Player_One_rgb/Ready_Player_One_rgb/InputVideo.mp4");
    }

    private void initMedia() {
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);
    }

    private void initButtons() {
        buttonBar.add(playButton);
        playButton.addActionListener(e -> playVideo());
        buttonBar.add(pauseButton);
        pauseButton.addActionListener(e -> pauseVideo());
        buttonBar.add(stopButton);
        stopButton.addActionListener(e -> stopVideo());
        contentPane.add(buttonBar, BorderLayout.SOUTH);
    }

    private void initTree(List<IndexNode> nodes) {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(new IndexNode("Root", 0));

        for (IndexNode scene : nodes) {
            DefaultMutableTreeNode sceneNode = new DefaultMutableTreeNode(scene);
            rootNode.add(sceneNode);
            if (!scene.isLeaf()) {
                for (int j = 0; j < scene.getChildren().size(); j++) {
                    IndexNode shot = scene.getChildren().get(j);
                    DefaultMutableTreeNode shotNode = new DefaultMutableTreeNode(shot);
                    sceneNode.add(shotNode);
                    if (!shot.isLeaf()) {
                        for (int k = 0; k < shot.getChildren().size(); k++) {
                            IndexNode subshot = shot.getChildren().get(k);
                            DefaultMutableTreeNode subshotNode = new DefaultMutableTreeNode(subshot);
                            shotNode.add(subshotNode);
                        }
                    }
                }
            }
        }

        JTree tree = new JTree(rootNode);
        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (selectedNode != null && selectedNode.isLeaf()) {
                IndexNode nodeData = (IndexNode) selectedNode.getUserObject();
                playVideo(nodeData.getTime());
            }
        });
        indexPanel.add(tree);

        contentPane.add(indexPanel, BorderLayout.WEST);
    }

    private void pauseVideo() {
        mediaPlayerComponent.mediaPlayer().controls().pause();
    }

    private void playVideo() {
        if (stoppedTime >= 0) {
            mediaPlayerComponent.mediaPlayer().controls().setTime((long) stoppedTime);
            stoppedTime = -1;
        } else {
            mediaPlayerComponent.mediaPlayer().controls().play();
        }
    }

    private void playVideo(double second) {
        mediaPlayerComponent.mediaPlayer().controls().setTime((long) second * 1000);
    }

    private void stopVideo() {
        System.out.println(mediaPlayerComponent.mediaPlayer().status().time());
    }
}
