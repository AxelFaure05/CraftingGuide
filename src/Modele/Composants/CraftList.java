package Modele.Composants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.HashMap;

import Modele.Composants.ItemList.ItemList;
import Modele.Composants.ItemMatrix.ItemMatrix;

public class CraftList extends HashMap<Item, ItemMatrix> implements Serializable {
	
	public final static String EMPLACEMENT_LISTECRAFTCOMPLETE = "./Data/DAT_files/completeCraftList.dat";

	ItemList iL;
	
	public CraftList() {super();}
	
	public CraftList(ItemList iL) {
		super();
		this.iL = iL;
	}
	
	public CraftList(String str, ItemList iL) {
		super();
		this.iL = iL;
		this.rawDataLoad(str);
	}
	
	public void rawDataLoad(String file) {
		
		try {
			BufferedReader bR = new BufferedReader(new FileReader(file));
			String str = new String(bR.readLine());
			String[] arg, elem;
			ItemMatrix craft;
			
			while(str != null) {
				arg = str.split(":");
				elem = arg[1].split(",");
				craft = new ItemMatrix(3);
				for(int i = 0; i<elem.length; i++) {
					craft.add(elem[i], i);
				}
				this.put(this.iL.research(arg[0].toLowerCase()).racine(), craft);
				str = bR.readLine();
			}
			bR.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void serialize() {
		
	}
	
	public CraftList deserialize() {
		return null;
	}
}
