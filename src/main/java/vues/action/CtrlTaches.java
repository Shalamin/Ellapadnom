package vues.action;

import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Benevole;
import modele.Evenement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CtrlTaches {
    @FXML private Button bnCree;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnFermer;
    @FXML private TableView<Map.Entry<String, Benevole>> tableTaches;
    private Evenement evenement;

    /* Relation avec le controleur */
    @FXML void clicCree(ActionEvent event){
        Principale.ouvrirFenCrTaches(evenement);
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

    public void initialize() {

        tableTaches.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        BooleanBinding rien =
                Bindings.equal(tableTaches.getSelectionModel().selectedIndexProperty(), -1);
        bnSupprimer.disableProperty().bind(rien);
        bnModifier.disableProperty().bind(rien);
    }

    public void setEvent(Evenement e){
        evenement = e;
    }

}
