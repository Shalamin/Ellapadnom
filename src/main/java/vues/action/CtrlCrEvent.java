package vues.action;

import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modele.*;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

public class CtrlCrEvent {

    @FXML private Button bnAnnuler;
    @FXML private Button bnOK;
    @FXML private TextField txtNom;
    @FXML private ComboBox<Salle> selectSalle;
    @FXML private ComboBox<String> selectEvent;
    @FXML private ComboBox<Benevole> selectBen;
    @FXML private DatePicker date;




    @FXML void valider(ActionEvent event) {
        String nom = txtNom.getText();
        String dateFormat = date.getValue().toString();

        String saison = Integer.toString(date.getValue().getYear());
        Salle salle = (Salle) selectSalle.getValue();
        Benevole orga = (Benevole) selectBen.getValue();
        if(selectEvent.getSelectionModel().getSelectedItem() == "Gala"){
            String theme = "";
            String prof = "";

            Principale.ajouterUnEvent(nom, dateFormat, saison, salle, orga, theme, prof);
        }
        else if(selectEvent.getSelectionModel().getSelectedItem() == "Soirée dansante"){

            Principale.ajouterUnEvent(nom, dateFormat, saison, salle, orga);
        }

    }
    @FXML void annuler(ActionEvent event){
        Principale.fermerFenCrEvent();

    }



    public void clear(){
        txtNom.clear();
        System.out.println(txtNom.getText());
        selectBen.setValue(null);
        selectEvent.setValue("");
        selectSalle.setValue(null);
        date.setValue(null);


    }

    public void initialize(){

        selectSalle.setItems(Principale.getLesSalles());
        selectEvent.setItems(Principale.getLesTypes());
        selectBen.setItems(Principale.getLesBenevoles());

        BooleanBinding pasPret = Bindings.or(Bindings.or(txtNom.textProperty().isEmpty(), selectBen.valueProperty().isNull()), Bindings.or(selectEvent.valueProperty().isNull(), selectSalle.valueProperty().isNull()));
        bnOK.disableProperty().bind(Bindings.when(pasPret).then(true).otherwise(false));
    }

}
