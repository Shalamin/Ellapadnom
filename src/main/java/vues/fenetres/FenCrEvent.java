package vues.fenetres;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vues.action.CtrlCrEvent;

import java.io.IOException;

public class FenCrEvent extends Stage {
    private CtrlCrEvent ctrl;

    public FenCrEvent() {
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
        loader.setLocation(getClass().getResource("/fxml/creer_event.fxml"));


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
}
