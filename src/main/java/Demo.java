import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;

public class Demo {
    public static void main(String[] args) {

        EmbeddedMediaPlayerComponent component = new EmbeddedMediaPlayerComponent();

        JFrame frame = new JFrame();
        frame.setBounds(new Rectangle(200, 200, 800, 600));

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        frame.setContentPane(contentPane);

        component = new EmbeddedMediaPlayerComponent();
        contentPane.add(component, BorderLayout.CENTER);


        frame.setBounds(new Rectangle(200, 200, 800, 600));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        component.mediaPlayer().media().play("file:///D:/MyDocument/Study/576MultiMedia/proj/Ready_Player_One_rgb/Ready_Player_One_rgb/InputVideo.mp4");

    }
}
