package Modele.Composants.ItemList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Modele.Composants.Item;

public class ItemList extends ABR<Item>{
	
	public ItemList(String str) {
		super();
		this.load(str);
	}
	
	public ItemList() {
		super();
	}
	
	public ItemList(Item i, ItemList arbG, ItemList arbD) {
		super(i, arbG, arbD);
	}
	
	public ItemList add(Item item) {
		if(this.estVide()) {
			this.element = item;
			this.arbD = new ItemList();
			this.arbG = new ItemList();
			return this;
		}
		if(item.compareTo(this.element)<0) {
			return ((ItemList) this.arbG).add(item);
		}
		if(item.compareTo(this.element)>0) {
			return ((ItemList) this.arbD).add(item);
		}
		return this;
	}
	
	public void load(String file) {
		
		try {
			BufferedReader bR = new BufferedReader(new FileReader(file));
			String str = new String(bR.readLine());
			String[] arg;
			
			while(str!=null) {
				arg = str.split(":");
				this.add(new Item(
						Integer.valueOf(arg[0]),
						arg[1],
						Boolean.getBoolean(arg[2]),
						Boolean.getBoolean(arg[3]),
						Boolean.getBoolean(arg[4])));
				str = bR.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
