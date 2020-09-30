package world.ucode.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import world.ucode.Main;

public class Character extends ImageView {

    SpriteAnimation animation;
    //ImageView imageView;

    public enum MenuStane {
        SELECT_STANE,
        GMAE_STANE
    }

    public enum Identity {
        PATRIC
    }

    public Character(Identity character, MenuStane stane) {
        if (stane == MenuStane.SELECT_STANE) {
            if (character == Identity.PATRIC) {
                setImage(Resuse.selectPatrick);
//                imageView = new ImageView(Resuse.selectPatrick);
                setFitWidth(300);
                setFitHeight(300);
                //getChildren().addAll(imageView);
            }
        }
    }
}