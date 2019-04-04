package Modele;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modele.Composants.Item;

class ModeleTest {
	
	Modele modl;

	@BeforeEach
	void setUp() throws Exception {
		modl = new Modele();
	}

	@Test
	void test() {
		Item item = modl.inventaireCreatif.research("furnace").racine();
		modl.itemToUncraft.getMatrix()[0] = item;

		System.out.println(modl.itemToUncraft);
		System.out.println(Arrays.toString(modl.itemToUncraft.getMatrix()));
		System.out.println(item.getName());
		System.out.println(Arrays.toString(modl.cL.keySet().toArray()));
		System.out.println(Arrays.toString(modl.cL.get(item.getName()).getMatrix()));
		modl.uncraft();
		
		System.out.println(Arrays.toString(modl.uncraftResult.getMatrix()));
	}
}