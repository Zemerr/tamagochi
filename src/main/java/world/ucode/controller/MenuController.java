package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import world.ucode.Main;
import world.ucode.model.Selectmodel;
import world.ucode.view.Scenes;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public void inselect(ActionEvent event) {
        Main.allscenes.activate(Scenes.GameScene.SELECT_MENU);
        Main.select = new Selectmodel(Selectmodel.Identity.PATRIC);
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
