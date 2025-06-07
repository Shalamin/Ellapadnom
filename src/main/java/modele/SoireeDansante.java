package modele;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SoireeDansante extends Evenement{
    private List<String> planTable = new ArrayList<String>();

    public SoireeDansante(String nom, String date, String saison, Salle laSalle, Benevole organisateur){
        super(nom, date, saison, laSalle, organisateur);
        super.setType("Soirée dansante");
    }
    void ajouterPlanTable(String nom){
        planTable.add(nom);
    }
}
