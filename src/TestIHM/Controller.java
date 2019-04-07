package TestIHM;



import java.util.Map;

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
    
    public void leftClick(MouseEvent e) {
    	Node source = (Node) e.getTarget();
    	System.out.println(source.getParent().getId());
    	String id = source.getParent().getId();
    	System.out.println(id==(source.getParent().getId()).toString());
    	//if(id==)
    	int x = coords(e).first;
    	int y = coords(e).second;
    	int z = coordsToPosition(x, y);
    	System.out.println("x="+x);
    	System.out.println("y="+y);
    	System.out.println(this.inventory2.getChildren().get(z));
    }
    
    public CouplePerso coords(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		Node n = source.getParent();
		Integer colIndex = null;
		Integer rowIndex = null;
		if(e.getSource() instanceof Pane) {
			if(n instanceof GridPane) {
				colIndex = GridPane.getColumnIndex(source);
		        rowIndex = GridPane.getRowIndex(source);
		        if(colIndex == null) colIndex = 0;
		        if(rowIndex == null) rowIndex = 0;
			}
			else {
		        colIndex = GridPane.getColumnIndex(n);
		        rowIndex = GridPane.getRowIndex(n);
		        if(colIndex == null) colIndex = 0;
		        if(rowIndex == null) rowIndex = 0;
			}
		}
		CouplePerso result = new CouplePerso(rowIndex,colIndex);
		return result ;
	}
    
    public class CouplePerso{
    	public int first;
    	public int second;
    	public CouplePerso(int f,int s) {
    		this.first=f;
    		this.second=s;
    	}
    }
    
    public CouplePerso coordsTable(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		Integer colIndex = null;
		Integer rowIndex = null;
		//if (e.getSource() instanceof Pane) {
	        colIndex = GridPane.getColumnIndex(source);
	        rowIndex = GridPane.getRowIndex(source);
	        if(colIndex == null) colIndex = 0;
	        if(rowIndex == null) rowIndex = 0;
	        System.out.println("Coords table de craft");
	        System.out.println(rowIndex);
	        System.out.println(colIndex);
		//}
		CouplePerso result = new CouplePerso(rowIndex, colIndex);
		return result;
	}
    
    public void resultClicked(MouseEvent e) {
		System.out.println("Result clicked");
	}
    
    public Integer coordsToPosition(int a,int b) {
    	return a*9+b+1;
    }
}