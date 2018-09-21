package game;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

public class Platform extends GameObject {
    Platform (int x, int y) {
        super(x, y);
        renderer = new ImageRenderer("images/background/ground.png");
        this.boxCollider = new BoxCollider(x, y, 1280, 100);
    }
}
