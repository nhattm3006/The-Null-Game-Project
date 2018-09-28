package players;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class PlayerExplosion extends GameObject {
    public PlayerExplosion(int x, int y) {
        super(x, y);
        this.renderer = new Animation(4, false,
                ImageUtil.load("images/player/PlayerDie.png")
        );
    }

    public void run() {
        Animation animation = (Animation)this.renderer;
        if (animation.finished) {
            this.destroy();
        }
    }
}