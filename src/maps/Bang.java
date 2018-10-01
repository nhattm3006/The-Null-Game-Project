package maps;

import bases.Animation;
import bases.BoxCollider;
import bases.GameObject;
import bases.ImageUtil;

public class Bang extends GameObject {
    public Bang(int x, int y, int width, int height){
        super(x, y);
        boxCollider = new BoxCollider(x, y, 369 , 129);
        renderer = new Animation(10, true, ImageUtil.load("images/platforms/Bang.png"));

    }
}
