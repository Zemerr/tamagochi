package world.ucode;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import world.ucode.model.*;
import world.ucode.view.Scenes;

import java.net.URL;
import java.sql.SQLException;


public class Main extends Application {
    public static Scenes allscenes;
    public static  Gamemodel game = null;
    public static Selectmodel select = null;
    public static MediaPlayer mp;






    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception, ClassNotFoundException {
        mp = new MediaPlayer(Resuse.res.media);
        mp.setOnEndOfMedia(new Runnable() {
            public void run() {
                mp.seek(Duration.ZERO);
            }
        });
        mp.setOnError(()->
                System.out.println("media error"+mp.getError().toString()));
        mp.setAutoPlay(true);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                if (Datareserve.dataserve.tosave) {
                    try {
                        Database.WriteDB(game.health, game.feedpos, game.waterpos, game.medicinepos, game.cleanpos, game.crabs);
                    } catch (ClassNotFoundException classNotFoundException) {
                        classNotFoundException.printStackTrace();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
               }
                System.exit(0);
            }
        });
            Database.checkDB();
            allscenes = new Scenes(stage);
            allscenes.activate(Scenes.GameScene.MAIN_MENU);
    }
}


