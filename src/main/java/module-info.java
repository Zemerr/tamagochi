module utama {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires javafx.fxml;
    exports world.ucode;
    exports world.ucode.view;
    opens world.ucode.view to javafx.fxml;
    opens world.ucode to javafx.fxml;
    opens world.ucode.controller to javafx.fxml;
}