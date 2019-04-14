package Modele.Structures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.HashMap;
import Modele.Composants.Craft;
import Modele.Composants.Stack;

public class CraftListReversed extends HashMap<String, Craft> implements Serializable {
	
	private static final String rawList = "./Data/rawData/rawCraftList.txt";
	private ItemList itemList;
	
	public CraftListReversed(ItemList il) {
		this.setItemList(il);
		this.rawDataLoad(CraftListReversed.rawList);
	}
	
	public void rawDataLoad(String file) {
		try {
			BufferedReader bR = new BufferedReader(new FileReader(file));
			String str = bR.readLine();
			String[] arg, elem;
			Craft craft;
			
			while(str != null) {
				arg = str.split(":");
				elem = arg[1].split(",");
				craft = new Craft();
				for(int i = 0; i<elem.length; i++) {
					if(!elem[i].equals("0")) {
						craft.add(new Stack(this.getItemList().research(elem[i], true).racine(), 1), i);
					} else {
						craft.add(null, i);
					}
				}
				craft.craftID = craft.matID();
				this.put(arg[0], craft);
				str = bR.readLine();
			}
			bR.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ItemList getItemList() {
		return itemList;
	}

	public void setItemList(ItemList itemList) {
		this.itemList = itemList;
	}
	
}
