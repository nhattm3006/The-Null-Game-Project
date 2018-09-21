package enemies;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import bases.*;
import players.Player;

public class Enemy extends GameObject {
    public ArrayList<EnemyBullet> enemyBullets;
    Random random;

    EnemyShoot enemyShoot;
    EnemyMove enemyMove;

    public Enemy(int x, int y) {
        super(x, y);

        renderer = new Animation(
                ImageUtil.load("images/enemy/bacteria/bacteria1.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria2.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria3.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria4.png")
        );
        random = new Random();
        enemyMove = new EnemyMove();
        enemyShoot = new EnemyShoot();
        this.boxCollider = new BoxCollider(x, y, 30, 30);
    }

    public void run() {
        super.run();
        this.move();
        this.shoot();
        this.hitPlayers();
    }

    private void hitPlayers() {
        Player player = GameObject.checkCollision(this.boxCollider, Player.class);

        if (player != null) {
            player.getHit();
        }
    }

    public void getHit() {
        this.destroy();
        EnemyExplosion enemyExplosion =
                new EnemyExplosion((int)this.position.x, (int)this.position.y);
        GameObject.add(enemyExplosion);
    }

    public void shoot() {
        this.enemyShoot.run(this);
    }

    public void move() {
        this.enemyMove.run(position);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}