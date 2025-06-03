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
    public static void ouvrirFenEvent() {
        fenEvent.show();
    }

    public static void fermerFenEvent() {
        fenEvent.close();
    }
    public static void ouvrirFenAffectation() {


    }
    public static void fermerConfirmation() {
        fenConfirmation.close();
    }


    // enregistrement d'une réservation (se contente de l'afficher dans la console)

}
