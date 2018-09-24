package players;

import bases.Animation;
import bases.ImageUtil;
import bases.Renderer;
import bases.Vector2D;
import inputs.InputManager;

import java.awt.*;

public class PlayerAnimator extends Renderer {


    public boolean isFaceLeft;
    private Animation currentAnimation;
    private Animation leftAnimation;
    private Animation rightAnimation;
    private Animation shootLeftAnimation;
    private Animation shootRightAnimation;


    public PlayerAnimator() {
        leftAnimation = new Animation(10,
                true,
                ImageUtil.load("images/player/PlayerLeft1.png"));

        rightAnimation = new Animation(10,
                true,
                ImageUtil.load("images/player/PlayerRight1.png"));
        shootLeftAnimation = new Animation(10, true,
                ImageUtil.load("images/player/PlayerLeft1.png"),
                ImageUtil.load("images/player/PlayerLeft2.png"),
                ImageUtil.load("images/player/PlayerLeft3.png"));
        shootRightAnimation = new Animation(10, true,
                ImageUtil.load("images/player/PlayerRight1.png"),
                ImageUtil.load("images/player/PlayerRight2.png"),
                ImageUtil.load("images/player/PlayerRight3.png"));
        this.currentAnimation = rightAnimation;
    }

    public void render(Graphics g, Vector2D position) {
        this.currentAnimation.render(g, position);
    }

    void selectAnimation() {
        if (isFaceLeft) {
            if (InputManager.instance.xPressed) {
                this.currentAnimation = shootLeftAnimation;
            }
            else {
                this.currentAnimation = this.leftAnimation;
            }
        }
        else {
            if (InputManager.instance.xPressed) {
                this.currentAnimation = shootRightAnimation;
            }
            else {
                this.currentAnimation = this.rightAnimation;
            }
        }

    }
}
