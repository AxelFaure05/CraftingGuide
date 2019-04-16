package Modele.Structures;

import java.io.Serializable;
import java.util.ArrayList;

import Modele.Modele;
import Modele.Composants.Stack;

public class Inventory extends ArrayList<Stack> implements Serializable {
	
	public Inventory() {
		super(Modele.invSize);
                for(int k = 0; k<Modele.invSize; k++){
                       this.add(null);
                }
	}
	
}
