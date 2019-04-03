package Modele.Composants.ItemList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

import Modele.Composants.Item;

public class ItemList extends ABR<Item> implements Serializable {
	
	public final static String EMPLACEMENT_LISTECOMPLETE = "./Data/DAT_files/completeList.dat";
	
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
	
	public ItemList research(String str) {
		ItemList res = this.deserialize(EMPLACEMENT_LISTECOMPLETE);
		while(res.element.compareTo(new Item(0, str, str + ".png", false, false, false))<0) {
			res = (ItemList) res.arbD;
		}
		ItemList resultatRecherche = new ItemList();
		Iterator<Item> it = res.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			if(item.getName().startsWith(str)) {
				resultatRecherche.addItem(item);
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
						arg[1] + ".png",
						Boolean.getBoolean(arg[2]),
						Boolean.getBoolean(arg[3]),
						Boolean.getBoolean(arg[4])));
				str = bR.readLine();
			}
			bR.close();
			this.serialize(EMPLACEMENT_LISTECOMPLETE);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	public ItemList deserialize(String str) {
		try {
			FileInputStream fis = new FileInputStream(new File(str));
			ObjectInputStream ois = new ObjectInputStream(fis);
			ItemList il = (ItemList) ois.readObject();
			ois.close();
			fis.close();
			return il;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
