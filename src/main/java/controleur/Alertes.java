package controleur;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alertes {

    public static void afficherErreurNull(){
        Alert alerte = new Alert(Alert.AlertType.ERROR, "Un des éléments est vide", ButtonType.CLOSE);
    }
}
