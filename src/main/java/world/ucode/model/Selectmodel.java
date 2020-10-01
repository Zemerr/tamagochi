package world.ucode.model;

public class Selectmodel {



    public Identity currentChar;
    public Character forselect;

    public enum MenuStane {
        SELECT_STANE,
        GAME_STANE
    }

    public enum Identity {
        PATRIC
    }


    public Selectmodel(Identity ch) {
        this.currentChar = ch;
        forselect = new Character(ch, MenuStane.SELECT_STANE);
    }
}
