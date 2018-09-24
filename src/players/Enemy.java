package players;

import bases.*;
import enemies.EnemyExplosion;

import java.awt.*;

public class Enemy extends GameObject {

    EnemyMove enemyMove;
    public Enemy(int x, int y){
        super(x,y);
        renderer = new Animation(
                ImageUtil.load("images/enemy/Enemyleft1.png"),
                ImageUtil.load("images/enemy/Enemyleft2.png")
        );
        enemyMove = new EnemyMove();
        boxCollider = new BoxCollider(30,30);
    }

    @Override
    public void run() {
        super.run();
        this.move();
//        this.getHit();
        this.hitPlayer();
        this.deactivateIfNeeded();
    }

    private void move() {
        this.enemyMove.run(position,boxCollider);
    }

    /* Đây là phần thêm vào */

    // Ham check colision khi nem gach vao enemy
     public void getHit(){
         this.destroy();
         EnemyExplosion enemyExplosion = new EnemyExplosion((int)this.position.x,
                 (int)this.position.y);
         enemyExplosion.run();
         GameObject.add(enemyExplosion);
     }


    private void deactivateIfNeeded(){
        if (this.position.x < 720){
            this.isActive = false;
        }
    }

     private void hitPlayer(){
         Player player = GameObject.checkCollision(this.boxCollider, Player.class);

         if (player != null){
             player.getHit();
         }
     }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }
}
