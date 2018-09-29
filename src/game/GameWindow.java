package game;

import inputs.InputManager;
import utils.Audio;
import utils.ViewPort;

import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    private ViewPort viewPort;
    GameCanvas canvas;
    public GameWindow() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                InputManager.instance.keyPressed(keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent keyEvent) {
                InputManager.instance.keyReleased(keyEvent);
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        this.setSize(1280,720);
        this.setResizable(false);
        this.setTitle("Cong Chua Danh Ghen");

        canvas = new GameCanvas();
        this.setContentPane(canvas);
        this.setVisible(true);
        Audio.loadSound("images/audio/MarioNhacChuong-V.A-2717632.mp3");
        Audio.initialize();
        Audio.playMedia("images/audio/MarioNhacChuong-V.A-2717632.mp3");
        Audio.play(null);
    }

    public void mainLoop() {
        long lastTimeRender = 0;
        long currentTime;

        while (true) {
            currentTime = System.nanoTime();
            if (currentTime - lastTimeRender >= 17_000_000) {
                canvas.run();
                canvas.render();
                lastTimeRender = currentTime;
            }
        }
    }
}