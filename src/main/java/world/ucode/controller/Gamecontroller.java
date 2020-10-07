package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import world.ucode.Main;
import world.ucode.model.Gamemodel;

import java.net.URL;
import java.util.ResourceBundle;

public class Gamecontroller {


    @FXML private Label feedlab;
    @FXML private Label waterlab;
    @FXML private Label medicinelab;
    @FXML private Label cleanlab;



    @FXML private ProgressBar feedbar;
    @FXML private ProgressBar givewaterbar;
    @FXML private ProgressBar vedicinebar;
    @FXML private ProgressBar cleanbar;

    private double barspeed = 0.01;


    public void changegameBar() {
        feedbar.setProgress(feedbar.getProgress() - barspeed);
        givewaterbar.setProgress(givewaterbar.getProgress() - barspeed);
        vedicinebar.setProgress(vedicinebar.getProgress() - barspeed);
        cleanbar.setProgress(cleanbar.getProgress() - barspeed);

        feedlab.setText(Integer.toString((Main.game.feedpos)--));
        waterlab.setText(Integer.toString((Main.game.waterpos)--));
        medicinelab.setText(Integer.toString((Main.game.medicinepos)--));
        cleanlab.setText(Integer.toString((Main.game.cleanpos)--));
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
