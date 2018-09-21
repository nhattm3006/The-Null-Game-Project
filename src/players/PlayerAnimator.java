package players;

import bases.Animation;
import bases.ImageUtil;
import bases.Renderer;
import bases.Vector2D;

import java.awt.*;

public class PlayerAnimator extends Renderer {
    private Animation currentAnimation;
    private Animation leftAnimation;
    private Animation rightAnimation;
    private Animation straightAnimation;

    public PlayerAnimator() {
        leftAnimation = new Animation(10,
                true,
                        ImageUtil.load("images/player/CharacterRight1.png"),
                        ImageUtil.load("images/player/CharacterRight1.png"));

        rightAnimation = new Animation(10,
                true,
                ImageUtil.load("images/player/CharacterRight1.png"),
                ImageUtil.load("images/player/CharacterRight1.png"));

        straightAnimation = new Animation(10,
                true,
                ImageUtil.load("images/player/CharacterRight1.png"),
                ImageUtil.load("images/player/CharacterRight1.png"));
        this.currentAnimation = straightAnimation;
    }

    public void render(Graphics g, Vector2D position) {
        this.currentAnimation.render(g, position);
    }

    void selectAnimation(Vector2D playerVelocity) {
        if (playerVelocity.x < 0) {
            this.currentAnimation = this.leftAnimation;
        }
        else if (playerVelocity.x > 0) {
            this.currentAnimation = this.rightAnimation;
        }
        else {
            this.currentAnimation = this.straightAnimation;
        }
    }
}
