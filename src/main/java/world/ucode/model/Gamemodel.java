package world.ucode.model;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.geometry.Bounds;

import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import world.ucode.Main;
import world.ucode.model.characters.Character;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import world.ucode.controller.Gamecontroller;


public class Gamemodel {
    public final Character tamagochi;
    public boolean charplay = false;
    public HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public final AnimationTimer animtimer;
    private int playsec = 0;
    private ArrayList<ImageView> krabs = new ArrayList<>();
    private final Random rand = new Random();

    public int feedpos = 41;
    public int waterpos = 78;
    public int medicinepos = 46;
    public int cleanpos = 38;






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
        if (charplay == false)
            Main.allscenes.gamecontroller.changegameBar();
        else {
            playsec++;
            if (krabs.isEmpty()) {
                animtimer.stop();
                tamagochi.animation.changeonAdult();
                playsec = 0;
                charplay = false;
                createkrabs();
            }
        }
    }


    private Boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    private void upadatemove() {
        if(isPressed(KeyCode.A)) {
            tamagochi.setTranslateX((Main.game.tamagochi.getTranslateX() - 6));
            tamagochi.animation.play();
        }
        if(isPressed(KeyCode.D)) {
            tamagochi.setTranslateX((Main.game.tamagochi.getTranslateX() + 6));
            tamagochi.animation.play();
        }
        movecrabs();
    }

    private void createkrabs() {
        int y = 0;
        int x = 0;
            for (int i = 0; i < 5; i++) {
                ImageView crabs = new ImageView(Resuse.res.crabs);
                crabs.setFitWidth(20);
                crabs.setFitHeight(20);
                x = rand.nextInt(850);
                y = y + ((rand.nextInt(200)  * -1) - 150);
                crabs.setTranslateX(x);
                crabs.setTranslateY(y);
                Main.allscenes.gamepane.getChildren().add(crabs);
                krabs.add(crabs);
            }
    }

    private void movecrabs() {
        for (int i = 0; i < krabs.size(); i++) {
            ImageView crab = krabs.get(i);
            crab.setTranslateY(crab.getTranslateY() + 1);
            if (crab.getTranslateY() > 800) {
                Main.allscenes.gamepane.getChildren().remove(crab);
                krabs.remove(crab);
            }
            Bounds b = tamagochi.getBoundsInParent();
            Rectangle r = new Rectangle(b.getMinX(), (b.getMinY()+b.getMaxY())/2, b.getWidth(), b.getHeight()/2);

            if (r.intersects(crab.getBoundsInParent()))
                System.out.println("lol");


        }
    }

    private void colision() {

    }
}
