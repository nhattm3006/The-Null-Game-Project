package enemies;

import bases.*;
import utils.ViewPort;

import java.awt.*;

public class Enemy extends GameObject {

    EnemyMove enemyMove;
    private EnemyAnimator enemyAnimator;
    public boolean isLeft;

    public Enemy(int x, int y){
        super(x,y);
        this.enemyAnimator = new EnemyAnimator();
        renderer = this.enemyAnimator;
        enemyMove = new EnemyMove();
        boxCollider = new BoxCollider(30,30);
    }

    @Override
    public void run() {
        super.run();
        this.move();
//        this.animate();
    }

    private void move() {
        this.enemyMove.run(position,boxCollider);
//        this.isLeft = EnemyMove.moveLeft;
    }

    public void animate(){
        this.enemyAnimator.selectAnimation();
        this.enemyAnimator.isLeft = this.isLeft;
    }


    @Override
    public void render(Graphics g, ViewPort viewPort) {
        super.render(g, viewPort);
    }

    public void getHit() {
        this.destroy();
        EnemyExplosion enemyExplosion = new EnemyExplosion((int)this.position.x, (int)this.position.y);
        enemyExplosion.run();
        GameObject.add(enemyExplosion);
    }
}
