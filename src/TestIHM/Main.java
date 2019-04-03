package TestIHM;

import java.beans.EventHandler;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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
	GridPane inventory = ctrl.returnInventaire();
	
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
		
		//Evenement qui lance la fonction d'affichage des coordonnées
		//inventory.setOnMouseClicked(event -> this.coords(event));
		
		//Finalisation du setup de la fenêtre
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	//Fonction renvoyant une Node contenue aux coordonnées du GridPane indiqué en paramètre
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
	
	//Fonction renvoyant une matrice qui contient les Pane (contenant des imageView ou non)
	public Node[][] scan() {
		
		Node[][]inventaire = null;
		
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				
				inventaire[i][j] = getNodeByRowColumnIndex(i, j, inventory);
			}
		}
		return inventaire;
	}
	
	//Fonction appelée par le click de la souris sur un item du GridPane
	public void coords(MouseEvent e) {
		Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
	}
	
}
