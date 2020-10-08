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
    private ArrayList<ImageView> krabs = new ArrayList<>();
    private final Random rand = new Random();

    public int feedpos;
    public int waterpos;
    public int medicinepos;
    public int cleanpos;
    public int crabs;
    public int ages;






    final Timeline timeline = new Timeline();
    public Gamemodel(Selectmodel.Identity ch, Selectmodel.MenuStane scene) {
        tamagochi = new Character(ch, scene);
        ages = Main.select.currentChar.i;
        feedpos = 41;
        waterpos = 78;
        medicinepos = 46;
        cleanpos = 38;
        crabs = 50;
        Main.allscenes.gamecontroller.updatelab(ages, feedpos, waterpos, medicinepos, cleanpos, crabs);
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
            if (krabs.isEmpty()) {
                animtimer.stop();
                tamagochi.animation.changeonAdult();
                charplay = false;
                createkrabs();
            }
        }
        //System.out.println(tamagochi.getTranslateX());
    }


    private Boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    private void upadatemove() {
        if(isPressed(KeyCode.A) && tamagochi.getTranslateX() - 6 > -500) {
            tamagochi.setTranslateX((tamagochi.getTranslateX() - 6 ));
            tamagochi.animation.play();
        }
        if(isPressed(KeyCode.D) && tamagochi.getTranslateX() - 6 < 350 ) {
            tamagochi.setTranslateX((tamagochi.getTranslateX() + 6 ));
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
            crab.setTranslateY(crab.getTranslateY() + 3);
            if (crab.getTranslateY() > 800) {
                Main.allscenes.gamepane.getChildren().remove(crab);
                krabs.remove(crab);
            }
            colision(crab);

        }
    }

    private void colision(ImageView crab) {
        Bounds b = tamagochi.getBoundsInParent();
        Rectangle r = new Rectangle(b.getMinX(), (b.getMinY()+b.getMaxY())/2, b.getWidth(), b.getHeight()/2);
        if (r.intersects(crab.getBoundsInParent())) {
            Main.allscenes.gamepane.getChildren().remove(crab);
            krabs.remove(crab);
            crabs++;
            Main.allscenes.gamecontroller.changecrabs();
        }
    }
}
