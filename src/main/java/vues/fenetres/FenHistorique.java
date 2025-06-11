package vues.fenetres;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import vues.action.CtrlAccueil;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import controleur.*;
import vues.action.CtrlAccueil;
import vues.action.CtrlHisto;
import vues.action.CtrlRecherche;
import java.io.IOException;


public class FenHistorique extends Stage{
    static CtrlHisto ctrl;
    public FenHistorique() {
        this.setTitle("EllaPadNom");
        this.setResizable(false);
        Scene laScene = new Scene(creerSceneGraph());
        this.setScene(laScene);
        this.initModality(Modality.APPLICATION_MODAL);

    }

    private Pane creerSceneGraph() {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/historique.fxml"));

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


}
