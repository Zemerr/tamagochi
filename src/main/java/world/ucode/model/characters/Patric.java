package world.ucode.model.characters;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.model.SpriteAnimation;

public class Patric extends SpriteAnimation {
    public Patric(ImageView imageView, Duration duration, int count, int columns, int offsetX, int offsetY, int width, int height) {
        super(imageView, duration, count, columns, offsetX, offsetY, width, height);
    }

//    public Patric(ImageView imageView, Duration duration, int count, int columns, int offsetX, int offsetY, int width, int height) {
//        super(imageView, duration, count, columns, offsetX, offsetY, width, height);
//    }
//
    @Override
    protected void interpolate(double frac) {
        int index = Math.min((int)Math.floor(super.count*frac) + 1, count-1);
        if (index == 1)
            index = 0;
        final int x = (index / columns) * width + offsetX;
        super.imageView.setViewport(new Rectangle2D(x, offsetY, width, height));
    }
}
