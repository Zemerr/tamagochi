package world.ucode.model.characters;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class SpriteAnimation extends Transition{
    protected ImageView imageView;
    protected int count;
    protected int columns;
    protected int offsetX;
    protected int offsetY;
    protected int width;
    protected int height;



    public SpriteAnimation(
            ImageView imageView,
            Duration duration,
            int count, int columns,
            int offsetX, int offsetY,
            int width, int height
    ){
        this.imageView = imageView;
        this.count = count;
        this.columns = columns;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.width = width;
        this.height = height;
        setCycleDuration(duration);
        setCycleCount(Animation.INDEFINITE);
        setInterpolator(Interpolator.LINEAR);
        this.imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));


    }
    protected abstract void interpolate(double frac);

    public abstract void changeonAdult();

    public abstract void changeonPlay();
}