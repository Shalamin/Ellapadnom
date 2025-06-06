package vues.action;

import controleur.Principale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CtrlModTaches {

    @FXML
    private Button bnAnnuler;
    @FXML private Button bnOk;

    @FXML void valider(ActionEvent event) {
        Principale.ouvrirFenTaches();
    }
    @FXML void annuler(ActionEvent event){
        Principale.ouvrirFenTaches();
        Principale.fermerFenModTaches();
    }

}
