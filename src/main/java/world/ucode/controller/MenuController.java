package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import world.ucode.Main;
import world.ucode.model.Character;
import world.ucode.model.Selectmodel;
import world.ucode.view.Scenes;

import java.net.URL;
import java.util.MissingFormatArgumentException;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public void inselect(ActionEvent event) {
        Main.select = new Selectmodel(Selectmodel.Identity.PATRIC);
        Main.allscenes.activate(Scenes.GameScene.SELECT_MENU);
        Main.allscenes.selectmenu.setCenter(Main.select.forselect);
    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
