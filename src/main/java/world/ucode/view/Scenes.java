package world.ucode.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import world.ucode.Main;

import java.io.IOException;
import java.util.HashMap;

public class Scenes {
    public BorderPane selectmenu;
    public Pane mainmenu;

    private Scene game = null;
    private Scene menu = null;
    private Scene select_menu = null;


    private Stage window;
    private HashMap<GameScene, Scene> allscenes = new HashMap<>();
    private HashMap<GameScene, Runnable> sceneinit = new HashMap<>();




    private void initmenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String fxmlFile = "/fxml/Main_menu.fxml";
        System.out.println("start");
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        mainmenu = (Pane) root;
        menu =  new Scene(root);
        allscenes.put(GameScene.MAIN_MENU, menu);
        window.sizeToScene();
        window.centerOnScreen();

    }

    private void initselect() throws IOException {
        FXMLLoader loader = new FXMLLoader();;
        String fxmlFile = "/fxml/Select_menu.fxml";
        System.out.println("start");
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        selectmenu = (BorderPane) root;
        select_menu =  new Scene(root);
        allscenes.put(GameScene.SELECT_MENU, select_menu);

    }

    public enum GameScene {
        MAIN_MENU,
        SELECT_MENU,
        GAME,
        GAME_OVER
    }

    public Scenes(Stage stage) {
        window = stage;
        window.setTitle("Tamagochi");
        window.show();
        allscenes.put(GameScene.MAIN_MENU, menu);
        allscenes.put(GameScene.SELECT_MENU, select_menu);
        allscenes.put(GameScene.GAME, game);

        sceneinit.put(GameScene.MAIN_MENU, () -> {
            try {
                initmenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        sceneinit.put(GameScene.SELECT_MENU, () -> {
            try {
                initselect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        sceneinit.put(GameScene.GAME, () -> {
            try {
                initmenu();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public void activate(GameScene act) {
        Scene needed = allscenes.get(act);
        if (needed == null) {
            sceneinit.get(act).run();
            needed = allscenes.get(act);
        }
        window.setScene(needed);
    }




}
