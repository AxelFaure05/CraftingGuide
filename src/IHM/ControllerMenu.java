package IHM;

import TestIHM.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class ControllerMenu {

    @FXML
    private Pane paneprincipal;

    @FXML
    void Démarrer(ActionEvent event) {
    	System.out.println("hello");
    	//TestIHM.Main main= new Main();
    	
    }

    @FXML
    void Credits(ActionEvent event) {

    }

    @FXML
    void Quitter(ActionEvent event) {

    }

}
