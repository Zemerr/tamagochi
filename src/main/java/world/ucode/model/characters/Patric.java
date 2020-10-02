package world.ucode.model.characters;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.Main;
import world.ucode.model.Resuse;

public class Patric extends SpriteAnimation {

    private ImageView currentim;
    private Character.Ages age;
    //private Character parent;


    public Patric(ImageView imageView, Duration duration, int count, int columns, int offsetX, int offsetY, int width, int height, Character.Ages age, Character parent) {

        super(imageView, duration, count, columns, offsetX, offsetY, width, height);
        currentim = imageView;
        this.age = age;
       // this.parent = parent;
        if (age == Character.Ages.CHILD) {
            currentim.setImage(Resuse.res.smallPatrick);
            currentim.setFitWidth(imageView.getBoundsInParent().getWidth() * 2);
            currentim.setFitHeight(imageView.getBoundsInParent().getHeight() * 2);
            currentim.setViewport(new Rectangle2D(0, offsetY, 50, height));
        }
        play();
        //sleep(5);
        changeimage();
    }


    @Override
    protected void interpolate(double frac) {
        if (age == Character.Ages.CHILD) {
            int index = Math.min((int) Math.floor(super.count * frac), count - 1);
            int x = 0;
            int width = 50;
            if (index == 1) {
                x = 50;
                width = 60;
            } else if (index == 2) {
                x = 110;
                width = 50;
            } else if (index == 3) {
                x = 160;
                width = 53;
            } else if (index == 4) {
                x = 213;
                width = 55;
            } else if (index == 5) {
                x = 270;
                width = 55;
            }
            super.imageView.setViewport(new Rectangle2D(x, offsetY, width, height));
        }
        else {
            int index = Math.min((int)Math.floor(count*frac) + 1, count-1);
            if (index == 1)
                index = 0;
            final int x = (index / columns) * width + offsetX;
            imageView.setViewport(new Rectangle2D(x, offsetY, width, height));
            currentim.setTranslateX(currentim.getTranslateX() +  1);
        }
    }
    
    @Override
    public void changeimage() {
        stop();
        currentim.setImage(Resuse.res.patrickGoRight);
//        currentim.setFitHeight(0);
//        currentim.setFitWidth(0);
        super.count = 10;
        super.width = 99;
        super.height = 104;
        currentim.setViewport(new Rectangle2D(0, offsetY, 99, 104));
        age = Character.Ages.ADULT;
        play();
    }
}
