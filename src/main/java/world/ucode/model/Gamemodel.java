package world.ucode.model;

public class Gamemodel {
    public final Character tamagochi;

    public Gamemodel(Selectmodel.Identity ch, Selectmodel.MenuStane scene) {
        tamagochi = new Character(ch, scene);
    }

}
