package Controller;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
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


	public Controller(Modele m, ControllerIHM c) {
		this.model = m;
		this.cIHM = c;
	}

	public void detectClick(MouseEvent e) {
		//Je regarde si on clique dans une pane pour debuter
		if(e.getSource() instanceof Pane) {
			Node source=(Node) e.getSource();
			String id = source.getParent().getId().toString();
			CouplePerso coord = cIHM.coords(e);
			Integer position = cIHM.coordsToPosition(coord.x, coord.y);

			//J'identifie le click de sourie
			if(e.getButton() == MouseButton.PRIMARY) {

				//J'identifie dans quoi nous cliquons
				if(id.equals("inventory")||id.equals("inventory1")||id.equals("inventory2")) {

					//Je recupere les infos du stack d'item cliqué
					Stack stackTemp = model.inventaireSurvie.getInv()[position];

					//Si le stack est non null, cela veut dire qu'on clique pas sur une case vide
					if(stackTemp != null) {

						//Je check si j'ai un item dans la case temporaire
						if(!itemEnMain) {
							stackTemp.setCount(1);
							model.inventaireSurvie.getInv()[position].remove(1);
							itemEnMain = !itemEnMain;
						}
						else {
							if(model.inventaireSurvie.getInv()[position].getItem() == stackTemp.getItem()) {
								stackTemp.add(stackTemp.getItem(), 1);
								model.inventaireSurvie.getInv()[position].remove(1);
							}
							else {
								if(model.inventaireSurvie.getInv()[position] == null) {
									model.inventaireSurvie.place(position, stackTemp);
									itemEnMain = !itemEnMain;
								}
								else {
									Stack stackTemp2 = model.inventaireSurvie.getInv()[position];
									model.inventaireSurvie.place(position, stackTemp);
									stackTemp = stackTemp2;
								}
							}
						}
					}
				}
			}
		}
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
