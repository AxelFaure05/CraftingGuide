package Modele.Structures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import Modele.Composants.Item;
import Modele.Structures.sous_Structures.ABR;

public class ItemList extends ABR<Item> implements Serializable {
	
	private static final String rawList = "./Data/rawData/rawItemList.txt";
	
	public ItemList(String str) {
		super();
		this.rawDataLoad(str);
	}
	
	public ItemList() {
		super();
	}
	
	public ItemList(Item i, ItemList arbG, ItemList arbD) {
		super(i, arbG, arbD);
	}
	
	public ItemList addItem(Item item) {
		if(this.estVide()) {
			this.element = item;
			this.arbD = new ItemList();
			this.arbG = new ItemList();
			return this;
		}
		if(item.compareTo(this.element)<0) {
			return ((ItemList) this.arbG).addItem(item);
		}
		if(item.compareTo(this.element)>0) {
			return ((ItemList) this.arbD).addItem(item);
		}
		return this;
	}
	
	public ItemList research(String str, boolean exact) {
		ItemList res = new ItemList(this.racine(),(ItemList) this.arbG,(ItemList) this.arbD);
		while(res.racine().compareTo(new Item(0, str, str + ".png", false)) > 0) {
			System.out.println(res.racine().getName());
			res = (ItemList) res.arbD;
		}
		ItemList resultatRecherche = new ItemList();
		Iterator<Item> it = res.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			if(item.getName().toLowerCase().startsWith(str.toLowerCase()) && !exact) {
				resultatRecherche.addItem(item);
			} else if(item.getName().toLowerCase().equals(str.toLowerCase()) && exact) {
				resultatRecherche.addItem(item);
				break;
			}
		}
		return resultatRecherche;
	}
	
	public void rawDataLoad(String file) {
		try {
			BufferedReader bR = new BufferedReader(new FileReader(file));
			String str = new String(bR.readLine());
			String[] arg;
			
			while(str!=null) {
				arg = str.split(":");
				this.addItem(new Item(
						Integer.valueOf(arg[0]),
						arg[1],
						"img_" + arg[1].toLowerCase() + ".png",
						Boolean.getBoolean(arg[2])));
				str = bR.readLine();
			}
			bR.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getRawlist() {
		return rawList;
	}
}
