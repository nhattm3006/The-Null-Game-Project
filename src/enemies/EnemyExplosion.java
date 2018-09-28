package enemies;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class EnemyExplosion extends GameObject {
    public EnemyExplosion(int x, int y){
        super(x , y);
        this.renderer = new Animation(3, true,
                ImageUtil.load("images/enemy/EnemyDie1.png"),
                ImageUtil.load("images/enemy/EnemyDie2.png"),
                ImageUtil.load("images/enemy/EnemyDie3.png"));
    }

    @Override
    public void run(){
        super.run();
        Animation animations = (Animation)this.renderer;
        if(animations.finished){
            this.destroy();
        }
    }

}
