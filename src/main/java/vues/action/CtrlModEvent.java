package vues.action;

import controleur.Principale;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import modele.Benevole;
import modele.Salle;
import modele.*;

import java.time.LocalDate;

public class CtrlModEvent {
    @FXML private TextField txtNom;
    @FXML private ComboBox<Salle> selectSalle;
    @FXML private ComboBox<String> selectEvent;
    @FXML private ComboBox<Benevole> selectBen;
    @FXML private DatePicker date;
    @FXML private Button bnAnnuler;
    @FXML private Button bnOk;

    @FXML void valider(ActionEvent event) {

    }
    @FXML void annuler(ActionEvent event){
        Principale.fermerFenModEvent();
    }

    public void initialize(){

    }
    public void afficherEvenement(Evenement e){
        txtNom.setText(e.getNom());
        selectSalle.setValue(e.getLaSalle());
        selectEvent.setValue(e.getType());
        date.setValue(LocalDate.parse(e.getDate()));

    }
}
