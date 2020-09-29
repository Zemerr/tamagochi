package world.ucode.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class menu  {

    @FXML
    private Button newgame;

    @FXML
    private Label score;


    public void change_but() {
//        if (score != null)
            score.setText("lol");
//        else
          //  System.out.println("lol");
    }
}
