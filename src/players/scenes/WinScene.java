package players.scenes;

import bases.GameObject;
import game.Background;
import inputs.InputManager;
import scenes.SceneManager;
import scenes.Scenes;
import utils.Audio;
import utils.ViewPort;

public class WinScene implements Scenes {
    @Override
    public void deinit() {
        GameObject.clearAll();

    }

    @Override
    public void init() {
        Background background = new Background(1280/2,720/2, "images/background/win.png");
        GameObject.add(background);
        Audio.loadSound("images/audio/iRingtones.net Ddu-Du Ddu-Du Ringtone - Android ringtones.mp3");
        Audio.playMedia("images/audio/iRingtones.net Ddu-Du Ddu-Du Ringtone - Android ringtones.mp3");
        Audio.initialize();


    }

    @Override
    public void run() {
        if (InputManager.instance.startAgain) {
            SceneManager.changeScene(new GamePlayScene());
        }
    }

    @Override
    public ViewPort getViewPort() {
        return null;
    }
}
