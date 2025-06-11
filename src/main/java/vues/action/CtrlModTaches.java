package vues.action;

import controleur.Alertes;
import controleur.Principale;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modele.Benevole;
import modele.Evenement;

import java.beans.beancontext.BeanContext;
import java.time.LocalDate;

public class CtrlModTaches {

    @FXML
    private Button bnAnnuler;
    @FXML private Button bnOK;
    @FXML private TextField txtMatricule;
    @FXML private ComboBox<Benevole> selectBen;
    private Evenement evenement;
    private String ancienneTache;
    private Benevole ancienBenevole;

    @FXML void valider(ActionEvent event) {
        String nouvelleTache = txtMatricule.getText();
        Benevole nouveauBenevole = selectBen.getValue();

        if(ancienneTache.equals("Organisateur")){
            Alert alerte = new Alert(Alert.AlertType.ERROR, "ERREUR : Ne pas modifier l'organisateur", ButtonType.CLOSE);
            alerte.show();
            Principale.fermerFenModTaches();
            Principale.ouvrirFenTaches();
        } else if(nouvelleTache.equals("Organisateur")){
            Alert alerte = new Alert(Alert.AlertType.ERROR, "ERREUR : Il y a déjà un organisateur", ButtonType.CLOSE);
            alerte.show();
        } else{
            Principale.modifierTache(ancienneTache, ancienBenevole, nouvelleTache, nouveauBenevole, evenement);
            Principale.ouvrirFenTaches(evenement);
            Principale.fermerFenModTaches();
        }


    }
    @FXML void annuler(ActionEvent event){
        //Principale.ouvrirFenTaches();
        Principale.fermerFenModTaches();
    }
    public void initialize(){
        selectBen.setItems(Principale.getLesBenevoles());

        BooleanBinding pasPret = txtMatricule.textProperty().isEmpty()
                .or(selectBen.valueProperty().isNull());

        bnOK.disableProperty().bind(pasPret);
    }
    public void afficherTache(Evenement e, String tache, Benevole benevole) {
        this.evenement = e;
        this.ancienneTache = tache;
        this.ancienBenevole = benevole;

        txtMatricule.setText(tache);
        selectBen.setValue(benevole);
    }

}
