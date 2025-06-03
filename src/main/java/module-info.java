module EllaDanse {
    requires javafx.controls;
    requires javafx.fxml;


    opens controleur to javafx.fxml;
    exports controleur;

    opens modele to javafx.fxml;
    exports controleur;
}
