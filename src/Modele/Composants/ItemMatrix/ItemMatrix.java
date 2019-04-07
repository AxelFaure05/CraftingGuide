package Modele.Composants.ItemMatrix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	public ItemMatrix(Object obj) {
		this.matrix = new Item[ItemMatrix.size[0]];
		this.matrix[0] = obj;
		this.dim = ItemMatrix.size[0];
	}
	
	public void add(Object item, int pos) {
		if(item instanceof Item) {
			//this.matrix[pos] = new Stack((Item) item, 1);
			this.matrix[pos] = item;
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
		Object[] mat1 = this.getMatrix();
		Object[] mat2 = mat.getMatrix();
		//System.out.println("[" + ((Item) mat1[0]).getName() + ", " + ((Item) mat1[1]).getName() + ", " + ((Item) mat1[2]).getName() + ", " + ((Item) mat1[3]).getName() + ", " + ((Item) mat1[4]).getName() + ", " + ((Item) mat1[5]).getName() + ", " + ((Item) mat1[6]).getName() + ", " + ((Item) mat1[7]).getName() + ", " +  ((Item) mat1[8]).getName() + " ]");
		//System.out.println("[" + ((Item) mat2[0]).getName() + ", " + ((Item) mat2[1]).getName() + ", " + ((Item) mat2[2]).getName() + ", " + ((Item) mat2[3]).getName() + ", " + ((Item) mat2[4]).getName() + ", " + ((Item) mat2[5]).getName() + ", " + ((Item) mat2[6]).getName() + ", " + ((Item) mat2[7]).getName() + ", " + ((Item) mat2[8]).getName() + " ]");
 		for(int k = 0; k<mat.dim; k++) {
			if(!((Item) mat1[k]).equals((Item) mat2[k])) {
				return false;
			}
		}
		return true;
	}

	public void setMatrix(Object[] matrix2) {
		this.matrix = matrix2;
	}
}
