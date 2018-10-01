package scenes;

import javafx.scene.media.MediaPlayer;

public class SceneManager {
    static public Scenes currentScene;
    public static Scenes nextScene;
    public static MediaPlayer mediaPlayer;

    public static void changeScene(Scenes newScene) {
        if (newScene != null) {
            nextScene = newScene;
        }
        }
    public static void changeSceneIfNeeded(){
        if (nextScene != null) {
            if (currentScene != null) {
                currentScene.deinit();
            }
            nextScene.init();

            currentScene = nextScene;
            nextScene = null;

        }

        }
    }

