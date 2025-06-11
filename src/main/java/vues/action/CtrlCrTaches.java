package vues.action;

import controleur.Alertes;
import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import modele.Benevole;
import modele.Evenement;
import modele.Salle;

public class CtrlCrTaches {

    @FXML
    private Button bnAnnuler;
    @FXML private Button bnOK;
    @FXML private TextField txtMatricule;
    @FXML private ComboBox<Benevole> selectBenevole;
    private Evenement evenement;

    @FXML void valider(ActionEvent event) {
        String nom = txtMatricule.getText();
        Benevole benevole = (Benevole) selectBenevole.getValue();
        if (evenement.getLesBenevoles().containsKey(nom)) {
            Alertes.afficherErreurTacheDejaLa();
            Principale.fermerFenModTaches();
        } else {
            Principale.ajouterTache(nom, benevole, evenement);
            Principale.ouvrirFenTaches(evenement);
        }
    }
    @FXML void annuler(ActionEvent event){
        Principale.fermerFenCrTaches();
        Principale.ouvrirFenTaches(evenement);
    }

    public void clear(){
        txtMatricule.clear();
        selectBenevole.setValue(null);
    }

    public void initialize(){
        selectBenevole.setItems(Principale.getLesBenevoles());

        BooleanBinding pasPret = txtMatricule.textProperty().isEmpty()
                .or(selectBenevole.valueProperty().isNull());

        bnOK.disableProperty().bind(pasPret);
    }

    public void setEvent(Evenement e) {
        evenement = e;
    }

}
