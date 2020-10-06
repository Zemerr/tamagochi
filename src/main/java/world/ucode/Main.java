package world.ucode;



import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.model.Gamemodel;
import world.ucode.model.Resuse;
import world.ucode.model.Selectmodel;
import world.ucode.view.menu;
import world.ucode.view.Scenes;




public class Main extends Application {
    public static Scenes allscenes;
    public static  Gamemodel game = null;
    public static Selectmodel select = null;




    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception, ClassNotFoundException {
            allscenes = new Scenes(stage);
            allscenes.activate(Scenes.GameScene.MAIN_MENU);
    }
}


