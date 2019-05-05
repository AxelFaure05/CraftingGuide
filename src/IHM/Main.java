package IHM;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.beans.EventHandler;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Controller.Controller;
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

public class Main extends Application implements KeyListener{
	private BorderPane layout;
	static Modele modl = new Modele();
	static ControllerIHM ctrl = new ControllerIHM();
	static Controller ctrll = new Controller(modl,ctrl);
	GridPane inventory = ctrl.returnInventaire();
	GridPane inventory1 = ctrl.returnInventaire1();
	GridPane inventory2 = ctrl.returnInventaire2();
	GridPane tableCraft = ctrl.returnCraftingTable();
	GridPane inv_crea = ctrl.returnInventaire_Crea();
	ScrollPane scroll = ctrl.returnScrollPane();
	Pane tempo2 = ctrl.returntempo2();
	Pane result;
	GridPane tblu;
	public static boolean menuFermee=false;
	static Map<String, Object> namespace;
	ArrayList<GridPane> inventaires = new ArrayList<GridPane>();
	Stage primaryStage;
	public final static String DATA = "./Data/Designs/Items/";
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public static boolean menuferm() {
		return !menuFermee;
	}
	@Override
	
	//Ceci est une fonction qui avait pour but de lancer un menu de démarrage, avant de lancer le programme. Elle a du être oublié à cause du fait qu'on ne pouvait plus gérer correctement nos interractions graphiques
	
	/*public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("interface2.fxml"));
			Parent root = loader.load();
			namespace = loader.getNamespace();
			
			root.setId("fenetre");
			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			
			primaryStage.setTitle("Crafting Guide");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			if (menuFermee==true) {
				primaryStage.close();
				menuFermee=false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(tempoFull());
		
	}
	
	public void fermetureMenu() {
		primaryStage.close();
	}*/
	
	//Fonction de lancement de la fenêtre
	public void start(Stage primaryStage) throws Exception {
		try {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("interface.fxml"));
		Parent root = loader.load();
		namespace = loader.getNamespace();
		
		root.setId("fenetre");
		Scene scene = new Scene(root);
		primaryStage.setResizable(false);
		inventory = (GridPane)namespace.get("inventory");
		inventory1 = (GridPane)namespace.get("inventory1");
		inventory2 = (GridPane)namespace.get("inventory2");
		tableCraft = (GridPane)namespace.get("table");
		scroll = (ScrollPane)namespace.get("scroll");
		inv_crea = (GridPane)namespace.get("inventory_crea");
		tempo2 = (Pane)namespace.get("tempo2");
		result = (Pane)namespace.get("result");
		tblu = (GridPane)namespace.get("table_uncraft");
		
		System.out.println(result);
		ctrl.settableuncraft(tblu);
		ctrl.setresult(result);
		//inventaires.add(inventory);
		//inventaires.add(inventory1);
		//inventaires.add(inventory2);
		//inventaires.add(inv_crea);
		
		System.out.println(inventaires);
		
		creerItemsBase();
		
		//Finalisation du setup de la fenï¿½tre
		primaryStage.setTitle("Crafting Guide");
		primaryStage.setScene(scene);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(tempoFull());
		
	}
	
	
	//Fonction de génération des items dans notre inventaire dit "créatif"
	public void creerItemsBase() throws IOException {
		
		Iterator<Item> it = modl.fullItemList.iterator();
		Iterator<Node> itP = inv_crea.lookupAll("Pane").iterator();
		Pane pane;
		Item item;
		Image image;
		ImageView iv;
		int index = 0;
		
		
		
		while(it.hasNext()) {
			item = it.next();
			
			try {
				String url = item.getImLink();
				//String[] path = url.split(".");
				
				image = SwingFXUtils.toFXImage(ImageIO.read(new File(DATA+item.getImLink())), null);
				//String nom = path[0];
				pane = (Pane) itP.next();
				iv = new ImageView(image);
				iv.setId(url);
				iv.setFitHeight(26);
				iv.setFitWidth(26);
				iv.setTranslateX(3.0);
				iv.setTranslateY(3.0);
				//((Pane) inv_crea.getChildren().get(index)).getChildren().remove(inv_crea.);
				pane.getChildren().add(iv);
				index++;
				//System.out.println(image.impl_getUrl());
				System.out.println(iv.getId());
				} catch (Exception e){
					//e.printStackTrace();
					System.out.println(DATA+item.getImLink());
					System.out.println("Non existant");
				}
			System.out.println(item.getImLink());
			//System.out.println(Main.imageExist(item));
		}		
		
    }
	//Fonction qui vérifie si on a bien une image dans notre base d'image
	public static boolean imageExist(Item item){
			boolean result = false;
			try {
				Image image = SwingFXUtils.toFXImage(ImageIO.read(new File(DATA+item.getImLink())), null);
		         result=true;
		    } catch (IOException e) {
		    	//e.printStackTrace();
				result=false;
			}
		return result;
	}
	
	//Fonction renvoyant une Node contenue aux coordonnï¿½es du GridPane indiquï¿½ en paramï¿½tre
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
		
		for(int i=0;i<28;i++) {
			for(int j=0;j<9;j++) {				
				inventaire[i][j] = getNodeByRowColumnIndex(i, j, inventory);
			}
		}
		return inventaire;
	}
	
	public static Controller returnController() {
		return ctrll;
	}
	
	public boolean tempoFull() {
    	boolean result = false;
    	//if(tempo2.getChildren())
    	System.out.println(tempo2);
    	return result;
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
