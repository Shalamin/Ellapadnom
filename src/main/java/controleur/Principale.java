package controleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import vues.*;
import modele.*;

public class Principale extends Application{
    static public FenAccueil fenAccueil;
    static public FenCrEvent fenCrEvent;


    public void start(Stage f) throws IOException {
        fenAccueil = new FenAccueil();
        fenAccueil.show();

    }

    public static void main(String args[]) {
        Application.launch();
    }

    ////////////////////////////////////////////
    // Gestion des fenêtres (à compléter) //
    ////////////////////////////////////////////

    public static void fermerAppli() {
        System.exit(0);
    }
    public static void ouvrirFenEvent() {
        fenCrEvent.show();
    }

    public static void fermerFenEvent() {
        fenCrEvent.close();
    }
    public static void ouvrirFenAffectation() {
    }




}
