package Controller;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import TestIHM.Main;
import Modele.Modele;
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
		if(e.getSource() instanceof Pane) {
			Node source=(Node) e.getSource();
			String id = source.getParent().getId();
			if(id.equals("inventory")) {
				CouplePerso coord = cIHM.coords(e);
				if(itemEnMain) {
					model.inventaireSurvie.remove(cIHM.coordsToPosition(coord.x, coord.y));
				}
				else {
					//model.inventaireSurvie.
					model.inventaireSurvie.remove(cIHM.coordsToPosition(coord.x, coord.y));
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
