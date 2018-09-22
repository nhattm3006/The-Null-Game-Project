package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import game.Platform;
import game.Setting;

public class EnemyMove extends GameObject {
    public Vector2D velocity;
    private final float GRAVITY = 0.4f;
    EnemyMove() {
        velocity = new Vector2D();
        boxCollider = new BoxCollider(30, 30);
    }
    public void run(Vector2D position,BoxCollider boxCollider){
        this.velocity.x -= 0.01;
        updateVerticalPhysics(position, boxCollider);
        updateHorizontalPhysics(position,boxCollider);
        this.velocity.y += GRAVITY;
        position.addUp(velocity);
        if (position.x < 0) position.x = 0;
        if (position.y > 800) position.y = Setting.SCREEN_WIDTH;
    }
    private void updateVerticalPhysics(Vector2D position, BoxCollider boxCollider) {
        BoxCollider nextBoxCollider = boxCollider.shift(0, velocity.y);

        Platform platform = GameObject.checkCollision(nextBoxCollider, Platform.class);
        if (platform != null) {
            boolean moveContinue = true;
            float shiftDistance = 1;
            while (moveContinue) {
                if (GameObject.checkCollision(boxCollider.shift(0, shiftDistance), Platform.class) != null) {
                    moveContinue = false;
                }
                else {
                    shiftDistance += 1;
                    position.addUp(0, 1);
                }
            }
            velocity.y = 0;
        }
    }
    private void updateHorizontalPhysics(Vector2D position, BoxCollider boxCollider) {
        BoxCollider nextBoxCollider = boxCollider.shift(velocity.x, 0);

        Platform platform = GameObject.checkCollision(nextBoxCollider, Platform.class);
        if (platform != null) {
            boolean moveContinue = true;
            float shiftDistance = 1;
            while (moveContinue) {
                if (GameObject.checkCollision(boxCollider.shift(shiftDistance, 0), Platform.class) != null) {
                    moveContinue = false;
                }
                else {
                    shiftDistance -= 1;
                    position.addUp(1, 0);
                }
            }
            velocity.y = 0;
        }
    }

}
