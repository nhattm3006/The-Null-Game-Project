package players;

import bases.*;

public class Enemy extends GameObject {

    EnemyMove enemyMove;
    public Enemy(int x, int y){
        super(x,y);
        this.renderer = new ImageRenderer("images/enemy/Enemy1.png");
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
}
