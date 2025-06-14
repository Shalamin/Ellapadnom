package modele;

import controleur.Alertes;
import controleur.Principale;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.*;

public abstract class Evenement {
    protected String nom;
    protected String date;
    protected String saison;
    protected String type;
    protected Salle laSalle;
    protected ObservableMap<String, Benevole> lesBenevoles = FXCollections.observableHashMap();
    public Evenement(String nom, String date, String saison, Salle laSalle, Benevole organisateur){
        this.nom = nom;
        this.date = date;
        this.saison = saison;
        this.laSalle = laSalle;
        lesBenevoles.put("Organisateur", organisateur);
        organisateur.ajouterEventTache(this, "Organisateur");

    }
    public void setType(String t){
        type = t;
    }

    public String getType(){
        return type;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSaison() {
        return saison;
    }
    public ObservableMap<String, Benevole> getLesBenevoles(){
        return lesBenevoles;
    }
    public void setSaison(String saison) {
        this.saison = saison;
    }

    public Salle getLaSalle() {
        return laSalle;
    }

    public void setLaSalle(Salle laSalle) {
        this.laSalle = laSalle;
    }

    public boolean equals(Evenement e){
        return e.getNom() == nom && e.getSaison() == saison;
    }


    /// BENEVOLES \\\
    // Privates \\
    private void ajouterTache(String tache, Benevole ben){
        lesBenevoles.put(tache, ben);
        ben.ajouterEventTache(this, tache);
    }
    private void retirerTache(String tache, Benevole ben){
        lesBenevoles.remove(tache, ben);
        ben.retirerEventTache(tache, this);

    }
    private void retirerTache(String tache){
        lesBenevoles.get(tache).retirerEventTache(tache, this);
        lesBenevoles.remove(tache);
    }
    private void supprimerBenevole(Benevole ben){
        Iterator it = lesBenevoles.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getValue() == ben){
                lesBenevoles.remove(pair.getKey(), ben);
            }
        }
    }

    // Publics \\
    public void affecterTache(String tache, Benevole ben){
        if(ben == null || tache == ""){
            Alertes.afficherErreurNull();
        } else{
            ajouterTache(tache, ben);
        }
    }

    public void enleverTache(String tache, Benevole ben){
        if(tache == "" || ben == null){
            Alertes.afficherErreurNull();
        }
        else if(!lesBenevoles.containsKey(tache) || !lesBenevoles.containsValue(ben)){
            Alertes.afficherErreurAbsent();
        }
        else {
            retirerTache(tache, ben);
            ben.retirerEventTache(tache, this);
        }
    }
    public void enleverTache(String tache){
        if(tache == ""){
            Alertes.afficherErreurNull();
        }
        else if(!lesBenevoles.containsKey(tache)){
            Alertes.afficherErreurAbsent();
        }
        else {
            retirerTache(tache);
            lesBenevoles.get(tache).retirerEventTache(tache, this);
        }
    }
    public void supprimerBenevoleEvent(Benevole ben){
        if(ben == null){
            Alertes.afficherErreurNull();
        }
        else if(!lesBenevoles.containsValue(ben)){
            Alertes.afficherErreurAbsent();
        }
        else{
            supprimerBenevole(ben);
            ben.retirerEvent(this);
        }
    }
    public void afficherTaches(){
        Iterator it = lesBenevoles.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();

        }
    }


    /// SALLE \\\


    private void ajouterSalle(Salle salle){
        laSalle = salle;
    }
    private void supprimerSalle(){
        laSalle = null;

    }

    public void affecterSalle(Salle salle){
        if(salle == null){
            Alertes.afficherErreurNull();
        }

        else{
            salle.ajouterEvent(this);
            ajouterSalle(salle);
        }
    }

    public void retirerSalle(){
        laSalle.retirerEvent(this);
        supprimerSalle();
    }


}
