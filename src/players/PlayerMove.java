package players;

import bases.BoxCollider;
import bases.GameObject;
import bases.Vector2D;
import game.Platform;
import game.Setting;
import inputs.InputManager;

public class PlayerMove {
    public Vector2D velocity;
    private final float GRAVITY = 0.4f;
    private final float JUMP_SPEED = 15f;

    public PlayerMove() {
        velocity = new Vector2D();
    }

    void run(Vector2D position, BoxCollider boxCollider) {
        this.velocity.x = 0;

        jump(boxCollider);
        this.velocity.y += GRAVITY;

        moveHorizontal();
        updateVerticalPhysics(position, boxCollider);
        updateHorizontalPhysics(position, boxCollider);
        position.addUp(velocity);

        if (position.x < 0) position.x = 0;
        if (position.y > 800) position.y = Setting.SCREEN_WIDTH;
    }

    private void jump(BoxCollider boxCollider) {
        if (InputManager.instance.upPressed) {
            BoxCollider boxColliderAtBottom = boxCollider.shift(0, 1);
            if (GameObject.checkCollision(boxColliderAtBottom, Platform.class) != null) {

                velocity.y = -JUMP_SPEED;
            }
        }
    }

    private void moveHorizontal() {
        if (InputManager.instance.rightPressed) {
            velocity.x += 5;
        }

        if (InputManager.instance.leftPressed) {
            velocity.x -= 5;
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
                    shiftDistance += 1;
                    position.addUp(1, 0);
                }
            }
            velocity.x = 0;
        }
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
}