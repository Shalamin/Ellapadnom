package modele;

import controleur.Alertes;
import controleur.Principale;

import java.util.*;

public abstract class Evenement {
    protected String nom;
    protected Date date;
    protected String saison;
    protected Salle laSalle;
    protected HashMap<String, Benevole> lesBenevoles = new HashMap<String, Benevole>();
    public Evenement(String nom, Date date, String saison, Salle laSalle, Benevole organisateur){
        this.nom = nom;
        this.date = date;
        this.saison = saison;
        this.laSalle = laSalle;
        lesBenevoles.put("Organisateur", organisateur);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSaison() {
        return saison;
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
    /// BENEVOLES \\\
    // Privates \\
    private void ajouterTache(String tache, Benevole ben){
        lesBenevoles.put(tache, ben);
        ben.ajouterEventTache(this, tache);
    }
    public void affecterTache(String tache, Benevole ben){
        if(ben == null || tache == ""){
            Alertes.afficherErreurNull();
        }
        else if(lesBenevoles.get(tache) == ben){
            Alertes.afficherErreurDejaLa();
        }
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


    /// SALLE \\\


    private void ajouterSalle(Salle salle){
        laSalle = salle;
    }
    public void affecterSalle(Salle salle){
        if(salle == null){
            Alertes.afficherErreurNull();
        }
        else if(laSalle == salle){
            Alertes.afficherErreurDejaLa();
        }
    }


}
