package vues.action;


import controleur.Principale;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import modele.Evenement;
import modele.Salle;
import vues.fenetres.FenAccueil;

import java.util.Date;

public class CtrlRecherche {



    private final ObservableList<String> listChoix = FXCollections.observableArrayList();
    @FXML public TextField trie;
    @FXML public Button bnValider;
    @FXML public Button bnAnnuler;
    @FXML public Label saisonLabel;
    @FXML public Label eventLabel;
    @FXML public Label sallesLabel;
    @FXML public ComboBox<String> choixTrie;
    @FXML public ComboBox<Salle> selectSalle;
    @FXML public DatePicker selectSaison;
    @FXML private final ObservableList<Evenement> lesEvenementChercher  = FXCollections.observableArrayList();
    @FXML void valider(ActionEvent event){
        String texte = trie.getText();
        String saisonAct = Integer.toString(selectSaison.getValue().getYear());
        switch (choixTrie.getValue()){
            case "Evenement":
                for(int i = 0; i < Principale.getLesEvenements().size(); i++){
                    if(Principale.getLesEvenements().get(i).getNom().contains(texte)){
                        lesEvenementChercher.add(Principale.getLesEvenements().get(i));
                    }
                }
                break;
            case "Salles":
                for(int i = 0; i < Principale.getLesEvenements().size(); i++){
                    if(Principale.getLesEvenements().get(i).getLaSalle().getNomSalle().equalsIgnoreCase(selectSalle.getSelectionModel().getSelectedItem().getNom())){
                        lesEvenementChercher.add(Principale.getLesEvenements().get(i));
                    }
                }
                break;
            case "Saison":
                for(int i = 0; i < Principale.getLesEvenements().size(); i++){
                    if(Principale.getLesEvenements().get(i).getSaison().
                            equalsIgnoreCase(saisonAct)){
                        lesEvenementChercher.add(Principale.getLesEvenements().get(i));
                    }
                }
                break;
        }
        if(lesEvenementChercher.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR ,"Aucun evenement trouvé.", ButtonType.CLOSE);
            alert.setTitle("Erreur Saison");
            alert.show();
        }
        else{
            FenAccueil.updateTable(lesEvenementChercher);
            Principale.fermerFenRecherche();

        }

    }


    public void effacer() {
        lesEvenementChercher.clear();
        selectSalle.setValue(null);
        choixTrie.setValue(null);
    }

    @FXML void annuler(ActionEvent event){
        Principale.fermerFenRecherche();
    }

    @FXML void initialize(){
        listChoix.addAll("Evenement", "Saison" ,"Salles");
        choixTrie.setItems(listChoix);
        selectSalle.setItems(Principale.getLesSalles());
        BooleanBinding rien =
                Bindings.equal(choixTrie.getSelectionModel().selectedIndexProperty(), -1);
        bnValider.disableProperty().bind(rien);
        BooleanBinding event =
                Bindings.equal(choixTrie.getSelectionModel().selectedIndexProperty(), 0);
        BooleanBinding saison =
                Bindings.equal(choixTrie.getSelectionModel().selectedIndexProperty(), 1);
        BooleanBinding salles =
                Bindings.equal(choixTrie.getSelectionModel().selectedIndexProperty(), 2);

        eventLabel.visibleProperty().bind(event);
        saisonLabel.visibleProperty().bind(saison);
        sallesLabel.visibleProperty().bind(salles);
        selectSalle.visibleProperty().bind(salles);
        trie.visibleProperty().bind(event);
        selectSaison.visibleProperty().bind(saison);


    }

}
