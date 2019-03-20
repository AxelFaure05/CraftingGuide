package IHM;
import javafx.application.Application;
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
	 * On risque d'avoir pas mal d'images et de donn�es � stocker, 
	 * 		peut-�tre que les stocker dans un dossier cr�� � cet effet peut aider dans l'organisation ? 
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




			//Cr�ation des diff�rents �l�ments
			Menu onglet1= new Menu("Menu Principal");
			Menu onglet2= new Menu("Table de Craft");
			Menu onglet3= new Menu("Table de Craft Invers�e");

			MenuBar menuBar= new MenuBar();
			menuBar.getMenus().addAll(onglet1);
			menuBar.getMenus().addAll(onglet2);
			menuBar.getMenus().addAll(onglet3);

			Button bouttoncraft= new Button ("Crafting");
			Button bouttoncraftInverse= new Button ("Crafting Invers�e");
			HBox hbox = new HBox();
			hbox.setPadding(new Insets(10, 120, 15, 12));
			hbox.setSpacing(100);
			hbox.setStyle("-fx-background-color: #336699;");


			hbox.getChildren().addAll(bouttoncraft, bouttoncraftInverse);



		

			//Agencement des diff�rents �l�ments du layout
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
