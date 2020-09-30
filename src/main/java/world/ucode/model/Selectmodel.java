package world.ucode.model;

public class Selectmodel {

    public Character.Identity currentChar;
    public Character forselect;


    public Selectmodel(Character.Identity ch) {
        this.currentChar = ch;
        forselect = new Character(ch, Character.MenuStane.SELECT_STANE);
    }




}
