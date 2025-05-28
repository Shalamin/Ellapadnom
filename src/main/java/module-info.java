module EllaDanse {
    requires javafx.controls;
    requires javafx.fxml;


    opens EllaDanse to javafx.fxml;
    exports EllaDanse;
}