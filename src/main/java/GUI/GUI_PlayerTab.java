package GUI;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class GUI_PlayerTab extends JPanel {

    final JFXPanel fxPanel = new JFXPanel();
    File bip;
    Media hit;
    MediaPlayer mediaPlayer;
    JButton playButton;

    public GUI_PlayerTab() {
        this.initialize();
    }

    public Container initialize() {

        this.add(fxPanel);

        this.setPreferredSize(new Dimension(400, 300));
        this.setBackground(Color.BLACK);

        setMusic();
        setButtons();

        Platform.runLater(new Runnable() {
            public void run() {
                initFX(fxPanel);
            }
        });

        this.setVisible(true);
        return this;
    }

    private void initFX(JFXPanel fxPanel) {
        Scene scene = initScene();
        fxPanel.setScene(scene);
    }

    private Scene initScene() {
        Group root = new Group();
        Scene scene = new Scene(root, javafx.scene.paint.Color.GREENYELLOW);

        return (scene);
    }

    private void setButtons() {

        playButton = new JButton("▶");
        /* buttons setting */
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Status status = mediaPlayer.getStatus();

                if (status == Status.PAUSED
                        || status == Status.READY
                        || status == Status.STOPPED) {

                    mediaPlayer.play();
                    playButton.setText("||");
                } else {
                    mediaPlayer.pause();
                    playButton.setText("▶");
                }
            }
        });


        this.add(playButton);
       
        
        /* buttons setting end */


    }

    private void setMusic() {
        bip = new File(System.getProperty("user.home") + "/Downloads/[와타아메]+모노크로스로드.mp3");
        System.out.println(bip.toURI().toString());
        hit = new Media(bip.toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
    }


}