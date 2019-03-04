package Modele;

import Modele.Composants.ItemList.ItemList;

public class Modele {
	
	public ItemList inventaireCreatif;
	
	public Modele() {
		this.inventaireCreatif = new ItemList("src/Modele/listeCompleteDesItems.txt");
	}
	
}
