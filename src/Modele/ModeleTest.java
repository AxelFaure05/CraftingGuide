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
	
	Modele modl = new Modele();
	Stack itm1;
	Stack itm2;
	Stack itm3;
	Stack itm4;

	@BeforeEach
	void setUp() throws Exception {
		//modl = new Modele();
		itm1 = new Stack(modl.fullItemList.research("noteblock", true).racine(), 1);
		itm2 = new Stack(modl.fullItemList.research("wood_plank", true).racine(), 1);
		itm3 = new Stack(modl.fullItemList.research("redstone_dust", true).racine(), 1);
		itm4 = new Stack(modl.fullItemList.research("stick", true).racine(), 1);
		
	}
	
	@Test
	void testIndependanceSchema() {
		StackMatrix crft = new StackMatrix(9);
		for(int k = 0; k<crft.matrix.length; k++) {
			if(k == 1 || k == 2) {
				crft.matrix[k] = itm2;
			} else if (k == 5 || k == 8){
				crft.matrix[k] = itm4;
			} else {
				crft.matrix[k] = null;
			}
		}
		
		modl.tableDeCraft = crft;
		modl.Craft();
		System.out.println(modl.resultatCraft.getStackAt(0));
		assertEquals(modl.resultatCraft.getStackAt(0).getItem().equals(modl.getStackFromFullList("wooden_hoe").getItem()), true);
	}
	
	@Test
	void testResearch() {
		String str = new String(modl.fullItemList.research("Nether_quartz", true).racine().getName());
		assertEquals(str.equals("nether_quartz"), true);
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