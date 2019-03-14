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
	 * On risque d'avoir pas mal d'images et de données à stocker, 
	 * 		peut-être que les stocker dans un dossier créé à cet effet peut aider dans l'organisation ? 
	 */
	public final static String DOSSIER_DONNEES = "./Data/";
	private BorderPane layout;
	private Scene scene;


	@Override
	public void start(Stage window) {
		try {
			layout = new BorderPane();
			scene= new Scene (layout,400,297);



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

			Button bouttoncraft= new Button ("Crafting");
			Button bouttoncraftInverse= new Button ("Crafting Inversée");
			HBox hbox = new HBox();
			hbox.setPadding(new Insets(10, 120, 15, 12));
			hbox.setSpacing(100);
			hbox.setStyle("-fx-background-color: #336699;");


			hbox.getChildren().addAll(bouttoncraft, bouttoncraftInverse);



		

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



	private void registerHandler(Shape s, Color defaultColor, Color hoverColor) {
		s.setOnMouseEntered( e -> s.setFill(hoverColor));
		s.setOnMouseExited(e -> s.setFill(defaultColor));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
