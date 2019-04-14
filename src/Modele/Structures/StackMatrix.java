package Modele.Structures;

import Modele.Composants.Craft;
import Modele.Composants.Stack;

public class StackMatrix {
	
	public Stack[] matrix;
	private int dimension;
	
	public StackMatrix(int dim) {
		this.setMatrix(new Stack[dim]);
		this.setDimension(dim);;
	}
	public StackMatrix(Stack stck, int dim) {
		this.setMatrix(new Stack[dim]);
		this.setDimension(dim);
		this.matrix[0] = stck;
	}
	public Stack getStackAt(int ind) {
		return this.matrix[ind];
	}
	public int getDimension() {
		return dimension;
	}
	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	public Stack[] getMatrix() {
		return matrix;
	}
	public void setMatrix(Stack[] matrix) {
		this.matrix = matrix;
	}
	public void add(Stack stck, int ind) {
		this.matrix[ind] = stck;
	}
	public void remove(int ind) {
		this.matrix[ind] = null;
	}
	public int matID() {
		int k = 0;
		int id = 0;
		while(this.getMatrix()[k]==null && k<8) {
			k++;
		}
		for(int j = 0; j<10-k; j++) {
			try {
				id = id + (j+1)*this.getMatrix()[k+j].hashCode();
			} catch (Exception e) {
				continue;
			}
		}
		k = 0;
		while(this.getMatrix()[3*(1+((int)(k/3)))-(k%3)-1]==null && k<8) {
			k++;
		}
		for(int j = 0; j<10-k; j++) {
			try {
				id = id + (j+1)*this.getMatrix()[3*(1+((int)((k+j)/3)))-((k+j)%3)-1].hashCode();
			} catch (Exception e) {
				continue;
			}	
		}
		return id;
	}
	@Override
	public boolean equals(Object mat) {
		if(!(mat instanceof StackMatrix)) return false;
		String comp1 = new String("");
		String comp2 = new String("");
		for(int k = 0; k<9; k++) {
			try {
				comp1 = comp1 + this.getMatrix()[k].getItem().getName();
			} catch (Exception e) { /*Mauvaise pratique de laisser un catch vide*/ }
			try {
				comp2 = comp2 + ((StackMatrix)mat).getMatrix()[k].getItem().getName();
			} catch (Exception e) { /*Mauvaise pratique de laisser un catch vide*/ }
		}
		return comp1.equals(comp2);
	}
	@Override
	public int hashCode() {
		int hash = 0;
		for(int k = 0; k<9; k++) {
			try {
				hash = hash + (k+1)*this.getMatrix()[k].hashCode();
			} catch (Exception e) { /*Mauvaise pratique de laisser un catch vide*/ }
		}
		return hash;
	}
}