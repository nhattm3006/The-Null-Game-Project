package enemies;

import bases.*;

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
    }

    private void move() {
        this.enemyMove.run(position,boxCollider);
    }


    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    public void getHit() {
        this.destroy();
        EnemyExplosion enemyExplosion = new EnemyExplosion((int)this.position.x, (int)this.position.y);
        enemyExplosion.run();
        GameObject.add(enemyExplosion);
    }
}
