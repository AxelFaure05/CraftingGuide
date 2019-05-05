package IHM;



import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import Controller.Controller;
import Modele.Composants.Item;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class ControllerIHM {
	//Instanciation des différents composants chargés par le fichier interface.fxml
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
	    private AnchorPane anchorResult1;
    //Différentes fonctions qui renvoient nos différents composants fxml afin de les réutiliser dans d'autres classes
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
    
    public Pane returnResult() {
    	return this.result;
    }
    
    public Pane returnResult1() {
    	return this.result1;
    }
    
    public void setresult(Pane res) {
    	this.result = res;
    }
    
    public void settableuncraft(GridPane tbl) {
    	this.table_uncraft = tbl;
    }
    public final static String DATA = "./Data/Designs/Items/";
    
    ArrayList<Pane> listeTempo = new ArrayList<Pane>();
    ArrayList<GridPane> listeInventaires = new ArrayList<GridPane>();  
    
    //leftClick est une grosse fonction qui gère tous les clics sur les différents composants. Elle aurait pu être plus condensée, cependant nos composants ne font pas tous la même taille,
    //donc l'instanciation des images ne se fait pas toujours à la même taille, et de plus, cela revient au même que de relancer d'autres fonctions dans celle-ci, c'est pourquoi nous avons tout mis ici dans des boucles if.
    
    public void leftClick(MouseEvent e) {
    	//Récupération de différentes données, plus ou moins nécessaires au bon fonctionnement de la fonction
    	ctrl.detectClick(e);
    	listeTempo.add(tempo);
    	listeTempo.add(tempo1);
    	listeTempo.add(tempo2);
    	listeInventaires.add(inventory);
    	listeInventaires.add(inventory1);
    	listeInventaires.add(inventory2);
    	Node source = (Node) e.getTarget();
    	Parent p = source.getParent();
    	String id = source.getParent().getId();
    	int x = coords(e).x;
    	int y = coords(e).y;
    	int z = coordsToPosition(x, y);
    	int posParent = coordsToPosition(coordsParent(e).x, coordsParent(e).y);
    	//System.out.println("x="+x);
    	//System.out.println("y="+y);
    	//System.out.println(this.inventory2.getChildren().get(z));
    	//System.out.println(inventory2.getId());
    	//System.out.println("ParentID:"+id);
    	//System.out.println("Clicked element ID :"+source.getId());
    	//Mise en place des conditions
    	//Si l'item sur lequel on clique est dans l'inventaire
    	
    	//Toute cette partie n'est lancée que si l'on n'utilise pas le clic molette/central de la souris
    	if(!(e.getButton() == MouseButton.MIDDLE)) {
    	
	    	//Si on tient un item et que la source est un des inventaires
	    	if(source instanceof Pane && !(listeTempo.get(0).getChildren().isEmpty()) && !(source.getParent().getId().equals("inventory_crea")) && !(source.getParent().getId().equals("table")) && !(source.getParent().getId().equals("anchorResult1")) && !(source.getId().equals("result"))) {
	    		//System.out.println("cdt 1");
	    		for(int i=0;i<3;i++) {
	    			ImageView ima = (ImageView) tempo2.getChildren().get(0);
	    			Image im = ima.getImage();
	    			if(e.getButton() == MouseButton.PRIMARY) {
	    				listeTempo.get(i).getChildren().clear();
	    			}
		    		ImageView iv = new ImageView(im);
		    		String ID = ima.getId();
		    		iv.setId(ID);
		    		iv.setFitHeight(36);
					iv.setFitWidth(36);
					iv.setTranslateX(4.0);
					iv.setTranslateY(4.0);
	
					GridPane grid = listeInventaires.get(i);
					Pane p1 = (Pane) grid.getChildren().get(z-1);
					p1.getChildren().add(iv);
	    		}	
	    		return;
	    	}
	    	//Si on tient un Item et que l'on clique sur un item dans l'inventaire
	    	if(source instanceof ImageView && (p.getParent().getId().equals("inventory2") || p.getParent().getId().equals("inventory1") || p.getParent().getId().equals("inventory") ) && !(tempo.getChildren().isEmpty()) && !(p.getId().equals("result"))) {
	    		//System.out.println("cdt7");
	    		ImageView imA = (ImageView) tempo2.getChildren().get(0);
	    		String iD = imA.getId();    		
	    		
	    		for(int i=0;i<3;i++) {
	    			GridPane grid = listeInventaires.get(i);
	    			Pane p1 = (Pane) grid.getChildren().get(posParent-1);
	    			ImageView ima = (ImageView) source;
		    		Image im = ima.getImage();
		    		ImageView iv = new ImageView(im);
		    		String ID = ima.getId();
		    		iv.setId(ID);
		    		
		    		iv.setFitHeight(86);
					iv.setFitWidth(86);
					iv.setTranslateX(4.0);
					iv.setTranslateY(4.0);
					
					Image iM = imA.getImage();
					ImageView iV = new ImageView(iM);
					
					iV.setId(iD);
					iV.setFitHeight(36);
					iV.setFitWidth(36);
					iV.setTranslateX(4.0);
					iV.setTranslateY(4.0);
	    		
	    			p1.getChildren().clear();
	    			p1.getChildren().add(iV);
	    			if(e.getButton() == MouseButton.PRIMARY) {
	    				listeTempo.get(i).getChildren().clear();
	    			}
	    			listeTempo.get(i).getChildren().add(iv);
	    		}
	    	}
	    	
	    	//Si on ne tient rien et qu'on clique un item d'un inventaire
	    	if(source instanceof ImageView && (p.getParent().getId().equals("inventory2") || p.getParent().getId().equals("inventory1") || p.getParent().getId().equals("inventory") ) && tempo.getChildren().isEmpty()) {
	    		//System.out.println("cdt2");
	    		//System.out.println("---");
	    		for(int i=0;i<3;i++) {
	    			
	    			GridPane grid = listeInventaires.get(i);
	    			Pane p1 = (Pane) grid.getChildren().get(posParent-1);
	    			ImageView ima = (ImageView) source;
		    		Image im = ima.getImage();
		    		ImageView iv = new ImageView(im);
		    		String ID = ima.getId();
		    		iv.setId(ID);
		    		
		    		iv.setFitHeight(85);
					iv.setFitWidth(85);
					iv.setTranslateX(4.0);
					iv.setTranslateY(4.0);
					
	    			p1.getChildren().clear();
	    			listeTempo.get(i).getChildren().add(iv);
	    		}
	    	}
	    	
	    	//Si on tient un item et qu'on clique dans la table de craft
	    	if(source instanceof Pane && !(listeTempo.get(0).getChildren().isEmpty()) && source.getParent().getId().equals("table")) {
	    		//System.out.println("cdt4");
	    		
	    		int k = coordsTable(e).x;
	        	int l = coordsTable(e).y;
	        	int m = coordsInTable(k,l)-1;
	    		
	    		ImageView ima = (ImageView) tempo2.getChildren().get(0);
	    		Image im = ima.getImage();
	    		//System.out.println("1");
	    		GridPane grid = table;
	    		Pane p1 = (Pane) grid.getChildren().get(m);
	    		p1.getChildren().clear();
	    		if(e.getButton() == MouseButton.PRIMARY) {
		    		for(int i=0;i<3;i++) {
		    			listeTempo.get(i).getChildren().clear();
		    		}	
	    		}
	    		//System.out.println("2");
	    		ImageView iv = new ImageView(im);
	    		String ID = ima.getId();
	    		iv.setId(ID);
		    	iv.setFitHeight(86);
				iv.setFitWidth(86);
				iv.setTranslateX(4.0);
				iv.setTranslateY(4.0);
				//System.out.println("ID="+ID);
	    		p1.getChildren().add(iv);
	    		//System.out.println("3");
	    	}
			//Si on clique sur un item dans la table et qu'on tient un item
			if(source instanceof ImageView && p.getParent().getId().equals("table") && !(listeTempo.get(0).getChildren().isEmpty())) {
				result.getChildren().clear();
				//System.out.println("cdt10");
				ImageView imA = (ImageView) tempo2.getChildren().get(0);
				Image iM = imA.getImage();
				ImageView iV = new ImageView(iM);
				String iD = imA.getId();
				iV.setId(iD);
				iV.setFitHeight(80);
				iV.setFitWidth(80);
				iV.setTranslateX(6.0);
				iV.setTranslateY(6.0);
				for(int i=0;i<3;i++) {
					if(e.getButton() == MouseButton.PRIMARY) {
						listeTempo.get(i).getChildren().clear();
					}
		    		ImageView ima = (ImageView) source;
		    		Image im = ima.getImage();
		    		ImageView iv = new ImageView(im);
		    		iv.setFitHeight(84);
					iv.setFitWidth(84);
					iv.setTranslateX(4.0);
					iv.setTranslateY(4.0);
					//((Pane) listeTempo.get(i)).getChildren().clear();;
					((Pane) listeTempo.get(i)).getChildren().add(iv);
					
					
				}
					
					Pane p1 = (Pane) source.getParent();
					p1.getChildren().clear();
					p1.getChildren().add(iV);
			}
			////Si on clique sur un item dans la table et qu'on ne tient rien
	    	if(source instanceof ImageView && p.getParent().getId().equals("table") && (listeTempo.get(0).getChildren().isEmpty())) {
				//System.out.println("cdt5");
				result.getChildren().clear();
				int k = coordsParent(e).x;
	        	int l = coordsParent(e).y;
	        	int m = coordsInTable(k,l)-1;
	        	//System.out.println(m);
	        	String ID = source.getId();
				for(int i=0;i<3;i++) {
					if(e.getButton() == MouseButton.PRIMARY) {
						listeTempo.get(i).getChildren().clear();
					}
		    		ImageView ima = (ImageView) source;
		    		Image im = ima.getImage();
		    		ImageView iv = new ImageView(im);
		    		iv.setId(ID);
		    		iv.setFitHeight(84);
					iv.setFitWidth(84);
					iv.setTranslateX(4.0);
					iv.setTranslateY(4.0);
					((Pane) listeTempo.get(i)).getChildren().add(iv);
				}
				Pane p1 = (Pane) table.getChildren().get(m);
				p1.getChildren().clear();
				//System.out.println("ID="+ID);
			}
	    	//Si on tient un item et qu'on clique sur la case d'entrée du uncraft
			if(source instanceof Pane && !(source.getParent().getId().equals("anchorResult1")) && !(listeTempo.get(0).getChildren().isEmpty()) && !(source.getParent().getId().equals("result")) && !(source.getParent().getId().equals("table"))) {
				//System.out.println("cdt6");
				ImageView ima = (ImageView) tempo2.getChildren().get(0);
	    		Image im = ima.getImage();
	    		result1.getChildren().clear();
				for(int i=0;i<3;i++) {
					if(e.getButton() == MouseButton.PRIMARY) {
						listeTempo.get(i).getChildren().clear();
					}
	    		}
				ImageView iv = new ImageView(im);
				String ID = ima.getId();
	    		iv.setId(ID);
	    		iv.setFitHeight(86);
				iv.setFitWidth(86);
				iv.setTranslateX(4.0);
				iv.setTranslateY(4.0);
				result1.getChildren().add(iv);
			}
			//Si on ne tient rien et qu'on clique sur la case d'entrée du uncraft
			if(source instanceof Pane && source.getParent().getId().equals("anchorResult1") && !(listeTempo.get(0).getChildren().isEmpty())) {
				//System.out.println("cdt8");
				ImageView ima =  (ImageView) tempo2.getChildren().get(0);
		    	Image im = ima.getImage();
		    	ImageView iv = new ImageView(im);
		    	String ID = ima.getId();
		    	iv.setId(ID);
		    	iv.setFitHeight(86);
				iv.setFitWidth(86);
				iv.setTranslateX(4.0);
				iv.setTranslateY(4.0);
				for(int i=0;i<3;i++) {
					if(e.getButton() == MouseButton.PRIMARY) {
						((Pane) listeTempo.get(i)).getChildren().clear();
					}
				}
				result1.getChildren().add(iv);
			}
			//Si on veut récupérer l'image passée en entrée du uncraft
			if(source instanceof ImageView && p.getParent().getId().equals("anchorResult1")) {
				//System.out.println("cdt9");
				clearUncraft();
				if(listeTempo.get(0).getChildren().isEmpty()) {
					for(int i=0;i<3;i++) {
						ImageView ima = (ImageView) source;
			    		Image im = ima.getImage();
			    		ImageView iv = new ImageView(im);
			    		String ID = ima.getId();
			    		iv.setId(ID);
			    		iv.setFitHeight(86);
						iv.setFitWidth(86);
						iv.setTranslateX(4.0);
						iv.setTranslateY(4.0);
					
						((Pane) listeTempo.get(i)).getChildren().add(iv);
					}
					result1.getChildren().clear();
				}
				
				else {
					
					for(int i=0;i<3;i++) {
						ImageView ima = (ImageView) source;
						Image im = ima.getImage();
			    		ImageView iv = new ImageView(im);
			    		String ID = ima.getId();
			    		iv.setId(ID);
			    		iv.setFitHeight(86);
						iv.setFitWidth(86);
						iv.setTranslateX(4.0);
						iv.setTranslateY(4.0);
						
						ImageView imA = (ImageView) tempo2.getChildren().get(0);
						Image iM = imA.getImage();
						ImageView iV = new ImageView(iM);
						String iD = imA.getId();
					    iV.setId(iD);
					    iV.setFitHeight(86);
						iV.setFitWidth(86);
						iV.setTranslateX(4.0);
						iV.setTranslateY(4.0);
						
						if(e.getButton() == MouseButton.PRIMARY) {
							((Pane) listeTempo.get(i)).getChildren().clear();
						}
						((Pane) listeTempo.get(i)).getChildren().add(iv);
						result1.getChildren().clear();
						result1.getChildren().add(iV);
					}
				}
			}
	    	//Si on vient de l'inventaire dit "Créatif"
	    	else {
	    		if(source instanceof ImageView && (p.getParent().getId().equals("inventory_crea") /*|| p.getParent().getId().equals("anchorResult1")*/)) {
	    			//System.out.println("cdt3");
	        		for(int i=0;i<3;i++) {
	        			listeTempo.get(i).getChildren().clear();
	    	    		ImageView ima = (ImageView) source;
	    	    		Image im = ima.getImage();
	    	    		ImageView iv = new ImageView(im);
	    	    		String ID = ima.getId();
	    	    		iv.setId(ID);
	    	    		iv.setFitHeight(86);
	    				iv.setFitWidth(86);
	    				iv.setTranslateX(4.0);
	    				iv.setTranslateY(4.0);
	    				((Pane) listeTempo.get(i)).getChildren().add(iv);
	        		}
	        		//result1.getChildren().clear();
	        	}
	    	}
    	}
    	//Si on fait un clic molette/central : on supprime l'item cliqué
    	else {
    		if(source instanceof ImageView && !(p.getParent().getId().equals("inventory_crea"))) {
    			//System.out.println("Clear");
    			if(p.getParent().getId().equals("inventory") || p.getParent().getId().equals("inventory1") || p.getParent().getId().equals("inventory2")) {
    				//System.out.println("On est dans un inventaire");
    				for(int i=0;i<3;i++) {
    					GridPane grid = listeInventaires.get(i);
    					Pane p1 = (Pane) grid.getChildren().get(posParent-1);
    					p1.getChildren().clear();
    				}
    			}
    			if(p.getParent().getId().equals("table")) {
    				result.getChildren().clear();
    				Pane p1 = (Pane) source.getParent();
	    			p1.getChildren().clear();
    			}
    			else {
	    			Pane p1 = (Pane) source.getParent();
	    			p1.getChildren().clear();
    			}
    		}
    	}
    }
    //Fonction de nettoyage de la table de uncraft
    public void clearUncraft() {
    	for(int i=0;i<9;i++) {
    		Pane p1 = (Pane) table_uncraft.getChildren().get(i);
    		//System.out.println(p1.getChildren());
	    	p1.getChildren().clear();
    		clearResult();
    	}
    }
    //Fonction de nettoyage de la table de craft, lancée par le bouton "Clear"
    public void clearTable() {
    	for(int i=0;i<9;i++) {
    		Pane p1 = (Pane) table.getChildren().get(i);
    		//System.out.println(p1.getChildren());
	    	p1.getChildren().clear();
    		clearResult();
    	}
    }
    //Fonction de nettoyage du résultat du craft
    public void clearResult() {
    	//System.out.println("Clearing crafting result");
    	result.getChildren().clear();
    }
    //Fonction qui affiche un item résultant d'un craft
    public void afficheResult(String link) throws IOException{
    	System.out.println("Affichage du résultat du Craft");
		Image im = SwingFXUtils.toFXImage(ImageIO.read(new File(DATA+link)), null);
		ImageView iv = new ImageView(im);
		String ID = link;
		iv.setId(ID);
		iv.setFitHeight(86);
		iv.setFitWidth(86);
		iv.setTranslateX(3.0);
		iv.setTranslateY(3.0);
		//try {
		setresult(result);
		System.out.println(iv);
		result.getChildren().add(iv);
		/*}catch(Exception e) {
			System.out.println("ERREUR");
			System.out.println("Cause de l'erreur: "+e.getCause());
			System.out.println(e.getMessage());
		}*/
    }
  //Fonction qui affiche un item résultant d'un décraft
    public void affichageUncraft(ArrayList<String> linkList) throws IOException {
    	//System.out.println("Affichage du Craft");
    	for(int i=0;i<9;i++) {
    		if(!(linkList.get(i)==null)) {
	    		Image im = SwingFXUtils.toFXImage(ImageIO.read(new File(DATA+linkList.get(i))), null);
	    		ImageView iv = new ImageView(im);
	    		String ID = linkList.get(i);
	    		iv.setId(ID);
	    		iv.setFitHeight(86);
	    		iv.setFitWidth(86);
	    		iv.setTranslateX(3.0);
	    		iv.setTranslateY(3.0);
	    		System.out.println("Table de uncraft : " + table_uncraft);
	    		Pane p1 = (Pane) table_uncraft.getChildren().get(i);
				p1.getChildren().clear();
	    		p1.getChildren().add(iv);
	    		//System.out.println(ID);
    		}
    	}
    }
    //Fonction de renvoi des coordonnées Parentes de l'élément cliqué
    public CouplePerso coordsParent(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		Node n = source.getParent();
		Integer colIndex = null;
		Integer rowIndex = null;
		
		colIndex = GridPane.getColumnIndex(n);
		rowIndex = GridPane.getRowIndex(n);
		if(colIndex == null) colIndex = 0;
        if(rowIndex == null) rowIndex = 0;
        
        CouplePerso result = new CouplePerso(rowIndex,colIndex);
		return result ;
    }
    //Fonction de renvoi des coordonnées de l'élément cliqué
    public CouplePerso coords(MouseEvent e) {
		Node source = (Node) e.getTarget() ;
		Integer colIndex = null;
		Integer rowIndex = null;
		
		colIndex = GridPane.getColumnIndex(source);
		rowIndex = GridPane.getRowIndex(source);
		if(colIndex == null) colIndex = 0;
        if(rowIndex == null) rowIndex = 0;
		
		CouplePerso result = new CouplePerso(rowIndex,colIndex);
		return result ;
	}
    //Couple perso est une classe renvoyant un couple d'Integer, et est utilisée pour renvoyer un couple de coordonnées
    public class CouplePerso{
    	public int x;
    	public int y;
    	public CouplePerso(int f,int s) {
    		this.x=f;
    		this.y=s;
    	}
    }
    //Fonction qui renvoie les coordonnées d'une position dans la table de craft
    public CouplePerso coordsTable(MouseEvent e) {
    	//ctrl.detectClick(e);
		Node source = (Node) e.getTarget() ;
		Integer colIndex = null;
		Integer rowIndex = null;
		
	    colIndex = GridPane.getColumnIndex(source);
	    rowIndex = GridPane.getRowIndex(source);
	    if(colIndex == null) colIndex = 0;
	    if(rowIndex == null) rowIndex = 0;
	    
	    //System.out.println("Coords table de craft");
	    //System.out.println(rowIndex);
	    //System.out.println(colIndex);
	    //System.out.println(source.getParent().getId());
	    
		CouplePerso result = new CouplePerso(rowIndex, colIndex);
		return result;
	}
    
    public void resultClicked(MouseEvent e) {
//    	ctrl.detectClick(e);
		//System.out.println("Result clicked");
		//System.out.println(e.getSource());
	}
    //Fonction qui renvoie la position dans une liste de l'élément cliqué par rapport à nos inventaires de 9 cases de large
    public Integer coordsToPosition(int a,int b) {
    	return a*9+b+1;
    }
    //Fonction qui renvoie la position dans une liste de l'élément cliqué par rapport à la table de craft de 3 cases de large    
    public Integer coordsInTable(int a,int b) {
    	return a*3+b+1;
    }
}