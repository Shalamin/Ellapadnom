package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.sun.jdi.StringReference;
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

        Salle salle = new Salle("ursulines", 150);
        Benevole first = new Benevole("Lui", "LeMeilleur");
        Gala g1 = new Gala("event1", new Date(1, 1, 1), "2025", salle, first, "sexy" , "Roberto");
        lesEvenements.add(g1);
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


    public static ObservableList<Evenement> getLesEvenements(){
        return lesEvenements;
    }
    public static ObservableList<String> getLesTypes(){
        ObservableList<String> res = FXCollections.observableArrayList();
        res.add("Gala");
        res.add("Soirée dansante");
        return res;
    }
    public static ObservableList<Salle> getLesSalles(){
        ObservableList<Salle> res = FXCollections.observableArrayList();
        Salle s1 = new Salle("Ursulines", 150);
        res.add(s1);
        return res;
    }
    public static ObservableList<Benevole> getLesBenevoles(){
        ObservableList<Benevole> res = FXCollections.observableArrayList();
        Benevole b1 = new Benevole("Johan", "Le Goff");
        res.add(b1);
        return res;
    }
    public static void ajouterUnEvent(String nom, Date date, String saison, Salle laSalle, Benevole orga, String theme, String prof){
        Gala g = new Gala(nom, date, saison, laSalle, orga, theme, prof);
        Donnees.ajouterEvent(g);
        fermerFenCrEvent();
    }
    public static void ajouterUnEvent(String nom, Date date, String saison, Salle laSalle, Benevole orga){
        SoireeDansante sd = new SoireeDansante(nom, date, saison, laSalle, orga);
        Donnees.ajouterEvent(sd);
        fermerFenCrEvent();

    }
}
