package utils;

import bases.GameObject;
import bases.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class ViewPort  {
    private Vector2D position;
    private Vector2D followOffset;
    public ViewPort(){
        position =  new Vector2D();
        followOffset = new Vector2D();
    }
    public void follow(GameObject gameObject){
        position = gameObject.position.add(followOffset);
    }

    public Vector2D translate(Vector2D screenPosition){
        return screenPosition.subtract(this.position.x, 0);
    }
    public Vector2D getFollowOffset() {
        return followOffset;
    }
}
