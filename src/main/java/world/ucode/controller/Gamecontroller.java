package world.ucode.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import world.ucode.Main;
import world.ucode.view.Scenes;
import world.ucode.controller.MenuController;

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
    private int healthspeedlab = 0;


    public void changegameBar() {
        if (Main.game.feedpos >= 0) {
            feedbar.setProgress(((float)Main.game.feedpos/100) - barspeed);
            feedlab.setText(Integer.toString((Main.game.feedpos)--));
            if (Main.game.feedpos == 0)
                healthspeedlab++;
        }

        if (Main.game.waterpos >= 0) {
            givewaterbar.setProgress(((float)Main.game.waterpos/100) - barspeed);
            waterlab.setText(Integer.toString((Main.game.waterpos)--));
            if (Main.game.waterpos == 0)
                healthspeedlab++;
        }

        if (Main.game.medicinepos >= 0) {
            vedicinebar.setProgress(((float)Main.game.medicinepos/100) - barspeed);
            medicinelab.setText(Integer.toString((Main.game.medicinepos)--));
            if (Main.game.medicinepos == 0)
                healthspeedlab++;
        }

        if (Main.game.cleanpos >= 0) {
            cleanbar.setProgress(((float)Main.game.cleanpos/100) - barspeed);
            cleanlab.setText(Integer.toString((Main.game.cleanpos)--));
            if (Main.game.cleanpos == 0)
                healthspeedlab++;
        }

        if (healthspeedlab > 0) {
            Main.game.health = Main.game.health-healthspeedlab;
            health.setText(Integer.toString((Main.game.health)));
            heathbar.setProgress((double)(Main.game.health)/100);
            if (Main.game.health <= 0) {
                Main.game.stopall();
                Main.allscenes.activate(Scenes.GameScene.GAME_OVER);
            }
        }
    }

    public void updatelab(int ages, int feedpos, int waterpos, int medicinepos, int cleanpos, int crabss) {

        if (feedpos <= 0) {
            feedpos = 0;
            healthspeedlab++;
        }
        if (waterpos <= 0) {
            waterpos = 0;
            healthspeedlab++;
        }
        if (medicinepos <= 0) {
            medicinepos = 0;
            healthspeedlab++;
        }
        if (cleanpos <= 0) {
            cleanpos = 0;
            healthspeedlab++;
        }

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
            //System.out.println("playact");
            Main.game.tamagochi.animation.changeonPlay();
            Main.game.animtimer.start();
            Main.game.charplay = true;
        }
    }

    public void cleanact(ActionEvent actionEvent) {
        if (Main.game.crabs >= 10) {
            Main.game.crabs -= 10;
            Main.game.cleanpos += 10;
            if (Main.game.cleanpos <= 0) {
                Main.game.cleanpos = 0;
                healthspeedlab--;
            }
            cleanlab.setText(Integer.toString((Main.game.cleanpos)));
            cleanbar.setProgress((float)Main.game.cleanpos/100);
            crabs.setText(Integer.toString((Main.game.crabs)));
        }
    }

    public void medicineact(ActionEvent actionEvent) {
        if (Main.game.crabs >= 10) {
            Main.game.crabs -= 10;
            if (Main.game.medicinepos <= 0) {
                Main.game.medicinepos = 0;
                healthspeedlab--;
            }
            Main.game.medicinepos += 10;
            medicinelab.setText(Integer.toString((Main.game.medicinepos)));
            vedicinebar.setProgress((float)Main.game.medicinepos/100);
            crabs.setText(Integer.toString((Main.game.crabs)));
        }
    }

    public void wateract(ActionEvent actionEvent) {
        if (Main.game.crabs >= 10) {
            Main.game.crabs -= 10;
            if (Main.game.waterpos <= 0) {
                Main.game.waterpos = 0;
                healthspeedlab--;
            }
            Main.game.waterpos += 10;
            waterlab.setText(Integer.toString((Main.game.waterpos)));
            givewaterbar.setProgress((float)Main.game.waterpos/100);
            crabs.setText(Integer.toString((Main.game.crabs)));
        }
    }

    public void feedact(ActionEvent actionEvent) {
        if (Main.game.crabs >= 10) {
            Main.game.crabs -= 10;
            if (Main.game.feedpos <= 0) {
                Main.game.feedpos = 0;
                healthspeedlab--;
            }
            Main.game.feedpos += 10;
            feedlab.setText(Integer.toString((Main.game.feedpos)));
            feedbar.setProgress((float)Main.game.feedpos/100);
            crabs.setText(Integer.toString((Main.game.crabs)));

        }
    }

    public void gomenu(ActionEvent actionEvent) {
        Main.allscenes.menuController.makeresumevisible();
        Main.allscenes.activate(Scenes.GameScene.MAIN_MENU);
    }
}
