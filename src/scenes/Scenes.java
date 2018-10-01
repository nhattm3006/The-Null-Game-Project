package scenes;


import utils.ViewPort;

public interface Scenes {
    void deinit();
    void init();
    void run();
    ViewPort getViewPort();
}
