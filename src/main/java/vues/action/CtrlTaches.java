package vues.action;

import controleur.Principale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CtrlTaches {
    @FXML private Button bnCree;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnFermer;
    @FXML private TableView<Taches> listeTaches;

    /* Relation avec le controleur */
    @FXML void clicCree(ActionEvent event){
        Principale.ouvrirFenCrEvent();
    }
    @FXML void clicModifier(ActionEvent event){
        Principale.ouvrirModEvent();
    }
    @FXML void doubleClic(ActionEvent event){
        Principale.ouvrirModEvent();
    }
    @FXML void clicClose(ActionEvent event) {
        Principale.fermerTache();
    }
}
