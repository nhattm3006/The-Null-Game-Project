package game;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;

public class Platform extends GameObject {
    public int isType;

    public Platform(int x, int y, int width, int height, String url) {
        super(x, y);
        this.boxCollider = new BoxCollider(x, y, 1280, 100);
        if(url != null){
            this.renderer = new ImageRenderer(url);
        }
    }
    public Platform(int x,int y, int width, int height){
        super(x, y);
        this.boxCollider = new BoxCollider(x, y, width, height);
    }

    // add platforms
    public void addImage(int dataImg){
        switch (dataImg){
            case 2: {
                isType = 2;
                this.renderer = new ImageRenderer("images/platforms/grass.png");
                break;
            }

            case 1: {
                isType = 1;
                this.renderer = new ImageRenderer( "images/platforms/platform.png");
                break;
            }

            case 3: {
                isType =3;
                this.renderer = new ImageRenderer("images/platforms/spkie.png");
                break;
            }
            case 4: {
                isType = 4;
                this.renderer = new ImageRenderer("images/platforms/hotel.png");
            }
            case 5:{
                isType = 5;
                this.renderer = new ImageRenderer("images/platforms/Bang.png");
            }
            case 6:{
                isType = 6;
                this.renderer = new ImageRenderer("images/platforms/Bang2.png");
            }
        }
    }
}