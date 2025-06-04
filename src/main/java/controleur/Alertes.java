package controleur;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alertes {

    public static void afficherErreurNull() {
        Alert alerte = new Alert(Alert.AlertType.ERROR, "ATTENTION : Un des éléments est vide.", ButtonType.CLOSE);
        alerte.setTitle("Erreur élément vide");
        alerte.show();
    }

    public static void afficherErreurDejaLa() {
        Alert alerte = new Alert(Alert.AlertType.ERROR, "ATTENTION : L'élément est déjà saisi.", ButtonType.CLOSE);
        alerte.setTitle("Erreur élément déjà saisi");
        alerte.show();
    }

    public static void afficherErreurAbsent() {
        Alert alerte = new Alert(Alert.AlertType.ERROR, "ATTENTION : L'élément n'existe pas.", ButtonType.CLOSE);
        alerte.setTitle("Erreur élément inexistant");
        alerte.show();
    }


}

