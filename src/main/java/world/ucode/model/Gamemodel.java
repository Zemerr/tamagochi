package world.ucode.model;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import world.ucode.Main;
import world.ucode.model.characters.Character;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import world.ucode.controller.Gamecontroller;


public class Gamemodel {
    public final Character tamagochi;
    public boolean charplay = false;
    public HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public final AnimationTimer animtimer;
    private int playsec = 0;
    private ArrayList<ImageView> krabs = new ArrayList<>();



    final Timeline timeline = new Timeline();
    public Gamemodel(Selectmodel.Identity ch, Selectmodel.MenuStane scene) {
        tamagochi = new Character(ch, scene);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), e -> upadate());
        animtimer = new AnimationTimer() {
            @Override
            public void handle(final long NOW) {
                upadatemove();
            }
        };
        timeline.getKeyFrames().add(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        createkrabs();
    }

    private void upadate() {
        LocalTime currentTime = LocalTime.now();
        Main.allscenes.gamecontroller.changegameBar();

        if (charplay == true) {
            playsec++;
            if (playsec == 5) {
                animtimer.stop();
                tamagochi.animation.changeonAdult();
                playsec = 0;
                charplay = false;
            }
        }
        System.out.println(playsec);

    }


    private Boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    private void upadatemove() {
        if(isPressed(KeyCode.A)) {
            tamagochi.setTranslateX((Main.game.tamagochi.getTranslateX() - 3));
            tamagochi.animation.play();
        }
        if(isPressed(KeyCode.D)) {
            tamagochi.setTranslateX((Main.game.tamagochi.getTranslateX() + 3));
            tamagochi.animation.play();
        }
    }

    private void createkrabs() {
        ImageView crabs = new ImageView(Resuse.res.crabs);
        Main.allscenes.gamepane.getChildren().add(crabs);
    }
}
