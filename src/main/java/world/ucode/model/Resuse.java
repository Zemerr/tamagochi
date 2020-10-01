package world.ucode.model;

import javafx.scene.image.Image;

import java.io.InputStream;

public class Resuse {
    static InputStream iconStream = Resuse.class.getResourceAsStream("/pic/Patric_child.png");
    static public Image selectPatrick = new Image(iconStream);

    static InputStream iconStream1 = Resuse.class.getResourceAsStream("/pic/SmallPatric.png");
    static public Image smallPatrick = new Image(iconStream1);


    static public Image imagerex = new Image(Resuse.class.getResourceAsStream("/pic/trex.png"));


}
