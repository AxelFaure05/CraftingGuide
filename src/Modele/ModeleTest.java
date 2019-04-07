package Modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modele.Composants.Item;
import Modele.Composants.ItemMatrix.ItemMatrix;

class ModeleTest {
	
	Modele modl;
	Item itm1;
	Item itm2;

	@BeforeEach
	void setUp() throws Exception {
		modl = new Modele();
		itm1 = modl.inventaireCreatif.research("furnace", true).racine();
		itm2 = modl.inventaireCreatif.research("cobblestone", true).racine();
	}

	@Test
	void testUncraft() {
		modl.itemToUncraft.getMatrix()[0] = itm1;
		modl.uncraft();
		
		assertEquals(modl.cL.get(itm1.getName()).getMatrix().equals(modl.uncraftResult.getMatrix()), true);
	}
	
	@Test
	void testCraft() {
		ItemMatrix im = new ItemMatrix(ItemMatrix.size[1]);
		Object[] matrix = im.getMatrix();
		
		for(int k = 0; k<matrix.length; k++) {
			if(k != 4) {
				matrix[k] = itm2;
			} else {
				matrix[k] = new Item(0, "vide", "img_vide.png", false, false, false);
			}
		}
		modl.craftingTable.setMatrix(matrix);
		modl.craft();
		
		assertEquals(((Item) modl.resultatCraft.getMatrix()[0]).equals((Item) itm1), true);
	}
}