package IHM;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

import IHM.Main;
import Modele.Modele;
import Modele.Composants.Item;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControllerMenu {
	private BorderPane layout;
	static Modele modl = new Modele();
	static ControllerIHM ctrl = new ControllerIHM();
	//static Controller ctrll = new Controller(modl,ctrl);
	GridPane inventory = ctrl.returnInventaire();
	GridPane inventory1 = ctrl.returnInventaire1();
	GridPane inventory2 = ctrl.returnInventaire2();
	GridPane tableCraft = ctrl.returnCraftingTable();
	GridPane inv_crea = ctrl.returnInventaire_Crea();
	ScrollPane scroll = ctrl.returnScrollPane();
	Pane tempo2 = ctrl.returntempo2();
	Pane result;
	static Map<String, Object> namespace;
	
	ArrayList<GridPane> inventaires = new ArrayList<GridPane>();
    @FXML
    private Pane paneprincipal;
    public final static String DATA = "./Data/Designs/Items/";
    
    
    
    
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
    
    
    
    
    
    
    
    
    @FXML
    void Démarrer(MouseEvent e) throws Exception {
    	System.out.println("Démarrer");
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("interface.fxml"));
		Parent root = loader.load();
		namespace = loader.getNamespace();
		 Stage stage = new Stage();
         stage.setTitle("Table de Crafting");
        
         stage.show();
		root.setId("fenetre");
		Scene scene = new Scene(root);
	//	primaryStage.setResizable(false);
		inventory = (GridPane)namespace.get("inventory");
		inventory1 = (GridPane)namespace.get("inventory1");
		inventory2 = (GridPane)namespace.get("inventory2");
		tableCraft = (GridPane)namespace.get("table");
		scroll = (ScrollPane)namespace.get("scroll");
		inv_crea = (GridPane)namespace.get("inventory_crea");
		tempo2 = (Pane)namespace.get("tempo2");
		result = (Pane)namespace.get("result");
		
		System.out.println(result);
		ctrl.setresult(result);
		//inventaires.add(inventory);
		//inventaires.add(inventory1);
		//inventaires.add(inventory2);
		//inventaires.add(inv_crea);
		
		System.out.println(inventaires);
		
		creerItemsBase();
		
		//Finalisation du setup de la fenï¿½tre
	//	primaryStage.setTitle("Crafting Guide");
		//primaryStage.setScene(scene);
		
		stage.setScene(scene);
	//	primaryStage.show();
		
		}
	
    

    @FXML
    void Credits(MouseEvent e) {

    }

    @FXML
    void Quitter(MouseEvent e) {
    	Platform.exit();
    }

}
