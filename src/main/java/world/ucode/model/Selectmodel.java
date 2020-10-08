package world.ucode.model;

import world.ucode.model.characters.Character;

public class Selectmodel {



    public Identity currentChar;
    public Character forselect;

    public enum MenuStane {
        SELECT_STANE,
        GAME_STANE
    }

    public enum Identity {
        PATRIC(80);

        public final int  i;
        Identity(int i) {
            this.i = i;
        }
    }


    public Selectmodel(Identity ch) {
        this.currentChar = ch;
        forselect = new Character(ch, MenuStane.SELECT_STANE);
    }
}
