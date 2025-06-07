package controleur;

import java.io.IOException;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import vues.action.*;
import vues.fenetres.*;
import modele.*;

public class Principale extends Application{
    static public FenAccueil fenAccueil;
    static public FenTaches fenTaches;
    static public FenCrEvent fenCrEvent;
    static public FenCrTaches fenCrTaches;
    static public FenModEvent fenModEvent;
    static public FenModTaches fenModTaches;

    private static ObservableList<Evenement> lesEvenements = FXCollections.observableArrayList();

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

        Salle salle = new Salle("Ursulines", 150);
        Donnees.ajouterSalle(salle);
        Benevole first = new Benevole("Lui", "LeMeilleur");
        Donnees.ajouterBenevole(first);
        Gala g1 = new Gala("event1", "2025-01-01", "2025", salle, first, "sexy" , "Roberto");
        Donnees.ajouterEvenement(g1);
        Application.launch();
    }

    ////////////////////////////////////////////
    // Gestion des fenêtres (à compléter)
    ////////////////////////////////////////////

    public static void ouvrirFenModEvent(){fenModEvent.show();}
    public static void ouvrirFenModTaches(){fenModTaches.show();}
    public static void ouvrirFenCrEvent(){
        fenCrEvent.show();
        fenCrEvent.effacer();
    }
    public static void ouvrirFenCrTaches(){fenCrTaches.show();}
    public static void ouvrirFenTaches(){fenTaches.show();}

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
    public static ObservableList<String> getLesTypes(){
        ObservableList<String> res = FXCollections.observableArrayList();
        res.add("Gala");
        res.add("Soirée dansante");
        return res;
    }


    public static void ajouterUnEvent(String nom, String date, String saison, Salle laSalle, Benevole orga, String theme, String prof){
        Gala g = new Gala(nom, date, saison, laSalle, orga, theme, prof);
        Donnees.ajouterEvenement(g);
        g.affecterSalle(laSalle);
        fenCrEvent.close();
    }
    public static void ajouterUnEvent(String nom, String date, String saison, Salle laSalle, Benevole orga){
        SoireeDansante sd = new SoireeDansante(nom, date, saison, laSalle, orga);
        Donnees.ajouterEvenement(sd);
        fenCrEvent.close();

    }
}
