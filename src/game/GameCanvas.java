package game;

import bases.GameObject;
import enemies.Enemy;
import maps.Map;
import players.Player;
import utils.Audio;
import utils.ViewPort;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static game.Setting.SCREEN_HEIGTH;
import static game.Setting.SCREEN_WIDTH;

public class GameCanvas extends JPanel {
    private ViewPort viewPort;
    Background background;

    Player player;

    Enemy enemy;
    Audio audio;

    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    public GameCanvas() {





        background = new Background(1280/2, 720/2);
        GameObject.add(background);


        Map map = Map.load("images/platforms/demo.json");
        map.generate();

        player = new Player(20, 250);
        GameObject.add(player);

        enemy = new Enemy(800, 335);
        GameObject.add(enemy);

        backBuffer = new BufferedImage(SCREEN_WIDTH,SCREEN_HEIGTH,BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
        this.viewPort = new ViewPort();
        this.viewPort.getFollowOffset().set(-Setting.SCREEN_WIDTH/2,-Setting.SCREEN_HEIGTH/2);
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.drawImage(backBuffer,0,0,null);
    }

    void run() {
        viewPort.follow(player);
        background.velocity.set(player.playerMove.velocity);
        GameObject.runAll();
    }

    void render() {
        GameObject.renderAll(backBufferGraphics,viewPort);
        this.repaint();
    }
}