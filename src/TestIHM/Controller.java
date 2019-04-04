package TestIHM;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class Controller {

    @FXML
    private Pane result;

    @FXML
    private Pane paneprincipal;

    @FXML
    private GridPane table;
    
    @FXML
    private GridPane inventory;

    @FXML
    void dragdetect(ActionEvent event) {

    }

    @FXML
    void dragdone(ActionEvent event) {

    }
    
    public GridPane returnInventaire() {
    	return this.inventory;
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
		if(e.getSource() instanceof Pane) {
	        Integer colIndex = GridPane.getColumnIndex(source);
	        Integer rowIndex = GridPane.getRowIndex(source);
	        System.out.println(colIndex);
	        System.out.println(rowIndex);
		}
	}
    
    public void coordsTable(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		if(e.getSource() instanceof Pane) {
	        Integer colIndex = GridPane.getColumnIndex(source);
	        Integer rowIndex = GridPane.getRowIndex(source);
	        System.out.println("Coords table de craft");
	        System.out.println(colIndex);
	        System.out.println(rowIndex);
		}
	}
    
    public void resultClicked(MouseEvent e) {
		System.out.println("R�sultat cliqu�");
	}
    
}