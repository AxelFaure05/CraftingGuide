package Modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modele.Composants.Craft;
import Modele.Composants.Item;
import Modele.Composants.Stack;
import Modele.Structures.ItemList;
import Modele.Structures.StackMatrix;

class ModeleTest {
	
	Modele modl;
	Stack itm1;
	Stack itm2;
	Stack itm3;

	@BeforeEach
	void setUp() throws Exception {
		modl = new Modele();
		itm1 = new Stack(modl.fullItemList.research("noteblock", true).racine(), 1);
		itm2 = new Stack(modl.fullItemList.research("wood_plank", true).racine(), 1);
		itm3 = new Stack(modl.fullItemList.research("redstone_dust", true).racine(), 1);
		
	}

	@Test
	void testUncraft() {
		StackMatrix crft = new StackMatrix(9);
		
		for(int k = 0; k<crft.matrix.length; k++) {
			if(k != 4) {
				crft.matrix[k] = itm2;
			} else {
				crft.matrix[k] = itm3;
			}
		}
		
		Craft craft = new Craft(crft);
		modl.resultatCraft.getMatrix()[0] = itm1;
		modl.Uncraft();
		
		assertEquals(modl.fullCraftListReversed.get(itm1.getItem().getName()).equals(craft), true);
	}
	
	@Test
	void testCraft() {
		StackMatrix crft = new StackMatrix(9);
		
		for(int k = 0; k<crft.matrix.length; k++) {
			if(k != 4) {
				crft.matrix[k] = itm2;
			} else {
				crft.matrix[k] = itm3;
			}
		}
		
		modl.tableDeCraft = crft;
		modl.Craft();
		assertEquals(modl.resultatCraft.getMatrix()[0].getItem().equals(itm1.getItem()), true);
	}
}