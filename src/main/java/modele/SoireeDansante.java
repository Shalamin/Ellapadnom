package modele;

import java.util.Date;

public class SoireeDansante extends Evenement{
    private List<String> planTable = new ArrayList<String>();

    public SoireeDansante(String nom, Date date, String saison, Salle laSalle, Benevole organisateur){
        super(nom, date, saison, laSalle, organisateur);
    }
}
