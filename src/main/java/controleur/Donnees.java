package controleur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import modele.*;
import java.util.*;

public class Donnees {
    static private ObservableList<Benevole> lesBenevoles = FXCollections.observableArrayList();
    static private ObservableList<Evenement> lesEvenements = FXCollections.observableArrayList();
    static private ObservableList<Salle> lesSalles = FXCollections.observableArrayList();
    static private ObservableMap<String, Benevole> lesTaches = FXCollections.observableHashMap();

    static public void chargementDonnees() {
        lesBenevoles.add(new Benevole("Mace","Sacha"));
        lesBenevoles.add(new Benevole("Lebeul","Ethan"));
        lesBenevoles.add(new Benevole("Monnier","Gabriel"));

        lesSalles.add(new Salle("Les Ursulines", 300));
        lesSalles.add(new Salle("Carré Magique", 200));

        lesEvenements.add(new Gala("TchatchaDanse", "2014-01-02", "2014", getLaSalle("Les Ursulines") , getLeBenevole("Mace"), "Tchatcha", "Noah"));

        lesBenevoles.get(0).ajouterEventTache(lesEvenements.get(0), "Organisateur");
    }

    public static Salle getLaSalle(String nomSalle) {
        Salle res = null;
        for (Salle salle : lesSalles) {
            if(salle.getNomSalle().equals(nomSalle)) {
                res = salle;
            }
        }

        return res;
    }

    public static Benevole getLeBenevole(String nomBenevole) {
        Benevole res = null;
        for (Benevole benevole : lesBenevoles) {
            if (benevole.getNom().equals(nomBenevole)) {
                res = benevole;
            }
        }

        return res;
    }

    public static  ObservableList<Benevole> getLesBenevoles() {
        return lesBenevoles;
    }

    static public ObservableList<Salle> getLesSalles() {
        return lesSalles;
    }

    public static ObservableList<Evenement> getLesEvenements() {
        return lesEvenements;
    }

    public static ObservableMap<String, Benevole> getLesTaches(Evenement e) {
        return e.getLesBenevoles();
    }

    //////////////////////////
    // méthodes (ou "requêtes") de mise à jour
    //////////////////////////

    //BENEVOLES

    static public void ajouterBenevole(Benevole b) {
        lesBenevoles.add(b);
    }

    static public void supprimerBenevole(Benevole b) {
        boolean trouve = false;
        int i=0;
        while (!trouve && i<lesBenevoles.size()) {
            if ( lesBenevoles.get(i).equals(b)){
                lesBenevoles.remove(i);
                trouve = true;
            }
            i++;
        }
    }


    //SALLES

    static public void ajouterSalle(Salle s) {
        lesSalles.add(s);
    }

    static public void supprimerSalle(Salle s) {
        boolean trouve = false;
        int i=0;
        while (!trouve && i<lesSalles.size()) {
            if ( lesSalles.get(i).equals(s)){
                lesSalles.remove(i);
                trouve = true;
            }
            i++;
        }
    }


    //EVENEMENTS

    static public void ajouterEvenement(Evenement e) {
        lesEvenements.add(e);
    }

    static public void supprimerEvenement(Evenement e) {
        boolean trouve = false;
        int i=0;
        while (!trouve && i<lesEvenements.size()) {
            System.out.println(lesEvenements.get(i).getNom());
            if ( lesEvenements.get(i).equals(e)){
                lesEvenements.remove(i);
                trouve = true;
            }
            i++;
        }
    }
    static public void modifierEvenement(Evenement e){
        boolean trouve = false;

        int i=0;
        while (!trouve && i<lesEvenements.size()) {
            if ( lesEvenements.get(i).getNom().equals(e.getNom())){
                lesEvenements.set(i, e);

                trouve = true;
            }
            else{
                i++;
            }
        }

    }


    //TACHES
    static public void ajouterTache(String t, Benevole b, Evenement e) {
        for (Evenement event : lesEvenements ) {
            if (event.getNom().equals(e.getNom()) && event.getSaison().equals(e.getSaison())) {
                event.affecterTache(t, b);
                System.out.println("Tache ajout<UNK> avec le tache");
            }
        }
    }

    public static void modifierTache(String ancienneTache, Benevole ancienBenevole,
                                     String nouvelleTache, Benevole nouveauBenevole, Evenement e) {
        ObservableMap<String, Benevole> taches = e.getLesBenevoles();

        // Vérifie que l'entrée à modifier existe bien
        if (taches.containsKey(ancienneTache) && taches.get(ancienneTache).equals(ancienBenevole)) {
            taches.remove(ancienneTache);
            taches.put(nouvelleTache, nouveauBenevole);
        }
    }


    static public void supprimerTache(String t, Benevole b, Evenement e) {
        ObservableMap<String, Benevole> taches = e.getLesBenevoles();
        if (taches.containsKey(t) && taches.get(t).equals(b)) {
            taches.remove(t);
        }
    }
}
