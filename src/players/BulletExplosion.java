package players;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class BulletExplosion extends GameObject {
    public BulletExplosion(int x, int y) {
        super(x, y);
        this.renderer = new Animation(3, true,
                ImageUtil.load("images/enemy/bacteria dead/bacteria_dead1.png"),
                ImageUtil.load("images/enemy/bacteria dead/bacteria_dead2.png"),
                ImageUtil.load("images/enemy/bacteria dead/bacteria_dead3.png"),
                ImageUtil.load("images/enemy/bacteria dead/bacteria_dead4.png"),
                ImageUtil.load("images/enemy/bacteria dead/bacteria_dead5.png")
        );
    }

    public void run() {
        Animation animation = (Animation)this.renderer;
        if (animation.finished) {
            this.destroy();
        }
    }
}
