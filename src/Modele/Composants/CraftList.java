package Modele.Composants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;
import java.util.HashMap;

import Modele.Composants.ItemList.ItemList;
import Modele.Composants.ItemMatrix.ItemMatrix;

public class CraftList extends HashMap<Item, ItemMatrix> implements Serializable {
	
	public final static String EMPLACEMENT_LISTECRAFTCOMPLETE = "./Data/DAT_files/completeCraftList.dat";

	ItemList iL;
	
	public CraftList(ItemList iL) {
		super();
		this.iL = iL;
	}
	
	public CraftList(String str, ItemList iL) {
		super();
		this.rawDataLoad(str);
		this.iL = iL;
	}
	
	public void rawDataLoad(String file) {
		
		try {
			BufferedReader bR = new BufferedReader(new FileReader(file));
			String str = new String(bR.readLine());
			String[] arg;
			
			while(str!=null) {
				arg = str.split(":");
				this.put(iL.research(arg[0]).racine(), new ItemMatrix(3)); 
				str = bR.readLine();
			}
			bR.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
