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
import modele.Benevole;
import modele.Evenement;
import modele.Salle;

public class CtrlHisto {

    @FXML private Button bnFermer;
    @FXML public TableView<Benevole> tvListeBenevoles;

    /* Relation avec le controleur */
    @FXML void clicFermer(ActionEvent event) {
        Principale.fermerFenHistorique();
    }



    @FXML void initialize() {

        TableColumn<Benevole,String> colonne1 = new TableColumn<>("Benevole");
        colonne1.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tvListeBenevoles.getColumns().set(0, colonne1);
        TableColumn<Benevole, Salle> colonne2 = new TableColumn<>("Prenom");
        colonne2.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        tvListeBenevoles.getColumns().set(1, colonne2);
        TableColumn<Benevole, Salle> colonne3 = new TableColumn<>("Tâche");
        colonne2.setCellValueFactory(new PropertyValueFactory<>("tache"));
        tvListeBenevoles.getColumns().set(2, colonne2);
        TableColumn<Benevole, Salle> colonne4 = new TableColumn<>("Saison");
        colonne2.setCellValueFactory(new PropertyValueFactory<>("saison"));
        tvListeBenevoles.getColumns().set(3, colonne2);
        tvListeBenevoles.setItems(Principale.getLesBenevoles());
        tvListeBenevoles.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);



    }
}
