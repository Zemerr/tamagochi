package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import world.ucode.Main;
import world.ucode.model.Database;
import world.ucode.model.Datareserve;
import world.ucode.model.Gamemodel;
import world.ucode.model.Selectmodel;
import world.ucode.view.Scenes;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    public Button loadbut;
    public Button Resumebut;
    public Pane restartpane;

    public void inselect(ActionEvent event) {
        if (Datareserve.dataserve.first_enty) {
            Main.allscenes.activate(Scenes.GameScene.SELECT_MENU);
            if (Main.select == null)
                Main.select = new Selectmodel(Selectmodel.Identity.PATRIC);
        }
        else {
            restartpane.setVisible(true);
            restartpane.setDisable(false);
        }

    }





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void resume(ActionEvent actionEvent) {
        Main.allscenes.activate(Scenes.GameScene.GAME);
    }

    public void loadGame(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Main.allscenes.activate(Scenes.GameScene.GAME);
        if (Main.game == null) {
            System.out.println("there is null");
            Main.game = new Gamemodel(Selectmodel.Identity.PATRIC, Selectmodel.MenuStane.GAME_STANE);
        }
    }

    public void makeresumevisible() {
        restartpane.setVisible(false);
        restartpane.setDisable(true);

        loadbut.setVisible(false);
        loadbut.setDisable(true);

        Resumebut.setVisible(true);
        Resumebut.setDisable(false);
    }

    public void makeloadsvisible() {
        loadbut.setVisible(true);
        loadbut.setDisable(false);
    }

    public void yesRenewact(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Datareserve.dataserve.first_enty = true;

        Datareserve.dataserve.updateval(80, 41, 78, 46, 38, 50);
        Database.deleteTable();

        if (Main.game != null) {
            Main.game.stopall();
            Main.game = null;
        }



        Main.allscenes.activate(Scenes.GameScene.SELECT_MENU);
        if (Main.select == null)
            Main.select = new Selectmodel(Selectmodel.Identity.PATRIC);
    }

    public void nobackact(ActionEvent actionEvent) {
        restartpane.setVisible(false);
        restartpane.setDisable(true);
    }
}
