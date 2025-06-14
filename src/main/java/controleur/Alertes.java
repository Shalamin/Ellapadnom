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

    public static void afficherErreurSupprOrganisateur() {
        Alert alerte = new Alert(Alert.AlertType.ERROR, "ATTENTION : Vous ne pouvez pas supprimer le rôle de l'organisateur.", ButtonType.CLOSE);
        alerte.setTitle("Erreur tache Organisateur");
        alerte.show();
    }

    public static void afficherErreurTacheDejaLa() {
        Alert alerte = new Alert(Alert.AlertType.ERROR, "ATTENTION : Vous ne pouvez pas créer cette tache car elle existe déjà", ButtonType.CLOSE);
        alerte.setTitle("Erreur tache ");
        alerte.show();
    }

    public static void afficherErreurEventDejaLa() {
        Alert alerte = new Alert(Alert.AlertType.ERROR, "ATTENTION : Vous ne pouvez pas créer cet événement, il existe déjà", ButtonType.CLOSE);
        alerte.setTitle("Erreur créer événement ");
        alerte.show();
    }

    public static void afficherErreurModifEventDejaLa() {
        Alert alerte = new Alert(Alert.AlertType.ERROR, "ATTENTION : Vous ne pouvez pas changer l'année de la saison", ButtonType.CLOSE);
        alerte.setTitle("Erreur modifier événement ");
        alerte.show();
    }


}

