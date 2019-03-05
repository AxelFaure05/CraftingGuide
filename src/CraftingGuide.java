import java.util.Iterator;

import Controller.*;
import IHM.*;
import Modele.*;
import Modele.Composants.Item;

public class CraftingGuide {
	
	public CraftingGuide() {
		
		Modele modl = new Modele();
		Iterator<Item> it = modl.inventaireCreatif.research("Iron".toLowerCase()).iterator();
		while(it.hasNext()) {
			Item item = it.next();
			System.out.println(item.getName());
		}
	}
	
	public static void main(String[] args) {
		new CraftingGuide();
	}
}
