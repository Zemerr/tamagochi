package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import world.ucode.Main;
import world.ucode.model.Character;
import world.ucode.model.Gamemodel;
import world.ucode.model.Selectmodel;
import world.ucode.view.Scenes;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectmenuController implements Initializable {



    public void inmainmenu(ActionEvent event) {
        Main.allscenes.activate(Scenes.GameScene.MAIN_MENU);
    }

    public void ingame(ActionEvent actionEvent) {
        Main.game = new Gamemodel(Main.select.currentChar, Selectmodel.MenuStane.GAME_STANE);
        Main.allscenes.activate(Scenes.GameScene.GAME);
        Main.allscenes.gamepane.setCenter(Main.game.tamagochi);
        //Main.game.tamagochi.startAnim();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
