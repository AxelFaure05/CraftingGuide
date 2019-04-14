package Modele.Structures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;

import Modele.Composants.Craft;
import Modele.Composants.Item;
import Modele.Composants.Stack;

//re-réfléchis-y, tu étais fatigué. ;3
public class CraftList extends HashMap<Craft, String> implements Serializable {


	private static final String rawList = "./Data/rawData/rawCraftList.txt";
	private ItemList itemList;
	
	public CraftList(ItemList il) {
		this.setItemList(il);
		this.rawDataLoad(CraftList.rawList);
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
				this.put(craft, arg[0]);
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
