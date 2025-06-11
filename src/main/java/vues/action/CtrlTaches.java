package vues.action;

import controleur.Alertes;
import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Benevole;
import modele.Evenement;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CtrlTaches {
    @FXML private Button bnCree;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnFermer;
    @FXML private TableView<Map.Entry<String, Benevole>> tableTaches;
    @FXML private TableColumn<Map.Entry<String, Benevole>, String> colTache;
    @FXML private TableColumn<Map.Entry<String, Benevole>, String> colNom;
    @FXML private TableColumn<Map.Entry<String, Benevole>, String> colPrenom;
    private Evenement evenement;

    /* Relation avec le controleur */
    @FXML void clicCree(ActionEvent event){
        Principale.ouvrirFenCrTaches(evenement);
        Principale.fermerFenTaches();
    }
    @FXML void clicModifier(ActionEvent event){
        Map.Entry<String, Benevole> selection = tableTaches.getSelectionModel().getSelectedItem();

        if (selection != null) {
            Principale.ouvrirFenModTaches(evenement, selection.getKey(), selection.getValue());
            Principale.fermerFenTaches();
        }
    }
    @FXML void doubleClic(ActionEvent event){
        Map.Entry<String, Benevole> selection = tableTaches.getSelectionModel().getSelectedItem();

        if (selection != null) {
            Principale.ouvrirFenModTaches(evenement, selection.getKey(), selection.getValue());
            Principale.fermerFenTaches();
        }
    }
    @FXML void clicClose(ActionEvent event) {
        Principale.fermerFenTaches();
    }

    @FXML void clicSupp(ActionEvent event){

        Map.Entry<String, Benevole> selection = tableTaches.getSelectionModel().getSelectedItem();

        if (Objects.equals(selection.getKey(), "Organisateur")){
            Alertes.afficherErreurSupprOrganisateur();
        } else {
            Alert alert =  new Alert(Alert.AlertType.CONFIRMATION,
                    "Voulez-vous vraiment supprimer cette tâches?",
                    ButtonType.YES,
                    ButtonType.NO);
            alert.setTitle("Confirmation de suppression");
            alert.showAndWait();
            if (alert.getResult() == ButtonType.YES) {
                Principale.supprimerTache(selection.getKey(), selection.getValue(), evenement);
            }
        }
    }

    public void initialize() {
        colTache.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getKey())
        );
        colNom.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getValue().getNom())
        );
        colPrenom.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getValue().getPrenom())
        );

        tableTaches.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        BooleanBinding rien =
                Bindings.equal(tableTaches.getSelectionModel().selectedIndexProperty(), -1);
        bnSupprimer.disableProperty().bind(rien);
        bnModifier.disableProperty().bind(rien);
    }

    public void setEvent(Evenement e){
        evenement = e;

        ObservableMap<String, Benevole> mapTaches = Principale.getLesTaches(evenement);


        //PARTIE CHATGPT
        // Convertis en liste observable d’entrées
        ObservableList<Map.Entry<String, Benevole>> liste =
                FXCollections.observableArrayList(mapTaches.entrySet());

        mapTaches.addListener((MapChangeListener<? super String, ? super Benevole>)change -> {
            if (change.wasRemoved()) {
                liste.removeIf(entry -> entry.getKey().equals(change.getKey()));
            }
            if (change.wasAdded()) {
                liste.add(new AbstractMap.SimpleEntry<>(
                        (String) change.getKey(),
                        (Benevole) change.getValueAdded()
                ));
            }
            liste.setAll(e.getLesBenevoles().entrySet());
        });
        //FIN DE LA PARTIE CHAT GPT


        tableTaches.setItems(liste);
    }

}
