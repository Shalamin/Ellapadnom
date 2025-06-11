package vues.action;

import controleur.Alertes;
import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML private Button bnOK;
    private Evenement evenement;
    @FXML void valider(ActionEvent event) {



        String nom = txtNom.getText();
        String type = selectEvent.getSelectionModel().getSelectedItem();
        Salle laSalle = selectSalle.getSelectionModel().getSelectedItem();
        String laDate = date.getValue().toString();
        String saison = Integer.toString(date.getValue().getYear());
        if (!evenement.getSaison().equals(saison)) {
            Alertes.afficherErreurModifEventDejaLa();
        } else {
            Principale.modifierEvenement(evenement, nom, laSalle, laDate, saison,  type);
        }
    }
    @FXML void annuler(ActionEvent event){
        Principale.fermerFenModEvent();
    }

    public void initialize(){
        selectSalle.setItems(Principale.getLesSalles());
        selectEvent.setItems(Principale.getLesTypes());
        txtNom.setDisable(true);
        BooleanBinding pasPret = txtNom.textProperty().isEmpty();
        bnOK.disableProperty().bind(Bindings.when(pasPret).then(true).otherwise(false));
    }
    public void afficherEvenement(Evenement e){
        txtNom.setText(e.getNom());
        selectSalle.setValue(e.getLaSalle());
        selectEvent.setValue(e.getType());
        date.setValue(LocalDate.parse(e.getDate()));
        evenement = e;

    }

}
