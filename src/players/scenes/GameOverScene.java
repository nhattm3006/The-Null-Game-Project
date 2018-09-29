package players.scenes;

import bases.GameObject;
import bases.ImageRenderer;
import game.Background;
import scenes.Scenes;

public class GameOverScene implements Scenes {
    @Override
    public void deinit() {

    }

    @Override
    public void init() {
        GameObject background = new GameObject();
        background.renderer = new ImageRenderer("images/background/GameOver.png");
        background.position.set(1280/2,720/2);
        GameObject.add(background);

    }
}
