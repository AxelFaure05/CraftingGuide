package TestIHM;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Controller.Controller;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ControllerIHM {
	
	Controller ctrl = Main.returnController();

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
    
    ArrayList<Pane> listeTempo = new ArrayList<Pane>();
    ArrayList<GridPane> listeInventaires = new ArrayList<GridPane>();
    
    
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
    	ctrl.detectClick(e);
    	listeTempo.add(tempo);
    	listeTempo.add(tempo1);
    	listeTempo.add(tempo2);
    	listeInventaires.add(inventory);
    	listeInventaires.add(inventory1);
    	listeInventaires.add(inventory2);
    	Node source = (Node) e.getTarget();
    	Parent p = source.getParent();
    	System.out.println(source.getParent());
    	System.out.println(source.getParent().getId());
    	String id = source.getParent().getId();
    	System.out.println(id==(source.getParent().getId()).toString());
    	//if(id==)
    	int x = coords(e).x;
    	int y = coords(e).y;
    	int z = coordsToPosition(x, y);
    	System.out.println("x="+x);
    	System.out.println("y="+y);
    	System.out.println(this.inventory2.getChildren().get(z));
    	 
    		

    	
    	//Mise en place des conditions
    	//Si l'item sur lequel on clique est dans l'inventaire
    	
    	
    	if(source instanceof Pane && !listeTempo.get(0).getChildren().isEmpty() && source.getId()!="inv_crea"  /* && source.*/) {
    		System.out.println("cdt 1");
    		for(int i=0;i<3;i++) {
    			ImageView ima = (ImageView) tempo2.getChildren().get(0);
    			Image im = ima.getImage();
    			listeTempo.get(i).getChildren().clear();
	    		
	    		ImageView iv = new ImageView(im);
	    		iv.setFitHeight(26);
				iv.setFitWidth(26);
				iv.setTranslateX(3.0);
				iv.setTranslateY(3.0);
				System.out.println(source);
				System.out.println(((Pane)source).getChildren());
				GridPane grid = listeInventaires.get(i);
				Pane p1 = (Pane) grid.getChildren().get(z-1);
				p1.getChildren().add(iv);
    		}		
    	}
    	
    	if(source instanceof Pane && listeTempo.get(0).getChildren().isEmpty() && listeInventaires.contains(p.getId().toString())  /* && source.*/) {
    		System.out.println("cdt2");
    		for(int i=0;i<3;i++) {
    			
    			GridPane grid = listeInventaires.get(i);
    			Pane p1 = (Pane) grid.getChildren().get(z-1);
    			
    			ImageView ima = (ImageView) p1.getChildren().get(0);
    			Image im = ima.getImage();
    			ImageView iv = new ImageView(im);
	    		iv.setFitHeight(26);
				iv.setFitWidth(26);
				iv.setTranslateX(3.0);
				iv.setTranslateY(3.0);
				
    			//p1.getChildrenUnmodifiable().clear();
    			p1.getChildren().clear();
    			listeTempo.get(i).getChildren().add(iv);
    			
    			
    		}
    	}
    	
    	//if(source instanceof Pane && !listeTempo.get(0).getChildren().isEmpty() && listeInventaires.contains(source.getId())  /* && source.*/) {
    		/*for(int i=0;i<3;i++) {
    			
    		}
    	}*/
    	
    	else {
    		if(source instanceof ImageView) {
    			System.out.println("cdt3");
        		for(int i=0;i<3;i++) {
        			listeTempo.get(i).getChildren().clear();
    	    		ImageView ima = (ImageView) source;
    	    		Image im = ima.getImage();
    	    		ImageView iv = new ImageView(im);
    	    		iv.setFitHeight(26);
    				iv.setFitWidth(26);
    				iv.setTranslateX(3.0);
    				iv.setTranslateY(3.0);
    				((Pane) listeTempo.get(i)).getChildren().add(iv);
        		}
        	}
    	}
    	
    	
    }
    
    public CouplePerso coords(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		Node n = source.getParent();
		Integer colIndex = null;
		Integer rowIndex = null;
		
		colIndex = GridPane.getColumnIndex(source);
		rowIndex = GridPane.getRowIndex(source);
		if(colIndex == null) colIndex = 0;
        if(rowIndex == null) rowIndex = 0;
		
		/*if(e.getSource() instanceof Pane) {
			if(n instanceof GridPane) {
				colIndex = GridPane.getColumnIndex(source);
		        rowIndex = GridPane.getRowIndex(source);
		        if(colIndex == null) colIndex = 0;
		        if(rowIndex == null) rowIndex = 0;
			}
			else {
				if(n instanceof ImageView) {
					colIndex = GridPane.getColumnIndex(n.getParent());
			        rowIndex = GridPane.getRowIndex(n.getParent());
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
		}*/
		CouplePerso result = new CouplePerso(rowIndex,colIndex);
		return result ;
	}
    
    public class CouplePerso{
    	public int x;
    	public int y;
    	public CouplePerso(int f,int s) {
    		this.x=f;
    		this.y=s;
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