package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import world.ucode.Main;
import world.ucode.model.Database;
import world.ucode.model.Datareserve;
import world.ucode.view.Scenes;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Gameovercontroller implements Initializable  {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void goinmenu(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Database.deleteTable();
        Datareserve.dataserve.first_enty = true;
        Main.allscenes.menuController.makealldis();
        Main.allscenes.activate(Scenes.GameScene.MAIN_MENU);
    }
}
