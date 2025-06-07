package vues.fenetres;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vues.action.CtrlModEvent;
import modele.*;
import java.io.IOException;

public class FenModEvent extends Stage {
    private CtrlModEvent ctrl;

    public FenModEvent() {
        this.setTitle("EllaPadNom");
        this.setResizable(false);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.initModality(Modality.APPLICATION_MODAL);
    }
    private Pane creerSceneGraph() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/modification_event.fxml"));

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
    public void afficherEvenement(Evenement e){
        ctrl.afficherEvenement(e);
    }
}
