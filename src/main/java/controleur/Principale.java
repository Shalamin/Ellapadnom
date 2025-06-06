package controleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import modele.Benevole;
import modele.Evenement;
import modele.Salle;
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

    public static void fermerFenAccueil() {System.exit(0);}
    public static void fermerFenTaches() {fenTaches.close();}
    public static void fermerFenCrEvent() {fenCrEvent.close();}
    public static void fermerFenCrTaches() {fenCrTaches.close();}
    public static void fermerFenModEvent() {fenModEvent.close();}
    public static void fermerFenModTaches() {fenModTaches.close();}


    //Ajout et suppression données
    static public void ajouterBenevole(Benevole b) {
        Donnees.ajouterBenevole(b);
    }

    static public void supprimerBenevole(Benevole b) {
        Donnees.supprimerBenevole(b);
    }

    static public void ajouterSalle(Salle s) {
        Donnees.ajouterSalle(s);
    }

    static public void supprimerSalle(Salle s) {
        Donnees.supprimerSalle(s);
    }

    static public void ajouterEvenement(Evenement e) {
        Donnees.ajouterEvenement(e);
    }

    static public void SupprimerEvenement(Evenement e) {
        Donnees.supprimerEvenement(e);
    }

    //GETTER données

    static public ObservableList<Benevole> getLesBenevoles(){
        return Donnees.getLesBenevoles();
    }

    static public ObservableList<Salle> getLesSalles(){
        return Donnees.getLesSalles();
    }

    static public ObservableList<Evenement> getLesEvenements(){
        return Donnees.getLesEvenements();
    }

}
