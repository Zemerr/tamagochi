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

    @FXML private Label playlab;
    @FXML private Label feedlab;
    @FXML private Label waterlab;
    @FXML private Label medicinelab;
    @FXML private Label cleanlab;



    @FXML private ProgressBar feedbar;
    @FXML private ProgressBar playbar;
    @FXML private ProgressBar givewaterbar;
    @FXML private ProgressBar vedicinebar;
    @FXML private ProgressBar cleanbar;

    private double barspeed = 0.01;


    public void changegameBar() {
        feedbar.setProgress(feedbar.getProgress() - barspeed);
        playbar.setProgress(playbar.getProgress() - barspeed);
        givewaterbar.setProgress(givewaterbar.getProgress() - barspeed);
        vedicinebar.setProgress(vedicinebar.getProgress() - barspeed);
        cleanbar.setProgress(cleanbar.getProgress() - barspeed);
    }

    @FXML
    public void playaction(ActionEvent actionEvent) {
        System.out.println("playact");
        Main.game.tamagochi.animation.changeonPlay();
    }



}
