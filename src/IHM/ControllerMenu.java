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
    void D�marrer(MouseEvent e) throws Exception {
    	System.out.println("D�marrer");
    	Main appli = new Main();
    	
		appli.launch();
    	
    }

    @FXML
    void Credits(MouseEvent e) {

    }

    @FXML
    void Quitter(MouseEvent e) {

    }

}
