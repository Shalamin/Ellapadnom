package vues.action;

import controleur.Principale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class CtrlTaches {
    @FXML private Button bnCree;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnFermer;

    /* Relation avec le controleur */
    @FXML void clicCree(ActionEvent event){
        Principale.ouvrirFenCrTaches();
        Principale.fermerFenTaches();
    }
    @FXML void clicModifier(ActionEvent event){
        Principale.ouvrirFenModTaches();
        Principale.fermerFenTaches();
    }
    @FXML void doubleClic(ActionEvent event){
        Principale.ouvrirFenModTaches();
        Principale.fermerFenTaches();
    }
    @FXML void clicClose(ActionEvent event) {
        Principale.fermerFenTaches();
    }

    @FXML void clicSupp(ActionEvent event){

        Alert alert =  new Alert(Alert.AlertType.CONFIRMATION,
            "Voulez-vous vraiment supprimer cette tâches?",
            ButtonType.YES,
            ButtonType.NO);
        alert.setTitle("Confirmation de suppression");
        alert.showAndWait();}




}
