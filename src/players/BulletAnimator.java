package players;

import bases.Animation;
import bases.ImageUtil;
import bases.Renderer;
import bases.Vector2D;

import java.awt.*;

public class BulletAnimator extends Renderer {
    private Animation straightAnimation;
    private Animation currentAnimation;

    public BulletAnimator() {
        straightAnimation = new Animation(5,
                false,
                ImageUtil.load("images/bullet/brick3.png"),
                ImageUtil.load("images/bullet/brick2.png"),
                ImageUtil.load("images/bullet/brick4.png"),
                ImageUtil.load("images/bullet/brick1.png"));

        this.currentAnimation = straightAnimation;
}

    public void render(Graphics g, Vector2D position) {
        this.currentAnimation.render(g, position);
    }

    void selectAnimation(Vector2D bulletVelocity) {
        if (bulletVelocity.x > 0) {
            this.currentAnimation = this.straightAnimation;
        }
    }
}
