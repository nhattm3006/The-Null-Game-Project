package game;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import utils.ViewPort;

import java.awt.*;

public class Background extends GameObject {
    ImageRenderer renderer;
    public Vector2D velocity;
    public Background(int x, int y) {
        super(x, y);
        this.position  = new Vector2D();
        velocity = new Vector2D();
        this.renderer = new ImageRenderer("images/background/maxresdefault.jpg");
    }

    @Override
    public void render(Graphics g, ViewPort viewPort) {
        g.drawImage(this.renderer.image, (int) position.x,(int) position.y, null);
        g.drawImage(this.renderer.image, (int) position.x + 1280,(int) position.y, null);
        g.drawImage(this.renderer.image, (int) position.x - 1280,(int) position.y, null);
    }

    @Override
    public void run() {
        if (position.x > - 1280 && position.x < 1280) {
            this.position.subtractBy(velocity.x * 0.1f, 0);
        } else {
            position.x = 0;
        }
    }
}
