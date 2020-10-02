package world.ucode.model;

import world.ucode.model.characters.Character;

public class Gamemodel {
    public final Character tamagochi;

    public Gamemodel(Selectmodel.Identity ch, Selectmodel.MenuStane scene) {
        tamagochi = new Character(ch, scene);
    }

}
