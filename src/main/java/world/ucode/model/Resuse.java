package world.ucode.model;

import javafx.scene.image.Image;

import java.io.InputStream;

public class Resuse {
    static InputStream iconStream = Resuse.class.getResourceAsStream("/pic/Patric_child.png");
    static public Image selectPatrick = new Image(iconStream);




}
