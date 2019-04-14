package Modele.Composants;

import java.io.Serializable;

import Modele.Structures.StackMatrix;

public class Craft extends StackMatrix implements Serializable {
	
	public int craftID;
	
	public Craft() {
		super(9);
		this.craftID = this.matID();
	}
	
	public Craft(StackMatrix stkma) {
		super(9);
		this.setMatrix(stkma.getMatrix());
		this.craftID = stkma.matID();
	}
	@Override
	public boolean equals(Object crft) {
		if(!(crft instanceof Craft)) return false;
		return this.craftID == ((Craft) crft).craftID && super.equals((Craft) crft);
	}
	@Override
	public int hashCode() {
		return this.craftID;
	}
}
