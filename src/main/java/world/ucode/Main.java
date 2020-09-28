package world.ucode;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception, ClassNotFoundException {
        String fxmlFile = "/fxml/Main_menu.fxml";
        FXMLLoader loader = new FXMLLoader();
        System.out.println("start");
        Parent root = (Parent) loader.load(getClass().getResourceAsStream(fxmlFile));
        stage.setTitle("Tamagochi");
        stage.setScene(new Scene(root));
        stage.show();
        menu.change_but();
    }
}


