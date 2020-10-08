package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import world.ucode.Main;

public class Gamecontroller {


    @FXML private Label feedlab;
    @FXML private Label waterlab;
    @FXML private Label medicinelab;
    @FXML private Label cleanlab;
    @FXML private Label crabs;
    @FXML private Label health;



    @FXML private ProgressBar feedbar;
    @FXML private ProgressBar givewaterbar;
    @FXML private ProgressBar vedicinebar;
    @FXML private ProgressBar cleanbar;
    @FXML private ProgressBar heathbar;



    private double barspeed = 0.01;
    private double healthspeedbar = 0.01;
    private int healthspeedlab = 0;


    public void changegameBar() {
        if (Main.game.feedpos >= 0) {
            feedbar.setProgress(feedbar.getProgress() - barspeed);
            feedlab.setText(Integer.toString((Main.game.feedpos)--));
            if (Main.game.feedpos == 0)
                healthspeedlab++;
        }

        if (Main.game.waterpos >= 0) {
            givewaterbar.setProgress(givewaterbar.getProgress() - barspeed);
            waterlab.setText(Integer.toString((Main.game.waterpos)--));
            if (Main.game.waterpos == 0)
                healthspeedlab++;
        }

        if (Main.game.medicinepos >= 0) {
            vedicinebar.setProgress(vedicinebar.getProgress() - barspeed);
            medicinelab.setText(Integer.toString((Main.game.medicinepos)--));
            if (Main.game.medicinepos == 0)
                healthspeedlab++;
        }

        if (Main.game.cleanpos >= 0) {
            cleanbar.setProgress(vedicinebar.getProgress() - barspeed);
            cleanlab.setText(Integer.toString((Main.game.cleanpos)--));
            if (Main.game.cleanpos == 0)
                healthspeedlab++;
        }

        if (healthspeedlab > 0) {
            Main.game.ages = Main.game.ages-healthspeedlab;
            health.setText(Integer.toString((Main.game.ages)));
            heathbar.setProgress((double)(Main.game.ages)/100);
        }
    }

    public void updatelab(int ages, int feedpos, int waterpos, int medicinepos, int cleanpos, int crabss) {
        feedlab.setText(Integer.toString((feedpos)));
        waterlab.setText(Integer.toString((waterpos)));
        medicinelab.setText(Integer.toString((medicinepos)));
        cleanlab.setText(Integer.toString((cleanpos)));
        health.setText(Integer.toString((ages)));
        crabs.setText(Integer.toString((crabss)));

        feedbar.setProgress((float)feedpos/100);
        givewaterbar.setProgress((float)waterpos/100);
        vedicinebar.setProgress((float)medicinepos/100);
        cleanbar.setProgress((float)cleanpos/100);
        heathbar.setProgress((float)ages/100);
    }


    public void changecrabs() {
        crabs.setText(Integer.toString((Main.game.crabs)));
    }

    @FXML
    public void playaction(ActionEvent actionEvent) {
        if (Main.game.charplay == false) {
            System.out.println("playact");
            Main.game.tamagochi.animation.changeonPlay();
            Main.game.animtimer.start();
            Main.game.charplay = true;
        }
    }

}
