package vues;

import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.Evenement;


public class CtrlAccueil {

    @FXML private Button bnCree;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnTaches;
    @FXML private Button bnFermer;
    @FXML private TableView<Evenement> tvListeEvenement;

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
        BooleanBinding rien =
                Bindings.equal(tvListeEvenement.getSelectionModel().selectedIndexProperty(), -1);

        TableColumn<Evenement,String> colonne1 = new TableColumn<Evenement,String>("Nom");
        colonne1.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nom"));
        tvListeEvenement.getColumns().set(0, colonne1);
        TableColumn<Evenement, String> colonne2 = new TableColumn<Evenement,String>("Salle");
        colonne2.setCellValueFactory(new PropertyValueFactory<Evenement, String>("salle"));
        tvListeEvenement.getColumns().set(1, colonne2);
        TableColumn<Evenement, String> colonne3 = new TableColumn<Evenement,String>("Type");
        colonne3.setCellValueFactory(new PropertyValueFactory<Evenement, String>("type"));
        tvListeEvenement.getColumns().set(2, colonne3);
        TableColumn<Evenement,Date> colonne4 = new TableColumn<Evenement ,Date>("Date");
        colonne4.setCellValueFactory(new PropertyValueFactory<Evenement, Date>("date"));
        tvListeEvenement.getColumns().set(3, colonne4);
        TableColumn<Evenement,String> colonne5 = new TableColumn<Evenement,String>("Saison");
        colonne5.setCellValueFactory(new PropertyValueFactory<Evenement, String>("saison"));
        tvListeEvenement.getColumns().set(4, colonne5);

        tvListeEvenement.setItems(Principale.getLesEvenements());
        tvListeEvenement.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        bnSupprimer.disableProperty().bind(rien);
        bnModifier.disableProperty().bind(rien);


    }


}
