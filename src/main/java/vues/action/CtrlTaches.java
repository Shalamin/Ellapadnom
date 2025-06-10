package vues.action;

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
        });
        //FIN DE LA PARTIE CHAT GPT


        tableTaches.setItems(liste);
    }

}
