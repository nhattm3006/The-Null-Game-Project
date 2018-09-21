package game;

import bases.GameObject;
import players.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static game.Setting.SCREEN_HEIGTH;
import static game.Setting.SCREEN_WIDTH;

public class GameCanvas extends JPanel {
    Background background;

    Player player;
    Platform ground1;
    Platform ground2;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    public GameCanvas() {
        background = new Background(1280/2, 720/2);
        GameObject.add(background);

        ground1 = new Platform(1280/2, 650);
        GameObject.add(ground1);

        ground2 = new Platform(1280, 500);
        GameObject.add(ground2);

        player = new Player(300, 550);
        GameObject.add(player);

        backBuffer = new BufferedImage(SCREEN_WIDTH,SCREEN_HEIGTH,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }

    void run() {
        GameObject.runAll();
    }

    void render() {
        GameObject.renderAll(backBufferGraphics);

        this.repaint();
    }
}