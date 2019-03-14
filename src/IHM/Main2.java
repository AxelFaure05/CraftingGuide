package IHM;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Main2 extends Application {

	Group root = new Group();

	
	/*
	 *	Tu peux directement travailler sur la classe src/CraftingGuide,
	 *		c'est la classe principale qui fait office de Frame.
	 */
	
	/*
	 * On risque d'avoir pas mal d'images et de données à stocker, 
	 * 		peut-être que les stocker dans un dossier créé à cet effet peut aider dans l'organisation ? 
	 */
	public final static String DOSSIER_DONNEES = "./Data/";
	

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane onglet = new BorderPane();
			
			Image bk = new Image("file:" + DOSSIER_DONNEES + "Designs/Table_de_Craft.png");
			ImageView mv = new ImageView(bk);
			/*mv.setFitWidth(500);
			mv.setFitHeight(500);*/
			mv.setImage(bk);
			
			
			//Ajout des onglets
			Menu onglet1= new Menu("Onglet1");
			Menu onglet2= new Menu("Onglet2");
			Menu onglet3= new Menu("Onglet3");
			Menu onglet4= new Menu("Onglet4");
			MenuBar menuBar= new MenuBar();
			menuBar.getMenus().addAll(onglet1);
			menuBar.getMenus().addAll(onglet2);
			menuBar.getMenus().addAll(onglet3);
			menuBar.getMenus().addAll(onglet4);
			onglet.setTop(menuBar);
			
			Group g2 = new Group();
			ComposantPerso c = new ComposantPerso();
		
			root.getChildren().addAll(g2,c,mv,onglet);
			
			Scene scene = new Scene(root,335,350);
			scene.setRoot(root);
			
			//Appel de la fonction pour le hover des cases
			interactionInventaire();
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Crafting Guide");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			
			primaryStage.show();
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void interactionInventaire() {
		int col = 14;
		int lig = 166;
		Rectangle r;
		
		for(int j = 0;j<3;j++) {
			for(int i = 0;i<9;i++) {
				r = new Rectangle(col+36*i,lig+36*j,32,32);
				r.setFill(Color.TRANSPARENT);
				registerHandler(r, Color.TRANSPARENT, Color.DARKGRAY);
				root.getChildren().add(r);
			}
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