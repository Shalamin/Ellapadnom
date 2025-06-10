package vues.fenetres;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Benevole;
import modele.Evenement;
import vues.action.CtrlModEvent;
import vues.action.CtrlModTaches;

import java.io.IOException;

public class FenModTaches extends Stage {
    private CtrlModTaches ctrl;
    public FenModTaches() {
        this.setTitle("EllaPadNom");
        this.setResizable(false);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.initModality(Modality.APPLICATION_MODAL);
    }
    private Pane creerSceneGraph() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/modification_tache.fxml"));

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
    public void afficherTache(Evenement e, String tache, Benevole b) {
        ctrl.afficherTache(e, tache, b);
    }
}
