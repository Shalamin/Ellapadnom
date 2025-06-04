package modele;

import java.util.Date;

public class Gala extends Evenement{
    public String theme;
    public String professeur;

    public Gala(String nom, Date date, String saison, Salle laSalle, Benevole organisateur, String theme, String professeur){
        super(nom, date, saison, laSalle, organisateur);
        this.theme = theme;
        this.professeur = professeur;
    }

}
