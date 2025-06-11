package controleur;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
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
    static public FenCrGala fenCrGala;

    private static ObservableList<Evenement> lesEvenements = FXCollections.observableArrayList();

    public void start(Stage f) throws IOException {
        Donnees.chargementDonnees();
        fenAccueil = new FenAccueil();
        fenTaches = new FenTaches();
        fenCrEvent = new FenCrEvent();
        fenCrGala = new FenCrGala();
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

    public static void ouvrirFenModEvent(Evenement e){
        fenModEvent.afficherEvenement(e);
        fenModEvent.show();
    }
    public static void ouvrirFenModTaches(Evenement e, String tache, Benevole b){
        fenModTaches.afficherTache(e, tache, b);
        fenModTaches.show();
    }
    public static void ouvrirFenCrEvent(){
        fenCrEvent.show();
        fenCrEvent.effacer();
    }
    public static void ouvrirFenCrTaches(Evenement e){
        fenCrTaches.eventSelect(e);
        fenCrTaches.effacer();
        fenCrTaches.show();
    }
    public static void ouvrirFenTaches(Evenement e){
        fenTaches.eventSelect(e);
        fenTaches.show();}
    public static void ouvrirFenCrGala(String nom, String date, String saison, Salle salle, Benevole orga){
        fenCrEvent.close();
        fenCrGala.show();
        fenCrGala.donnees(nom, date, saison ,salle, orga);
        fenCrGala.effacer();
    }
    public static void ouvrirFenCrTaches(){fenCrTaches.show();}
    public static void ouvrirFenTaches(){fenTaches.show();}

    public static void fermerFenAccueil() {System.exit(0);}
    public static void fermerFenTaches() {fenTaches.close();}
    public static void fermerFenCrEvent() {fenCrEvent.close();}
    public static void fermerFenCrGala(){fenCrGala.close();}
    public static void fermerFenCrTaches() {fenCrTaches.close();}
    public static void fermerFenModEvent() {
        fenModEvent.close();
    }
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

    static public void supprimerEvenement(Evenement e) {
        e.getLaSalle().retirerEvent(e);
        Iterator it = e.getLesBenevoles().entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            Benevole ben = (Benevole) pair.getValue();
            ben.retirerEvent(e);
        }
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
    public static ObservableMap<String, Benevole> getLesTaches(Evenement e){
        return Donnees.getLesTaches(e);
    }



    public static void ajouterUnEvent(Evenement e){
        Donnees.ajouterEvenement(e);
        if(fenCrGala.isShowing()){
            fenCrGala.close();
        }
        fenCrEvent.close();

    }
    public static void modifierEvenement(Evenement e, String nom, Salle salle, String date, String saison, String type){
        if(type.equals("Gala")){
            Gala gala = new Gala(nom, date, saison, salle, e.getLesBenevoles().get("Organisateur"), "", "");
            Donnees.modifierEvenement(gala);
        }
        else if(type.equals("Soirée dansante")){
            SoireeDansante sd = new SoireeDansante(nom, date, saison, salle, e.getLesBenevoles().get("Organisateur"));
            Donnees.modifierEvenement(sd);
            System.out.println("SOIREE");

        }
        fenModEvent.close();
    }

    public static void ajouterTache(String t, Benevole b, Evenement e){
        b.ajouterEventTache(e, t);
        System.out.println(b.getMesEvents());
        Donnees.ajouterTache(t, b, e);
        fenCrTaches.close();
    }

    public static void modifierTache(String ancienneTache, Benevole ancienBenevole,
                                     String nouvelleTache, Benevole nouveauBenevole, Evenement e) {
        ancienBenevole.retirerEventTache(ancienneTache, e);
        nouveauBenevole.ajouterEventTache(e, nouvelleTache);
        Donnees.modifierTache(ancienneTache, ancienBenevole, nouvelleTache, nouveauBenevole, e);
    }

    public static void supprimerTache(String nomTache, Benevole benevole, Evenement evenement){
        benevole.retirerEventTache(nomTache, evenement);
        Donnees.supprimerTache(nomTache, benevole, evenement);
    }
}
