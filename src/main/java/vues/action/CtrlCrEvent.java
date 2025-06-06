package vues.action;

import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modele.*;

import java.time.ZoneId;
import java.util.Date;

public class CtrlCrEvent {

    @FXML private Button bnAnnuler;
    @FXML private Button bnOK;
    @FXML private TextField txtNom;
    @FXML private ComboBox selectSalle;
    @FXML private ComboBox selectEvent;
    @FXML private ComboBox selectBen;
    @FXML private DatePicker date;
    //public Gala(String nom, Date date, String saison, Salle laSalle, Benevole organisateur, String theme, String professeur){

    @FXML void valider(ActionEvent event) {
        String nom = txtNom.getText();
        Date dateFormat = Date.from(date.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        String saison = Integer.toString(dateFormat.getYear());
        Salle salle = (Salle) selectSalle.getValue();
        Benevole orga = (Benevole) selectBen.getValue();
        if(selectSalle.getSelectionModel().getSelectedItem() == "Gala"){
            String theme = "";
            String prof = "";

            Principale.ajouterUnEvent(nom, dateFormat, saison, salle, orga, theme, prof);
        }
        else if(selectSalle.getSelectionModel().getSelectedItem() == "Soirée dansante"){

            Principale.ajouterUnEvent(nom, dateFormat, saison, salle, orga);
        }

    }
    @FXML void annuler(ActionEvent event){
        Principale.fermerFenCrEvent();
    }

    @FXML void initialize(){
        BooleanBinding pasPret = Bindings.or(Bindings.or(txtNom.textProperty().isEmpty(), selectSalle.armedProperty().asString().isEmpty()), Bindings.or(selectEvent.armedProperty().asString().isEmpty(), date.armedProperty().asString().isEmpty()));
        bnOK.disableProperty().bind(Bindings.when(pasPret).then(true).otherwise(false));
        selectSalle.setItems(Principale.getLesSalles());
        selectEvent.setItems(Principale.getLesTypes());
        selectBen.setItems(Principale.getLesBenevoles());
    }

}
