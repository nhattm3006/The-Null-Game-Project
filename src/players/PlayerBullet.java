package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;


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
//        hitEnemies();
        deactivateIfNeeded();
    }

    private void deactivateIfNeeded() {
        if (this.position.x > 1280) {
            this.isActive = false;
        }
    }

//    private void hitEnemies() {
//        Enemy enemy = GameObject.checkCollision(this.boxCollider, Enemy.class);
//
//        if (enemy != null) {
//            enemy.getHit();
//            System.out.println("HIT");
//
////            this.getHit();
//            this.destroy();
//
//        }
//    }

    /* Xóa hàm này nhé, thừa vcl */
//    public void getHit() {
//        this.destroy();
//        BulletExplosion bulletExplosion =
//                new BulletExplosion((int)this.position.x, (int)this.position.y);
//        GameObject.add(bulletExplosion);
//    }

    private void move() {
        if (isFaceLeft) {
            this.position.addUp(-5, 0);
        }
        else {
            this.position.addUp(5, 0);
        }
    }
}