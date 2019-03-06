package Modele.Composants.ItemMatrix;

import java.util.ArrayList;

import Modele.Composants.Item;

public class ItemMatrix {
	
	public final static int[] size = {1, 3};
	
	Item[] matrix;
	
	public ItemMatrix(int size) {
		this.matrix = new Item[size*size];
	}
	
	public void add(Item item, int pos) {
		this.matrix[pos] = item;
	}
	
	public void remove(int pos) {
		this.matrix[pos] = null;
	}
}
