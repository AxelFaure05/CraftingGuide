package Controller;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import TestIHM.Main;
import Modele.Modele;

public class Controller implements ActionListener,ItemListener, Observer {
	Modele model;
	Main inter;
	GridPane table;
	
	
	public Controller(Modele m, Main i) {
		this.inter = i;
		this.model = m;
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
