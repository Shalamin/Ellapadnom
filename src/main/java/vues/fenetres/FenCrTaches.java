package vues.fenetres;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Evenement;
import vues.action.CtrlCrTaches;
import vues.action.CtrlTaches;

import java.io.IOException;

public class FenCrTaches extends Stage {
    private CtrlCrTaches ctrl;
    public FenCrTaches() {
        this.setTitle("EllaPadNom");
        this.setResizable(false);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.initModality(Modality.APPLICATION_MODAL);
    }
    private Pane creerSceneGraph() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/creer_tache.fxml"));

        Pane root = new Pane();
        try {
            root = loader.load();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ctrl = loader.getController();
        return root;
    }
    public void eventSelect(Evenement e){ctrl.setEvent(e);}
    public void effacer(){
        ctrl.clear();
    }
}
