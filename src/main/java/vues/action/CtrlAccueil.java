package vues.action;


import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import modele.Evenement;
import modele.Salle;

import javax.swing.*;
import java.util.Date;


public class CtrlAccueil {

    @FXML private Button bnCree;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnTaches;
    @FXML private Button bnFermer;
    @FXML private Button bnHistorique;
    @FXML public TableView<Evenement> tvListeEvenement;

    /* Relation avec le controleur */
    @FXML void clicFermer(ActionEvent event) {
        Principale.fermerFenAccueil();
    }
    @FXML void clicCree(ActionEvent event){
        Principale.ouvrirFenCrEvent();
    }
    @FXML void clicModifier(ActionEvent event){
        Principale.ouvrirFenModEvent(tvListeEvenement.getSelectionModel().getSelectedItem());
    }
    @FXML  void doubleClic(MouseEvent event){
        if(event.getClickCount() == 2 && !tvListeEvenement.getSelectionModel().isEmpty()) {
            Principale.ouvrirFenModEvent(tvListeEvenement.getSelectionModel().getSelectedItem());
        }
    }

    @FXML void clicTache(ActionEvent event){
        Principale.ouvrirFenTaches(tvListeEvenement.getSelectionModel().getSelectedItem());
    }

    @FXML void clicHisto(ActionEvent event){
        Principale.ouvrirFenHistorique();
    }
    @FXML void clicSupp(ActionEvent event){

        tvListeEvenement.getSelectionModel().selectedIndexProperty();

        Alert alert =  new Alert(Alert.AlertType.CONFIRMATION,
                "Voulez-vous vraiment supprimer cet événement ?",
                ButtonType.YES,
                ButtonType.NO);
        alert.setTitle("Confirmation de suppression");
        alert.showAndWait();
        if(alert.getResult() == ButtonType.YES){
            Principale.supprimerEvenement(tvListeEvenement.getSelectionModel().getSelectedItem());
        }

    }
    @FXML void clicRech(ActionEvent event){
        Principale.ouvrirFenRecherche();
    }
    public void updateTable(ObservableList list){
        tvListeEvenement.setItems(list);
        tvListeEvenement.refresh();
    }
    @FXML void initialize() {

        TableColumn<Evenement,String> colonne1 = new TableColumn<>("Nom");
        colonne1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tvListeEvenement.getColumns().set(0, colonne1);
        TableColumn<Evenement, Salle> colonne2 = new TableColumn<>("Salle");
        colonne2.setCellValueFactory(new PropertyValueFactory<>("laSalle"));
        tvListeEvenement.getColumns().set(1, colonne2);
        TableColumn<Evenement, String> colonne3 = new TableColumn<>("Type");
        colonne3.setCellValueFactory(new PropertyValueFactory<>("type"));
        tvListeEvenement.getColumns().set(2, colonne3);
        TableColumn<Evenement, String> colonne4 = new TableColumn<>("Date");
        colonne4.setCellValueFactory(new PropertyValueFactory<>("date"));
        tvListeEvenement.getColumns().set(3, colonne4);
        TableColumn<Evenement,String> colonne5 = new TableColumn<>("Saison");
        colonne5.setCellValueFactory(new PropertyValueFactory<>("saison"));
        tvListeEvenement.getColumns().set(4, colonne5);
        tvListeEvenement.setItems(Principale.getLesEvenements());
        tvListeEvenement.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        BooleanBinding rien =
                Bindings.equal(tvListeEvenement.getSelectionModel().selectedIndexProperty(), -1);

        bnSupprimer.disableProperty().bind(rien);
        bnModifier.disableProperty().bind(rien);
        bnTaches.disableProperty().bind(rien);


    }


}
