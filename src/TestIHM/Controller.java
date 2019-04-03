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
    private AnchorPane result;

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
    
    @FXML
    public void coords(MouseEvent e) {
    	System.out.println("click dans l'inventaire");
		Node source = (Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.printf("Mouse entered cell [%d, %d]%n", colIndex.intValue(), rowIndex.intValue());
	}
    
}