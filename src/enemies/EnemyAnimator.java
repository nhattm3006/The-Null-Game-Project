package enemies;

import bases.Animation;
import bases.ImageUtil;
import bases.Renderer;
import bases.Vector2D;

import java.awt.*;

public class EnemyAnimator extends Renderer {

    public boolean faceLeft;
    private Animation currentAnimation;
    private Animation leftAnimation;
    private Animation rightAnimation;

    public EnemyAnimator(){
        leftAnimation = new Animation(10, true,
                ImageUtil.load("images/enemy/Enemyleft1.png"),
                ImageUtil.load("images/enemy/Enemyleft2.png"));

        rightAnimation = new Animation(10, true,
                ImageUtil.load("images/enemy/EnemyRight1.png"),
                ImageUtil.load("images/enemy/EnemyRight2.png"));

        this.currentAnimation = leftAnimation;
    }

    public void render(Graphics g, Vector2D position) {
        this.currentAnimation.render(g, position);
    }

    void selectAnimation(Vector2D velocity) {
        if (faceLeft && velocity.x < 0) {
            this.currentAnimation = this.leftAnimation;
        }
        if (!faceLeft && velocity.x > 0){
            this.currentAnimation = this.rightAnimation;

        }
    }
}

