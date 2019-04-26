package Controller;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import TestIHM.Main;
import Modele.Modele;
import Modele.Composants.Item;
import Modele.Composants.Stack;
import TestIHM.ControllerIHM;
import TestIHM.ControllerIHM.CouplePerso;

public class Controller implements ActionListener,ItemListener, Observer {
	Modele model;
	ControllerIHM cIHM;
	boolean itemEnMain = false;
	
	Stack resultat;
	//Je créé le stack d'item qui sera dans notre main
	Stack stackTemp = null;


	public Controller(Modele m, ControllerIHM c) {
		this.model = m;
		this.cIHM = c;

		
		Item testI = new Item(10,"objet","objet",true);
		Stack test = new Stack(testI,1);
		//model.inventaireSurvie.set(2, test);
		//model.inventaireSurvie.set(3, test);
	}

	public void detectClick(MouseEvent e) {
		//Je regarde si on clique dans une pane pour debuter
		if(e.getSource() instanceof Pane) {
			Node source=(Node) e.getSource();
			String id = source.getId().toString();
			CouplePerso coord = cIHM.coords(e);
			//J'identifie le click de sourie
			if(e.getButton() == MouseButton.PRIMARY) {



				//J'identifie si nous cliquons dans l'inventaire
				if(id.equals("inventory")||id.equals("inventory1")||id.equals("inventory2")) {
					Integer position = cIHM.coordsToPosition(coord.x, coord.y)-1;
					//Je recupere les infos du stack d'item clique
					Stack stackRecup = model.inventaireSurvie.get(position);
					//Je regarde si j'ai deja un item dans la main oui ou non
					if(!itemEnMain) {
						//Si j'ai pas d'item dans la main, et que je clique sur une case ou se trouve un item, je la recupere
						if(stackRecup != null) {
							System.out.print("je recupere l'item ");
							System.out.println(position);
							stackTemp = model.putInInv(position, stackTemp);
							itemEnMain = !itemEnMain;
						}
					}
					else {
						//Si j'ai un item dans la main, et que la case clique est vide, alors je pose l'item dans cette case de l'inventaire
						if(stackRecup == null) {
							System.out.print("je pose l'item ");
							System.out.println(position);
							
							stackTemp = model.putInInv(position, stackTemp);
							itemEnMain=!itemEnMain;
						}
						//Si la case clique n'est pas vide, alors j'echange les deux items de place
						else {
							System.out.print("jechange deux items de place ");
							System.out.println(position);
							
							stackTemp = model.putInInv(position, stackTemp);
							
							//model.inventaireSurvie.set(position,null);
							//model.inventaireSurvie.set(position, stackTemp);
							//stackTemp = stackRecup;
						}
					}
					//System.out.println(model.inventaireSurvie.get(position));

				}
				
				//Je regarde si on clique sur la table de craft
				if(id.equals("table")) {
					
					Integer position = cIHM.coordsInTable(coord.x, coord.y)-1;
					//Je recupere les infos du stack d'item clique
					Stack stackRecup = model.tableDeCraft.getMatrix()[position];

					//Je regarde si j'ai deja un item dans la main oui ou non
					if(!itemEnMain) {

						//Si j'ai pas d'item dans la main, et que je clique sur une case ou se trouve un item, je la recupere
						if(stackRecup != null) {
							stackTemp = model.putInTableSlot(position, stackTemp);
							//model.tableDeCraft.add(null,position);
							//stackTemp = stackRecup;
							itemEnMain=!itemEnMain;
						}
					}
					else {
						//Si j'ai un item dans la main, et que la case clique est vide, alors je pose l'item dans cette case du table de craft
						if(stackRecup == null) {
							stackTemp = model.putInTableSlot(position, stackTemp);
							//model.tableDeCraft.add(stackTemp, position);
							itemEnMain=!itemEnMain;
						}
						//Sinon j'echange les deux items de place
						else {
							stackTemp = model.putInTableSlot(position, stackTemp);
							//model.tableDeCraft.add(null, position);;
							//model.tableDeCraft.add(stackTemp, position);
							//stackTemp = stackRecup;
						}
					}
					resultat = model.resultatCraft.getMatrix()[0];
				}
				
				
				//Je regarde si on clique dans l'inventaire creatif
				if(id.equals("inventory_crea")) {
					Node sourceIm = (Node) e.getTarget();
					//Et si on clique sur un image
					if (sourceIm instanceof ImageView) {
						ImageView iv = (ImageView) sourceIm;
						String[] lienT = iv.getId().split("[\\.]");
						String[] lienT2 = lienT[0].split("img_");
						String lien = lienT2[1];												
						//Si on a pas d'item en main, ca nous mettra un l'item en main
						if(!itemEnMain) {
							stackTemp = new Stack(model.fullItemList.research(lien, true).racine(),1);
							itemEnMain = !itemEnMain;
						}
						//Sinon l'item dans notre main est remplacer
						else {
							stackTemp = new Stack(model.fullItemList.research(lien, true).racine(),1);
						}
					}
				}
			}
		}
		/*for(int i =0;i<10;i++) {
			System.out.println(model.inventaireSurvie.get(i));
		}*/
	}
	@Override
	public void update(Observable arg0, Object arg1) {
	}

	public void actionPerformed(ActionEvent a) {

	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
