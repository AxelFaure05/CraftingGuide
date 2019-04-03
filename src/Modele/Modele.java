package Modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Observable;

import Modele.Composants.CraftList;
import Modele.Composants.Inventaire.Inventaire;
import Modele.Composants.ItemList.ItemList;
import Modele.Composants.ItemMatrix.ItemMatrix;
import javafx.scene.Scene;

public class Modele extends Observable implements Serializable {
	
	public final static String DATA = "./Data/DAT_files/DATA.dat";
	public static int[] dim = {2, 9};
	
	public ItemList inventaireCreatif;
	public Inventaire inventaireSurvie;
	public ItemMatrix craftingTable;
	public ItemMatrix resultatCraft;
	private CraftList cL;
	
	public Scene onglet;
	
	public Modele() {
		
		try {
			this.deserialize();
			
		} catch(Exception e) {
			this.inventaireCreatif = new ItemList("src/Modele/listeCompleteDesItems.txt");
			this.inventaireSurvie = new Inventaire(3, 9);
			this.craftingTable = new ItemMatrix(3);
			this.resultatCraft = new ItemMatrix(1);
			this.cL = new CraftList("src/Modele/listeCompleteDesCrafts.txt", this.inventaireCreatif);
		}
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
	
	public void craft() {
		
	}
	public void serialize(String str) {
		try {
			FileOutputStream fos = new FileOutputStream(new File(str));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deserialize() {
		try {
			this.inventaireCreatif = (new ItemList()).deserialize(ItemList.EMPLACEMENT_LISTECOMPLETE);
			if(this.inventaireCreatif==null) throw new RuntimeException();
			this.inventaireSurvie = (new Inventaire(dim[0], dim[1])).deserialize();
			if(this.inventaireSurvie==null) throw new RuntimeException();
			this.cL = (new CraftList()).deserialize();
			if(this.cL==null) throw new RuntimeException();
		} catch (Exception e) {
			
		}
	}
}
