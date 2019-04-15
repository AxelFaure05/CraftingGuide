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
	
	public ItemList addItem(Item item, ItemList itml) {
		if(itml.estVide()) {
			itml.element = item;
			itml.arbD = new ItemList();
			itml.arbG = new ItemList();
			return itml;
		}
		else if(item.compareTo(itml.element)<0) {
			itml.arbG = addItem(item, (ItemList) itml.arbG);
			if(itml.balance() == 2) {
				if(item.compareTo(itml.arbG.racine())<0) {
					itml = rotationGauche(itml);
				} else {
					itml = doubleRotationGauche(itml);
				}
			}
		} else if(item.compareTo(this.element)>0) {
			itml.arbD = addItem(item, (ItemList) itml.arbD);
			if(itml.balance( ) == 2) {
				if(item.compareTo(itml.arbD.racine())>0) {
					itml = rotationDroite(itml);
				} else {
					itml = doubleRotationDroite(itml);
				}
			}
			
		}
		return itml;
	}
	
	private ItemList rotationGauche(ItemList k2)
    {
        ItemList k1 = (ItemList)k2.arbG;
        k2.arbG = (ItemList)k1.arbD;
        k1.arbD = (ItemList)k2;
        return k1;
    }

    private ItemList rotationDroite(ItemList k1)
    {
        ItemList k2 = (ItemList)k1.arbD;
        k1.arbD = (ItemList)k2.arbG;
        k2.arbG = (ItemList)k1;
        return k2;
    }
    
    private ItemList doubleRotationGauche(ItemList k3)
    {
        k3.arbG = rotationDroite( (ItemList)k3.arbG );
        return rotationGauche(k3);
    }

    private ItemList doubleRotationDroite(ItemList k1)
    {
        k1.arbD = rotationGauche( (ItemList)k1.arbD );
        return rotationDroite(k1);
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
				resultatRecherche.addItem(item, resultatRecherche);
			} else if(item.getName().toLowerCase().equals(str.toLowerCase()) && exact) {
				resultatRecherche.addItem(item, resultatRecherche);
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
						Boolean.getBoolean(arg[2])), this);
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
