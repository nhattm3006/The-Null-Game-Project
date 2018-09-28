package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import enemies.Enemy;


public class PlayerBullet extends GameObject {
    public  boolean isFaceLeft;
    private BulletAnimator bulletAnimator;
    public Vector2D velocity;
    public PlayerBullet(int x, int y) {
        super(x, y);
        velocity = new Vector2D();
        this.bulletAnimator = new BulletAnimator();
        renderer = this.bulletAnimator;
        this.boxCollider = new BoxCollider(x, y, 13, 20);
    }

    public void run() {
        super.run();
        move();
        hitEnemies();
        deactivateIfNeeded();
    }

    private void deactivateIfNeeded() {
        if (this.position.x > 10000) {
            this.isActive = false;
        }
    }

    private void hitEnemies() {
        Enemy enemy = GameObject.checkCollision(this.boxCollider, Enemy.class);

        if (enemy != null) {
            enemy.getHit();
            System.out.println("HIT");

            this.destroy();

        }
    }

    private void move() {
        if (isFaceLeft) {
            this.position.addUp(-5, 0);
        }
        else {
            this.position.addUp(5, 0);
        }
    }
}