package Modele.Composants.ItemMatrix;

import java.io.Serializable;
import java.util.ArrayList;

import Modele.Composants.Item;
import Modele.Composants.Stack;

public class ItemMatrix implements Serializable {
	
	public final static int[] size = {1, 3};
	
	private Object[] matrix;
	private int dim;
	
	public ItemMatrix(int size) {
		this.matrix = new Item[size*size];
		this.dim = size*size;
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
	
	public Object[] getMatrix() {
		return matrix;
	}
	
	public boolean equals(ItemMatrix mat) {
		for(int k = 0; k<mat.dim; k++) {
			if(!this.matrix[k].equals(mat.matrix[k])) {
				return false;
			}
		}
		return true;
	}
}
