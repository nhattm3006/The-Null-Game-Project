package players.scenes;

import bases.GameObject;
import bases.ImageRenderer;
import game.Background;
import inputs.InputManager;
import javafx.scene.Scene;
import javafx.util.Duration;
import jdk.internal.util.xml.impl.Input;
import scenes.SceneManager;
import scenes.Scenes;
import utils.Audio;
import utils.ViewPort;

public class SceneMenu implements Scenes {


    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        Background background = new Background(1280 / 2, 720 / 2, "images/background/GameMenu1.png");
        GameObject.add(background);
        Audio.initialize();
        Audio.playMedia("images/audio/MarioNhacChuong-V.A-2717632.mp3");


    }


    @Override
    public void run() {
        if (InputManager.instance.startAgain) {
            SceneManager.changeScene(new GamePlayScene());
        }
        if(InputManager.instance.exit){
            System.exit(0);
        }
    }

    @Override
    public ViewPort getViewPort() {
        return null;
    }
}

