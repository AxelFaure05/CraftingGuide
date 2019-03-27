package TestIHM;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        root.setId("fenetre");
		StackPane scene = new StackPane(root);
		//scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		scene.getStylesheets().add("application.css");
		
		primaryStage.setStyle(scene);
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
