package IHM;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			
			Image bk = new Image("file:Table_de_Craft.png");
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
