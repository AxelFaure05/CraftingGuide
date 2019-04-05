package TestIHM;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Controller {

	   @FXML
	    private Pane paneprincipal;

	    @FXML
	    private GridPane table;

	    @FXML
	    private GridPane inventory;
	    
	    @FXML
	    private GridPane inventory1;
	    
	    @FXML
	    private GridPane inventory2;

	    @FXML
	    private Pane result;

	    @FXML
	    private Pane tempo;

	    @FXML
	    private GridPane table_uncraft;

	    @FXML
	    private Pane result1;

	    @FXML
	    private Pane tempo2;

	    @FXML
	    private Pane tempo1;

	    @FXML
	    private GridPane inventory_crea;

    @FXML
    void dragdetect(ActionEvent event) {

    }

    @FXML
    void dragdone(ActionEvent event) {

    }
    
    public GridPane returnCraftingTable() {
		return table;
    }
    
    public GridPane returnInventaire() {
    	return this.inventory;
    }
    
    public GridPane returnInventaire1() {
    	return this.inventory1;
    }
    
    public GridPane returnInventaire2() {
    	return this.inventory2;
    }
    
   /* @FXML
    public void coords(MouseEvent e) {
    	System.out.println("click dans l'inventaire");
		Node source = (Node)e.getSource() ;
		System.out.println("1");
        Integer colIndex = GridPane.getColumnIndex(source);
        System.out.println("2");
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.println("3");
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
	}*/
    
    public void coords(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		Node n = source.getParent();
		if(e.getSource() instanceof Pane) {
			if(n instanceof GridPane) {
				System.out.println(source);
		        Integer colIndex = GridPane.getColumnIndex(source);
		        Integer rowIndex = GridPane.getRowIndex(source);
		        System.out.println(colIndex);
		        System.out.println(rowIndex);
			}
		 
			else {
				//System.out.println(source);
				System.out.println(n);
		        Integer colIndex = GridPane.getColumnIndex(n);
		        Integer rowIndex = GridPane.getRowIndex(n);
		        System.out.println(colIndex);
		        System.out.println(rowIndex);
			}
		}
		
	}
    
    public void coordsTable(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		if (e.getSource() instanceof Pane) {
	        Integer colIndex = GridPane.getColumnIndex(source);
	        Integer rowIndex = GridPane.getRowIndex(source);
	        System.out.println("Coords table de craft");
	        System.out.println(colIndex);
	        System.out.println(rowIndex);
		}
	}
    
    public void resultClicked(MouseEvent e) {
		System.out.println("Result clicked");
	}
    
}