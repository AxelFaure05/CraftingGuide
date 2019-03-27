package Modele;

import java.util.Observable;

import Modele.Composants.CraftList;
import Modele.Composants.Inventaire.Inventaire;
import Modele.Composants.ItemList.ItemList;
import Modele.Composants.ItemMatrix.ItemMatrix;
import javafx.scene.Scene;

public class Modele extends Observable {
	
	public ItemList inventaireCreatif;
	public Inventaire inventaireSurvie;
	public ItemMatrix craftingTable;
	public ItemMatrix resultatCraft;
	private CraftList cL;
	
	public Scene onglet;
	
	public Modele() {
		this.inventaireCreatif = new ItemList("src/Modele/listeCompleteDesItems.txt");
		this.inventaireSurvie = new Inventaire(3, 9);
		this.craftingTable = new ItemMatrix(3);
		this.resultatCraft = new ItemMatrix(1);
		this.cL = new CraftList("src/Modele/listeCompleteDesCrafts.txt", this.inventaireCreatif);
	}
	
	public void changedScene(Scene scn) {
		this.onglet = scn;
		this.hasChanged();
		this.notifyObservers();
	}
	
	public void changedCraftingTable() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void changedResultatCraft() {
		this.setChanged();
		this.notifyObservers();
	}
	
	public void uncraft() {
		
	}
	
	public void craf() {
		
	}
}
