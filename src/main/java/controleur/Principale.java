package controleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

public class Principale extends Application{
    static public FenetreAccueil		fenAccueil;
    static public FenetreEvenement 		fenEvent;
    static public FenetreAffectation 	fenAffect;



    public void start(Stage f) throws IOException {
        fenAccueil = new FenetreAccueil();
        fenAccueil.show();

    }

    public static void main(String args[]) {
        Application.launch();
    }

    ////////////////////////////////////////////
    // Gestion des fenêtres (à compléter)
    ////////////////////////////////////////////

    public static void fermerAppli() {
        System.exit(0);
    }
    public static void ouvrirFenPlan(String arr, String dep, int dur) {
        arrivee = arr;
        depart = dep;
        duree = dur;
        fenPlan.effeceNumEmplacement();
        fenPlan.show();
    }

    public static void fermerPlan() {
        fenPlan.close();
    }
    public static void ouvrirConfirmation(int emp) {
        numEmp = emp;
        fenConfirmation.show();
        fenConfirmation.initFenetre(numEmp, arrivee, depart, duree);

    }
    public static void fermerConfirmation() {
        fenConfirmation.close();
    }


    // enregistrement d'une réservation (se contente de l'afficher dans la console)

}
