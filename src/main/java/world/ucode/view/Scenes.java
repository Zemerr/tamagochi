package world.ucode.view;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import world.ucode.Main;
import world.ucode.controller.Gamecontroller;
import world.ucode.controller.MenuController;
import world.ucode.model.Datareserve;
import world.ucode.model.Resuse;

import java.io.IOException;
import java.util.HashMap;

public class Scenes {
    public BorderPane selectmenu;
    public Pane mainmenu;
    public BorderPane gamepane;
    public Pane gameover;

    private Scene game = null;
    private Scene menu = null;
    private Scene select_menu = null;
    private Scene game_over = null;


    private Stage window;
    private HashMap<GameScene, Scene> allscenes = new HashMap<>();
    private HashMap<GameScene, Runnable> sceneinit = new HashMap<>();


    public Gamecontroller gamecontroller;
    public MenuController menuController;









    private void initmenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        String fxmlFile = "/fxml/Main_menu.fxml";
        System.out.println("start menu");
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        mainmenu = (Pane) root;
        menu =  new Scene(root);
        menuController = loader.getController();
        if (!Datareserve.dataserve.first_enty)
            menuController.makeloadsvisible();
        allscenes.put(GameScene.MAIN_MENU, menu);
        window.sizeToScene();
        window.centerOnScreen();

    }

    private void initselect() throws IOException {
        FXMLLoader loader = new FXMLLoader();;
        String fxmlFile = "/fxml/Select_menu.fxml";
        System.out.println("start select");
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        selectmenu = (BorderPane) root;
        select_menu =  new Scene(root);
        allscenes.put(GameScene.SELECT_MENU, select_menu);
    }

    private void goGame() throws IOException {
        FXMLLoader loader = new FXMLLoader();;
        String fxmlFile = "/GameScene.fxml";
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        gamepane = (BorderPane) root;
        game =  new Scene(root);
        gamecontroller = loader.getController();
        allscenes.put(GameScene.GAME, game);
        setkey();
    }

    private void goGameOver() throws IOException {
        FXMLLoader loader = new FXMLLoader();;
        String fxmlFile = "/fxml/Game_over.fxml";
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        gameover = (Pane) root;
        game_over =  new Scene(root);
        allscenes.put(GameScene.GAME_OVER, game_over);
    }

    private void setkey() {

        game.setOnKeyPressed(event -> {
            if (Main.game.charplay == true) {
                 KeyCode keyCode = event.getCode();
                 if (keyCode.equals(KeyCode.A) || keyCode.equals(KeyCode.D)) {
                     Main.game.keys.put(keyCode, true);
                 }
            }});
        game.setOnKeyReleased(event -> {
            if (Main.game.charplay == true) {
                KeyCode keyCode = event.getCode();
                if (keyCode.equals(KeyCode.A) || keyCode.equals(KeyCode.D)) {
                        Main.game.keys.put(keyCode, false);
                    }
            }
        });
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
                goGame();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        sceneinit.put(GameScene.GAME_OVER, () -> {
            try {
                goGameOver();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void renew() {
        selectmenu = null;
        game = null;
        allscenes.put(GameScene.SELECT_MENU, select_menu);
        allscenes.put(GameScene.GAME, game);
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
