package controleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import vues.action.*;
import vues.fenetres.*;

public class Principale extends Application{
    static public FenAccueil fenAccueil;
    static public FenTaches fenTaches;
    static public FenCrEvent fenCrEvent;
    static public FenCrTaches fenCrTaches;
    static public FenModEvent fenModEvent;
    static public FenModTaches fenModTaches;

    public void start(Stage f) throws IOException {
        fenAccueil = new FenAccueil();
        fenTaches = new FenTaches();
        fenCrEvent = new FenCrEvent();
        fenCrTaches = new FenCrTaches();
        fenModEvent = new FenModEvent();
        fenModTaches = new FenModTaches();
        fenAccueil.show();

    }

    public static void main(String args[]) {
        Application.launch();
    }

    ////////////////////////////////////////////
    // Gestion des fenêtres (à compléter)
    ////////////////////////////////////////////
    public static void ouvrirFenModEvent(){fenModEvent.show();}
    public static void ouvrirFenModTaches(){fenModTaches.show();}
    public static void ouvrirFenCrEvent(){fenCrEvent.show();}
    public static void ouvrirFenCrTaches(){fenCrTaches.show();}
    public static void ouvrirFenTaches(){fenTaches.show();}

    public static void fermerFenAccueil() {System.exit(0);}
    public static void fermerFenTaches() {fenTaches.close();}
    public static void fermerFenCrEvent() {fenCrEvent.close();}
    public static void fermerFenCrTaches() {fenCrTaches.close();}
    public static void fermerFenModEvent() {fenModEvent.close();}
    public static void fermerFenModTaches() {fenModTaches.close();}


    // enregistrement d'une réservation (se contente de l'afficher dans la console)

}
