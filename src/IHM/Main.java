package IHM;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


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
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			
			Image bk = new Image("file:" + DOSSIER_DONNEES + "Designs/Table_de_Craft.png");
			ImageView mv = new ImageView(bk);
			/*mv.setFitWidth(500);
			mv.setFitHeight(500);*/
			mv.setImage(bk);
			Group root = new Group();
			Group g2 = new Group();
			ComposantPerso c = new ComposantPerso();
			
			root.getChildren().addAll(/*g2,c,*/mv);
			
			Scene scene = new Scene(root,335,315);
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Crafting Guide");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
