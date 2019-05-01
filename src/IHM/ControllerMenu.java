package IHM;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerMenu {

    @FXML
    private Pane paneprincipal;

    @FXML
    void Démarrer(MouseEvent e) throws Exception {
    	System.out.println("Démarrer");
    	Main appli = new Main();
    	Stage primaryStage = null;
		appli.start(primaryStage);
    	
    }

    @FXML
    void Credits(MouseEvent e) {

    }

    @FXML
    void Quitter(MouseEvent e) {

    }

}
