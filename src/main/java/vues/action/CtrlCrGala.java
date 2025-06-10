package vues.action;

import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modele.Benevole;
import modele.Gala;
import modele.Salle;

public class CtrlCrGala {


    @FXML
    private Button bnAnnuler;
    @FXML private Button bnOK;
    @FXML private TextField txtTheme;
    @FXML private TextField txtProf;
    private String nom;
    private String date;
    private String saison;
    private Salle salle;
    private Benevole orga;




    @FXML void valider(ActionEvent event) {
        String theme = txtTheme.getText();
        String prof = txtProf.getText();
        Gala g = new Gala(nom, date, saison, salle, orga, theme, prof);
        Principale.ajouterUnEvent(g);


    }
    @FXML void annuler(ActionEvent event){
        Principale.fermerFenCrGala();
        Principale.ouvrirFenCrEvent();
    }



    public void clear(){
        txtTheme.clear();
        txtProf.clear();


    }
    public void donnees(String nom, String date, String saison, Salle salle, Benevole orga){
        this.nom = nom;
        this.date = date;
        this.saison = saison;
        this.salle = salle;
        this.orga = orga;
    }
    public void initialize() {

        BooleanBinding pasPret = Bindings.or(txtTheme.textProperty().isEmpty(), txtProf.textProperty().isEmpty());
        bnOK.disableProperty().bind(Bindings.when(pasPret).then(true).otherwise(false));
    }
}
