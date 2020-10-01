package world.ucode.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import world.ucode.Main;
import world.ucode.model.characters.Patric;

public class Character extends ImageView {

    SpriteAnimation animation;
    ImageView curentIm;




    public Character(Selectmodel.Identity character, Selectmodel.MenuStane stane) {
        if (stane == Selectmodel.MenuStane.SELECT_STANE) {
            if (character == Selectmodel.Identity.PATRIC) {
                //curentIm = new ImageView(Resuse.imagerex);
//                curentIm.setFitWidth(300);
//                curentIm.setFitHeight(300);
                //getChildren().add(curentIm);
                //Main.allscenes.selectmenu.setCenter(this);
                setImage(Resuse.smallPatrick);
                setFitWidth(300);
                setFitHeight(300);
            }
        }
        else {
            if (character == Selectmodel.Identity.PATRIC) {
//                ImageView smallchar = new ImageView(Resuse.smallPatrick);
//                animation = new SpriteAnimation(smallchar, Duration.millis(300), 6, 1, 0, 0, 55, 62);

                //ImageView smallchar = new ImageView(Resuse.imagerex);
                int count = 4;
                int columns = 1;
                int offsetX = 0;
                int offsetY = 0;
                int width = 88;
                int height = 94;


                //animation = new SpriteAnimation(smallchar,Duration.millis(300),count,columns,offsetX,offsetY,width,height);
                setImage(Resuse.smallPatrick);
                //smallchar.setViewport(new Rectangle2D(offsetX,offsetY,width,height));
                animation = new Patric(this,Duration.millis(300),count,columns,offsetX,offsetY,width,height);

                //getChildren().addAll(smallchar);
                startAnim();
                //Main.allscenes.gamepane.setCenter(Main.game.tamagochi);
            }
        }
    }

    public void startAnim() {
        animation.play();
    }
}