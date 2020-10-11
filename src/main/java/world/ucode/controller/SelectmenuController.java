package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import world.ucode.Main;
import world.ucode.model.Gamemodel;
import world.ucode.model.Selectmodel;
import world.ucode.view.Scenes;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SelectmenuController implements Initializable {

    public TextField petname;
    public Label petlab;


    public void inmainmenu(ActionEvent event) {
        Main.allscenes.activate(Scenes.GameScene.MAIN_MENU);
    }

    public void ingame(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println("ingmae");
        String name = petname.getText();
        if (name.isEmpty()) {
            petlab.setTextFill(Color.RED);
        }
        else {

            Main.allscenes.activate(Scenes.GameScene.GAME);
            if (Main.game == null) {
                System.out.println("there is null too");
                Main.game = new Gamemodel(Main.select.currentChar, Selectmodel.MenuStane.GAME_STANE);
            }
            else {
                System.out.println("not lnull but whuy?");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
