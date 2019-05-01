package IHM;
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

public class MainMenu extends Application{
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
	static Map<String, Object> namespace;

	ArrayList<GridPane> inventaires = new ArrayList<GridPane>();
	
	public final static String DATA = "./Data/Designs/Items/";
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
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
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
