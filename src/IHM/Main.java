package IHM;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Main extends Application {
	
	/*
	 *	Tu peux directement travailler sur la classe src/CraftingGuide,
	 *		c'est la classe principale qui fait office de Frame.
	 */

	/*
	 * On risque d'avoir pas mal d'images et de données à stocker, 
	 * 		peut-être que les stocker dans un dossier créé à cet effet peut aider dans l'organisation ? 
	 */
	public final static String DOSSIER_DONNEES = "./Data/";
	private BorderPane layout;
	private Scene scene;
	Group root = new Group();

	
	@Override
	public void start(Stage window) {
		try {
			layout = new BorderPane();
			scene= new Scene (layout,1400,900);
			
			Image background = new Image("file:" + DOSSIER_DONNEES + "Designs/menu.jpg");
			ImageView mv = new ImageView(background);
			/*mv.setFitWidth(500);
			mv.setFitHeight(500);*/
			mv.setImage(background);
			layout.getChildren().addAll(mv);

			//Création des différents éléments
			Menu onglet1= new Menu("Menu Principal");
			Menu onglet2= new Menu("Table de Craft");
			Menu onglet3= new Menu("Table de Craft Inversée");

			MenuBar menuBar= new MenuBar();
			menuBar.getMenus().addAll(onglet1);
			menuBar.getMenus().addAll(onglet2);
			menuBar.getMenus().addAll(onglet3);

			Button bouttonCraft= new Button ("Crafting");
			
			//Appel d'une méthode qui gère l'ouverture de l'onglet crafting si clique sur boutton "BouttonCraft"
			 bouttonCraft.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		               System.out.println("Crafting");
		               crafting(window);
		            }
		        });
			 
			Button bouttonCraftInverse= new Button ("Crafting Inversée");
			
			//Appel d'une méthode qui gère l'ouverture de l'onglet crafting Inversée si clique sur boutton "BouttonCraftInverse"
			 bouttonCraftInverse.setOnAction(new EventHandler<ActionEvent>() {
		            @Override
		            public void handle(ActionEvent event) {
		                System.out.println("Crafting Inverse");
		                craftingInverse(window);
		            }
		        });
			 
			HBox hbox = new HBox();
			hbox.setPadding(new Insets(10, 120, 15, 12));
			hbox.setSpacing(100);
			hbox.setStyle("-fx-background-color: #336699;");


			hbox.getChildren().addAll(bouttonCraft, bouttonCraftInverse);

			//Agencement des différents éléments du layout
			layout.setTop(menuBar);
			layout.setBottom(hbox);
			//Affichage
			window.setScene(scene);
			window.show();
		} 

		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void menuStart(Stage window) {
		layout = new BorderPane();
		scene= new Scene (layout,1400,900);
		
		Image background = new Image("file:" + DOSSIER_DONNEES + "Designs/menu.jpg");
		ImageView mv = new ImageView(background);
		mv.setImage(background);
		layout.getChildren().addAll(mv);
		
		Menu onglet1= new Menu("Menu Principal");
		Menu onglet2= new Menu("Table de Craft");
		Menu onglet3= new Menu("Table de Craft Inversée");
		Menu onglet4= new Menu("Onglet4");
		MenuBar menuBar= new MenuBar();
		menuBar.getMenus().addAll(onglet1);
		menuBar.getMenus().addAll(onglet2);
		menuBar.getMenus().addAll(onglet3);
		menuBar.getMenus().addAll(onglet4);
		layout.setTop(menuBar);
		
		Button bouttonCraft= new Button ("Crafting");
		
		//Appel d'une méthode qui gère l'ouverture de l'onglet crafting si clique sur boutton "BouttonCraft"
		 bouttonCraft.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	               System.out.println("Crafting");
	               crafting(window);
	            }
	        });
		 
		Button bouttonCraftInverse= new Button ("Crafting Inversée");
		
		//Appel d'une méthode qui gère l'ouverture de l'onglet crafting Inversée si clique sur boutton "BouttonCraftInverse"
		 bouttonCraftInverse.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	                System.out.println("Crafting Inverse");
	                craftingInverse(window);
	            }
	        });
		 
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10, 120, 15, 12));
		hbox.setSpacing(100);
		hbox.setStyle("-fx-background-color: #336699;");


		hbox.getChildren().addAll(bouttonCraft, bouttonCraftInverse);
		
		Scene scene = new Scene(root,1400,900);
		scene.setRoot(root);
		
		//Agencement des différents éléments du layout
		layout.setTop(menuBar);
		layout.setBottom(hbox);
		//Affichage
		window.setScene(scene);
		window.show();
	}
	
	public void crafting(Stage window) {
		layout = new BorderPane();
		scene= new Scene (layout,1400,900);
		Image bk = new Image("file:" + DOSSIER_DONNEES + "Designs/Table_de_Craft.png");
		ImageView mv = new ImageView(bk);
		/*mv.setFitWidth(500);
		mv.setFitHeight(500);*/
		mv.setImage(bk);
		
		
		//Ajout des onglets
		Menu onglet1= new Menu("Menu Principal");
		Menu onglet2= new Menu("Table de Craft");
		Menu onglet3= new Menu("Table de Craft Inversée");
		Menu onglet4= new Menu("Onglet4");
		MenuBar menuBar= new MenuBar();
		menuBar.getMenus().addAll(onglet1);
		menuBar.getMenus().addAll(onglet2);
		menuBar.getMenus().addAll(onglet3);
		menuBar.getMenus().addAll(onglet4);
		layout.setTop(menuBar);
		
		onglet1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Retour au Menu");
				menuStart(window);
			}
			
		});
		
		Group g2 = new Group();
		ComposantPerso c = new ComposantPerso();
	
		root.getChildren().addAll(g2,c,mv,layout);
		
		Scene scene = new Scene(root,1400,900);
		scene.setRoot(root);
		
		//Appel de la fonction pour le hover des cases
		interactionInventaire();
		
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setTitle("Crafting Guide");
		window.setResizable(false);
		window.setScene(scene);
		
		window.show();
	}
	
	public void craftingInverse(Stage window) {
		
	}
	
	
	
	
	
	public void interactionInventaire() {
		int col = 11;
		int lig = 198;
		Rectangle r;
		
		for(int j = 0;j<3;j++) {
			for(int i = 0;i<9;i++) {
				r = new Rectangle(col+36*i,lig+36*j,32,32);
				r.setFill(Color.TRANSPARENT);
				registerHandler(r, Color.TRANSPARENT, Color.DARKGRAY);
				root.getChildren().add(r);
			}
		}
		
		for(int i=0;i<9;i++) {
			r = new Rectangle(col+36*i,lig+38.75*3,32,32);
			r.setFill(Color.TRANSPARENT);
			registerHandler(r, Color.TRANSPARENT, Color.DARKGRAY);
			root.getChildren().add(r);
		}
		
		int col1 = 55;
		int lig1 = 64;
		
		for(int i = 0;i<3;i++) {
			for (int j = 0;j<3;j++) {
					r = new Rectangle(col1+36*i,lig1+36*j,32,32);
					r.setFill(Color.TRANSPARENT);
					registerHandler(r, Color.TRANSPARENT, Color.DARKGRAY);
					root.getChildren().add(r);
				}
			}
		r = new Rectangle(237.5,94.5,42,42);
		r.setFill(Color.TRANSPARENT);
		registerHandler(r, Color.TRANSPARENT, Color.DARKGRAY);
		root.getChildren().add(r);
	}

	private void registerHandler(Shape s, Color defaultColor, Color hoverColor) {
		s.setOnMouseEntered( e -> s.setFill(hoverColor));
		s.setOnMouseExited(e -> s.setFill(defaultColor));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
