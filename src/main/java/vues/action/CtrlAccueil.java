package vues.action;


import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Evenement;
import modele.Salle;

import java.util.Date;


public class CtrlAccueil {

    @FXML private Button bnCree;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnTaches;
    @FXML private Button bnFermer;
    @FXML private TableView<Evenement> tvListeEvenement;

    /* Relation avec le controleur */
    @FXML void clicFermer(ActionEvent event) {
        Principale.fermerFenAccueil();
    }
    @FXML void clicCree(ActionEvent event){
        Principale.ouvrirFenCrEvent();
    }
    @FXML void clicModifier(ActionEvent event){
        Principale.ouvrirFenModEvent();
    }
    @FXML void doubleClic(ActionEvent event){
        Principale.ouvrirFenModEvent();
    }

    @FXML void clicTache(ActionEvent event){
        Principale.ouvrirFenTaches();
    }


    @FXML void clicSupp(ActionEvent event){

        tvListeEvenement.getSelectionModel().selectedIndexProperty();

        Alert alert =  new Alert(Alert.AlertType.CONFIRMATION,
                "Voulez-vous vraiment supprimer cet événement ?",
                ButtonType.YES,
                ButtonType.NO);
        alert.setTitle("Confirmation de suppression");
        alert.showAndWait();

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
        TableColumn<Evenement, Date> colonne4 = new TableColumn<>("Date");
        colonne4.setCellValueFactory(new PropertyValueFactory<>("date"));
        tvListeEvenement.getColumns().set(3, colonne4);
        TableColumn<Evenement,String> colonne5 = new TableColumn<>("Saison");
        colonne5.setCellValueFactory(new PropertyValueFactory<>("saison"));
        tvListeEvenement.getColumns().set(4, colonne5);
        tvListeEvenement.setItems(Principale.getLesEvenements());
        System.out.println(Principale.getLesEvenements());
        tvListeEvenement.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        BooleanBinding rien =
                Bindings.equal(tvListeEvenement.getSelectionModel().selectedIndexProperty(), -1);

        bnSupprimer.disableProperty().bind(rien);
        bnModifier.disableProperty().bind(rien);


    }


}
