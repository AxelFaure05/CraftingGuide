package Modele.Composants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import Modele.Composants.ItemList.ItemList;
import Modele.Composants.ItemMatrix.ItemMatrix;

public class CraftList extends HashMap<String, ItemMatrix> implements Serializable, Iterable<String> {
	
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
			String str = bR.readLine();
			String[] arg, elem;
			ItemMatrix craft;
			
			while(str != null) {
				arg = str.split(":");
				elem = arg[1].split(",");
				craft = new ItemMatrix(3);
				for(int i = 0; i<elem.length; i++) {
					if(!elem[i].equals("0")) {
						craft.add(this.iL.research(elem[i], true).racine(), i);
					} else {
						craft.add(new Item(0, "vide", "img_vide.png", false, false, false), i);
					}
				}
				this.put(arg[0], craft);
				str = bR.readLine();
			}
			bR.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Iterator<String> iterator() {
		return this.keySet().iterator();
	}
	
	public void serialize() {
		
	}
	
	public CraftList deserialize() {
		return null;
	}
}
