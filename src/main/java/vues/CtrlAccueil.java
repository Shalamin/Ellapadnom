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

    /* Relation avec le controlleur */
    @FXML void clicCree(ActionEvent event){
        Principale.ouvrirFenCrEvent();
    }
    @FXML void clicModifier(ActionEvent event){
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

        TableColumn<Employe,Integer> colonne1 = new TableColumn<Employe,Integer>("Matricule");
        colonne1.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("matricule"));
        tvListeEmployes.getColumns().set(0, colonne1);
        TableColumn<Employe, String> colonne2 = new TableColumn<Employe,String>("Nom");
        colonne2.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
        tvListeEmployes.getColumns().set(1, colonne2);
        TableColumn<Employe, String> colonne3 = new TableColumn<Employe,String>("Poste");
        colonne3.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
        tvListeEmployes.getColumns().set(2, colonne3);
        TableColumn<Employe,Integer> colonne4 = new TableColumn<Employe,Integer>("Département");
        colonne4.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("dept"));
        tvListeEmployes.getColumns().set(3, colonne4);

        tvListeEvenement.setItems(Principale.getLesEvenements());
        tvListeEvenement.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


        //A FAIRE griser les boutons Modifier et Supprimer quand aucune sélection

        bnSupprimer.disableProperty().bind(rien);
        bnModifier.disableProperty().bind(rien);


    }


}
