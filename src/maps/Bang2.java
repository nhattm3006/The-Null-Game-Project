package maps;

import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.ImageUtil;

public class Bang2 extends GameObject {
    public Bang2(int x, int y, int width, int height){
        super(x, y);
        boxCollider = new BoxCollider(x, y, 0 , 0);
        renderer = new Animation(10, true, ImageUtil.load("images/platforms/Bang2.png"));

    }
}

