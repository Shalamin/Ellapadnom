package vues.action;

import controleur.Principale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import modele.Benevole;
import modele.Evenement;

import java.beans.beancontext.BeanContext;
import java.time.LocalDate;

public class CtrlModTaches {

    @FXML
    private Button bnAnnuler;
    @FXML private Button bnOk;
    @FXML private TextField txtMatricule;

    @FXML void valider(ActionEvent event) {
        //Principale.ouvrirFenTaches();
        Principale.fermerFenModTaches();
    }
    @FXML void annuler(ActionEvent event){
        //Principale.ouvrirFenTaches();
        Principale.fermerFenModTaches();
    }
    public void afficherTache(String s, Benevole b){
        txtMatricule.setText(s);

    }

}
