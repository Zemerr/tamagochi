package world.ucode.model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration;
import world.ucode.Main;
import world.ucode.model.characters.Character;

import java.time.LocalTime;

import world.ucode.controller.Gamecontroller;


public class Gamemodel {
    private final Character tamagochi;



    final Timeline timeline = new Timeline();
    public Gamemodel(Selectmodel.Identity ch, Selectmodel.MenuStane scene) {
        tamagochi = new Character(ch, scene);
        KeyFrame kf = new KeyFrame(Duration.seconds(1), e -> upadate());
        timeline.getKeyFrames().add(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void upadate() {
        LocalTime currentTime = LocalTime.now();
        Main.allscenes.gamecontroller.changegameBar();
        System.out.println(currentTime);
    }

}
