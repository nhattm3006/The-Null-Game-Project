package players.scenes;

import bases.GameObject;
import bases.ImageUtil;
import enemies.Enemy;
import game.Background;
import game.Setting;
import maps.Map;
import players.Player;
import scenes.SceneManager;
import scenes.Scenes;
import utils.Audio;
import utils.ViewPort;

import java.awt.*;

public class GamePlayScene implements Scenes {
    Background background;
    public Player player;
    public ViewPort viewPort;
    public Enemy enemy;
    Image image;
    public GamePlayScene() {

    }

    @Override
    public void deinit() {
        GameObject.clearAll();
    }

    @Override
    public void init() {
        viewPort=new ViewPort();
        viewPort.followOffset.x=-80/2;
        background = new Background(1280,720, "images/background/maxresdefault.jpg");
        GameObject.add(background);
        Map map = Map.load("images/platforms/map1.json");
        map.generate();
        player = new Player(20,250);
        GameObject.add(player);
        enemy = new Enemy(400,250);
        GameObject.add(enemy);
        Enemy enemy2 = new Enemy(3200, 250);
        GameObject.add(enemy2);
        Image image1 = ImageUtil.load("images/platforms/Bang2.png");

    }

    @Override
    public void run() {
        viewPort.follow(player);
        if (!player.isActive) {
            SceneManager.changeScene(new GameOverScene());
        }
        if (player.position.y >= 720) {
            SceneManager.changeScene(new GameOverScene());
        }
    }

    @Override
    public ViewPort getViewPort() {
        return this.viewPort;
    }
}
