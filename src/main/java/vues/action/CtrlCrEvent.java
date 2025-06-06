package vues.action;

import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CtrlCrEvent {

    @FXML private Button bnAnnuler;
    @FXML private Button bnOK;
    @FXML private TextField txtNom;
    @FXML private ComboBox selectSalle;
    @FXML private ComboBox selectEvent;
    @FXML private DatePicker date;

    @FXML void valider(ActionEvent event) {


    }
    @FXML void annuler(ActionEvent event){
        Principale.fermerFenCrEvent();
    }

    @FXML void initialize(){
        BooleanBinding pasPret = Bindings.or(Bindings.or(txtNom.textProperty().isEmpty(), selectSalle.armedProperty().asString().isEmpty()), Bindings.or(selectEvent.armedProperty().asString().isEmpty(), date.armedProperty().asString().isEmpty()));
        bnOK.disableProperty().bind(Bindings.when(pasPret).then(true).otherwise(false));
        selectSalle.setItems(Principale.getLesSalles());
        selectEvent.setItems(Principale.getLesTypes());
    }

}
