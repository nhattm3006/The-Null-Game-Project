package bases;

import javax.swing.*;
import java.awt.*;

public class BoxCollider extends GameObject {
    private int width;
    private int height;

    public BoxCollider(int x, int y, int width, int height) {
        super();
        this.position.set(x, y);
        this.screenPosition.set(x, y);
        this.width = width;
        this.height = height;
    }

    public BoxCollider(int width, int height) {
        this(0, 0, width, height);
    }

    public BoxCollider shift(float x, float y) {
        BoxCollider shiftedBoxCollider = new BoxCollider(this.width, this.height);
        shiftedBoxCollider.position.set(this.position.add(x, y));
        shiftedBoxCollider.screenPosition.set(this.screenPosition.add(x, y));

        return shiftedBoxCollider;
    }

    private float top() {
        return this.position.y - this.height / 2;
    }

    private float bot() {
        return this.position.y + this.height / 2;
    }

    private float left() {
        return this.position.x - this.width / 2;
    }

    private float right() {
        return this.position.x + this.width / 2;
    }

    public boolean collideWith(BoxCollider other) {
        boolean xOverlap = (this.left() <= other.right()) && (other.left() <= this.right());
        boolean yOverlap = (this.top() <= other.bot()) && (other.top() <= this.bot());

        return xOverlap && yOverlap;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public void render(Graphics g) {
        g.drawRect((int)this.left(), (int)this.top(), this.width, this.height);
    }
}
