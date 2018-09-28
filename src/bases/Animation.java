package bases;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Animation extends Renderer {
    ArrayList<Image> images;
    int imageIndex;
    FrameCounter frameCounter;
    private boolean oneTime;
    public boolean finished;

    public Animation(Image...imgs) {
        this(10, false, imgs);
    }

    public Animation(int frameDelay, boolean oneTime, Image...imgs) {
        this.images = new ArrayList<>();
        this.images.addAll(Arrays.asList(imgs));
        this.oneTime = oneTime;
        this.finished = false;
        this.imageIndex = 0;
        this.frameCounter = new FrameCounter(frameDelay);
    }

    private void changeCurrentImage() {
        frameCounter.run();
        if (frameCounter.expired) {
            frameCounter.reset();
            if (this.imageIndex < this.images.size() - 1) {
                this.imageIndex += 1;
            }
            else {
                if (this.oneTime) {
                    this.finished = true;
                }
                else {
                    this.imageIndex = 0;
                }
            }
        }
    }

    private void renderCurrentImage(Graphics g, Vector2D position) {
        Image currentImage = images.get(this.imageIndex);
        int imageWidth = currentImage.getWidth(null);
        int imageHeight = currentImage.getHeight(null);
        Vector2D renderPosition = position.subtract(imageWidth / 2, imageHeight / 2);
        g.drawImage(currentImage,(int)renderPosition.x,(int)renderPosition.y,null);
    }

    public void render(Graphics g, Vector2D position) {
        renderCurrentImage(g, position);
        changeCurrentImage();
    }
}
