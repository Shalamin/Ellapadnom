module EllaDanse {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens controleur to javafx.fxml;
    exports controleur;

    opens modele to javafx.fxml;
    exports controleur;
}
