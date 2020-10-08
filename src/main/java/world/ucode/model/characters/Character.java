package world.ucode.model.characters;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import world.ucode.Main;
import world.ucode.model.Resuse;
import world.ucode.model.Selectmodel;

public class Character extends ImageView {

    public SpriteAnimation animation;
    private Ages age;


    public enum Ages {
        CHILD,
        ADULT
    }




    public Character(Selectmodel.Identity character, Selectmodel.MenuStane stane) {
        age = Ages.CHILD;
        if (stane == Selectmodel.MenuStane.SELECT_STANE) {
            Resuse.res.setSelectMap(this, character);
            Resuse.res.selectinitview.get(character).run();
            Main.allscenes.selectmenu.setCenter(this);
        }
        else {
            Resuse.res.setGameMap(this, character, age);
            Resuse.res.gameinitview.get(character).run();
            Main.allscenes.gamepane.setAlignment(this, Pos.BOTTOM_CENTER);
            Main.allscenes.gamepane.setCenter(this);
        }
    }


}