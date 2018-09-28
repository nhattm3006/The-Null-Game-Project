package bases;

import java.util.ArrayList;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        this(0,0);
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector2D other) {
        set(other.x, other.y);
    }

    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other) {
        this.addUp(other.x, other.y);
    }

    public Vector2D add(float x, float y) {
        return new Vector2D(this.x + x, this.y + y);
    }

    public Vector2D add(Vector2D other) {
        return this.add(other.x, other.y);
    }

    public void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;
    }

    void subtractBy(Vector2D other) {
        this.subtractBy(other.x, other.y);
    }

    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);
    }

    public Vector2D subtract(Vector2D other) {
        return this.subtract(other.x, other.y);
    }

    void scaleBy(float f) {
        this.x *= f;
        this.y *= f;
    }

    Vector2D scale(float f) {
        return new Vector2D(this.x * f,  this.y * f);
    }

    float length() {
        return (float)Math.sqrt(x * x + y * y);
    }

    Vector2D normalize() {
        float length = this.length();
        return new Vector2D(this.x / length, this.y / length);
    }
}