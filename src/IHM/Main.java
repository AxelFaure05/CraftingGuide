package IHM;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Main extends Application {
	Group root = new Group();
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			
			Image bk = new Image("file:Table_de_Craft.png");
			ImageView mv = new ImageView(bk);
			/*mv.setFitWidth(500);
			mv.setFitHeight(500);*/
			mv.setImage(bk);
			
			Group g2 = new Group();
			ComposantPerso c = new ComposantPerso();
			
			/*Rectangle r = new Rectangle(14,166,32,32);
			r.setFill(Color.TRANSPARENT);
			registerHandler(r, Color.TRANSPARENT, Color.DARKGRAY);*/
			
			root.getChildren().addAll(g2,c,mv/*,r*/);
			
			Scene scene = new Scene(root,335,315);
			
			scene.setRoot(root);
			
			interactionInventaire();
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Crafting Guide");
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void interactionInventaire() {
		int col = 14;
		int lig = 166;
		Rectangle r = null;
		
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
