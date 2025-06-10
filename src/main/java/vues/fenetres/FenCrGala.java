package vues.fenetres;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vues.action.CtrlCrGala;
import java.io.IOException;
import modele.*;

public class FenCrGala extends Stage{
    private CtrlCrGala ctrl;
    public FenCrGala() {
        this.setTitle("EllaPadNom");
        this.setResizable(false);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.initModality(Modality.APPLICATION_MODAL);

    }
    public void effacer(){
        ctrl.clear();
    }
    private Pane creerSceneGraph() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/creer_event_gala.fxml"));


        Pane root = new Pane();
        try {
            root = loader.load();
            ctrl = loader.getController();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return root;
    }
    public void donnees(String nom, String date, String saison, Salle salle, Benevole orga){
        ctrl.donnees(nom, date, saison, salle, orga);
    }
}
