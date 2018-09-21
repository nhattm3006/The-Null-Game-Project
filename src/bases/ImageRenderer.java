package bases;

import java.awt.*;

public class ImageRenderer extends Renderer {
    Image image;

    public ImageRenderer(String url) {
        image = ImageUtil.load(url);
    }

    public void render(Graphics g, Vector2D position) {
        int imageWidth = this.image.getWidth(null);
        int imageHeight = this.image.getHeight(null);
        Vector2D renderPosition = position.subtract(imageWidth / 2, imageHeight / 2);
        g.drawImage(this.image,(int)renderPosition.x,(int)renderPosition.y,null);
    }
}