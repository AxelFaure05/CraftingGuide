package IHM;
import IHM.Main;
import javafx.application.Application;
import javafx.application.Platform;
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
    	Stage primaryStage;
		//Main.crafting(primaryStage);
	
    }

    @FXML
    void Credits(MouseEvent e) {

    }

    @FXML
    void Quitter(MouseEvent e) {
    	Platform.exit();
    }

}
