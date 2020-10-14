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

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;



public class Gamemodel implements Builder{
    public final Character tamagochi;
    public boolean charplay = false;
    public HashMap<KeyCode, Boolean> keys = new HashMap<>();
    public final AnimationTimer animtimer;
    final Timeline timeline = new Timeline();
    private ArrayList<ImageView> krabs = new ArrayList<>();
    private final Random rand = new Random();

    public int feedpos;
    public int waterpos;
    public int medicinepos;
    public int cleanpos;
    public int crabs;
    public int health;

    private int crabsspeed = 3;







    public Gamemodel(Selectmodel.Identity ch, Selectmodel.MenuStane scene) throws SQLException, ClassNotFoundException {
        tamagochi = new Character(ch, scene);
        if (Datareserve.dataserve.first_enty) {
            Datareserve.dataserve.health = Main.select.currentChar.i;
            Database.createtable();
            Datareserve.dataserve.first_enty = false;
        }

        setAll(Datareserve.dataserve.health,Datareserve.dataserve.feedpos, Datareserve.dataserve.waterpos, Datareserve.dataserve.medicinepos, Datareserve.dataserve.cleanpos, Datareserve.dataserve.crabs);
        Main.allscenes.gamecontroller.updatelab(health, feedpos, waterpos, medicinepos, cleanpos, crabs);
        KeyFrame kf = new KeyFrame(Duration.seconds(3), e -> upadate());
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
        Datareserve.dataserve.tosave = true;

    }

    private void upadate() {
        int  sec = LocalTime.now().getSecond();
        if (charplay == false)
            Main.allscenes.gamecontroller.changegameBar();
        else
            crabsspeed++;
        //System.out.println(sec);

    }


    private Boolean isPressed(KeyCode key) {
        return keys.getOrDefault(key, false);
    }

    private void upadatemove() {
        if(isPressed(KeyCode.A) && tamagochi.getTranslateX() - 6 > -500) {
            tamagochi.setScaleX(1);
            tamagochi.setTranslateX((tamagochi.getTranslateX() - 6 ));
            tamagochi.animation.play();
        }
        if(isPressed(KeyCode.D) && tamagochi.getTranslateX() - 6 < 350 ) {
            tamagochi.setScaleX(-1);
            tamagochi.setTranslateX((tamagochi.getTranslateX() + 6 ));
            tamagochi.animation.play();
        }
        movecrabs();
        if (krabs.isEmpty()) {
            animtimer.stop();
            tamagochi.animation.changeonAdult();
            charplay = false;
            createkrabs();
            for (Map.Entry<KeyCode, Boolean> iter: keys.entrySet())
                iter.setValue(false);
            crabsspeed = 3;
        }
    }

    private void createkrabs() {
        int y = 0;
        int x = 0;
            for (int i = 0; i < 50; i++) {
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
            crab.setTranslateY(crab.getTranslateY() + crabsspeed);
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

    public void stopall() {
        timeline.stop();
        animtimer.stop();
        tamagochi.animation.stop();
    }


    private void setAll(int health, int feedpos, int waterpos, int medicinepos, int cleanpos, int crabs) {
        setcrabs(crabs);
        setfeedpos(feedpos);
        setwaterpos(waterpos);
        setmedicinepos(medicinepos);
        setcleanpos(cleanpos);
        sethealth(health);
    }

    @Override
    public void setcrabs(int crabs) {
        this.crabs = crabs;
    }

    @Override
    public void setfeedpos(int feedpos) {
        this.feedpos = feedpos;
    }

    @Override
    public void setwaterpos(int waterpos) {
        this.waterpos = waterpos;
    }

    @Override
    public void setmedicinepos(int medicinepos) {
        this.medicinepos = medicinepos;
    }

    @Override
    public void setcleanpos(int cleanpos) {
        this.cleanpos = cleanpos;
    }

    @Override
    public void sethealth(int health) {
        this.health = health;
    }
}
