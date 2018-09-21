package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import enemies.Enemy;

public class PlayerBullet extends GameObject {
    private BulletAnimator bulletAnimator;

    public PlayerBullet(int x, int y) {
        super(x, y);
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
        if (this.position.x > 1280) {
            this.isActive = false;
        }
    }

    private void hitEnemies() {
        Enemy enemy = GameObject.checkCollision(this.boxCollider, Enemy.class);

        if (enemy != null) {
            enemy.getHit();
            this.getHit();
            this.destroy();
        }
    }

    public void getHit() {
        this.destroy();
        BulletExplosion bulletExplosion =
                new BulletExplosion((int)this.position.x, (int)this.position.y);
        GameObject.add(bulletExplosion);
    }

    private void move() {
        this.position.addUp(5, 0);
    }
}