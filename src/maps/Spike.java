package maps;

import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.ImageUtil;

public class Spike extends GameObject {
    public Spike(int x, int y, int width, int height){
        super(x, y);
        boxCollider = new BoxCollider(x, y, 32 , 32);
        renderer = new Animation(10, true, ImageUtil.load("images/platforms/spkie.png"));
    }

}