package TestIHM;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application{
	private BorderPane layout;
	
	Controller ctrl = new Controller();
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        root.setId("fenetre");
		Scene scene = new Scene(root);
		
		//scene.getStylesheets().addAll(this.getClass().getResource("application.css").toExternalForm());
		scene.getStylesheets().add("application.css");
		
		
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public Node getNodeByRowColumnIndex (final int row, final int column, GridPane gridPane) {
	    Node result = null;
	    ObservableList<Node> childrens = gridPane.getChildren();

	    for (Node node : childrens) {
	        if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
	            result = node;
	            break;
	        }
	    }

	    return result;
	}
	
	public Node[][] scan() {
		GridPane gp = ctrl.returnGridPane();
		Node[][]inventaire = null;
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				
				inventaire[i][j] = getNodeByRowColumnIndex(i, j, gp);
			}
		}
		return inventaire;
	}
	
}
