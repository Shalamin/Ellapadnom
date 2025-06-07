package modele;

import java.util.*;

public class Benevole {
    private String nom;
    private String prenom;
    private HashMap<String, Evenement> mesEvents = new HashMap<String, Evenement>();


    public Benevole(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }



    public void setMesEvents(HashMap<String, Evenement> mesEvents) {
        this.mesEvents = mesEvents;
    }

    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }

    public HashMap<String, Evenement> getMesEvents() {
        return mesEvents;
    }

    public boolean equals(Benevole ben){
        return ben.getNom() == nom && ben.getPrenom() == prenom;
    }

    public void ajouterEventTache(Evenement e, String tache){
        mesEvents.put(tache, e );
    }
    void retirerEvent(Evenement e){
        Iterator it = mesEvents.entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if(pair.getValue() == e){
                mesEvents.remove(pair.getKey(), e);
            }
        }
    }
    void retirerEventTache( String tache, Evenement e){
        mesEvents.remove(tache, e);
    }
    void ajouterEvent(Evenement e){
        mesEvents.put("Inconnue", e);
    }





}
