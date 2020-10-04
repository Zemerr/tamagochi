package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;

import java.net.URL;
import java.util.ResourceBundle;

public class Gamecontroller {

    @FXML
    private ProgressBar feedbar;

    @FXML private ProgressBar playbar;
    @FXML private ProgressBar givewaterbar;
    @FXML private ProgressBar vedicinebar;
    @FXML private ProgressBar cleanbar;

    //

   // private Gamecontroller() {
//
//    }
//

    public void changegameBar() {
        feedbar.setProgress(feedbar.getProgress() - 0.01);
        playbar.setProgress(playbar.getProgress() - 0.01);
        givewaterbar.setProgress(givewaterbar.getProgress() - 0.01);
        vedicinebar.setProgress(vedicinebar.getProgress() - 0.01);
        cleanbar.setProgress(cleanbar.getProgress() - 0.01);
    }

    @FXML
    public void playaction(ActionEvent actionEvent) {
        System.out.println("playact");
    }
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//    }
}
