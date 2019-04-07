package Modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;

import Modele.Composants.CraftList;
import Modele.Composants.Item;
import Modele.Composants.Inventaire.Inventaire;
import Modele.Composants.ItemList.ItemList;
import Modele.Composants.ItemMatrix.ItemMatrix;
import javafx.scene.Scene;

public class Modele extends Observable implements Serializable {
	
	public final static String DATA = "./Data/DAT_files/DATA.dat";
	public static int[] DIM = {27, 243};
	
	public ItemList inventaireCreatif;
	public Inventaire inventaireSurvie;
	public ItemMatrix craftingTable;
	public ItemMatrix resultatCraft;
	public ItemMatrix itemToUncraft;
	public ItemMatrix uncraftResult;
	CraftList cL;
	
	public Scene onglet;
	
	public Modele() {
		
		try {
			this.deserialize();
			this.craftingTable = new ItemMatrix(3);
			this.uncraftResult = new ItemMatrix(3);
			this.resultatCraft = new ItemMatrix(1);
			this.itemToUncraft = new ItemMatrix(1);
			

		} catch(Exception e) {
			this.inventaireCreatif = new ItemList("src/Modele/listeCompleteDesItems.txt");
			this.inventaireSurvie = new Inventaire(Modele.DIM[1]);
			this.craftingTable = new ItemMatrix(3);
			this.uncraftResult = new ItemMatrix(3);
			this.resultatCraft = new ItemMatrix(1);
			this.itemToUncraft = new ItemMatrix(1);

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
		this.uncraftResult = this.cL.get(((Item) this.itemToUncraft.getMatrix()[0]).getName());
		this.setChanged();
		this.notifyObservers();
	}
	
	public void craft() {
		Iterator<String> itm = cL.iterator();
		String tmp;
		while(itm.hasNext()) {
			tmp = itm.next();
			if(this.craftingTable.equals(cL.get(tmp))) {
				this.resultatCraft.remove(0);
				this.resultatCraft.add(this.inventaireCreatif.research(tmp, true).racine(), 0);
			}
		}
		
	}
	private void serialize(String str) {
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
	
	private void deserialize() throws Exception {
		try {
			this.inventaireCreatif = (new ItemList()).deserialize(ItemList.EMPLACEMENT_LISTECOMPLETE);
			if(this.inventaireCreatif==null) throw new RuntimeException();
			this.inventaireSurvie = (new Inventaire(Modele.DIM[1])).deserialize();
			if(this.inventaireSurvie==null) throw new RuntimeException();
			this.cL = (new CraftList()).deserialize(CraftList.EMPLACEMENT_LISTECRAFTCOMPLETE);
			if(this.cL==null) throw new RuntimeException();
		} catch (Exception e) {
			throw new Exception();
		}
	}
}
