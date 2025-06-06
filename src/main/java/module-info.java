module EllaDanse {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires jdk.jdi;


    opens controleur to javafx.fxml;
    exports controleur;

    opens modele to javafx.fxml;
    exports modele;

    opens  vues.action to javafx.fxml;
    exports vues.action;
    opens  vues.fenetres to javafx.fxml;
    exports vues.fenetres;
}
