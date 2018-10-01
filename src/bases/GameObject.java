package bases;


import utils.ViewPort;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public Vector2D screenPosition;
    public Renderer renderer;
    public boolean isActive;
    public static boolean isDead;

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newGameObjects = new ArrayList<>();

    public static void add(GameObject g) {
        newGameObjects.add(g);
    }

    public static void runAll() {
        for (GameObject g: gameObjects) {
            if (g.isActive && !g.isDead) {
                g.run();
            }
        }

        gameObjects.addAll(newGameObjects);
        newGameObjects.clear();
    }
    public static void clearAll() {
        gameObjects.clear();
        newGameObjects.clear();
    }

    public static void renderAll(Graphics backBufferGraphic,ViewPort viewPort) {
        for(GameObject go: gameObjects){
            if(go.isActive){
                go.render(backBufferGraphic,viewPort);
            }
        }
    }

    // Generics
    public static <Z extends GameObject> Z recycle(int x, int y, Class<Z> cls) {
        Z z = null;

        for (GameObject go: gameObjects) {
            if (!go.isActive) {
                if (go.getClass().equals(cls)) {
                    z = (Z) go;
                }
            }
        }

        if (z == null) {
            try {
                z = cls.getConstructor(int.class, int.class).newInstance(x, y);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
            GameObject.add(z);
        }
        else {
            z.isActive = true;
            z.position.x = x;
            z.position.y = y;
        }

        return z;
    }

    // Generics: tổng quát kiểu
    public static <T extends  GameObject> T checkCollision(BoxCollider boxCollider, Class<T> cls) {
        T result = null;

        for (GameObject go: gameObjects) {
            if (go.isActive && go.boxCollider != null) {
                if (go.getClass().equals(cls)){
                    if (go.boxCollider.collideWith(boxCollider)) {
                        result = (T)go;
                    }
                }
            }
        }

        return result;
    }

    public BoxCollider boxCollider;

    public GameObject(int x, int y) {
        this.position = new Vector2D(x, y);
        this.screenPosition = new Vector2D();
        this.renderer = null; // not yet specified
        this.boxCollider = null;
        this.isActive = true;
        this.isDead = false;
    }

    public GameObject() {
        this(0, 0);
    }

    public void run() {
        if (this.boxCollider != null) {
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
            boxCollider.run();
        }
    }

    public void render(Graphics g, ViewPort viewPort){
        if(this.renderer != null){
            this.renderer.render(g,viewPort.translate(this.position));
        }
        // Hiện boxCollider
        //if (this.boxCollider != null) {
           // boxCollider.render(g, viewPort);
       // }
    }

    public void destroy() {
        this.isActive = false;
    }

    public void gameOver() {
        this.isDead = true;
    }
}