package Modele.Composants.ItemMatrix;

import java.util.ArrayList;

import Modele.Composants.Item;
import Modele.Composants.Stack;

public class ItemMatrix {
	
	public final static int[] size = {1, 3};
	
	Object[] matrix;
	
	public ItemMatrix(int size) {
		this.matrix = new Item[size*size];
	}
	
	public void add(Object item, int pos) {
		if(item instanceof Item) {
			this.matrix[pos] = new Stack((Item) item, 1);
		} else if(item instanceof Stack) {
			this.matrix[pos] = item;
		}
		
	}
	
	public void remove(int pos) {
		this.matrix[pos] = null;
	}
}
