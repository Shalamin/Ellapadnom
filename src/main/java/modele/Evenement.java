package modele;

import controleur.Alertes;
import sae201.sae201.controleur.Principale;

import java.util.Date;
import java.util.List;
import java.util.HashMap;

public class Evenement {
    private String nom;
    private Date date;
    private String saison;
    private Salle laSalle;
    private HashMap<String, Benevole> lesBenevoles = new HashMap<String, Benevole>();
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

    private void ajouterTache(String tache, Benevole ben){
        lesBenevoles.put(tache, ben);
    }
    public void affecterTache(String tache, Benevole ben){
        if(ben == null || tache == ""){
            Alertes.afficherErreurNull();
        }
        else if(lesBenevoles.get(tache) == ben){
            Alertes.afficherErreurDejaLa();
        }
    }
    private void retirerTache(String tache, Benevole ben){lesBenevoles.remove(tache, ben);}
    private void retirerTache(String tache){lesBenevoles.remove(tache);}
    public void enleverTache(String tache, Benevole ben){
        if(tache == "" || ben == null){
            Alertes.afficherErreurNull();
        }
        else if(!lesBenevoles.containsKey(tache) || !lesBenevoles.containsValue(ben)){
            Alertes.afficherErreurAbsent();
        }
        else {
            retirerTache(tache, ben);
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
        }
    }

}
