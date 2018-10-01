package game;

import bases.GameObject;
import players.scenes.SceneMenu;
import scenes.SceneManager;
import utils.Audio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static game.Setting.SCREEN_HEIGTH;
import static game.Setting.SCREEN_WIDTH;

public class GameCanvas extends JPanel {
    BufferedImage backBuffer;
    Graphics backBufferGraphics;

    public GameCanvas() {
        SceneManager.changeScene(new SceneMenu());
        backBuffer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGTH, BufferedImage.TYPE_INT_ARGB);
        backBufferGraphics = backBuffer.getGraphics();
        SceneManager.nextScene = new SceneMenu();
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(backBuffer,0,0,null);
    }

    void run() {
        GameObject.runAll();
        SceneManager.changeSceneIfNeeded();
        SceneManager.currentScene.run();
        System.out.println(SceneManager.currentScene);
    }

    void render() {

        GameObject.renderAll(backBufferGraphics, SceneManager.currentScene.getViewPort());
        this.repaint();
    }
}