package TestIHM;

import java.awt.image.BufferedImage;
import java.beans.EventHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Modele.Modele;
import Modele.Composants.Item;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Main extends Application{
	private BorderPane layout;
	
	Modele modl = new Modele();
	Controller ctrl = new Controller();
	GridPane inventory = ctrl.returnInventaire();
	GridPane inventory1 = ctrl.returnInventaire1();
	GridPane inventory2 = ctrl.returnInventaire2();
	GridPane tableCraft = ctrl.returnCraftingTable();
	GridPane inv_crea = ctrl.returnInventaire_Crea();
	ScrollPane scroll = ctrl.returnScrollPane();
	
	ArrayList<GridPane> inventaires = new ArrayList<GridPane>();
	
	public final static String DATA = "./Data/Designs/Items/";
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		
		Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        root.setId("fenetre");
		Scene scene = new Scene(root);
		
		inventory = (GridPane) root.getChildrenUnmodifiable().get(0).lookupAll("GridPane").toArray()[1];
		inventory1 = (GridPane) root.getChildrenUnmodifiable().get(0).lookupAll("GridPane").toArray()[3];
		inventory2 = (GridPane) root.getChildrenUnmodifiable().get(0).lookupAll("GridPane").toArray()[4];
		tableCraft = (GridPane) root.getChildrenUnmodifiable().get(0).lookupAll("GridPane").toArray()[2];
		scroll = (ScrollPane) root.getChildrenUnmodifiable().get(0).lookupAll("ScrollPane").toArray()[0];
		inv_crea = (GridPane) ((AnchorPane) scroll.getContent()).getChildren().get(0);
		
		inventaires.add(inventory);
		inventaires.add(inventory1);
		inventaires.add(inventory2);
		inventaires.add(inv_crea);
		
		System.out.println(inventaires);
		
		creerItemsBase();
		
		//Finalisation du setup de la fenêtre
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void creerItemsBase() throws IOException {
		
		Iterator<Item> it = modl.inventaireCreatif.iterator();
		Iterator<Node> itP = inv_crea.lookupAll("Pane").iterator();
		Pane pane;
		Item item;
		Image image;
		ImageView iv;
		int index = 0;
		
		
		while(it.hasNext()) {
			item = it.next();
			
			try {
				image = SwingFXUtils.toFXImage(ImageIO.read(new File(DATA+item.getLien())), null);
				pane = (Pane) itP.next();
				iv = new ImageView(image);
				iv.setFitHeight(26);
				iv.setFitWidth(26);
				iv.setTranslateX(3.0);
				iv.setTranslateY(3.0);
				//((Pane) inv_crea.getChildren().get(index)).getChildren().remove(inv_crea.);
				pane.getChildren().add(iv);
				index++;
				} catch (Exception e){
					System.out.println(DATA+item.getLien());
					System.out.println("Non existant");
				}
			System.out.println(item.getLien());
			//System.out.println(Main.imageExist(item));
		}		
		((Pane) inv_crea.getChildren().get(20)).getChildren().clear();
    }
	
	/*public static boolean imageExist(Item item){
			boolean result = false;
			try {
				Image image = SwingFXUtils.toFXImage(ImageIO.read(new File(DATA+item.getLien())), null);
		         result=true;
		    } catch (IOException e) {
		    	//e.printStackTrace();
				result=false;
			}
		return result;
	}*/
	
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
	/*public void coords(MouseEvent e) {
		Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
	}*/
	
}
