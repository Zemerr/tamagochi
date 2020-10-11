package world.ucode.model;

import javafx.scene.image.Image;
import javafx.util.Duration;
import javafx.scene.media.Media;

import world.ucode.model.characters.Character;
import world.ucode.model.characters.Patric;


import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;

public class Resuse {
    static public final Resuse res = new Resuse();


    private Image selectPatrick;


    public Image crabs;
    public Image patricplay;
    public Image smallPatrick;
    public Image patrickGoRight;
    public Image patrickGoLeft;
    public HashMap<Selectmodel.Identity, Runnable> selectinitview = new HashMap<>();
    public HashMap<Selectmodel.Identity, Runnable> gameinitview = new HashMap<>();

    URL path = Resuse.class.getResource("/music.mp3");
    public Media media;




    private Resuse() {
        selectPatrick = new Image(Resuse.class.getResourceAsStream("/pic/patric/Patric_child.png"));
        smallPatrick = new Image( Resuse.class.getResourceAsStream("/pic/patric/SmallPatric.png"));
        patrickGoRight = new Image(Resuse.class.getResourceAsStream("/pic/patric/Patricgoright.png"));
        patrickGoLeft = new Image(Resuse.class.getResourceAsStream("/pic/patric/Patricgoleft.png"));
        patricplay = new Image(Resuse.class.getResourceAsStream("/pic/patric/patric_play.png"));
        crabs = new Image(Resuse.class.getResourceAsStream("/pic/crabs.png"));
        media = new Media(path.toString());
    }



    private void setSelectPatrick(Character cur) {
        cur.setImage(selectPatrick);
        cur.setFitWidth(300);
        cur.setFitHeight(300);
    }




    public void setSelectMap(Character character, Selectmodel.Identity individual) {
        if (individual == Selectmodel.Identity.PATRIC)
            selectinitview.put(individual, () -> setSelectPatrick(character));
    }

    private void setPatricSmallAnim(Character character, Character.Ages age) {
        int count = 6;
        int columns = 1;
        int offsetX = 0;
        int offsetY = 0;
        int width = 50;
        int height = 62;
        character.animation = new Patric(character, Duration.millis(1500),count,columns,offsetX,offsetY,width,height, age);
    }

    public void setGameMap(Character character, Selectmodel.Identity individual, Character.Ages age) {
        if (individual == Selectmodel.Identity.PATRIC)
            gameinitview.put(individual, () -> setPatricSmallAnim(character, age));
    }
}
