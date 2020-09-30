package world.ucode.model;

import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Patric extends SpriteAnimation{

    public Patric(ImageView imageView, Duration duration, int count, int columns, int offsetX, int offsetY, int width, int height) {
        super(imageView, duration, count, columns, offsetX, offsetY, width, height);
    }

    @Override
    protected void interpolate(double frac) {

    }
}
