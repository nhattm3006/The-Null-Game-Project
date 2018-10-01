package enemies;

import bases.*;
import utils.ViewPort;

import java.awt.*;

public class Enemy extends GameObject {

    EnemyMove enemyMove;
    EnemyAnimator enemyAnimator;
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
        this.animate();
    }

    private void move() {
        this.enemyMove.run(position,boxCollider);
    }

    public void animate(){
        this.enemyAnimator.selectAnimation(this.enemyMove.velocity);
}


    public void getHit() {
        this.destroy();
        EnemyExplosion enemyExplosion = new EnemyExplosion((int)this.position.x, (int)this.position.y);
        enemyExplosion.run();
        GameObject.add(enemyExplosion);
    }
}
