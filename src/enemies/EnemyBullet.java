package enemies;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import players.Player;

public class EnemyBullet extends GameObject {
    public EnemyBullet(int x, int y) {
        super(x, y);
        renderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet2.png");
        this.boxCollider = new BoxCollider(x, y, 20, 20);
    }

    public void run() {
        super.run();
        move();
        hitPlayers();
    }

    private void hitPlayers() {
        Player player = GameObject.checkCollision(this.boxCollider, Player.class);

        if (player != null) {
            player.getHit();
            this.destroy();
        }
    }

    private void move() {
        this.position.addUp(0, 5);
    }
}