package TestIHM;



import java.util.Map;

import Modele.Modele;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Controller {
	Modele model;
	public Controller() {
	}

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
	    private ScrollPane scroll;

    @FXML
    void dragdetect(ActionEvent event) {

    }

    @FXML
    void dragdone(ActionEvent event) {

    }
    
    public GridPane returnCraftingTable() {
		return table;
    }
    
    public GridPane returnInventaire_Crea() {
		return inventory_crea;
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
    
    public ScrollPane returnScrollPane() {
    	return this.scroll;
    }
    
    public Pane returntempo2() {
    	return this.tempo2;
    }
    
    public void leftClick(MouseEvent e) {
    	Node source = (Node) e.getTarget();
    	Node p = source.getParent();
		if(e.getSource() instanceof Pane) {
			if(p instanceof GridPane) {
				String siCase = source.getId().toString();
				if(siCase.equals("case")) {

					Integer colIndex = GridPane.getColumnIndex(source);
					Integer rowIndex = GridPane.getRowIndex(source);
					//Si on est dans la colone ou ligne 0, je fais en genre que ca renvoie 0 et pas null

					if(colIndex == null) {	colIndex=0; }
					if(rowIndex == null) {	rowIndex=0; }

					System.out.println(colIndex);
					System.out.println(rowIndex);
				}
			}
		}
		else {
			if(p.getId() != null) {
				String siCase = p.getId().toString();
				if(siCase.equals("case")) {

					Integer colIndex = GridPane.getColumnIndex(p);
					Integer rowIndex = GridPane.getRowIndex(p);
					//Si on est dans la colone ou ligne 0, je fais en genre que ca renvoie 0 et pas null

					if(colIndex == null) {	colIndex=0; }
					if(rowIndex == null) {	rowIndex=0; }

					System.out.println(colIndex);
					System.out.println(rowIndex);
				}

			}
		}
   }
  
    public void coordsTable(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		Integer colIndex = null;
		Integer rowIndex = null;
		if (e.getSource() instanceof Pane) {
	        colIndex = GridPane.getColumnIndex(source);
	        rowIndex = GridPane.getRowIndex(source);
	        if(colIndex == null) colIndex = 0;
	        if(rowIndex == null) rowIndex = 0;
	        System.out.println("Coords table de craft");
	        System.out.println(rowIndex);
	        System.out.println(colIndex);
		}
	}
    
    public void resultClicked(MouseEvent e) {
		System.out.println("Result clicked");
	}
    
    public Integer coordsToPosition(int a,int b) {
    	return a*9+b+1;
    }
}