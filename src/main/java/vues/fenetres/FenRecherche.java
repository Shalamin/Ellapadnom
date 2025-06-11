package vues.fenetres;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vues.action.CtrlCrTaches;
import vues.action.CtrlRecherche;

import java.io.IOException;

public class FenRecherche extends Stage {
    static CtrlRecherche ctrl;
    public FenRecherche() {
        this.setTitle("EllaPadNom");
        this.setResizable(false);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);

    }

    private Pane creerSceneGraph() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/recherche.fxml"));

        Pane root = new Pane();

        try {
            root = loader.load();
            ctrl = loader.getController();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        loader.getController();
        return root;
    }
    public void effacer(){
        ctrl.effacer();
    }
}
