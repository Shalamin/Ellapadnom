package modele;

import java.util.ArrayList;
import java.util.List;

public class Salle {
    private String nomSalle;
    private int capacite;
    private List<Evenement> mesEvents = new ArrayList<Evenement>();

    public Salle(String nomSalle, int capacite){
        this.nomSalle = nomSalle;
        this.capacite = capacite;
    }
    public String getNom(){
        return nomSalle;
    }
    public String toString(){
        return nomSalle + " - "+capacite;
    }

    /*package*/ void ajouterEvent(Evenement e){
        mesEvents.add(e);
    }
    /*package*/ void retirerEvent(Evenement e){
        mesEvents.remove(e);
    }

}
