package world.ucode;



import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import world.ucode.model.*;
import world.ucode.view.Scenes;

import java.net.URL;
import java.sql.SQLException;


public class Main extends Application {
    public static Scenes allscenes;
    public static  Gamemodel game = null;
    public static Selectmodel select = null;
    private static MediaPlayer mp;

    //MediaPlayer mp;




    public static void main(String[] args) throws Exception {
        //mp = new MediaPlayer(Resuse.res.media);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception, ClassNotFoundException {
        URL path = Resuse.class.getResource("/music.mp3");
        Media media = new Media(path.toString());
        mp = new MediaPlayer(media);

        mp.setOnError(()->
                System.out.println("media error"+mp.getError().toString()));
        mp.setAutoPlay(true);
        //mp.setVolume(10);
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
                System.out.println("exit");
                System.exit(0);
            }
        });
            Database.checkDB();
            allscenes = new Scenes(stage);
            allscenes.activate(Scenes.GameScene.MAIN_MENU);
    }
}


